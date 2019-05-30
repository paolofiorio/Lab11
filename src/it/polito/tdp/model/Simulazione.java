package it.polito.tdp.model;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Random;

public class Simulazione {

	private Random rd;
	private Statistiche statistiche;
	private Queue<Evento> eventi;	
	private Map<Integer, Tavolo> tavoli;
	
	
	public Simulazione() {
		rd = new Random(50);
		statistiche = new Statistiche();
		eventi = new PriorityQueue<Evento>();
		tavoli = new HashMap<Integer, Tavolo>();
	}
	
	public void aggiungiEvento(Evento e) {
		eventi.add(e);
	}
	
	public void simula() {
		while(!eventi.isEmpty())
			doSimula();
	}

	private long doSimula() {
		
		if(eventi.isEmpty())
			return Long.MAX_VALUE;
		 
		Evento e= eventi.remove();
		
		switch(e.evento) {
		
		case ARRIVO_GRUPPO_CLIENTI:
			Tavolo table = trovaTavoloDisponibile(e.getGruppo().getNum_persone());

			if (table != null) {

				// Assegno il tavolo ai clienti
				table.setIdGruppo(e.getGruppo().getId());
				table.setLibero(false);
				e.getGruppo().setSoddisfatti(true);

				// Creo un nuovo evento per simulare i clienti che escono dal
				// locale
				Evento uscita = new Evento(	Evento.TipoEvento.PARTENZA_GRUPPO_CLIENTI,
						e.getTimeStamp() + e.getGruppo().getDurata(), e.getGruppo());

				aggiungiEvento(uscita);

				System.out.println("Minuto: " + e.getTimeStamp() + " - Tavolo " + table.getIdTavolo() + " (Capienza: "
						+ table.getNumPostiASedere() + ") Occupato da Gruppo  " + e.getGruppo().getId() + " (Gruppo da "
						+ e.getGruppo().getNum_persone() + " Persone). Se ne vanno tra " + e.getGruppo().getDurata()
						+ " minuti");

			} else {

				float tolleranza = e.getGruppo().getTolleranza();
				float probabilita = rd.nextFloat();

				if (probabilita <= tolleranza) {

					// I clienti vengono serviti al bancone
					e.getGruppo().setSoddisfatti(true);
					System.out.println("Minuto: " + e.getTimeStamp() + " - Il gruppo  " + e.getGruppo().getId() + " (Gruppo da "
							+ e.getGruppo().getNum_persone() + " Persone) e' servito al bancone");

				} else {

					// I clienti escono dal locale non soddisfatti.
					e.getGruppo().setSoddisfatti(false);
					System.out.println("Minuto: " + e.getTimeStamp() + " - Il gruppo  " + e.getGruppo().getId() + " (Gruppo da "
							+ e.getGruppo().getNum_persone() + " Persone) se n'e' andato insoddisfatto");
				}
			}

			statistiche.aggiungiClienti(e.getGruppo());
			
			break;
			
		case PARTENZA_GRUPPO_CLIENTI:
		
			// I clienti lasciano il locale.
						// Libero il tavolo.
						Tavolo libero = this.trovaTavolo(e.getGruppo().getId());
						libero.setLibero(true);
						libero.setIdGruppo(-1);

						System.out.println("Minuto: " + e.getTimeStamp() + " - Tavolo " + libero.getIdTavolo() + " (Capienza: "
								+ libero.getNumPostiASedere() + ") Liberato da gruppo " + e.getGruppo().getId()
								+ ". Ritorna disponibile!");

						break;

					default:
			throw new IllegalArgumentException();
			
		}
		
		return e.getTimeStamp();
	}
	
	
	
	private Tavolo trovaTavoloDisponibile(int numPersone) {

		int postiTavoloMin = Integer.MAX_VALUE;
		Tavolo tav = null;

		// Itero su tutti i tavoli
		for (Tavolo t : new LinkedList<Tavolo>(tavoli.values())) {

			// Controllo i requisiti minimi
			if (t.isLibero() && numPersone >= 0.5 * t.getNumPostiASedere()) {

				// Cerco il tavolo con il minimo numero di posti a sedere.
				if (postiTavoloMin > t.getNumPostiASedere()) {
					tav = t;
					postiTavoloMin = t.getNumPostiASedere();
				}
			}
		}

		return tav;
	}

	public Tavolo trovaTavolo(int id) {

		for (Tavolo t : tavoli.values()) {
			if (t.getIdGruppo() == id)
				return t;
		}
		return null;
	}

	public void addTable(int numPosti) {
		Tavolo temp = new Tavolo(numPosti);
		tavoli.put(temp.getIdTavolo(), temp);
		statistiche.setNumTavoli(tavoli.size());
	}

	public Statistiche getStats() {
		return this.statistiche;
	}

	public void cleanup() {
		eventi.clear();
		statistiche.cleanup();
}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
