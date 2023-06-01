package ra.dao;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import ra.model.Car;

@Repository
public interface CarRepository extends PagingAndSortingRepository<Car,Long> {
    @Query("select c from Car as c where c.catalog.id = :id")
    Iterable<Car> searchByCatalogId(@Param("id") Long id);

}
