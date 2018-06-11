package pe.jaav.sistemas.seguridadgeneral.model.dao.impl;
 
import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;
import pe.jaav.common.util.UtilesCommons;
import pe.jaav.sistemas.seguridadgeneral.model.dao.SysUsuarioAsignadoDao;
import pe.jaav.sistemas.seguridadgeneral.model.domain.SysUsuarioAsignado;
import pe.jaav.sistemas.seguridadgeneral.model.domain.SysUsuarioAsignadoPK;
 
@Repository
public class SysUsuarioAsignadoDaoImpl extends AbstractDaoImpl<SysUsuarioAsignado, SysUsuarioAsignadoPK> implements SysUsuarioAsignadoDao {
	protected  SysUsuarioAsignadoDaoImpl() {
		super(SysUsuarioAsignado.class);
	}
 
	public int guardar(SysUsuarioAsignado objDao) {
		save(objDao);
		return 1;
	}
 
	public int actualizar(SysUsuarioAsignado objDao) {
		update(objDao);
		return 1;
	}
 
	public int eliminar(SysUsuarioAsignado objDao) {
		delete(objDao);
		return 1;
	}
 
	public int contarListado(SysUsuarioAsignado objDao) {
		Criteria criteria = getCriteriaFilter(objDao);
		String obj = criteria.uniqueResult() != null ? criteria.uniqueResult().toString() : "0";
		return Integer.parseInt(obj);
	}
 
	@SuppressWarnings("unchecked")
	public List<SysUsuarioAsignado> listar(SysUsuarioAsignado objDao,boolean paginable) {
		Criteria criteria = getCriteriaFilter(objDao);
		if(paginable){
			setPaginable(objDao, criteria);
		}
		return criteria.list();
	}
 
	public Criteria getCriteriaFilter(Object objDaoGen){
		Criteria criteria = null;
		if(objDaoGen instanceof SysUsuarioAsignado){
			SysUsuarioAsignado objDao = (SysUsuarioAsignado)objDaoGen;
			criteria = getCurrentSession().createCriteria(SysUsuarioAsignado.class);
			if (UtilesCommons.noEsVacio(objDao.getId().getFkUsuaId())) {
				criteria.add(Restrictions.eq("id.fkUsuaId", objDao.getId().getFkUsuaId()));
			}
			if (UtilesCommons.noEsVacio(objDao.getId().getFkRolId())) {
				criteria.add(Restrictions.eq("id.fkRolId", objDao.getId().getFkRolId()));
			}
			if (UtilesCommons.noEsVacio(objDao.getUsasigEstado())) {
				criteria.add(Restrictions.eq("usasigEstado", objDao.getUsasigEstado()));
			}
		}
		return criteria;
	}
}
