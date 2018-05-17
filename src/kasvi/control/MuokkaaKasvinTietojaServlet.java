package kasvi.control;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kasvi.model.Kasvi;
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
		
		// muokkaa painikkeen mukana parametrina jsp:lt� tuleva kasviId
		String idStr = request.getParameter("id");
		int KasviId = new Integer(idStr);

		System.out.println(KasviId);// testi
		
		// Kasvin muokkaus formiin tiedot tietokannasta
		KasviDAO kasvidao = new KasviDAO();
		Kasvi kasvi = kasvidao.findByKasviId(KasviId);
	
		// Talletetaan request-olion alle kasvi, jotta tiedot ovat k�yt�ss� jsp:ll�
		request.setAttribute("kasvi", kasvi);

		System.out.println(kasvi);

		// ohjaa sivulle jossa kasvin tietoja muokataan fromilla
		String jsp = "/view/MuokkaaKasvinTietoja.jsp";
		RequestDispatcher dispather = getServletContext().getRequestDispatcher(jsp);
		dispather.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
	// haetaan lomakkeella sy�tetyt  muokatut tiedot
	
		String stringId = request.getParameter("kasviId");//kasvin Id ei ole k�ytt�j�n muokattavissa
		int kasviId = new Integer(stringId);

		String nimi = request.getParameter("nimi"); // nimi

		String kuvaus = request.getParameter("kuvaus"); // kuvaus

		String kastelu = request.getParameter("kastelu"); // kastelu

		String valo = request.getParameter("valo"); // valo

		String stringHenkiloId = request.getParameter("henkiloId"); //henkiloId ei ole k�ytt�j�n muokattavissa
		int henkiloId = new Integer(stringHenkiloId);

		// Luodaan uusi KasviOlio edellisill� parametreill�
		Kasvi kasvi = new Kasvi(kasviId, nimi, kuvaus, kastelu, valo, henkiloId);

		System.out.println(kasvi);// testi onnistuuko uuden kasviOlion luonti

		// Luodaan dao-olio
		KasviDAO kasvidao = new KasviDAO();
		
		// p�ivitet��n uudet tiedot kasvista tiedot tietokantaan
		kasvidao.updateByKasviId(kasvi);
		
		//v�litet��n henkiloId parametrina henkilon-kasvit servletille jotta sivu avautuu uudestaan p�ivitetyn�
		response.sendRedirect("henkilon-kasvit?henkiloId=" + henkiloId);

	
		}	

	}


