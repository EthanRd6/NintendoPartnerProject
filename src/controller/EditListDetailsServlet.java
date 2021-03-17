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
		response.getWriter().append("Served at: editListDetailsServlet").append(request.getContextPath());
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
			String [] selectedGames = request.getParameterValues("allItemsToAdd");
			List<Games> selectedGamesInList = new ArrayList<Games>();
			
			for (int i = 0; i < selectedGames.length; i++) {
				System.out.println(selectedGames[i]);
				Games c = lbh.searchForGameById(Integer.parseInt(selectedGames[i]));
				selectedGamesInList.add(c);
			}
			
			listToUpdate.setListOfGames(selectedGamesInList);
		} catch (NullPointerException e) {
			List<Games> selectedGamesInList = new ArrayList<Games>();
			listToUpdate.setListOfGames(selectedGamesInList);
		}
		
		listToUpdate.setListName(newListName);
		
		
		dao.updateList(listToUpdate);
		
		getServletContext().getRequestDispatcher("/viewAllListsServlet").forward(request, response);
	}

}
