package controller;

import java.io.IOException;
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

		UserHelper dao = new UserHelper();
		String act = request.getParameter("doThisToGame");
		
		System.out.println("In User Edit - Game Edit");
		
		String path = "/viewAllUsersServlet";
		
		if (act.equals("Delete Game")) {
			try {
				System.out.println("In User Edit - Delete Game");
				
				Integer tempUserId = Integer.parseInt(request.getParameter("userId"));
				Integer tempGameId = Integer.parseInt(request.getParameter("gameId"));
			
				User userToDeleteGame = dao.searchForUserById(tempUserId);
				List<Games> OwnedGames = userToDeleteGame.getGamesOwned();
				
				
				for(Games game: OwnedGames) {
					if(game.getGameId() == tempGameId) {
						OwnedGames.remove(game);
					}
				}
				
				dao.updateUser(userToDeleteGame);
				

			} catch (NumberFormatException e) {
				System.out.println("Forgot to select an game to delete");
			}
			
		} else if (act.equals("Add Game")) {
			

		}
		getServletContext().getRequestDispatcher(path).forward(request, response);
	}

}
