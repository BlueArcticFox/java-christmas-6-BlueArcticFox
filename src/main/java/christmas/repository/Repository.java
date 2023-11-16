package christmas.repository;

import java.util.List;
import java.util.Optional;
import christmas.domain.IndexModel;

public interface Repository<T extends IndexModel>{
    Long save(T object);

    Optional<T> findById(Long id);

    List<T> findAll();

    void deleteAll();
}
