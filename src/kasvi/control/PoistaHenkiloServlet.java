package kasvi.control;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kasvisto.model.dao.HenkiloDAO;
import kasvisto.model.dao.KasviDAO;

@WebServlet("/poista-henkilo")
public class PoistaHenkiloServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public PoistaHenkiloServlet() {
		super();

	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		try {
			// poistetaan poista painikkeen mukana parametrina tuleen henkiloid:n perusteella kaikki henkilon kasvit
			// kasvit joissa on viiteavaimena henkiloId pit‰‰ poistaa ennen kuin henkilo voidaan poistaa
			String idStr = request.getParameter("id");
			int henkiloId = new Integer(idStr);
			// Luodaan kasvidao
			KasviDAO kasvidao = new KasviDAO();
			// Lis‰t‰‰n kasvin tiedot tietokantaan
			kasvidao.removeKasviByHenkiloId(henkiloId);
		} catch (SQLException e) {
			
			System.out.println("Sovelluksessa tapahtui virhe " + e.getMessage());
		}

		try {
			// poistetaan poista painikkeen mukana parametrina tuleen henkiloid:n perusteella henkilo
			String idStr = request.getParameter("id");
			int henkiloId = new Integer(idStr);
			// Luodaan henkilodao
			HenkiloDAO henkilodao = new HenkiloDAO();
			// Lis‰t‰‰n henkilˆn tiedot tietokantaan
			henkilodao.removeHenkilo(henkiloId);
		} catch (SQLException e) {
			
			System.out.println("Sovelluksessa tapahtui virhe " + e.getMessage());
		}

		// uudelleenohjataan selain etusivulle
		response.sendRedirect("etusivu");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
