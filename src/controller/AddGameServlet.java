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
 * Servlet implementation class AddGameServlet
 */
@WebServlet("/addGameServlet")
public class AddGameServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddGameServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String name = request.getParameter("name");
		String type = request.getParameter("type");
		String year = request.getParameter("year");
		Integer numPlayers = Integer.parseInt(request.getParameter("numPlayers"));
		LocalDate ld;
		
		try {
			ld = LocalDate.of(Integer.parseInt(year), null, (Integer) null);
		}catch(NumberFormatException ex) {
			ld = LocalDate.now();
		}
		
		Games g = new Games(ld, name, type, numPlayers);
		GamesHelper dao = new GamesHelper();
		dao.addGame(g);
		
		getServletContext().getRequestDispatcher("/index.html").forward(request, response);
	}

}
