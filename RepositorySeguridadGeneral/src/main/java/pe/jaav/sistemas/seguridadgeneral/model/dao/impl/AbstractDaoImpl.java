package pe.jaav.sistemas.seguridadgeneral.model.dao.impl;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Order;
import org.springframework.beans.factory.annotation.Autowired;

import pe.jaav.common.util.UtilesCommons;
import pe.jaav.sistemas.seguridadgeneral.model.dao.AbstractDao;
import pe.jaav.sistemas.seguridadgeneral.model.domain.EntidadSup;

import java.io.Serializable;
import java.util.Arrays;
import java.util.List;



public abstract class AbstractDaoImpl<E, I extends Serializable> implements AbstractDao<E,I> {

    public static final String ORDER_ASC  = "ASC";
    public static final String ORDER_DESC = "DESC";

    private Class<E> entityClass;

    protected AbstractDaoImpl(Class<E> entityClass) {
        this.entityClass = entityClass;
    }

    @Autowired
    private SessionFactory sessionFactory;

    public Session getCurrentSession() {
        return sessionFactory.getCurrentSession();
    }

    @SuppressWarnings("unchecked")
    //@Override
    public E findById(I id) {
        return (E) getCurrentSession().get(entityClass, id);
    }

    public void saveOrUpdate(E e) {
        getCurrentSession().saveOrUpdate(e);
        iniciarAuditoriaTrace(e,"IoU","");
    }
    
    public void update(E e) {    	
        getCurrentSession().update(e);
        iniciarAuditoriaTrace(e,"U","");
    }

    //@Override
    public void save(E e) {    	
        getCurrentSession().save(e);
        iniciarAuditoriaTrace(e,"I","");
    }

    
    //@Override
    public void delete(E e) {
        getCurrentSession().delete(e);
        iniciarAuditoriaTrace(e,"D","");
    }

    @SuppressWarnings("unchecked")
    public List<E> findByCriteria(Criterion criterion) {
        Criteria criteria = getCurrentSession().createCriteria(entityClass);
        criteria.add(criterion);
        return criteria.list();
    }
    
    public void setPaginable(EntidadSup entidad, Criteria criteria){        
        criteria.setFirstResult(entidad.getInicio());
        criteria.setMaxResults(entidad.getNumeroFilas());
        criteria.setFetchSize(entidad.getNumeroFilas());        
    }
    
    
    public void setOrdenableAtrib(Criteria criteria, String order, String ... columns){
        if(columns != null && columns.length > 0){
            List<String> list = Arrays.asList(columns);
            for(String column : list){
                if(order.equalsIgnoreCase(ORDER_ASC)){
                    criteria.addOrder(Order.asc(column));
                }else{
                    criteria.addOrder(Order.desc(column));
                }
            }
        }
    }
    
    public void setOrdenable(Criteria criteria, String order, List<String> list){
        if(UtilesCommons.noEsVacio(list)){
            for(String column : list){
                if(order.equalsIgnoreCase(ORDER_ASC)){
                    criteria.addOrder(Order.asc(column));
                }else{
                    criteria.addOrder(Order.desc(column));
                }
            }
        }
    }
    
    
    public void setParametrosAuditoriaTrace(E e,I id,String tipo) {
        //OBS tipo por defecto L  (...)    	    
    	iniciarAuditoriaTrace(e, "L", "");    	    	    	    	
    }       
    
    /*********TRATAMIENTO AUDITORÍA******/
    public void  iniciarAuditoriaTrace(Object objTrace, String typeTrace,String primKeyData){
    	try{
    		
    		
    	}catch(Exception ex){
    		ex.printStackTrace();
    	}    	
    }
	    
}
