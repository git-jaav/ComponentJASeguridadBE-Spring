package pe.jaav.sistemas.general.service;

import java.util.List;



import pe.jaav.sistemas.seguridadgeneral.model.domain.GenPersona;

public interface GenPersonaService {
	public GenPersona obtenerPorID(Integer id);
	
	public int contarListado(GenPersona objDao);
	public List<GenPersona> listar(GenPersona objDao,boolean paginable);	
	
	public int guardar(GenPersona objDao);
	public int actualizar(GenPersona objDao);
	public int eliminar(GenPersona objDao);
}
