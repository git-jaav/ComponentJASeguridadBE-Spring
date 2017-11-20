package pe.jaav.sistemas.seguridadgeneral.model.dao.impl;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

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

	public SysUsuario obtenerPorID(Integer id) {	
		return findById(id);
	}

	public int contarListado(SysUsuario objUsuario) {
		Criteria criteria = getCurrentSession().createCriteria(SysUsuario.class);	
		if (objUsuario.getUsuaUsuario() != null && objUsuario.getUsuaUsuario() != "") {
			criteria.add(Restrictions.eq("usuaUsuario", objUsuario.getUsuaUsuario()));
		}
		if (objUsuario.getUsuaEstado()!= null && objUsuario.getUsuaEstado() != "") {
			criteria.add(Restrictions.eq("usuaEstado", objUsuario.getUsuaEstado()));
		}		
		if (objUsuario.getUsuaNombre() != null && !"".equals(objUsuario.getUsuaNombre())) {
			criteria.add(Restrictions.like("usuaNombre", objUsuario.getUsuaNombre(), MatchMode.ANYWHERE).ignoreCase());
		}
		criteria.setProjection(Projections.rowCount());
		String obj = criteria.uniqueResult() != null ? criteria.uniqueResult().toString() : "0";
		return Integer.parseInt(obj);
		
	}

	@SuppressWarnings("unchecked")
	public List<SysUsuario> listar(SysUsuario objUsuario,boolean paginable) {	
		Criteria criteria = getCurrentSession().createCriteria(SysUsuario.class);	
		if (objUsuario.getUsuaUsuario() != null && objUsuario.getUsuaUsuario() != "") {
			criteria.add(Restrictions.eq("usuaUsuario", objUsuario.getUsuaUsuario()));
		}
		if (objUsuario.getUsuaEstado()!= null && objUsuario.getUsuaEstado() != "") {
			criteria.add(Restrictions.eq("usuaEstado", objUsuario.getUsuaEstado()));
		}			
		if (objUsuario.getUsuaNombre() != null && !"".equals(objUsuario.getUsuaNombre())) {
			criteria.add(Restrictions.like("usuaNombre", objUsuario.getUsuaNombre(), MatchMode.ANYWHERE).ignoreCase());
		}
		
		if(paginable){
			criteria.setFirstResult(objUsuario.getInicio());
			criteria.setMaxResults(objUsuario.getNumeroFilas());
			criteria.setFetchSize(objUsuario.getNumeroFilas());			
		}
		return criteria.list();				
	}

}
