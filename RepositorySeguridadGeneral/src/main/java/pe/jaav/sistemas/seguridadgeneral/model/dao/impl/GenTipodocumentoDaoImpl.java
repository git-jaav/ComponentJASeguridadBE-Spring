package pe.jaav.sistemas.seguridadgeneral.model.dao.impl;
 
import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;
import pe.jaav.common.util.UtilesCommons;
import pe.jaav.sistemas.seguridadgeneral.model.dao.GenTipodocumentoDao;
import pe.jaav.sistemas.seguridadgeneral.model.domain.GenTipodocumento;
 
@Repository
public class GenTipodocumentoDaoImpl extends AbstractDaoImpl<GenTipodocumento, Integer> implements GenTipodocumentoDao {
	protected  GenTipodocumentoDaoImpl() {
		super(GenTipodocumento.class);
	}
 
	public int guardar(GenTipodocumento objDao) {
		Object result = getCurrentSession().save(objDao);		
		return (int) (result!=null?result:0);
	}
 
	public int actualizar(GenTipodocumento objDao) {
		update(objDao);
		return 1;
	}
 
	public int eliminar(GenTipodocumento objDao) {
		delete(objDao);
		return 1;
	}
 
	public int contarListado(GenTipodocumento objDao) {
		Criteria criteria = getCriteriaFilter(objDao);
		String obj = criteria.uniqueResult() != null ? criteria.uniqueResult().toString() : "0";
		return Integer.parseInt(obj);
	}
 
	@SuppressWarnings("unchecked")
	public List<GenTipodocumento> listar(GenTipodocumento objDao,boolean paginable) {
		Criteria criteria = getCriteriaFilter(objDao);
		if(paginable){
			setPaginable(objDao, criteria);
		}
		return criteria.list();
	}
 
	public Criteria getCriteriaFilter(Object objDaoGen){
		Criteria criteria = null;
		if(objDaoGen instanceof GenTipodocumento){
			GenTipodocumento objDao = (GenTipodocumento)objDaoGen;
			criteria = getCurrentSession().createCriteria(GenTipodocumento.class);
			if (UtilesCommons.noEsVacio(objDao.getTdocEstado())) {
				criteria.add(Restrictions.eq("tdocEstado", objDao.getTdocEstado()));
			}
		}
		return criteria;
	}
}
