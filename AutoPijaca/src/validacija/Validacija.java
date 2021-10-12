package validacija;

public class Validacija {
	
	//ispis parametara
	public void ispisiParametre(String userName, String password, 
								String repeatedPassword, String tipUsera) {
		
		System.out.println("Parametri su: ");
		System.out.println("User name: " + userName);
		System.out.println("Password: " + password);
		System.out.println("Repeated Password: " + repeatedPassword);
		System.out.println("Tip Usera: " + tipUsera);
	}

	// metoda koja proverava password
	public boolean daLiJePassDobar(String password) {
		
		int duzinaPassworda = password.length();
		
		if(duzinaPassworda < 8) {
			System.out.println("Password FAILED!!!");
			return false;
		}
		
		int brojacCifara = 0;
		int brojacVelikihSlova = 0;
		// prolaz kroz String -> niz char-ova
		for(int i = 0; i < duzinaPassworda; i++) {
			
			char karakter = password.charAt(i);
			
			if(Character.isDigit(karakter)) {
				brojacCifara ++;
			}
			
			if(Character.isUpperCase(karakter)) {
				brojacVelikihSlova ++;
			}	
		}
		
		if(brojacCifara >= 1 && brojacVelikihSlova >= 2) {
			System.out.println("Password OK...");
			return true;
		}else {
			System.out.println("Password FAILED!!!");
			return false;
		}
			
	}
	
	
	

}
