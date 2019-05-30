package it.polito.tdp.model;

public class Gruppo {
	static private int idGruppo = 0;
	private int id;
	private long arrivo;
	private long durata;
	private float tolleranza;
	private int num_persone;
	private boolean soddisfatti;
	public Gruppo(long arrivo, long durata, float tolleranza, int num_persone) {
		super();
		this.id= idGruppo++;
		this.arrivo = arrivo;
		this.durata = durata;
		this.tolleranza = tolleranza;
		this.num_persone = num_persone;
		this.soddisfatti = false;
	}
	public static int getIdGruppo() {
		return idGruppo;
	}
	public static void setIdGruppo(int idGruppo) {
		Gruppo.idGruppo = idGruppo;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public long getArrivo() {
		return arrivo;
	}
	public void setArrivo(long arrivo) {
		this.arrivo = arrivo;
	}
	public long getDurata() {
		return durata;
	}
	public void setDurata(long durata) {
		this.durata = durata;
	}
	public float getTolleranza() {
		return tolleranza;
	}
	public void setTolleranza(float tolleranza) {
		this.tolleranza = tolleranza;
	}
	public int getNum_persone() {
		return num_persone;
	}
	public void setNum_persone(int num_persone) {
		this.num_persone = num_persone;
	}
	public boolean isSoddisfatti() {
		return soddisfatti;
	}
	public void setSoddisfatti(boolean soddisfatti) {
		this.soddisfatti = soddisfatti;
	}
	
	@Override
	public String toString() {
		return "Customer#" + id;
	}
	
	
}
