package br.upe.service.core;

import java.util.List;

public interface IDbSet<T> {
    public T Find(Object id);
    public T Create(T object);
    public List<T> ToArray();
    public boolean update(T object);
    public boolean Delete(Object id);
}
