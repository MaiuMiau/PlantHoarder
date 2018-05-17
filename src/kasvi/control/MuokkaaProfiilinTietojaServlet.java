package kasvi.control;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kasvi.model.Henkilo;
import kasvisto.model.dao.HenkiloDAO;


@WebServlet("/muokkaa-profiilin-tietoja")
public class MuokkaaProfiilinTietojaServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
    public MuokkaaProfiilinTietojaServlet() {
        super();
        
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		// muokkaa painikkeen mukana parametrina jsp:ltä tuleva henkiloId
		String idStr = request.getParameter("id");
		int henkiloId = new Integer(idStr);

		System.out.println(henkiloId);// testi
		
		// henkilon muokkaus formiin tiedot tietokannasta
		HenkiloDAO henkilodao = new HenkiloDAO();
		Henkilo henkilo = henkilodao.findByhenkiloId(henkiloId);
		
		// Talletetaan request-olion alle henkilo, jotta tiedot ovat käytössä jsp:llä
		request.setAttribute("henkilo", henkilo);

		System.out.println(henkilo);// testi

		// ohjaa sivulle jossa muokataan profiilin tietoja lomakkeella
		String jsp = "/view/MuokkaaProfiilinTietoja.jsp";
		RequestDispatcher dispather = getServletContext().getRequestDispatcher(jsp);
		dispather.forward(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		// Haetaan lomakkeella syötetyt päivitetyt tiedot request-oliolta
		String stringId = request.getParameter("Id"); // henkiloId ei ole käyttäjän muutettavissa vaan on formissa piiloettuna
		int Id = new Integer(stringId);
		
		String kayttajaTunnus = request.getParameter("kayttajaTunnus");

		String etuNimi = request.getParameter("etuNimi");

		String sukuNimi = request.getParameter("sukuNimi");

		// Luodaan uusi henkiloOlio edellisillä parametreillä
		Henkilo henkilo = new Henkilo(Id,kayttajaTunnus, etuNimi, sukuNimi);

		// Luodaan henkilodao
		HenkiloDAO henkilodao = new HenkiloDAO();
		
		// Päivitetään henkilon tiedot lomakkeella anettujen tietojen mukaan
		henkilodao.updateById(henkilo);

		// uudelleenohjataan Profiilin tiedot sivuille jossa näkyvät nyt päivitetyt tiedot
		response.sendRedirect("profiilin-tiedot?henkiloId=" + Id);
	}

}
