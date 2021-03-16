package controller;

import java.io.IOException;
import java.time.LocalDate;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Games;



/**
 * Servlet implementation class EditGameServlet
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

		String year = request.getParameter("year");

		String type = request.getParameter("type");
		Integer numPlayers = Integer.parseInt(request.getParameter("numPlayers"));
		Integer tempId = Integer.parseInt(request.getParameter("id"));
		LocalDate ld;
		
		try {
			ld = LocalDate.of(Integer.parseInt(year), null, (Integer) null);
		}catch(NumberFormatException ex) {
			ld = LocalDate.now();
		}
		
		Games gameToUpdate = dao.searchForGameById(tempId);
		gameToUpdate.setName(name);

		gameToUpdate.setYear(ld);

		gameToUpdate.setType(type);
		gameToUpdate.setNumPlayers(numPlayers);
		
		dao.updateGame(gameToUpdate);
		
		getServletContext().getRequestDispatcher("/viewAllGamesServlet").forward(request, response);
	}

}
