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


@WebServlet("/kenen-kasvit-haluat-nahda")
public class KenenHenkilonKasvitHaluatNahdaServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
    public KenenHenkilonKasvitHaluatNahdaServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//   haetaan jsp:n profiilin-valintalistaan vaihtoehdot tietokannasta
		HenkiloDAO henkilodao = new HenkiloDAO();
		List<Henkilo> henkilot = henkilodao.findAll();
		
		// Talletetaan request-olion alle kasvilista, jotta tiedot ovat käytössä jsp:llä
		request.setAttribute("henkilot", henkilot);
		
		// ohjaa sivulle jossa valitaan profiilin perustella kenen kasvit näytetään
		String jsp = "/view/KenenHenkilonKasvitNaytetaan.jsp";
		RequestDispatcher dispather = getServletContext().getRequestDispatcher(
				jsp);
		dispather.forward(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 
		
		
	}

}
