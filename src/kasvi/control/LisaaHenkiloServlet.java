package kasvi.control;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kasvi.model.Henkilo;
import kasvisto.model.dao.HenkiloDAO;

@WebServlet("/lisaa-henkilo")
public class LisaaHenkiloServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public LisaaHenkiloServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String jsp = "/view/henkilolomake.jsp";
		RequestDispatcher dispather = getServletContext().getRequestDispatcher(jsp);
		dispather.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		try {
			String kayttajaTunnus = request.getParameter("kayttajaTunnus");

			String etuNimi = request.getParameter("etuNimi");

			String sukuNimi = request.getParameter("sukuNimi");

			// Luodaan uusi henkiloOlio edellisill‰ parametreill‰
			Henkilo henkilo = new Henkilo(kayttajaTunnus, etuNimi, sukuNimi);

			// Luodaan khenkilodao
			HenkiloDAO henkilodao = new HenkiloDAO();

			// Lis‰t‰‰n henkilon tiedot tietokantaan
			henkilodao.addHenkilo(henkilo);
			request.setAttribute("henkilo", henkilo);

		} catch (SQLException e) {
			// TODO: muuta virheilmoitus
			System.out.println("Sovelluksessa tapahtui virhe " + e.getMessage());
		}

		// uudelleenohjataan selain kasvilista-sivulle
		response.sendRedirect("etusivu");
	}

}
