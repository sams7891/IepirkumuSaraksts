package saraksts;

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
				
				if(koPievienot.equalsIgnoreCase("Tomātu sula")) {
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
			}
			
		}while(!izvele.equals("0"));

	}
	
	
}
