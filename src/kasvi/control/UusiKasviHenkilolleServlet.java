package kasvi.control;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kasvi.model.Henkilo;
import kasvi.model.Kasvi;
import kasvisto.model.dao.HenkiloDAO;
import kasvisto.model.dao.KasviDAO;

@WebServlet("/uusi-kasvi-henkilolle")
public class UusiKasviHenkilolleServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public UusiKasviHenkilolleServlet() {
		super();

	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		// kasvilomakkeen henkilo-valintalistaan vaihtoehdot tietokannasta
		HenkiloDAO henkilodao = new HenkiloDAO();
		List<Henkilo> henkilot = henkilodao.findAll();

		request.setAttribute("henkilot", henkilot);

		String jsp = "/view/LisaaKasviHenkilolle.jsp";
		RequestDispatcher dispather = getServletContext().getRequestDispatcher(jsp);
		dispather.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {

			// Haetaan lomakkeella syötetyn kasvin tiedot request-oliolta

			String stringHenkiloId = request.getParameter("henkiloId");
			int henkiloId = new Integer(stringHenkiloId);

			String nimi = request.getParameter("nimi"); // nimi

			String kuvaus = request.getParameter("kuvaus"); // kuvaus

			String kastelu = request.getParameter("kastelu"); // kastelu

			String valo = request.getParameter("valo"); // valo

			// Luodaan uusi KasviOlio edellisillä parametreillä
			Kasvi kasvi = new Kasvi(nimi, kuvaus, kastelu, valo, henkiloId);

			// Luodaan dao-olio
			KasviDAO kasvidao = new KasviDAO();
			// Lisätään kasvin tiedot tietokantaan
			kasvidao.addKasvi(kasvi);

			List<Kasvi> kasvit = kasvidao.findKasvitByHenkiloId(henkiloId);

			// Talletetaan request-olion alle kasvilista, jotta tiedot ovat
			// käytössä jsp:llä
			request.setAttribute("kasvit", kasvit);

			System.out.println(kasvit);

			// luodaan henkiloDao-olio
			HenkiloDAO henkiloDao = new HenkiloDAO();

			// etsitään henkilotietokannasta henkilo jonka id on parametrina
			// saatu henkilo id
			Henkilo henkilo = henkiloDao.findByhenkiloId(henkiloId);

			request.setAttribute("henkilo", henkilo);

			String jsp = "/view/HenkilonKasvinäkymä.jsp";
			RequestDispatcher dispather = getServletContext().getRequestDispatcher(jsp);
			dispather.forward(request, response);

			System.out.println(henkiloId);

		} catch (SQLException e) {
			// TODO: muuta virheilmoitus
			System.out.println("Sovelluksessa tapahtui virhe " + e.getMessage());
		}

	}

}
