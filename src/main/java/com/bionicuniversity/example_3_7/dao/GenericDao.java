package com.bionicuniversity.example_3_7.dao;

public interface GenericDao<T> {
	T create(T t);
	void delete(Object id);
	T read(Object id);
	T update(T t);
}