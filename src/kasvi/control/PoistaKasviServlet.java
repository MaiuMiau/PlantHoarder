package kasvi.control;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kasvisto.model.dao.KasviDAO;

@WebServlet("/poista-kasvi")
public class PoistaKasviServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	

	public PoistaKasviServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		try {

			// poistetaan kasvi poista painikkeen mukana parametrina tuleen kasviId:n perusteella
			String idStr = request.getParameter("id");
			int kasviId = new Integer(idStr);
			
			System.out.println(kasviId); //testi

			// Luodaan kasvidao
			KasviDAO kasvidao = new KasviDAO();
			// poistetaan kavin toedot tietokannasta kasviId:n perusteella
			kasvidao.removeKasvi(kasviId);
		} catch (SQLException e) {
			
			System.out.println("Sovelluksessa tapahtui virhe " + e.getMessage());
		}
		// poista painikkeen mukana parametrina tulee myös henkiloId jotta voidaan käyttää sitä sivun uudelleen ohjauksessa
		String idHenkStr = request.getParameter("henkiloId");
		int henkiloId = new Integer(idHenkStr);
		
		System.out.println(henkiloId);// testi
		
		//välitetään henkiloId parametrina henkilon-kasvit servletille jotta sivu avautuu uudestaan päivitetynä
		response.sendRedirect("henkilon-kasvit?henkiloId=" + henkiloId);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
