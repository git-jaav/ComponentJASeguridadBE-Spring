package pe.jaav.sistemas.seguridadgeneral.model.dao;
 
import java.util.List;

import org.hibernate.Criteria;

import pe.jaav.sistemas.seguridadgeneral.model.domain.SysSesion;
public interface SysSesionDao extends AbstractDao<SysSesion, Integer> {
	public int guardar(SysSesion objDao);
	public int actualizar(SysSesion objDao);
	public int eliminar(SysSesion objDao);
	public int contarListado(SysSesion objDao);
	public List<SysSesion> listar(SysSesion objDao,boolean paginable);
	public Criteria getCriteriaFilter(Object objDaoGen);
}
