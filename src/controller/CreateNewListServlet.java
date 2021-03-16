package controller;

import model.Games;
import model.ListDetails;
import model.User;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class CreateNewListServlet
 */
@WebServlet("/createNewListServlet")
public class CreateNewListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CreateNewListServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		getServletContext().getRequestDispatcher("/new-list.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		GamesHelper lih = new GamesHelper();
		String listName = request.getParameter("listName");
		System.out.println("List Name: " + listName);
		String userFirstName = request.getParameter("fName");
		String userLastName = request.getParameter("lName");

		
		String[] selectedGames = request.getParameterValues("allGamesToAdd");
		List<Games> selectedGamesInList = new ArrayList <Games>();
		//make sure something was selected - otherwise we get a null pointer exception
		if (selectedGames!= null && selectedGames.length > 0)
		{
			for(int i= 0; i<selectedGames.length;i++) {
				System.out.println(selectedGames[i]);
				Games c = lih.searchForGameById(Integer.parseInt(selectedGames[i]));
				selectedGamesInList.add(c);
			}
		}
		User user = new User(userFirstName, userLastName);
		ListDetails sld = new ListDetails(listName, user);
		sld.setListOfGames(selectedGamesInList);
		ListDetailsHelper slh = new ListDetailsHelper();
		slh.insertNewListDetails(sld);
		
		System.out.println("Success!");
		System.out.println(sld.toString());
		
		getServletContext().getRequestDispatcher("/index.html").forward(request, response);
	}

}
