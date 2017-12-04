package pe.jaav.sistemas.general.service;

public interface EncriptacionService {

	public String getCifrado(String token);
	
	public boolean isMatchDescifrado(String tokenCifrado,String token);
	
}
