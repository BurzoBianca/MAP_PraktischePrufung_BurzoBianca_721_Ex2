package Repository;

public interface ICrudRepo<T> {

    T findOne(Long id) ;

    Iterable<T> findAll();

    T save(T obj);

    T update(T obj);

    T delete(Long id);
}