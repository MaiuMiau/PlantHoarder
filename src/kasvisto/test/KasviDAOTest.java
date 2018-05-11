package kasvisto.test;

import java.util.ArrayList;

import kasvi.model.Kasvi;
import kasvisto.model.dao.KasviDAO;


public class KasviDAOTest {

	public static void main(String[] args) {
KasviDAO kasvidao = new KasviDAO();
		
		ArrayList<Kasvi> kasvit = kasvidao.findAll();
		
		
		
			System.out.println(kasvit);

	}

}
