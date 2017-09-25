package pe.jaav.sistemas.seguridadgeneral.model.domain;

import java.io.Serializable;

public class EntidadSup implements Serializable{

	private static final long serialVersionUID = 1L;

	private int inicio;
	private int numeroFilas;
	private int numeroColumnas;
	private boolean visibled;
	
	private int accionDB;
	
	private String valorStringSup;
	private Integer valorIntSup;
	public int getInicio() {
		return inicio;
	}
	public void setInicio(int inicio) {
		this.inicio = inicio;
	}
	public int getNumeroFilas() {
		return numeroFilas;
	}
	public void setNumeroFilas(int numeroFilas) {
		this.numeroFilas = numeroFilas;
	}
	public int getNumeroColumnas() {
		return numeroColumnas;
	}
	public void setNumeroColumnas(int numeroColumnas) {
		this.numeroColumnas = numeroColumnas;
	}
	public boolean isVisibled() {
		return visibled;
	}
	public void setVisibled(boolean visibled) {
		this.visibled = visibled;
	}
	public int getAccionDB() {
		return accionDB;
	}
	public void setAccionDB(int accionDB) {
		this.accionDB = accionDB;
	}
	public String getValorStringSup() {
		return valorStringSup;
	}
	public void setValorStringSup(String valorStringSup) {
		this.valorStringSup = valorStringSup;
	}
	
	public Integer getValorIntSup() {
		return valorIntSup;
	}
	public void setValorIntSup(Integer valorIntSup) {
		this.valorIntSup = valorIntSup;
	}
	

	
}
