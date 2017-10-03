package pe.jaav.sistemas.seguridadgeneral.model.dao.impl;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Criterion;
import org.springframework.beans.factory.annotation.Autowired;

import pe.jaav.sistemas.seguridadgeneral.model.dao.AbstractDao;

import java.io.Serializable;
import java.util.List;


public abstract class AbstractDaoImpl<E, I extends Serializable> implements AbstractDao<E,I> {

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
