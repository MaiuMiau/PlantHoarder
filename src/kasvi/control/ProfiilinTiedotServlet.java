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

@WebServlet("/profiilin-tiedot")
public class ProfiilinTiedotServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public ProfiilinTiedotServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// Haetaan henkiloId request-oliolta

		String stringHenkiloId = request.getParameter("henkiloId");
		int henkiloId = new Integer(stringHenkiloId);

		// luodaan henkiloDao
		HenkiloDAO henkiloDao = new HenkiloDAO();

		// etsitään henkilotietokannasta henkilo jonka id on parametrina saatu
		// henkilo id
		Henkilo henkilo = henkiloDao.findByhenkiloId(henkiloId);
		
		
		request.setAttribute("henkilo", henkilo);

		// lähetä selaimelta tullut pyyntö servletiltä edelleen jsp:lle
		String jsp = "/view/ProfiiliNakyma.jsp";
		RequestDispatcher dispather = getServletContext().getRequestDispatcher(jsp);
		dispather.forward(request, response);

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
