package pe.jaav.sistemas.seguridadgeneral.model.dao.impl;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import pe.jaav.common.util.UtilesCommons;
import pe.jaav.sistemas.seguridadgeneral.model.dao.UsuarioDao;
import pe.jaav.sistemas.seguridadgeneral.model.domain.SysUsuario;

@Repository
public class UsuarioDaoImpl extends AbstractDaoImpl<SysUsuario, Integer> implements UsuarioDao {

	protected UsuarioDaoImpl() {
		super(SysUsuario.class);
		
	}

	public int guardar(SysUsuario objUsuario) {
		Object result = getCurrentSession().save(objUsuario);
		return (int) (result!=null?result:0);

	}

	public int actualizar(SysUsuario objUsuario) {
		update(objUsuario);
		return 1;
	}

	public int eliminar(SysUsuario objUsuario) {
		delete(objUsuario);
		return 1;
	}

	public int contarListado(SysUsuario objDao) {
		Criteria criteria = getCriteriaFilter(objDao);
		criteria.setProjection(Projections.rowCount());
		String obj = criteria.uniqueResult() != null ? criteria.uniqueResult().toString() : "0";
		return Integer.parseInt(obj);
		
	}

	@SuppressWarnings("unchecked")
	public List<SysUsuario> listar(SysUsuario objDao,boolean paginable) {	
		Criteria criteria = getCriteriaFilter(objDao);				
		if(paginable){
			setPaginable(objDao, criteria);				
		}
		return criteria.list();				
	}

	@Override
	public Criteria getCriteriaFilter(Object objDaoGen) {
		Criteria criteria = null;
		if(objDaoGen instanceof SysUsuario){
			SysUsuario objDao = (SysUsuario)objDaoGen;
			criteria = getCurrentSession().createCriteria(SysUsuario.class);	
			if (UtilesCommons.noEsVacio(objDao.getUsuaUsuario())) {
				criteria.add(Restrictions.eq("usuaUsuario", objDao.getUsuaUsuario()));
			}
			if (UtilesCommons.noEsVacio(objDao.getUsuaEstado())) {
				criteria.add(Restrictions.eq("usuaEstado", objDao.getUsuaEstado()));
			}		
			if (UtilesCommons.noEsVacio(objDao.getUsuaNombre())) {
				criteria.add(Restrictions.like("usuaNombre", objDao.getUsuaNombre(), MatchMode.ANYWHERE).ignoreCase());
			}
		}
		return criteria;
	}

}
