package saraksts;

import java.util.LinkedList;
import java.util.regex.Pattern;

import javax.swing.JOptionPane;

public class Biblioteka {

	/*
	 * Ievažu pārbaude
	 */
	static int skaitlaParbaude(String zinojums, int tips) {
		String ievade;
		int skaitlis;
		
		while(true) {
			ievade = JOptionPane.showInputDialog(null, zinojums, tips);
			
			if(ievade == null)
				return -1;
			
			try {
				
				skaitlis = Integer.parseInt(ievade);
				
				if(skaitlis < 1) {
					JOptionPane.showMessageDialog(null, "Ievadīts nepareizs skaitlis!", "Nekorekti dati", JOptionPane.WARNING_MESSAGE);
				}
				
				return skaitlis;
			}catch(NumberFormatException e) {
				JOptionPane.showMessageDialog(null, "Nepareizs skaitlis ir ievadīts", "Kļūda", JOptionPane.ERROR_MESSAGE);
			}
		}
	}
	
	static double skaitlaParbaude(String zinojums, double tips) {
		String ievade;
		double skaitlis;
		
		while(true) {
			ievade = JOptionPane.showInputDialog(null, zinojums, tips);
			
			if(ievade == null)
				return -1;
			
			try {
				
				skaitlis = Double.parseDouble(ievade);
				
				if(skaitlis < 0.1) {
					JOptionPane.showMessageDialog(null, "Ievadīts nepareizs skaitlis!", "Nekorekti dati", JOptionPane.WARNING_MESSAGE);
				}
				
				return skaitlis;
			}catch(NumberFormatException e) {
				JOptionPane.showMessageDialog(null, "Nepareizs skaitlis ir ievadīts", "Kļūda", JOptionPane.ERROR_MESSAGE);
			}
		}
	}
	
	static String virknesParbaude(String zinojums, String nokl) {
		String ievade;
		
		
		do {
			ievade = JOptionPane.showInputDialog(null, zinojums, nokl);
			if(ievade == null)
				return null;
			
			ievade = ievade.trim();
		

			
		}while(!Pattern.matches("^[\\p{L} ]+$", ievade));
		
		return ievade;
	}
	
	/*
	 * Main metode 
	 */
	
	public static void main(String[] args) {
		String nosaukums, autors, izdevnieciba, izvelne;
		int id = 1, skaits, lppSk, indekss;
		double cena;
		LinkedList<Gramata> plaukts = new LinkedList<>();
		String[] darbibas = {"Pievienot grāmatu", "Noņemt grāmatu", "Apskatīt grāmatu", "Iznomāt grāmatu", "Apturēt"};
		
		do {
			izvelne = (String) JOptionPane.showInputDialog(null, "Izvēlies darbību", "Darbību saraksts", JOptionPane.INFORMATION_MESSAGE, null, darbibas, darbibas[0]);
			
			if(izvelne == null){
				izvelne = "Apturēt";
			}
			
			switch(izvelne) {
			case "Pievienot grāmatu":
				nosaukums = virknesParbaude("Ieraksti grāmatas nosaukumu", "Intara manifesto");
				
				if(nosaukums == null)
					break;
				
				autors = virknesParbaude("Ieraksti autora vārdu", "Intars Lācis");
				
				if(autors == null)
					break;
				
				izdevnieciba = virknesParbaude("Ieraksti izdevniecību", "LVT");
				
				if(izdevnieciba == null)
					break;
				
				skaits = skaitlaParbaude("Norāda eksemplāru skaitu", 1);
				
				if(skaits == -1) 
					break;
				
				lppSk = skaitlaParbaude("Norādi lappušu skaitu", 10);
				
				if(lppSk == -1)
					break;
				
				cena = skaitlaParbaude("Norāde grāmatas cenu", 0.1);
				
				if(cena == -1.0)
					break;
				
				plaukts.add(new Gramata(id, skaits, lppSk, nosaukums, autors, izdevnieciba, cena));
				
				break;

			case "Noņemt grāmatu":
				
			}
			
		}while(!izvelne.equals(darbibas[darbibas.length - 1]));
	}

}
