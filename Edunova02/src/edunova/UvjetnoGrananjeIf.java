package edunova;

public class UvjetnoGrananjeIf {

	private static boolean uvjet1() {
		System.out.println("Uvjet 1");
		return false;
	}
	
	private static boolean uvjet2() {
		System.out.println("Uvjet 2");
		return false;
	}
	
	
	
	public static void main(String[] args) {
		int i=2;
		
		boolean uvjet = i==1;
		
		if(uvjet) {
			System.out.println("1");
		}
		
		if(i==2) {
			System.out.println("2");
		}
		
		if(i>0) {
			System.out.println("Veće");
		}else {
			System.out.println("Manje ili jednako");
		}
		
		
		int j=1;
		//&logički i, on provjerava oba uvjeta
		if(i<0 & j>0) {
			System.out.println("Zadovoljena oba uvjeta");
		}
		
		
		//&&
		if(i<0 && j>0) {
			System.out.println("ZOB");
		}
		
		
		if(uvjet1() && uvjet2()) {
			System.out.println("OK");
		}
		
		//isto vrijedi i za ILI
		//ILI ne provjerava drugi uvjet ako je prvi zadovoljen
		//ali provjerava drugi čim prvi nije zadovoljen
		
		if(uvjet1() || uvjet2()) {
			System.out.println("od");
	}
		
		if(i%2==0) {
			
		}else if(i%3==0) {
			
		}else {
			
		}
	}
	

}



/*
 * binarno grananje- logičko grananje. 0-1
 * if-osnovna izvedba if naredbe- 10.linija
 * bad practice
 */