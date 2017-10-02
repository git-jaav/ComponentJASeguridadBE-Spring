package pe.jaav.sistemas.general.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import pe.jaav.sistemas.general.service.UsuarioService;
import pe.jaav.sistemas.seguridadgeneral.model.dao.UsuarioDao;
import pe.jaav.sistemas.seguridadgeneral.model.domain.SysUsuario;

@Service("usuarioService")
@Transactional(readOnly = true)
public class UsuarioServiceImpl implements UsuarioService{

	@Autowired
	UsuarioDao usuarioDao;

	@Override
	@Transactional(readOnly = false)
	public int guardar(SysUsuario objUsuario) {		
		return usuarioDao.guardar(objUsuario);
	}

	@Override
	@Transactional(readOnly = false)
	public int actualizar(SysUsuario objUsuario) {
		return usuarioDao.actualizar(objUsuario);
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
			if(listaTemp!=null){
				if(listaTemp.size()>0){
					if(clave != null){
						if(clave.trim().equals((""+listaTemp.get(0).getUsuaClave()).trim())){
							return listaTemp.get(0);
						}
					}else{
						if("".equals((""+listaTemp.get(0).getUsuaClave()).trim())
							|| listaTemp.get(0).getUsuaClave() == null
								){
							return listaTemp.get(0);
						}
					}
				}
			}			
		}catch(Exception e){
			e.printStackTrace();
		}	
		
		return null;
	}
	
	@Override
	public int contarListado(SysUsuario objUsuario) {
		try{
			return usuarioDao.contarListado(objUsuario);	
		}catch(Exception e){
			e.printStackTrace();
		}	
		return 0;
	}

	@Override
	public List<SysUsuario> listar(SysUsuario objUsuario,boolean paginable) {
		try{
			return usuarioDao.listar(objUsuario,paginable);	
		}catch(Exception e){
			e.printStackTrace();
		}	
		return null;
	}

	@Override
	public SysUsuario obtenerPorCodigo(String usuario) {
		try{
			SysUsuario usuarioFilt = new SysUsuario();
			usuarioFilt.setUsuaUsuario(usuario);	
			List<SysUsuario> listaTemp =  usuarioDao.listar(usuarioFilt, false);
			if(listaTemp!=null && listaTemp.size()>0){
				return listaTemp.get(0);							
			}			
		}catch(Exception e){
			e.printStackTrace();
		}			
		return null;
	}


}
