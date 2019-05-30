package it.polito.tdp.model;

public class Tavolo {

	
	static private int totaleTavoli = 0;
	private int idGruppo;
	private int idTavolo;
	private int numPostiASedere;
	private boolean libero;

	public Tavolo(int numPostiASedere) {
		this.libero = true;
		this.numPostiASedere = numPostiASedere;
		idTavolo = ++totaleTavoli;
		idGruppo = -1;
	}

	public int getIdGruppo() {
		return idGruppo;
	}

	public void setIdGruppo(int idGruppo) {
		this.idGruppo = idGruppo;
	}

	public int getIdTavolo() {
		return idTavolo;
	}

	public void setIdTavolo(int idTavolo) {
		this.idTavolo = idTavolo;
	}

	public int getNumPostiASedere() {
		return numPostiASedere;
	}

	public void setNumPostiASedere(int numPostiASedere) {
		this.numPostiASedere = numPostiASedere;
	}

	public boolean isLibero() {
		return libero;
	}

	public void setLibero(boolean libero) {
		this.libero = libero;
	}
	
}
