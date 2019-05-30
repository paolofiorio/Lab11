package it.polito.tdp.model;

public class Statistiche {

	private int numero_totale_clienti;
	private int numero_clienti_soddisfatti;
	private int numero_clienti_insoddisfatti;
	
	private int numero_totale_gruppi = 0;
	private int gruppi_soddisfatti = 0;
	private int gruppi_insoddisfatti = 0;

	private int numTavoli = 0;
	
	
	public void aggiungiClienti(Gruppo g) {

		numero_totale_gruppi++;
		numero_totale_clienti += g.getNum_persone();

		if (g.isSoddisfatti()) {
			numero_clienti_soddisfatti += g.getNum_persone();
			gruppi_soddisfatti++;

		} else {
			numero_clienti_insoddisfatti += g.getNum_persone();
			gruppi_insoddisfatti++;
		}

	}

	public void setNumTavoli(int numero) {
		numTavoli = numero;
	}

	public void cleanup() {
		this.numero_totale_gruppi = 0;
		this.gruppi_soddisfatti = 0;
		this.gruppi_insoddisfatti = 0;
		
		this.numero_totale_clienti = 0; 
		this.numero_clienti_soddisfatti = 0;
		this.numero_clienti_insoddisfatti = 0;
	}

	@Override
	public String toString() {

		String ris = "Numero totale Gruppi:  " + this.numero_totale_gruppi + "\n";
		ris += "Numero totale Gruppi Soddisfatti:  " + this.gruppi_soddisfatti + "\n";
		ris += "Numero totale Gruppi Insoddisfatti:  " + this.gruppi_insoddisfatti + "\n";
		ris += "Numero totale Clienti:  " + this.numero_totale_clienti + "\n";
		ris += "Numero totale Clienti Soddisfatti:  " + this.numero_clienti_soddisfatti + "\n";
		ris += "Numero totale Clienti Insoddisfatti:  " + this.numero_clienti_insoddisfatti + "\n";
		ris += "Numero tavoli con cui lavora il simulatore:  " + this.numTavoli + "\n\n\n";

		return ris;
}
	
	
	
	
	}
