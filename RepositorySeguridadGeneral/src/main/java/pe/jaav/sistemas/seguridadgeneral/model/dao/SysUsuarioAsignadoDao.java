package pe.jaav.sistemas.seguridadgeneral.model.dao;
 
import java.util.List;
import org.hibernate.Criteria;
import pe.jaav.sistemas.seguridadgeneral.model.domain.SysUsuarioAsignado;
import pe.jaav.sistemas.seguridadgeneral.model.domain.SysUsuarioAsignadoPK;
public interface SysUsuarioAsignadoDao extends AbstractDao<SysUsuarioAsignado, SysUsuarioAsignadoPK> {
	public int guardar(SysUsuarioAsignado objDao);
	public int actualizar(SysUsuarioAsignado objDao);
	public int eliminar(SysUsuarioAsignado objDao);
	public int contarListado(SysUsuarioAsignado objDao);
	public List<SysUsuarioAsignado> listar(SysUsuarioAsignado objDao,boolean paginable);
	public Criteria getCriteriaFilter(Object objDaoGen);
}
