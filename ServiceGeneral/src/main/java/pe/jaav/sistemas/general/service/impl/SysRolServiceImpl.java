package pe.jaav.sistemas.general.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import pe.jaav.common.util.UtilesCommons;
import pe.jaav.sistemas.general.service.SysRolService;
import pe.jaav.sistemas.seguridadgeneral.model.dao.SysRolDao;
import pe.jaav.sistemas.seguridadgeneral.model.dao.SysUsuarioAsignadoDao;
import pe.jaav.sistemas.seguridadgeneral.model.domain.SysRol;
import pe.jaav.sistemas.seguridadgeneral.model.domain.SysUsuarioAsignado;


@Service("sysRolService")
@Transactional(readOnly = true)
public class SysRolServiceImpl implements SysRolService {

	@Autowired
	SysRolDao sysRolDao;
	
	@Autowired
	SysUsuarioAsignadoDao sysUsuarioAsignadoDao;	

	@Override
	public int contarListado(SysRol objDao) {
		return sysRolDao.contarListado(objDao);
	}

	@Override
	public List<SysRol> listar(SysRol objDao, boolean paginable) {
		return sysRolDao.listar(objDao, paginable);
	}

	@Override
	public SysRol obtenerPorId(Integer id) {		
		return sysRolDao.findById(id);
	}

	@Override
	@Transactional(readOnly = false)
	public int guardar(SysRol objDao) {		
		return sysRolDao.guardar(objDao);
	}

	@Override
	@Transactional(readOnly = false)
	public int actualizar(SysRol objDao) {		
		return sysRolDao.actualizar(objDao);
	}

	@Override
	@Transactional(readOnly = false)
	public int eliminar(SysRol objDao) {
		return sysRolDao.eliminar(objDao);
	}

	@Override
	public List<SysRol> listarSysRolUsuarioAsigandos(Integer usuarioId) {
		List<SysRol> listaRolResult = null;
		SysUsuarioAsignado usuaAsig = new SysUsuarioAsignado();
		usuaAsig.getId().setFkUsuaId(usuarioId);
		List<SysUsuarioAsignado> listaUsuaAsig = sysUsuarioAsignadoDao.listar(usuaAsig, false);
		if(UtilesCommons.noEsVacio(listaUsuaAsig)){
			listaRolResult = listaUsuaAsig.stream()
					.filter(p -> p.getSysRol()!=null)
					.map(f -> f.getSysRol())
					.collect(Collectors.toList());
		}
		
		return listaRolResult;
	}


}
