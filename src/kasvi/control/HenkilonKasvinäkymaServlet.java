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

@WebServlet("/henkilon-kasvit")
public class HenkilonKasvinäkymaServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public HenkilonKasvinäkymaServlet() {
		super();

	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		//etsitään tietokannasta kaikki henkilön kasvit ja välitetään tiedot jsp:lle
		
		// Haetaan lomakkeella syötetyn henkiloId:n tiedot request-oliolta
		String stringHenkiloId = request.getParameter("henkiloId");
		int henkiloId = new Integer(stringHenkiloId);

		// Luodaan kasvidao-olio
		KasviDAO kasvidao = new KasviDAO();
		
		// etsitään kasvitietokannasta kasvit joidenka viiteavaimena on
		// parametrina saatu henkiloId
		List<Kasvi> kasvit = kasvidao.findKasvitByHenkiloId(henkiloId);

		// Talletetaan request-olion alle kasvilista, jotta tiedot ovat käytössä
		// jsp:llä
		request.setAttribute("kasvit", kasvit);
		
		System.out.println(kasvit);// testitulostus
		
		//luodaan henkiloDao-olio
		HenkiloDAO henkiloDao = new HenkiloDAO();
		
		// etsitään henkilotietokannasta henkilo jonka id on parametrina saatu henkilo id
		Henkilo henkilo = henkiloDao.findByhenkiloId(henkiloId);
		
		request.setAttribute("henkilo", henkilo);
		
		// lähetä selaimelta tullut pyyntö servletiltä edelleen jsp:lle
		String jsp = "/view/HenkilonKasvinäkymä.jsp";
		RequestDispatcher dispather = getServletContext().getRequestDispatcher(jsp);
		dispather.forward(request, response);

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
