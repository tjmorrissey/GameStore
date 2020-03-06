package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Games;

/**
 * Servlet implementation class editGameServlet
 */
@WebServlet("/editGameServlet")
public class EditGameServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EditGameServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		GamesHelper dao = new GamesHelper();
		
		String name = request.getParameter("name");
		double price = Double.parseDouble(request.getParameter("price"));
		Integer tempId = Integer.parseInt(request.getParameter("gameId"));
				
		Games gameToUpdate = dao.searchForGameById(tempId);
		gameToUpdate.setName(name);
		gameToUpdate.setPrice(price);
				
		dao.updateGame(gameToUpdate);

		getServletContext().getRequestDispatcher("/viewAllGamesServlet").forward(request, response);
	}

}
