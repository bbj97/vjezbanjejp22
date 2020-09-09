package edunova;

public class Start {

	public Start() {

		while (true) {

			izbornik();

			switch (Pomocno.akcija()) {
			case 1:
				Pomocno.unosDjela();
				break;
			case 2:
				CrudMet.ispisDjelaIzBaze();
				break;
			case 3:
				Pomocno.promjenaDjela();
				break;
			case 4:
				Pomocno.brisanjeDjela();
				break;
			case 5:
				idiNaEraDijagram();
				break;
			case 6:
				idiNaKodAplikacije();
				break;
			case 7:
				Baza.zatvoriVezu();
				System.out.println("Connection closed");
				return;

			}
		}
	}



	private void izbornik() {
		// TODO Auto-generated method stub
		
		System.out.println("******************************");
		System.out.println(" 1 - Unos novog djela");
		System.out.println(" 2 - Izlistaj sva djela");
		System.out.println(" 3 - Promjena podataka djela");
		System.out.println(" 4 - Brisanje djela");
		System.out.println(" 5 - Idi na ERA dijagram baze");
		System.out.println(" 6 - Idi na kod aplikacije");
		System.out.println(" 7 - Izlaz iz aplikacije");
		System.out.println("******************************");
		
	}



	private void idiNaKodAplikacije() {
		// TODO Auto-generated method stub
		
	}



	private void idiNaEraDijagram() {
		// TODO Auto-generated method stub
		
	}



	public static void main(String[] args) {
		new Start();
	}

}
