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
import model.ListDetails;
import model.User;

/**
 * Servlet implementation class EditListDetailsServlet
 */
@WebServlet("/editListDetailsServlet")
public class EditListDetailsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EditListDetailsServlet() {
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
		// TODO Auto-generated method stub
doGet(request, response);
		
		ListDetailsHelper dao = new ListDetailsHelper();
		GamesHelper lbh = new GamesHelper();
		UserHelper uh = new UserHelper();
		
		Integer tempId = Integer.parseInt(request.getParameter("id"));
		ListDetails listToUpdate = dao.searchForListDetailsById(tempId);
		
		String newListName = request.getParameter("listName");
		String userName = request.getParameter("userName");
		User newUser = uh.findUser(userName);
		
		
		try {
			String [] selectedBikes = request.getParameterValues("allBikesToAdd");
			List<Games> selectedBikesInList = new ArrayList<Games>();
			
			for (int i = 0; i < selectedBikes.length; i++) {
				System.out.println(selectedBikes[i]);
				Games c = lbh.searchForGameById(Integer.parseInt(selectedBikes[i]));
				selectedBikesInList.add(c);
			}
			
			listToUpdate.setListOfGames(selectedBikesInList);
		} catch (NullPointerException e) {
			List<Games> selectedBikesInList = new ArrayList<Games>();
			listToUpdate.setListOfGames(selectedBikesInList);
		}
		
		listToUpdate.setListName(newListName);
		listToUpdate.setUser(newUser);
		
		dao.updateList(listToUpdate);
		
		getServletContext().getRequestDispatcher("/viewAllListsServlet").forward(request, response);
	}

}
