package br.upe.dao.db;

import java.util.List;

public interface DAO<T> {
    public T getSingle(Object... chave);
    public List<T> getList();
    public List<T> getList(int top);
}