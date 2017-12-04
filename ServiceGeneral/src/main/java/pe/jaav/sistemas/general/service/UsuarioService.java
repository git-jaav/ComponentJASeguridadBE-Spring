package pe.jaav.sistemas.general.service;

import java.util.List;

import pe.jaav.sistemas.seguridadgeneral.model.domain.SysUsuario;

public interface UsuarioService {
	public int guardar(SysUsuario objUsuario);
	public int actualizar(SysUsuario objUsuario, boolean indicaCambioClave);
	public int eliminar(SysUsuario objUsuario);
	
	public SysUsuario obtenerLogin(String usuario,String clave);
	
	public SysUsuario obtenerPorID(Integer objUsuario);
	public SysUsuario obtenerPorCodigo(String usuario);
	
	public int contarListado(SysUsuario objUsuario);	
	public List<SysUsuario> listar(SysUsuario objUsuario,boolean paginable);
	
	public boolean detectarCambioClaveUsuario(Integer usuariId, String usuarioClave) ;
}
