package it.polito.tdp.bar;

import java.net.URL;
import java.util.Random;
import java.util.ResourceBundle;

import it.polito.tdp.model.Evento;
import it.polito.tdp.model.Gruppo;
import it.polito.tdp.model.Simulazione;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;

public class BarController {

	private Simulazione simulazione;
    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TextArea txtRisultato;

    @FXML
    private Button btnSimula;

    @FXML
    void doSimula(ActionEvent event) {
    	simulazione.cleanup();
    	
		// Creo un nuovo generatore di numeri casuali con seed iniziale 50.
		Random rn = new Random(50);

		long lastTimeOfArrival = 0;
		
		// Genero 2000 eventi.
		for (int t = 0; t < 2000; ++t) {
			
			long timeOfArrival = lastTimeOfArrival + 1 + rn.nextInt(9);
			long duration = (long) (60 + Math.random() * 60);
			float tolerance = rn.nextFloat();
			int numberOfPeople =  1 + rn.nextInt(9);
			
			// Genero un nuovo gruppo di clienti
			Gruppo customerGroup = new Gruppo(timeOfArrival, duration, tolerance, numberOfPeople);
			
			// Creo un nuovo evento e lo inserisco nella coda.
			Evento e = new Evento( Evento.TipoEvento.ARRIVO_GRUPPO_CLIENTI,timeOfArrival, customerGroup);
			simulazione.aggiungiEvento(e);
		}
		
		// Avvio la simulazion
		simulazione.simula();
		
		// Ottengo il risultato
		txtRisultato.appendText(simulazione.getStats().toString()); 
    }

    @FXML
    void initialize() {
        assert txtRisultato != null : "fx:id=\"txtRisultato\" was not injected: check your FXML file 'Bar.fxml'.";
        assert btnSimula != null : "fx:id=\"btnSimula\" was not injected: check your FXML file 'Bar.fxml'.";

    }

	public void setModel(Simulazione model) {
		// TODO Auto-generated method stub
		this.simulazione= model;
		
		simulazione.addTable(10);
		simulazione.addTable(10);
		
		simulazione.addTable(8);
		simulazione.addTable(8);
		simulazione.addTable(8);
		simulazione.addTable(8);
		
		simulazione.addTable(6);
		simulazione.addTable(6);
		simulazione.addTable(6);
		simulazione.addTable(6);
		
		simulazione.addTable(4);
		simulazione.addTable(4);
		simulazione.addTable(4);
		simulazione.addTable(4);
		simulazione.addTable(4);
	}
}

