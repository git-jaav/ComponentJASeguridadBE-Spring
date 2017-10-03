package pe.jaav.sistemas.seguridadgeneral.model.domain;

import java.io.Serializable;

public class EntidadSup implements Serializable{

	private static final long serialVersionUID = 1L;

	private int inicio;
	private int numeroFilas;
	private int numeroColumnas;			
	private int contadorTotal;
	
	private int accionDB;
	
	private String valorStringSup;
	private Integer valorIntSup;
	private boolean valorBoolSup;
	
	
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
	public int getContadorTotal() {
		return contadorTotal;
	}
	public void setContadorTotal(int contadorTotal) {
		this.contadorTotal = contadorTotal;
	}
	public boolean isValorBoolSup() {
		return valorBoolSup;
	}
	public void setValorBoolSup(boolean valorBoolSup) {
		this.valorBoolSup = valorBoolSup;
	}
	

	
}
