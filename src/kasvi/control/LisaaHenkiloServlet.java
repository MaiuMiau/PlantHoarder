package kasvi.control;

import java.io.IOException;
import java.io.PrintWriter;
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
		// l�het� selaimelta tullut pyynt� servletilt� edelleen jsp:lle
		String jsp = "/view/henkilolomake.jsp";
		RequestDispatcher dispather = getServletContext().getRequestDispatcher(jsp);
		dispather.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		try {
			// Haetaan lomakkeella sy�tetyn henkilon tiedot request-oliolta
			
			String kayttajaTunnus = request.getParameter("kayttajaTunnus");
			String etuNimi = request.getParameter("etuNimi");
			String sukuNimi = request.getParameter("sukuNimi");
			
			if ((kayttajaTunnus.length()>30) || (etuNimi.length()>30) || (sukuNimi.length()>30)){
				
				PrintWriter writer = response.getWriter();
				writer.println("<html><body>");
				writer.println("<h1>V��r�n pituinen sy�te! MAXpituus30</h1>");
				writer.println("</body></html>");
			}
			else if ((kayttajaTunnus.length()<30) || (etuNimi.length()<30) || (sukuNimi.length()<30) ){
				// Luodaan uusi henkiloOlio edellisill� parametreill�
				Henkilo henkilo = new Henkilo(kayttajaTunnus, etuNimi, sukuNimi);
				
				
				
				// Luodaan khenkilodao
				HenkiloDAO henkilodao = new HenkiloDAO();
				
				// Lis�t��n henkilon tiedot tietokantaan
				henkilodao.addHenkilo(henkilo);
				
				// Talletetaan request-olion alle henkilo, jotta tiedot ovat k�yt�ss� jsp:ll�
				request.setAttribute("henkilo", henkilo);
				
				// ohjaa sivulle jossa n�ytet��n lis�tyn profiilin tiedot 
				String jsp = "/view/ProfiiliNakyma.jsp";
				RequestDispatcher dispather = getServletContext().getRequestDispatcher(
						jsp);
				dispather.forward(request, response);
				
				
			}
			
		} catch (SQLException e) {
			
			System.out.println("Sovelluksessa tapahtui virhe " + e.getMessage());
		}

		
	}

}
