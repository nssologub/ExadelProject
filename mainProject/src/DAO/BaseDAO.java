package DAO;

/**
 * Created by alupachou on 12/16/2014.
 */
public interface BaseDAO <T> {
    public void create(T t);
    public T read(Long id);
    public T update(T t);
    public void delete(T t);
}
