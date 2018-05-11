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
		String idStr = request.getParameter("id");
		int henkiloId = new Integer(idStr);

		System.out.println(henkiloId);
		// henkilon muokkaus formiin tiedot tietokannasta
		HenkiloDAO henkilodao = new HenkiloDAO();
		Henkilo henkilo = henkilodao.findByhenkiloId(henkiloId);

		request.setAttribute("henkilo", henkilo);

		System.out.println(henkilo);

		// ohjaa sivulle jossa valitaan profiilin perustella kenen kasvit
		// näytetään
		String jsp = "/view/MuokkaaProfiilinTietoja.jsp";
		RequestDispatcher dispather = getServletContext().getRequestDispatcher(jsp);
		dispather.forward(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String stringId = request.getParameter("henkiloId");
		int Id = new Integer(stringId);
		
		String kayttajaTunnus = request.getParameter("kayttajaTunnus");

		String etuNimi = request.getParameter("etuNimi");

		String sukuNimi = request.getParameter("sukuNimi");

		// Luodaan uusi henkiloOlio edellisillä parametreillä
		Henkilo henkilo = new Henkilo(Id,kayttajaTunnus, etuNimi, sukuNimi);

		// Luodaan henkilodao
		HenkiloDAO henkilodao = new HenkiloDAO();
		
		// Muokataan henkilon tietoja lomakkeella anettujen syötteiden mukaan
		henkilodao.updateById(henkilo);

		// uudelleenohjataan selain etusivulle
		response.sendRedirect("etusivu");
	}

}
