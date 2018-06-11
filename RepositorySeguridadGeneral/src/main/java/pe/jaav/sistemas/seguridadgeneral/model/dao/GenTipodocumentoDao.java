package pe.jaav.sistemas.seguridadgeneral.model.dao;
 
import java.util.List;
import org.hibernate.Criteria;
import pe.jaav.sistemas.seguridadgeneral.model.domain.GenTipodocumento;
public interface GenTipodocumentoDao extends AbstractDao<GenTipodocumento, Integer> {
	public int guardar(GenTipodocumento objDao);
	public int actualizar(GenTipodocumento objDao);
	public int eliminar(GenTipodocumento objDao);
	public int contarListado(GenTipodocumento objDao);
	public List<GenTipodocumento> listar(GenTipodocumento objDao,boolean paginable);
	public Criteria getCriteriaFilter(Object objDaoGen);
}
