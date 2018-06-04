package pe.jaav.sistemas.seguridadgeneral.model.dao;
 
import java.util.List;

import org.hibernate.Criteria;

import pe.jaav.sistemas.seguridadgeneral.model.domain.SysRol;
public interface SysRolDao extends AbstractDao<SysRol, Integer> {
	public int guardar(SysRol objDao);
	public int actualizar(SysRol objDao);
	public int eliminar(SysRol objDao);
	public int contarListado(SysRol objDao);
	public List<SysRol> listar(SysRol objDao,boolean paginable);
	public Criteria getCriteriaFilter(Object objDaoGen);
}
