package pe.jaav.sistemas.seguridadgeneral.model.dao.impl;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.ProjectionList;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.hibernate.engine.jdbc.connections.internal.DatasourceConnectionProviderImpl;
import org.hibernate.engine.jdbc.connections.spi.ConnectionProvider;
import org.hibernate.engine.spi.SessionFactoryImplementor;
import org.springframework.beans.factory.annotation.Autowired;

import pe.jaav.sistemas.seguridadgeneral.model.dao.AbstractDao;

import java.io.Serializable;
import java.lang.reflect.Field;
import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.text.SimpleDateFormat;
import java.util.Date;
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
    	System.out.println("[INFO SYS] llamando trace listados - antes:"+e);    	
    	iniciarAuditoriaTrace(e, "L", "");    	    	    	
    	System.out.println("[INFO SYS] llamando trace listados - después:"+e);
    }
    
    /*********TRATAMIENTO AUDITORÍA******/
    public void  iniciarAuditoriaTrace(Object objTrace, String typeTrace,String primKeyData){
    	try{
    		
    		
    	}catch(Exception ex){
    		ex.printStackTrace();
    	}    	
    }
    
	
	/**Construye dinamicamente un nuevo objetode Una clase determinada a partir del objeto Original*/
    public static Object getNuevoObjetoGenerico(Object objetoOrigen, Class<?> claseNuevoObjeto){
		try{			
			Object objNuevo=null;
			if(objetoOrigen!=null && claseNuevoObjeto!=null){				
				String type = claseNuevoObjeto.getName();
				objNuevo = claseNuevoObjeto.newInstance();
				//objNuevo =  Class.forName(type).newInstance();
				////obtener los valores del objetoOrigen y set a objNuevo
				Field[] fields = objetoOrigen.getClass().getDeclaredFields();
				for(Field field : fields) {
	                try {
						if((field.getModifiers() & java.lang.reflect.Modifier.FINAL) == java.lang.reflect.Modifier.FINAL){
							//ES FINAL
						}else{
		                	String fieldName = field.getName();
		                	field.setAccessible(true);
		                	Object fieldValue = field.get(objetoOrigen);		                	
		                	//Field fieldNuevo = claseNuevoObjeto.getField(fieldName);
		                	
		                	//Field fieldNuevo = claseNuevoObjeto.getSuperclass().getField(fieldName);
		                	//Field fieldNuevo = objNuevo.getClass().getField(fieldName);
		                	
		                	field.set(objNuevo,fieldValue);
		                	/*
		                	if(fieldNuevo!=null){
		                		fieldNuevo.setAccessible(true);		                				                				                	
		                		//fieldNuevo.set(objNuevo.getClass().getSuperclass().newInstance(),fieldValue);	
		                		fieldNuevo.set(objNuevo,fieldValue);
		                	}*/
						}							                		               					
					} catch (IllegalArgumentException  e) {						
						e.printStackTrace();
					}	
				}									
			}
			return objNuevo;
		}catch(Exception ex){			
			ex.printStackTrace();
		}
		return null;
    }	
	public static void  showObjeto(Object objShow) {
		try{
			
			if(objShow!=null){
				System.out.println("[INFO SYS ] INICIO SHOW CLASS::"+objShow.getClass().getSimpleName());
				Field[] fields = objShow.getClass().getDeclaredFields();
				for(Field field : fields) {
		            try {
		            	String fieldName = field.getName();
		            	field.setAccessible(true);
		            	Object fieldValue = field.get(objShow);
						System.out.println("[INFO SYS ]  ATRIBUTO::"+fieldName +" || VALOR::"+fieldValue);
					} catch (IllegalArgumentException  e) {
						e.printStackTrace();
					}
				}
				System.out.println("[INFO SYS ]  FIN SHOW CLASS::"+objShow.getClass().getSimpleName());
			}	
		}catch(Exception ex){
			ex.printStackTrace();
		}
	}
	    
}
