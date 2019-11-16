package myapp.services;

import java.util.List;

public interface IFindLikeManager<T> {
	public List<T> findLike(String patern);
}
