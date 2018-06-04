package pe.jaav.sistemas.seguridadgeneral.model.dao.impl;
 
import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import pe.jaav.common.util.UtilesCommons;
import pe.jaav.sistemas.seguridadgeneral.model.dao.SysRolDao;
import pe.jaav.sistemas.seguridadgeneral.model.domain.SysRol;


@Repository
public class SysRolDaoImpl extends AbstractDaoImpl<SysRol, Integer> implements SysRolDao {
	
	protected SysRolDaoImpl() {
		super(SysRol.class);
	}
	public int guardar(SysRol objDao) {
		Object result = getCurrentSession().save(objDao);
		return (int) (result!=null?result:0);
	}
	public int actualizar(SysRol objDao) {
		update(objDao);
		return 1;
	}
	public int eliminar(SysRol objDao) {
		delete(objDao);
		return 1;
	}
	public int contarListado(SysRol objDao) {
		Criteria criteria = getCriteriaFilter(objDao);
		String obj = criteria.uniqueResult() != null ? criteria.uniqueResult().toString() : "0";
		return Integer.parseInt(obj);
	}
	@SuppressWarnings("unchecked")
	public List<SysRol> listar(SysRol objDao,boolean paginable) {
		Criteria criteria = getCriteriaFilter(objDao);
		if(paginable){
			setPaginable(objDao, criteria);	
		}
		return criteria.list();
	}
	
	public Criteria getCriteriaFilter(Object objDaoGen){		
		Criteria criteria = null;
		if(objDaoGen instanceof SysRol){
			SysRol objDao = (SysRol)objDaoGen;
			criteria = getCurrentSession().createCriteria(SysRol.class);
			if (UtilesCommons.noEsVacio(objDao.getRolCodigo())) {
				criteria.add(Restrictions.eq("rolCodigo", objDao.getRolCodigo()));
			}
		}
		return criteria;
	}
	
}
