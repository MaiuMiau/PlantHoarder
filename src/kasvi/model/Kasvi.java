package kasvi.model;



public class Kasvi {

	// atribuutit eli ominaisuudet 
		private int id;
		private String nimi; //kasvin nimi
		private String kuvaus;// lyhyt kuvaus kasvista
		private String kastelu;// kasteluohje
		private String valo;// minkälaista valoa kasvitervitsee. Aurinko, puolivarjo jne.
		private int henkiloId; // 
		
		// parametriton konstruktori, alustaa olion atribuutin arvot nulliksi ja nolliksi
		public Kasvi(){
			
			this.id = 0;
			this.nimi = "";
			this.kuvaus="";
			this.kastelu = "";
			this.valo = "";
			this.henkiloId= 0;
		}
		//parametrillinen konstruktori
		
		public Kasvi(int id ,String nimi, String kuvaus,String kastelu,String valo, int henkiloId){
			
			this.id = id;
			this.nimi = nimi;
			this.kuvaus = kuvaus;
			this.kastelu = kastelu;
			this.valo = valo;
			this.henkiloId = henkiloId;
		}
		
		//parametrillinen konstruktori
		
				public Kasvi(String nimi, String kuvaus,String kastelu,String valo,int henkiloId){
					
					this.nimi = nimi;
					this.kuvaus = kuvaus;
					this.kastelu = kastelu;
					this.valo = valo;
					this.henkiloId = henkiloId;
				}
				//parametrillinen konstruktori
				
				public Kasvi(int id, String nimi, String kuvaus,String kastelu,String valo){
					this.id = id;
					this.nimi = nimi;
					this.kuvaus = kuvaus;
					this.kastelu = kastelu;
					this.valo = valo;
					
				}
		
		public void setId(int id) {
			this.id = id;
		}

		public void setNimi(String nimi) {
			this.nimi = nimi;
		}

		public void setKuvaus(String kuvaus) {
			this.kuvaus = kuvaus;
		}

		public void setKastelu(String kastelu) {
			this.kastelu = kastelu;
		}

		public void setValo(String valo) {
			this.valo = valo;
		}
		
		public int getId() {
			return id;
		}
		

		public String getNimi() {
			return nimi;
		}

		public String getKuvaus() {
			return kuvaus;
		}

		public String getKastelu() {
			return kastelu;
		}

		public String getValo() {
			return valo;
		}

		

		

		@Override
		public String toString() {
			return "Kasvi [id=" + id + ", nimi=" + nimi + ", kuvaus=" + kuvaus + ", kastelu=" + kastelu + ", valo="
					+ valo + ", henkiloId=" + henkiloId + "]";
		}

		public int getHenkiloId() {
			return henkiloId;
		}

		public void setHenkiloId(int henkiloId) {
			this.henkiloId = henkiloId;
		}

		
		
		
}
