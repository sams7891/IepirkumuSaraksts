package saraksts;

import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedList;

import javax.swing.JOptionPane;

public class Uzd1 {
	
	static boolean jauEksiste(LinkedList<String> saraksts, String elements) {
		for(int i = 0; i < saraksts.size(); i++) {
						
			if(saraksts.get(i).equalsIgnoreCase(elements)) {
				JOptionPane.showMessageDialog(null, "Šāds produkts jau ir pievienots sarakstam!", "Kļūda", JOptionPane.WARNING_MESSAGE);
				return true;
			}
		}
		return false;
	}
	
	public static void main(String[] args) {
		String izvele, koPievienot, koAtrast, koNonemt, arKoAizstat;
		int kurPievienot, kurNonemt, kuruMainit;
		
		LinkedList<String> saraksts = new LinkedList<>();
		do {
			do {
				izvele = JOptionPane.showInputDialog("1 -Pievienot produktu\n2 -Produktu skaits\n"
						+ "3 -Izvadīt produktus\n4 -Atrast produktu\n"
						+ "5 -Pievienot konkrētā pozīcījā\n"
						+ "6 -Noņemt produktu\n7 -Noņemt pēc indeksa\n"
						+ "8 -Noņemt pirmo\n9 -Noņemt pēdējo\n"
						+ "10 -Mainīt produktu\n11 -Sakārtot alfabētiski\n"
						+ "12 -Nodzēst sarakstu\n0 -Apturēt");
						
						if(izvele == null)
							izvele = "0";
			}while(!izvele.matches("\\d+"));
			
			switch(izvele) {
			
			case "1":
				do {
					koPievienot = JOptionPane.showInputDialog("Kādu produktu pievienot?");
				}while((jauEksiste(saraksts, koPievienot) == true) || !koPievienot.matches("^[\\p{L} ]+$"));
				
				if(koPievienot.equalsIgnoreCase("Tomātu sula") || koPievienot.equalsIgnoreCase("Tomatu sula")) {
					JOptionPane.showMessageDialog(null, "Nebūs...");
					System.exit(0);
				}else {
					saraksts.add(koPievienot.toLowerCase());
				}
				
				JOptionPane.showMessageDialog(null, "Produkts pievienots sarakstam!", "Informācija", JOptionPane.INFORMATION_MESSAGE);	
				break;
				
			case "2":
				JOptionPane.showMessageDialog(null, "Produktu skaits: " + saraksts.size(), "Informācija", JOptionPane.INFORMATION_MESSAGE);
				break;
				
			case "3":
				if(saraksts.size() == 0)
					JOptionPane.showMessageDialog(null, "Nav sarakstā produktu", "Informācija", JOptionPane.INFORMATION_MESSAGE);
				else {
					Iterator<String> izvade = saraksts.iterator();
					String str = "";
					
					while(izvade.hasNext()) {
						str += izvade.next() + "\n";
					}
					
					JOptionPane.showMessageDialog(null, str, "Produktu saraksts", JOptionPane.INFORMATION_MESSAGE);
				}
				break;
				
			case "4":
				do {
					koAtrast = JOptionPane.showInputDialog(null, "Kādu produktu meklēt sarakstā?", "Jautājums", JOptionPane.INFORMATION_MESSAGE);
				}while(!koAtrast.matches("^[\\p{L} ]+$"));
				
				JOptionPane.showMessageDialog(null, ((saraksts.indexOf(koAtrast)) >- 1)? "Produktu saraksts" + saraksts.indexOf(koAtrast) + ". pozīcijā" : "Produkts netika atrasts sarakstā!", "Informācija", JOptionPane.INFORMATION_MESSAGE);
				break;
				
			case "5":
				do {
					koPievienot = JOptionPane.showInputDialog("Kādu produktu pievienot?");
					kurPievienot = Integer.parseInt(JOptionPane.showInputDialog("Kurā pozīcijā pievienot?"));
					
					
					
				}while((jauEksiste(saraksts, koPievienot) == true) || !koPievienot.matches("^[\\p{L} ]+$") || kurPievienot > saraksts.size() || kurPievienot < 0);
				
				saraksts.add(kurPievienot, koPievienot);
				break;
				
			case "6":
				
				do {
					koNonemt = JOptionPane.showInputDialog("Kuru produktu noņemt?");
				}while(!koNonemt.matches("^[\\p{L} ]+$") || !jauEksiste(saraksts, koNonemt));
				
				if(saraksts.remove(koNonemt.toLowerCase()))
					JOptionPane.showMessageDialog(null, "Produkts veiksīgi noņemts", "Paziņojums", JOptionPane.INFORMATION_MESSAGE
							);
				
				break;
				
			case "7":
				do {
					kurNonemt = Integer.parseInt(JOptionPane.showInputDialog("Kuras pozīcijas elementu noņemt?"));
				}while(kurNonemt >= saraksts.size() || kurNonemt < 0);
				
				JOptionPane.showMessageDialog(null, "Produkts: " + saraksts.get(kurNonemt) + " tika veiksmīgi noņemts.");
				saraksts.remove(kurNonemt);
				break;
				
			case "8":
				
				saraksts.removeFirst();
				JOptionPane.showMessageDialog(null, "Produkts: " + saraksts.get(0) + " tika veiksmīgi noņemts.");
				break;
				
			case "9":
				saraksts.removeLast();
				JOptionPane.showMessageDialog(null, "Produkts: " + saraksts.getLast() + " tika veiksmīgi noņemts.");
				break;
				
			case "10":
				do {
					kuruMainit = Integer.parseInt(JOptionPane.showInputDialog("Kura indeksa elementu mainīt"));
					arKoAizstat = JOptionPane.showInputDialog("Kāds būs jaunais produkts?");
				}while(!arKoAizstat.matches("^[\\p{L} ]+$"));
				break;
				
			case "11":
				Collections.sort(saraksts);
				break;
				
			case "12":
				saraksts.clear();
				JOptionPane.showMessageDialog(null, "Viss saraksts iztīrīts", "Ziņojums", JOptionPane.WARNING_MESSAGE);
				break;
				
			case "0":
				JOptionPane.showMessageDialog(null, "Programma apturēta", "Paziņojums", JOptionPane.INFORMATION_MESSAGE);
				
				default:
					JOptionPane.showMessageDialog(null, "Šāda darbība nepastāv", "Brīdinājums", JOptionPane.WARNING_MESSAGE);
					
			}
			
		}while(!izvele.equals("0"));

	}
	
	
}
