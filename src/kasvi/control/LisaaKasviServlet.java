package kasvi.control;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kasvi.model.Kasvi;
import kasvisto.model.dao.KasviDAO;

@WebServlet("/lisaa-kasvi")
public class LisaaKasviServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public LisaaKasviServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String jsp = "/view/kasvilomakeKokeiluuuuu.jsp";
		RequestDispatcher dispather = getServletContext().getRequestDispatcher(jsp);
		dispather.forward(request, response);

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		try {
			/*
			 * String stringId = request.getParameter("id"); // nimi int id =
			 * Integer.parseInt(stringId);
			 */

			String nimi = request.getParameter("nimi"); // nimi

			String kuvaus = request.getParameter("kuvaus"); // kuvaus

			String kastelu = request.getParameter("kastelu"); // kastelu

			String valo = request.getParameter("valo"); // valo

			String stringHenkiloId = null;
			int henkiloId = new Integer(stringHenkiloId);

			// Luodaan uusi KasviOlio edellisill‰ parametreill‰
			Kasvi kasvi = new Kasvi(nimi, kuvaus, kastelu, valo, henkiloId);

			// Luodaan kasvidao
			KasviDAO kasvidao = new KasviDAO();
			// Lis‰t‰‰n kasvin tiedot tietokantaan
			kasvidao.addKasvi(kasvi);

		} catch (SQLException e) {
			// TODO: muuta virheilmoitus
			System.out.println("Sovelluksessa tapahtui virhe " + e.getMessage());
		}

		// uudelleenohjataan selain kasvilista-sivulle
		response.sendRedirect("listaa-kasvi");
	}

}
