package kasvi.model;





	public class Henkilo {

		// atribuutit eli ominaisuudet 
			private int id;
			private String kayttajaTunnus;
			private String etuNimi; 
			private String sukuNimi;
			
			
			// parametriton konstruktori, alustaa olion atribuutin arvot nulliksi ja nolliksi
			public Henkilo(){
				super();
				this.id = 0;
				this.kayttajaTunnus = "";
				this.etuNimi="";
				this.sukuNimi = "";
				
			}
			//parametrillinen konstruktori
			
			public Henkilo(int id, String kayttajaTunnus, String etuNimi,String sukuNimi ){
				super();
				this.id = id;
				this.kayttajaTunnus = kayttajaTunnus;
				this.etuNimi = etuNimi;
				this.sukuNimi= sukuNimi;
				
			}
			
//parametrillinen konstruktori
			
			public Henkilo(String kayttajaTunnus, String etuNimi,String sukuNimi ){
				super();
				this.kayttajaTunnus = kayttajaTunnus;
				this.etuNimi = etuNimi;
				this.sukuNimi= sukuNimi;
				
			}
			
			
			
			

			public void setKayttajaTunnus(String kayttäjaTunnus) {
				this.kayttajaTunnus = kayttäjaTunnus;
			}

			public void setEtuNimi(String etuNimi) {
				this.etuNimi = etuNimi;
			}

			public void setSukuNimi(String sukuNimi) {
				this.sukuNimi = sukuNimi;
			}

			public String getKayttajaTunnus() {
				return kayttajaTunnus;
			}

			public String getEtuNimi() {
				return etuNimi;
			}

			public String getSukuNimi() {
				return sukuNimi;
			}

			@Override
			public String toString() {
				return "Henkilo [kayttäjaTunnus=" + kayttajaTunnus + ", etuNimi=" + etuNimi + ", sukuNimi=" + sukuNimi
						+ "]";
			}

			public int getId() {
				return id;
			}

			public void setId(int id) {
				this.id = id;
			}
			
}
