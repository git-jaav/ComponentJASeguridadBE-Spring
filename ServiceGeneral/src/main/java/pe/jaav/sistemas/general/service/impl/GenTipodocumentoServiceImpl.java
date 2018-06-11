package pe.jaav.sistemas.general.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import pe.jaav.sistemas.general.service.GenTipodocumentoService;
import pe.jaav.sistemas.seguridadgeneral.model.dao.GenTipodocumentoDao;
import pe.jaav.sistemas.seguridadgeneral.model.domain.GenTipodocumento;

@Service("genTipodocumentoService")
@Transactional(readOnly = true)
public class GenTipodocumentoServiceImpl implements GenTipodocumentoService {

	@Autowired
	GenTipodocumentoDao genTipodocumentoDao;
	
	@Override
	public GenTipodocumento obtenerPorID(Integer id) {		
		return genTipodocumentoDao.findById(id);
	}

	@Override
	public int contarListado(GenTipodocumento objDao) {		
		return genTipodocumentoDao.contarListado(objDao);
	}

	@Override
	public List<GenTipodocumento> listar(GenTipodocumento objDao, boolean paginable) {		
		return genTipodocumentoDao.listar(objDao, paginable);
	}

	@Override
	@Transactional(readOnly = false)
	public int guardar(GenTipodocumento objDao) {	
		return genTipodocumentoDao.guardar(objDao);
	}

	@Override
	@Transactional(readOnly = false)
	public int actualizar(GenTipodocumento objDao) {
		return genTipodocumentoDao.actualizar(objDao);
	}

	@Override
	@Transactional(readOnly = false)
	public int eliminar(GenTipodocumento objDao) {
		return genTipodocumentoDao.eliminar(objDao);
	}

}
