package it.polito.tdp.model;

public class Evento implements Comparable<Evento> {

	public enum TipoEvento  {
		ARRIVO_GRUPPO_CLIENTI, PARTENZA_GRUPPO_CLIENTI
	};
	
	public TipoEvento evento;
	private long timeStamp;
	private Gruppo gruppo;
	
	public Evento(TipoEvento evento, long timeStamp, Gruppo gruppo) {
		super();
		this.evento = evento;
		this.timeStamp = timeStamp;
		this.gruppo = gruppo;
	}
	
	public long getTimeStamp() {
		return timeStamp;
	}
	public void setTimeStamp(long timeStamp) {
		this.timeStamp = timeStamp;
	}

	public Gruppo getGruppo() {
		return gruppo;
	}

	public void setGruppo(Gruppo gruppo) {
		this.gruppo = gruppo;
	}

	@Override

	public int compareTo(Evento e) {
		return Long.compare(this.timeStamp, e.timeStamp);
}
	
	
	
}
