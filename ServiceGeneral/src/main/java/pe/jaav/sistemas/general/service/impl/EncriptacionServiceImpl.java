package pe.jaav.sistemas.general.service.impl;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import pe.jaav.common.crypto.CryptoMotorUtiles;
import pe.jaav.sistemas.general.service.EncriptacionService;

@Service("encriptacionService")
@Transactional(readOnly = true)
public class EncriptacionServiceImpl implements EncriptacionService {

	@Override
	public String getCifrado(String token) {
		try{
			if(token!=null){
				return CryptoMotorUtiles.getCifrado(token);	
			}				
		}catch(Exception e){
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public boolean isMatchDescifrado(String tokenCifrado, String token) {
		try{
			
			if(token!=null){
				return CryptoMotorUtiles.isMatchDescifrado(tokenCifrado, token);	
			}else if(token == null && tokenCifrado == null){
				return true;
			}							
		}catch(Exception e){
			e.printStackTrace();
		}
		return false;
	}

}
