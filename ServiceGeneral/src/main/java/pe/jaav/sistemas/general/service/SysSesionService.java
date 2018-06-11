package pe.jaav.sistemas.general.service;

import java.util.List;
import pe.jaav.sistemas.seguridadgeneral.model.domain.SysSesion;

public interface SysSesionService {

	public SysSesion obtenerPorID(Integer id);
	public int contarListado(SysSesion objDao);
	public List<SysSesion> listar(SysSesion objDao,boolean paginable);	
	
	public int guardar(SysSesion objDao);
	public int actualizar(SysSesion objDao);
	public int eliminar(SysSesion objDao);	
	
}
