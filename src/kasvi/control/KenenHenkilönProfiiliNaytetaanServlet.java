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
import kasvisto.model.dao.HenkiloDAO;


@WebServlet("/kenen-profiili-naytetaan")
public class KenenHenkilönProfiiliNaytetaanServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public KenenHenkilönProfiiliNaytetaanServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		// haetaan jsp:n profiilin-valintalistaan vaihtoehdot tietokannasta
		HenkiloDAO henkilodao = new HenkiloDAO();
		List<Henkilo> henkilot = henkilodao.findAll();
		
		// Talletetaan request-olion alle henkilo, jotta tiedot ovat käytössä jsp:llä
		request.setAttribute("henkilot", henkilot);
		
		// ohjaa sivulle jossa valitaan profiilin perustella kenen profiilin tiedot näytetään
		String jsp = "/view/KenenHenkilonProfiiliNaytetaan.jsp";
		RequestDispatcher dispather = getServletContext().getRequestDispatcher(
				jsp);
		dispather.forward(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
