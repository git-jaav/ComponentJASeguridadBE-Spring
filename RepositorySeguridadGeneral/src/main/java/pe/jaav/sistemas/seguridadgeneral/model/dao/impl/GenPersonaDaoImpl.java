package pe.jaav.sistemas.seguridadgeneral.model.dao.impl;
 
import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;
import pe.jaav.common.util.UtilesCommons;
import pe.jaav.sistemas.seguridadgeneral.model.dao.GenPersonaDao;
import pe.jaav.sistemas.seguridadgeneral.model.domain.GenPersona;
 
@Repository
public class GenPersonaDaoImpl extends AbstractDaoImpl<GenPersona, Integer> implements GenPersonaDao {
	protected  GenPersonaDaoImpl() {
		super(GenPersona.class);
	}
 
	public int guardar(GenPersona objDao) {
		//Object result = getCurrentSession().save(objDao);
		/**Generacio  de ID secuencial (CASO NO IDENTITY en DB)*/
		int maxResult = 0;
		Criteria criteria = getCurrentSession().createCriteria(GenPersona.class).setProjection(Projections.max("persId"));
		Object result = criteria.uniqueResult();
		if(result!=null){
			maxResult  = result == null ? 0 : (int)result;	
		}
		maxResult++;
		objDao.setPersId(maxResult);
		save(objDao);
		return maxResult;
				
	}
 
	public int actualizar(GenPersona objDao) {
		update(objDao);
		return 1;
	}
 
	public int eliminar(GenPersona objDao) {
		delete(objDao);
		return 1;
	}
 
	public int contarListado(GenPersona objDao) {
		Criteria criteria = getCriteriaFilter(objDao);
		String obj = criteria.uniqueResult() != null ? criteria.uniqueResult().toString() : "0";
		return Integer.parseInt(obj);
	}
 
	@SuppressWarnings("unchecked")
	public List<GenPersona> listar(GenPersona objDao,boolean paginable) {
		Criteria criteria = getCriteriaFilter(objDao);
		if(paginable){
			setPaginable(objDao, criteria);
		}
		return criteria.list();
	}
 
	public Criteria getCriteriaFilter(Object objDaoGen){
		Criteria criteria = null;
		if(objDaoGen instanceof GenPersona){
			GenPersona objDao = (GenPersona)objDaoGen;
			criteria = getCurrentSession().createCriteria(GenPersona.class);
			if (UtilesCommons.noEsVacio(objDao.getPersEstado())) {
				criteria.add(Restrictions.eq("persEstado", objDao.getPersEstado()));
			}
			if (UtilesCommons.noEsVacio(objDao.getPersNombreCompleto())) {
				criteria.add(Restrictions.like("persNombreCompleto", objDao.getPersNombreCompleto(),MatchMode.ANYWHERE).ignoreCase());
			}			
		}
		return criteria;
	}
}
