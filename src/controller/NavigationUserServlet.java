package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.User;

/**
 * Servlet implementation class NavigationUserServlet
 */
@WebServlet("/navigationUserServlet")
public class NavigationUserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public NavigationUserServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		UserHelper uh = new UserHelper();
		String act = request.getParameter("doThisToGame");
		
		//After changes redirect to ViewAllUsers, unless choose edit, or add
		String path = "/viewAllUsersServlet";
		
		if(act.equals("Delete")) {
			try {
				Integer tempId = Integer.parseInt(request.getParameter("id"));
				User userToDelete = uh.searchForUserById(tempId);
				uh.deleteUser(userToDelete);
			}
			catch (NumberFormatException e) {
				System.out.println("Forgot to select an User");
			}
			
		}
		else if(act.equals("Edit")) {
			try {
				Integer tempId = Integer.parseInt(request.getParameter("id"));
				User userToEdit = uh.searchForUserById(tempId);
				request.setAttribute("userToEdit", userToEdit);
				path = "/edit-user.jsp";
			}
			catch (NumberFormatException e) {
				System.out.println("Forgot to select an User");
			}
			
		}
		else if(act.equals("Add")) {
			path = "/addUserWithGamesServlet";
			
		}
		
		getServletContext().getRequestDispatcher(path).forward(request, response);
	}

}
