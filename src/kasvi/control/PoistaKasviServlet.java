package kasvi.control;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kasvisto.model.dao.KasviDAO;

@WebServlet("/poista-kasvi")
public class PoistaKasviServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * Vastaanottaa selaimelta tulleen kasvin poistopyynnön
	 * 
	 * @param request
	 *            pyyntö
	 * @param response
	 *            vastaus
	 */

	public PoistaKasviServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		try {

			// Haetaan lomakkeella syötetyn henkilon tiedot request-oliolta
			String idStr = request.getParameter("id");
			int kasviId = new Integer(idStr);

			System.out.println(kasviId);

			// Luodaan henkilodao
			KasviDAO kasvidao = new KasviDAO();
			// poistetaan kavin toedot tietokannasta
			kasvidao.removeKasvi(kasviId);
		} catch (SQLException e) {
			// TODO: muuta virheilmoitus
			System.out.println("Sovelluksessa tapahtui virhe " + e.getMessage());
		}

		// uudelleenohjataan selain henkilolista-sivulle
		response.sendRedirect("etusivu");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
