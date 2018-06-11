package pe.jaav.sistemas.general.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import pe.jaav.sistemas.general.service.SysSesionService;
import pe.jaav.sistemas.seguridadgeneral.model.dao.SysSesionDao;
import pe.jaav.sistemas.seguridadgeneral.model.domain.SysSesion;

@Service("sysSesionService")
@Transactional(readOnly = true)
public class SysSesionServiceImpl implements SysSesionService {

	@Autowired
	SysSesionDao sysSesionDao;
	
	@Override
	public SysSesion obtenerPorID(Integer id) {		
		return sysSesionDao.findById(id);
	}

	@Override
	public int contarListado(SysSesion objDao) {		
		return sysSesionDao.contarListado(objDao);
	}

	@Override
	public List<SysSesion> listar(SysSesion objDao, boolean paginable) {		
		return sysSesionDao.listar(objDao, paginable);
	}

	@Override
	@Transactional(readOnly = false)
	public int guardar(SysSesion objDao) {		
		return sysSesionDao.guardar(objDao);
	}

	@Override
	@Transactional(readOnly = false)
	public int actualizar(SysSesion objDao) {
		return sysSesionDao.actualizar(objDao);
	}

	@Override
	@Transactional(readOnly = false)
	public int eliminar(SysSesion objDao) {
		return sysSesionDao.eliminar(objDao);
	}

}
