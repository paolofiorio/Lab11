package it.polito.tdp.model;

import java.util.Random;

public class TestSimulazione {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Simulazione simulation = new Simulazione();

    	simulation.addTable(10);
    	simulation.addTable(10);

    	simulation.addTable(8);
    	simulation.addTable(8);
    	simulation.addTable(8);
    	simulation.addTable(8);

    	simulation.addTable(6);
    	simulation.addTable(6);
    	simulation.addTable(6);
    	simulation.addTable(6);

    	simulation.addTable(4);
    	simulation.addTable(4);
    	simulation.addTable(4);
    	simulation.addTable(4);
    	simulation.addTable(4);

		// Creo un nuovo generatore di numeri casuali con seed iniziale 50.
		Random rn = new Random(50);

		long lastTimeOfArrival = 0;
		
		// Genero 2000 eventi.
		for (int t = 0; t < 2000; ++t) {
			
			long timeOfArrival = lastTimeOfArrival + 1 + rn.nextInt(9);
			long duration = (long) (60 + Math.random() * 60);
			float tolerance = rn.nextFloat();
			int numberOfPeople =  1 + rn.nextInt(9);
			
			// Genro un nuovo gruppo di clienti
			Gruppo customerGroup = new Gruppo(timeOfArrival, duration, tolerance, numberOfPeople);
			
			// Creo un nuovo evento e lo inserisco nella coda.
			Evento e = new Evento(Evento.TipoEvento.ARRIVO_GRUPPO_CLIENTI,timeOfArrival,  customerGroup);
			simulation.aggiungiEvento(e);
		}

		System.out.print("\n\n*** SIMULATION STARTS ***\n\n");
		
		simulation.simula();

		System.out.print("\n\n*** SIMULATION ENDS ***\n\n");

		System.out.println("\n\n\n STATISTICHE \n");

		System.out.println(simulation.getStats().toString());

}
	}


