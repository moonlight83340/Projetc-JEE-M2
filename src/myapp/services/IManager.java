package myapp.services;

import java.util.List;

public interface IManager<T> {
	
    public T find(Integer id);
    public List<T> findAll();
    public List<T> findLike(String patern);

    public T save(T t);

    public void delete(T t);
    
}
