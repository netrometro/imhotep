package br.upe.service.core;

import java.util.List;

public interface IDbSet<T> {
    public T Find(Object id);
    public T Find(String field, Object value);
    public List<T> FindAll(String field, Object value);
    public T Create(T object);
    public List<T> ToArray();
    public boolean update(T object);
    public boolean Delete(Object id);
}
