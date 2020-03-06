package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Games;
import model.User;

/**
 * Servlet implementation class NavigateGamesServlet
 */
@WebServlet("/navigateGamesServlet")
public class NavigateGamesServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public NavigateGamesServlet() {
        super();
        // TODO Auto-generated constructor stub
    }


	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		GamesHelper gh = new GamesHelper();
		String act = request.getParameter("doThisToGame");
		
		//After changes redirect to ViewAllUsers, unless choose edit, or add
		String path = "/viewAllGamesServlet";
		
		if(act.equals("Delete")) {
			try {
				Integer tempId = Integer.parseInt(request.getParameter("gameId"));
				Games gameToDelete = gh.searchForGameById(tempId);
				gh.deleteGame(gameToDelete);
			}
			catch (NumberFormatException e) {
				System.out.println("Forgot to select an Game");
			}
			
		}
		else if(act.equals("Edit")) {
			try {
				Integer tempId = Integer.parseInt(request.getParameter("gameId"));
				Games gameToEdit = gh.searchForGameById(tempId);
				request.setAttribute("gameToEdit", gameToEdit);
				path = "/edit-game.jsp";
			}
			catch (NumberFormatException e) {
				System.out.println("Forgot to select an Game");
			}
			
		}
		else if(act.equals("Add Games(s)")) {
			path = "/addGameServlet";
			
		}
		
		getServletContext().getRequestDispatcher(path).forward(request, response);
	}

}
