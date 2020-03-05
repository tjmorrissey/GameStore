package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.User;

/**
 * Servlet implementation class EditUserServlet
 */
@WebServlet("/editUserServlet")
public class EditUserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EditUserServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		UserHelper dao = new UserHelper();
		
		String username = request.getParameter("username");
		Integer tempId = Integer.parseInt(request.getParameter("userId"));
				
		User itemToUpdate = dao.searchForUserById(tempId);
		
		itemToUpdate.setUsername(username);
				
		dao.updateUser(itemToUpdate);

		getServletContext().getRequestDispatcher("/viewAllUsersServlet").forward(request, response);
	}

}
