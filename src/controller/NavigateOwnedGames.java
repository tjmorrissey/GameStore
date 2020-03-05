package controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Games;
import model.User;

/**
 * Servlet implementation class NavigateOwnedGames
 */
@WebServlet("/navigateOwnedGames")
public class NavigateOwnedGames extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public NavigateOwnedGames() {
        super();
        // TODO Auto-generated constructor stub
    }


	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		UserHelper uhdao = new UserHelper();
		GamesHelper ghdao = new GamesHelper();
		List<Games> ownedGames;
		String act = request.getParameter("doThisToGame");
		
		//need to reference both the user, and the specific game it owns
		Integer tempUserId = Integer.parseInt(request.getParameter("userId"));
		
		String path = "/viewAllUsersServlet";
		
		if (act.equals("Delete Game")) {
			try {
				Integer tempGameId = Integer.parseInt(request.getParameter("gameId"));
				
				User userToDeleteGame = uhdao.searchForUserById(tempUserId);
				ownedGames = userToDeleteGame.getGamesOwned();
				
				//look through game list until if finds game that contains gameId to delete
				for(Games game: ownedGames) {
					if(game.getGameId() == tempGameId) {
						ownedGames.remove(game);
					}
				}
				
				//update user in database with new user info
				uhdao.updateUser(userToDeleteGame);
				

			} catch (NumberFormatException e) {
				System.out.println("Forgot to select an game to delete");
			}
			
		} else if (act.equals("Add Game")) {
			try {
				//need to reference both the user, and the specific game it owns
				
				User userToAddGame = uhdao.searchForUserById(tempUserId);
				ownedGames = userToAddGame.getGamesOwned();
				
				//list with all games available
				List<Games> allGames = ghdao.showAllGames();
				
				//empty list that will fill with games that are in allGames, but not in owned games
				List<Games> gamesNotOwned = new ArrayList<Games>();
				
				
				for(int j =0; j < allGames.size(); j++) {
					Games tempAllGames = allGames.get(j);
					
					for(int i = 0; i < ownedGames.size(); i++) {
						Games tempOwned = ownedGames.get(i);
						
						if(tempOwned.getGameId() == tempAllGames.getGameId()) {
							System.out.println("ID Match!");
							System.out.println(tempOwned);
						}
						else
						{
							gamesNotOwned.add(tempAllGames);
						}
					}
				}
				
				System.out.println("Owned:     " + ownedGames);
				System.out.println("Not Owned: " + gamesNotOwned);
				
				request.setAttribute("userToAddGame", userToAddGame);
				request.setAttribute("gamesNotOwned", gamesNotOwned);
			
				path = "/add-game-to-user.jsp";
				

			} catch (NumberFormatException e) {
				System.out.println("Forgot to select an game to delete");
			}
			

		}
		getServletContext().getRequestDispatcher(path).forward(request, response);
	}


}
