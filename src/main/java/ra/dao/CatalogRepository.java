package ra.dao;


import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;
import ra.model.Catalog;

@Repository
public interface CatalogRepository extends PagingAndSortingRepository<Catalog,Long> {
}
