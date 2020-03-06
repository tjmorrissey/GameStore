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
 * Servlet implementation class AddGamesToUserServlet
 */
@WebServlet("/addGamesToUserServlet")
public class AddGamesToUserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddGamesToUserServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		GamesHelper gh = new GamesHelper();
		
		String[] selectedGames = request.getParameterValues("allGamesToAdd");
		
		UserHelper uh = new UserHelper();
		User user = new User();
		
		int tempId = Integer.parseInt(request.getParameter("userId"));
		
		user = uh.searchForUserById(tempId);
		
		List<Games> ownedGames = user.getGamesOwned();
		//make sure something was selected – otherwise we get a null pointer exception
		if (selectedGames != null && selectedGames.length > 0)
		{
			for(int i = 0; i<selectedGames.length; i++) {
				System.out.println(selectedGames[i]);
			
				
				//search for game by I
				Games g = gh.searchForGameById(Integer.parseInt(selectedGames[i]));
			
				ownedGames.add(g);
			}
		}
		
		user.setGamesOwned(ownedGames);
		
		uh.updateUser(user);
		
		getServletContext().getRequestDispatcher("/viewAllUsersServlet").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
