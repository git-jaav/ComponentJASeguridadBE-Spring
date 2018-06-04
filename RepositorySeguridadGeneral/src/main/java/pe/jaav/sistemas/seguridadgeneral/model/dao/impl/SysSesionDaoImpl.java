package pe.jaav.sistemas.seguridadgeneral.model.dao.impl;
 
import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;
import pe.jaav.common.util.UtilesCommons;
import pe.jaav.sistemas.seguridadgeneral.model.dao.SysSesionDao;
import pe.jaav.sistemas.seguridadgeneral.model.domain.SysSesion;


@Repository
public class SysSesionDaoImpl extends AbstractDaoImpl<SysSesion, Integer> implements SysSesionDao {
	protected  SysSesionDaoImpl() {
		super(SysSesion.class);
	}
	public int guardar(SysSesion objDao) {
		Object result = getCurrentSession().save(objDao);
		return (int) (result!=null?result:0);
	}
	public int actualizar(SysSesion objDao) {
		update(objDao);
		return 1;
	}
	public int eliminar(SysSesion objDao) {
		delete(objDao);
		return 1;
	}
	public int contarListado(SysSesion objDao) {
		Criteria criteria = getCriteriaFilter(objDao);
		String obj = criteria.uniqueResult() != null ? criteria.uniqueResult().toString() : "0";
		return Integer.parseInt(obj);
	}
	@SuppressWarnings("unchecked")
	public List<SysSesion> listar(SysSesion objDao,boolean paginable) {
		Criteria criteria = getCriteriaFilter(objDao);
		if(paginable){
			setPaginable(objDao, criteria);
		}
		return criteria.list();
	}
 
	public Criteria getCriteriaFilter(Object objDaoGen){
		Criteria criteria = null;
		if(objDaoGen instanceof SysSesion){
			SysSesion objDao = (SysSesion)objDaoGen;
			criteria = getCurrentSession().createCriteria(SysSesion.class);
			if (UtilesCommons.noEsVacio(objDao.getFkUsuaId())) {
				criteria.add(Restrictions.eq("fkUsuaId", objDao.getFkUsuaId()));
			}
		}
		return criteria;
	}
}
