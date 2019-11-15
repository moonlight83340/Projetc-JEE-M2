package services;

import java.util.List;

public interface IManager<T> {
    public abstract List<T> findAll();

    public abstract T find(Long id);

    public abstract T save(T t);

    public abstract void delete(T t);
}
