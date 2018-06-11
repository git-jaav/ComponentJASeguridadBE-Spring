package pe.jaav.sistemas.general.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import pe.jaav.sistemas.general.service.GenPersonaService;
import pe.jaav.sistemas.seguridadgeneral.model.dao.GenPersonaDao;
import pe.jaav.sistemas.seguridadgeneral.model.domain.GenPersona;

@Service("genPersonaService")
@Transactional(readOnly = true)
public class GenPersonaServiceImpl implements GenPersonaService{

	@Autowired
	GenPersonaDao GenPersonaDao;
	
	@Override
	@Transactional(readOnly = false)
	public int guardar(GenPersona objDao) {		
		return GenPersonaDao.guardar(objDao);
	}

	@Override
	@Transactional(readOnly = false)
	public int actualizar(GenPersona objDao) {
		return GenPersonaDao.actualizar(objDao);
	}

	@Override
	@Transactional(readOnly = false)
	public int eliminar(GenPersona objDao) {
		return GenPersonaDao.eliminar(objDao);
	}

	@Override
	public int contarListado(GenPersona objDao) {
		return GenPersonaDao.contarListado(objDao);
	}

	@Override
	public List<GenPersona> listar(GenPersona objDao, boolean paginable) {
		return GenPersonaDao.listar(objDao,paginable);
	}

	@Override
	public GenPersona obtenerPorID(Integer id) {
		return GenPersonaDao.findById(id);
	}


}
