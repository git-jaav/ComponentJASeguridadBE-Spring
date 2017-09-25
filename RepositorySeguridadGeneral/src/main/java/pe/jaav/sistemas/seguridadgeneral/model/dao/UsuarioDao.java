package pe.jaav.sistemas.seguridadgeneral.model.dao;

import java.util.List;

import pe.jaav.sistemas.seguridadgeneral.model.domain.SysUsuario;

public interface UsuarioDao extends AbstractDao<SysUsuario, Integer> {
	
	
	public int guardar(SysUsuario objUsuario);
	public int actualizar(SysUsuario objUsuario);
	public int eliminar(SysUsuario objUsuario);
	
	public SysUsuario obtenerPorID(Integer objUsuario);
	public int contarListado(SysUsuario objUsuario);	
	public List<SysUsuario> listar(SysUsuario objUsuario,boolean paginable);
		
	
}
