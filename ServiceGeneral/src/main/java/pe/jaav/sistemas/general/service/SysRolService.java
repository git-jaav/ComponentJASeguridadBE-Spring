package pe.jaav.sistemas.general.service;

import java.util.List;

import pe.jaav.sistemas.seguridadgeneral.model.domain.SysRol;

public interface SysRolService {
	
	public SysRol obtenerPorId(Integer id);
	public int contarListado(SysRol objDao);
	public List<SysRol> listar(SysRol objDao,boolean paginable);
	
	public int guardar(SysRol objDao);
	public int actualizar(SysRol objDao);
	public int eliminar(SysRol objDao);
	
	public List<SysRol> listarSysRolUsuarioAsigandos(Integer usuarioId);
	
}
