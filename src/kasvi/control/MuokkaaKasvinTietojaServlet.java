package kasvi.control;

import java.io.IOException;
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

@WebServlet("/muokkaa-kasvin-tietoja")
public class MuokkaaKasvinTietojaServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public MuokkaaKasvinTietojaServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String idStr = request.getParameter("id");
		int KasviId = new Integer(idStr);

		System.out.println(KasviId);
		// Kasvin muokkaus formiin tiedot tietokannasta
		KasviDAO kasvidao = new KasviDAO();
		Kasvi kasvi = kasvidao.findByKasviId(KasviId);

		request.setAttribute("kasvi", kasvi);

		System.out.println(kasvi);

		// ohjaa sivulle jossa valitaan profiilin perustella kenen kasvit
		// n‰ytet‰‰n
		String jsp = "/view/MuokkaaKasvinTietoja.jsp";
		RequestDispatcher dispather = getServletContext().getRequestDispatcher(jsp);
		dispather.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String stringId = request.getParameter("kasviId");
		int kasviId = new Integer(stringId);

		String nimi = request.getParameter("nimi"); // nimi

		String kuvaus = request.getParameter("kuvaus"); // kuvaus

		String kastelu = request.getParameter("kastelu"); // kastelu

		String valo = request.getParameter("valo"); // valo

		String stringHenkiloId = request.getParameter("henkiloId");
		int henkiloId = new Integer(stringHenkiloId);

		// Luodaan uusi KasviOlio edellisill‰ parametreill‰
		Kasvi kasvi = new Kasvi(kasviId, nimi, kuvaus, kastelu, valo, henkiloId);

		System.out.println(kasvi);// testi osoittaa ett‰ kasvit siirtyv‰t mutta
									// en osaa tehd‰ updatea Daossa

		// Luodaan dao-olio
		KasviDAO kasvidao = new KasviDAO();
		// Lis‰t‰‰n kasvin tiedot tietokantaan
		kasvidao.updateByKasviId(kasvi);

		List<Kasvi> kasvit = kasvidao.findKasvitByHenkiloId(henkiloId);

		// Talletetaan request-olion alle kasvilista, jotta tiedot ovat k‰ytˆss‰
		// jsp:ll‰
		request.setAttribute("kasvit", kasvit);

		// luodaan henkiloDao-olio
		HenkiloDAO henkiloDao = new HenkiloDAO();

		// etsit‰‰n henkilotietokannasta henkilo jonka id on parametrina saatu
		// henkilo id
		Henkilo henkilo = henkiloDao.findByhenkiloId(henkiloId);

		request.setAttribute("henkilo", henkilo);

		String jsp = "/view/HenkilonKasvin‰kym‰.jsp";
		RequestDispatcher dispather = getServletContext().getRequestDispatcher(jsp);
		dispather.forward(request, response);

		System.out.println(henkiloId);

	}

}
