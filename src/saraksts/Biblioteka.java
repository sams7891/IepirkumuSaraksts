package saraksts;

import java.util.LinkedList;
import java.util.regex.Pattern;

import javax.swing.JOptionPane;

public class Biblioteka {
	
	
	/*
	 * Meklēšanas metode
	 */
	
	static int meklet(LinkedList<Gramata> saraksts, String nosaukums) {

		for(int i = 0; i < saraksts.size(); i++) {
			if(saraksts.get(i).getNosaukums().equalsIgnoreCase(nosaukums))
				return i;
		}
		
		return -1;
	}
	
	static boolean mekletBoolean(LinkedList<Gramata> saraksts, String nosaukums) {

		for(int i = 0; i < saraksts.size(); i++) {
			if(saraksts.get(i).getNosaukums().equalsIgnoreCase(nosaukums)) {
				JOptionPane.showMessageDialog(null, "Tāda grāmata jau eksistē");
				return true;	
			}
		}
		
		return false;
	}
	
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
		

			
		}while(!Pattern.matches("^[\\p{L} .]+$", ievade));
		
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
		LinkedList<Gramata> panemtasGramatas = new LinkedList<>();
		String[] darbibas = {"Pievienot grāmatu", "Noņemt grāmatu", "Apskatīt grāmatu", "Iznomāt grāmatu", "Atdot grāmatas", "Apturēt"};
		
		do {
			izvelne = (String) JOptionPane.showInputDialog(null, "Izvēlies darbību", "Darbību saraksts", JOptionPane.INFORMATION_MESSAGE, null, darbibas, darbibas[0]);
			
			if(izvelne == null){
				izvelne = "Apturēt";
			}
			
			switch(izvelne) {
			case "Pievienot grāmatu":
				boolean gramataEksiste = false;
				do {
					gramataEksiste = false;
					nosaukums = virknesParbaude("Ieraksti grāmatas nosaukumu", "Intara manifesto");
					
					if(nosaukums == null)
						break;
					
					gramataEksiste = mekletBoolean(plaukts, nosaukums);
					
				}while(gramataEksiste);
				
				
				
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
				if(plaukts.isEmpty()) {
					JOptionPane.showMessageDialog(null, "Nav plauktā nevienas grāmatas!", "Brīdinājums", JOptionPane.WARNING_MESSAGE);
				} else {
					nosaukums = virknesParbaude("Kā sauc grāmatu, kuru vēlies noņemt", "Intara manifesto");
					
					if(nosaukums == null)
						break;
					
					indekss = meklet(plaukts, nosaukums);
					
					if(indekss == -1)
						JOptionPane.showMessageDialog(null, "Meklētā grāmata nemaz plauktā neotrodas!", "Brīdinājums", JOptionPane.WARNING_MESSAGE);
					else {
						plaukts.remove(indekss);
						
						JOptionPane.showMessageDialog(null, "Grāmata dzēsta", "Paziņojums", JOptionPane.INFORMATION_MESSAGE);
					}
				}
				
				break;
				
			case "Apskatīt grāmatu":
				if(plaukts.isEmpty()) {
					JOptionPane.showMessageDialog(null, "Nav plauktā nevienas grāmatas!", "Brīdinājums", JOptionPane.WARNING_MESSAGE);
					break;
				}
				
				nosaukums = virknesParbaude("Kuru grāmatu aplūkosiet", "Intara manifesto");
				
				if(nosaukums == null)
					break;
				
				indekss = meklet(plaukts, nosaukums);
				
				if(indekss == -1)
					JOptionPane.showMessageDialog(null, "Meklētā grāmata nemaz plauktā neotrodas!", "Brīdinājums", JOptionPane.WARNING_MESSAGE);
				else
					plaukts.get(indekss).info();
				
				break;
				
			case "Iznomāt grāmatu":
				
				if(plaukts.isEmpty())
					JOptionPane.showMessageDialog(null, "Nav plauktā nevienas grāmatas!", "Brīdinājums", JOptionPane.WARNING_MESSAGE);
				else {
					nosaukums = virknesParbaude("Kādu grāmatu meklējat", "Intara manifesto");
					
					if(nosaukums == null)
						break;
					
					indekss = meklet(plaukts, nosaukums);
					
					if(indekss == -1)
						JOptionPane.showMessageDialog(null, "Meklētā grāmata nemaz plauktā neotrodas!", "Brīdinājums", JOptionPane.WARNING_MESSAGE);
					else {
						plaukts.get(indekss).panemtGramatu();
						panemtasGramatas.add(plaukts.get(indekss));
					}
						
				}
				
				break;
				
			case "Atdot grāmatas":
				if(panemtasGramatas.isEmpty()) {
					JOptionPane.showMessageDialog(null, "Nav nevienas paņemtas grāmatas");
					break;
				}
				
				String[] gramatuNosaukumi = new String[panemtasGramatas.size()];
				
				for(int i = 0; i < panemtasGramatas.size(); i++ ){
					gramatuNosaukumi[i] = panemtasGramatas.get(i).getNosaukums();
				}
				
				JOptionPane.showInputDialog(null, "Kuru grāmatu vēlies atgriezt", "Izvēlne", JOptionPane.INFORMATION_MESSAGE, null, gramatuNosaukumi, gramatuNosaukumi[0]);
					
				break;
			}
			
		}while(!izvelne.equals(darbibas[darbibas.length - 1]));
	}

}
