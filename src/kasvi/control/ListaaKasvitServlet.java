package kasvi.control;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kasvi.model.Kasvi;
import kasvisto.model.dao.KasviDAO;


@WebServlet("/listaa-kasvi")
public class ListaaKasvitServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public ListaaKasvitServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

	
		
		KasviDAO kasvidao = new KasviDAO();
		
		ArrayList<Kasvi> kasvit = kasvidao.findAll();
		request.setAttribute("kasvit", kasvit);

		// lähetä selaimelta tullut pyyntö servletiltä edelleen jsp:lle
		String jsp = "/view/kasvilista2.jsp";
		RequestDispatcher dispather = getServletContext().getRequestDispatcher(jsp);
		dispather.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
