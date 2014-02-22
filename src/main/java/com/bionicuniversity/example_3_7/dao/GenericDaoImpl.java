package com.bionicuniversity.example_3_7.dao;

import java.lang.reflect.*;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

public abstract class GenericDaoImpl<T> implements GenericDao<T>{
	@PersistenceContext
	protected EntityManager em;
	private Class< T > type;
	
	public GenericDaoImpl() {
		Type t = getClass().getGenericSuperclass();
		ParameterizedType pt = (ParameterizedType) t;
		type = (Class) pt.getActualTypeArguments()[0];
	}
	
	public T create(final T t) {
		em.persist(t);
		return t;
	}

	public void delete(final Object id) {
		em.remove(em.getReference(type, id));
	} 
	public T read(final Object id) {
		return (T) em.find(type, id);
	} 

	public T update(final T t) {
		return this.em.merge(t);
	}
	
}
