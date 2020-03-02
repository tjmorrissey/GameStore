package controller;

import java.io.IOException;
import java.time.LocalDate;
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
 * Servlet implementation class CreateNewUserServlet
 */
@WebServlet("/createNewUserServlet")
public class CreateNewUserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CreateNewUserServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		GamesHelper gh = new GamesHelper();
		String username = request.getParameter("username");
		System.out.println("Username: " + username);
		
		LocalDate ld = LocalDate.now();
		
		String[] selectedGames = request.getParameterValues("allGamesToAdd");
		List<Games> selectedGamesInList = new ArrayList<Games>();
		//make sure something was selected – otherwise we get a null pointer exception
		if (selectedGames != null && selectedGames.length > 0)
		{
			for(int i = 0; i<selectedGames.length; i++) {
				System.out.println(selectedGames[i]);
			
				
				//search for game by I
				Games g = gh.searchForGameById(Integer.parseInt(selectedGames[i]));
			
				selectedGamesInList.add(g);
			}
		}
		User user = new User(username, ld);
		
		user.setGamesOwned(selectedGamesInList);
		
		UserHelper slh = new UserHelper();
		
		slh.insertNewUser(user);

		System.out.println("Success!");
		System.out.println(user.toString());
		
		getServletContext().getRequestDispatcher("/viewAllListsServlet").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
