package pe.jaav.sistemas.seguridadgeneral.model.dao;
 
import java.util.List;
import org.hibernate.Criteria;
import pe.jaav.sistemas.seguridadgeneral.model.domain.GenPersona;
public interface GenPersonaDao extends AbstractDao<GenPersona, Integer> {
	public int guardar(GenPersona objDao);
	public int actualizar(GenPersona objDao);
	public int eliminar(GenPersona objDao);
	public int contarListado(GenPersona objDao);
	public List<GenPersona> listar(GenPersona objDao,boolean paginable);
	public Criteria getCriteriaFilter(Object objDaoGen);
}
