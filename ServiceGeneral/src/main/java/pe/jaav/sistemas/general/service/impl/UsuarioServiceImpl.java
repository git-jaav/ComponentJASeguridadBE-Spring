package pe.jaav.sistemas.general.service.impl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import pe.jaav.common.util.UtilesCommons;
import pe.jaav.sistemas.general.service.EncriptacionService;
import pe.jaav.sistemas.general.service.UsuarioService;
import pe.jaav.sistemas.general.service.utiles.Log;
import pe.jaav.sistemas.seguridadgeneral.model.dao.UsuarioDao;
import pe.jaav.sistemas.seguridadgeneral.model.domain.SysUsuario;

@Service("usuarioService")
@Transactional(readOnly = true)
public class UsuarioServiceImpl implements UsuarioService{

	@Autowired
	UsuarioDao usuarioDao;


	@Autowired
	EncriptacionService encriptacionService;
	
	
	@Override
	@Transactional(readOnly = false)
	public int guardar(SysUsuario objUsuario) {		
		try{
			/**Cifrar clave nueva**/			
			objUsuario.setUsuaFechamodif(new Date());
			if(objUsuario.getUsuaClave()!=null){
				objUsuario.setUsuaClave(encriptacionService.getCifrado(objUsuario.getUsuaClave()));	
			}
			return usuarioDao.guardar(objUsuario);
		}catch(Exception e){
			Log.error(e, "obtenerLogin");
			e.printStackTrace();
		}
		return 0;
	}

	@Override
	@Transactional(readOnly = false)
	public int actualizar(SysUsuario objUsuario, boolean indicaCambioClave) {
		try{
			if(indicaCambioClave){
				/**Cifrar clave nueva**/
				objUsuario.setUsuaClave(encriptacionService.getCifrado(objUsuario.getUsuaClave()));
				objUsuario.setUsuaFechamodif(new Date());
			}			
			return usuarioDao.actualizar(objUsuario);				
		}catch(Exception e){
			Log.error(e, "obtenerLogin");
			e.printStackTrace();
		}
		return 0;
	}

	@Override
	@Transactional(readOnly = false)
	public int eliminar(SysUsuario objUsuario) {
		return usuarioDao.eliminar(objUsuario);
	}

	@Override
	public SysUsuario obtenerPorID(Integer objUsuario) {
		Object result =  usuarioDao.findById(objUsuario);
		return result!=null?(SysUsuario)result:null;
	}

	@Override
	public SysUsuario obtenerLogin(String usuario, String clave) {
		try{
			SysUsuario usuarioFilt = new SysUsuario();
			usuarioFilt.setUsuaUsuario(usuario);	
			List<SysUsuario> listaTemp =  usuarioDao.listar(usuarioFilt, false);
			if(UtilesCommons.noEsVacio(listaTemp)){
				if(UtilesCommons.esVacio(clave)){
					if(UtilesCommons.esVacio(listaTemp.get(0).getUsuaClave())
						|| encriptacionService.isMatchDescifrado((""+listaTemp.get(0).getUsuaClave()).trim(), "")	
							){
						/**login correcto*/
						return listaTemp.get(0);
					}
				}else{
					/**validar*/		
					if(encriptacionService.isMatchDescifrado((""+listaTemp.get(0).getUsuaClave()).trim(), clave.trim())){
						return listaTemp.get(0);
					}
				}				
			}					
		}catch(Exception e){
			Log.error(e, "obtenerLogin");
			e.printStackTrace();
		}	
		
		return null;
	}
	
	
	@Override
	public int contarListado(SysUsuario objUsuario) {
		try{
			return usuarioDao.contarListado(objUsuario);	
		}catch(Exception e){
			Log.error(e, "contarListado");		
		}	
		return 0;
	}

	@Override
	public List<SysUsuario> listar(SysUsuario objUsuario,boolean paginable) {
		try{
			return usuarioDao.listar(objUsuario,paginable);	
		}catch(Exception e){
			Log.error(e, "listar");		
		}	
		return null;
	}

	@Override
	public SysUsuario obtenerPorCodigo(String usuario) {
		try{
			SysUsuario usuarioFilt = new SysUsuario();
			usuarioFilt.setUsuaUsuario(usuario);	
			List<SysUsuario> listaTemp =  usuarioDao.listar(usuarioFilt, false);
			if(UtilesCommons.noEsVacio(listaTemp)){
				return listaTemp.get(0);							
			}			
		}catch(Exception e){
			Log.error(e, "obtenerPorCodigo");			
		}			
		return null;
	}

	@Override
	public boolean detectarCambioClaveUsuario(Integer usuariId, String usuarioClave) {
		/**detectar cambio de la clave*/
		boolean cambioClave = false;
		try{
			SysUsuario objDb = usuarioDao.findById(usuariId);
			if(objDb!=null){
				if(UtilesCommons.esVacio(objDb.getUsuaClave())){
					if(UtilesCommons.noEsVacio(usuarioClave)){
						cambioClave = true;
					}
				}else{
					if(!objDb.getUsuaClave().trim().equals(usuarioClave)){
						cambioClave = true;
					}
				}
			}	
		}catch(Exception e){
			e.printStackTrace();
		}
		
		return cambioClave;
	}

}
