package pe.jaav.sistemas.seguridadgeneral.model.dao.impl;

import java.util.List;

import org.hibernate.Criteria;
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
		save(objUsuario);
		return 1;
	}

	public int actualizar(SysUsuario objUsuario) {
		update(objUsuario);
		return 1;
	}

	public int eliminar(SysUsuario objUsuario) {
		delete(objUsuario);
		return 1;
	}

	public SysUsuario obtenerPorID(Integer objUsuario) {
		// TODO Auto-generated method stub
		return null;
	}

	public int contarListado(SysUsuario objUsuario) {
		// TODO Auto-generated method stub
		return 0;
	}

	public List<SysUsuario> listar(SysUsuario objUsuario,boolean paginable) {	
		Criteria criteria = getCurrentSession().createCriteria(SysUsuario.class);	
		if (objUsuario.getUsuaUsuario() != null && objUsuario.getUsuaUsuario() != "") {
			criteria.add(Restrictions.eq("usuaUsuario", objUsuario.getUsuaUsuario()));
		}
		
		if(paginable){
			criteria.setFirstResult(objUsuario.getInicio());
			criteria.setMaxResults(objUsuario.getNumeroFilas());
			criteria.setFetchSize(objUsuario.getNumeroFilas());			
		}
		return criteria.list();				
	}

}
