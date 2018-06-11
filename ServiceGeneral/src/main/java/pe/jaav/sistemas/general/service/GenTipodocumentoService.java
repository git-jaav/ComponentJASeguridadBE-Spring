package pe.jaav.sistemas.general.service;

import java.util.List;

import pe.jaav.sistemas.seguridadgeneral.model.domain.GenTipodocumento;

public interface GenTipodocumentoService {

	public GenTipodocumento obtenerPorID(Integer id);
	public int contarListado(GenTipodocumento objDao);
	public List<GenTipodocumento> listar(GenTipodocumento objDao,boolean paginable);	
	
	public int guardar(GenTipodocumento objDao);
	public int actualizar(GenTipodocumento objDao);
	public int eliminar(GenTipodocumento objDao);

	
}
