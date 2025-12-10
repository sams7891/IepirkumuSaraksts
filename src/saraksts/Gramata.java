package saraksts;

import java.time.LocalDate;

import javax.swing.JOptionPane;

public class Gramata {
	private  int id, skaits, lppSk;
	private String nosaukums, autors, izdevnieciba;
	private LocalDate panemts, atgriezts;
	private double cena;
	
	public Gramata(int id, int skaits, int lppSk, String nosaukums, String autors, String izdevnieciba, double cena) {
		this.setId(id);
		this.setSkaits(skaits);
		this.setLppSk(lppSk);
		this.setNosaukums(nosaukums);
		this.autors = autors;
		this.izdevnieciba = izdevnieciba;
		this.cena = cena;
	}
	
	public void info() {
		JOptionPane.showMessageDialog(null, "ID: " + id + 
				"\nNosaukums: " + nosaukums +
				"\nAutors: " + autors + 
				"\nIzdevniecība: " + izdevnieciba +
				"\nLappušu skaits: " + lppSk +
				"\nCena: " + cena + " EUR" + 
				"\nEksemplāru skaits: " + skaits);
	}
	
	
	public void panemtGramatu() {
		if(skaits > 0) {
			skaits --;
			panemts = LocalDate.now();
			atgriezts = panemts.plusMonths(1);
			JOptionPane.showMessageDialog(null, "Grāmata paņemta: " + panemts + "\nGrāmatu jātgriež: " + atgriezts, "Brīdinājums", JOptionPane.WARNING_MESSAGE);
		} else {
			JOptionPane.showMessageDialog(null, "Grāmata nav pieejama, visi eksemplāri paņemti!", "Brīdinājums", JOptionPane.WARNING_MESSAGE);
		}
	}
	public int getSkaits() {
		return skaits;
	}

	public void setSkaits(int skaits) {
		this.skaits = skaits;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getLppSk() {
		return lppSk;
	}

	public void setLppSk(int lppSk) {
		this.lppSk = lppSk;
	}

	public String getNosaukums() {
		return nosaukums;
	}

	public void setNosaukums(String nosaukums) {
		this.nosaukums = nosaukums;
	}
}
