package myapp.services;

import java.util.List;

import javax.ejb.Local;

@Local
public interface IFindLikeManager<T> extends IManager<T>{
	public List<T> findLike(String patern);
}
