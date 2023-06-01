package ra.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ra.dao.CatalogRepository;
import ra.model.Catalog;

import java.util.Optional;
@Service
public class CatalogServiceIMPL implements ICatalogService{
    @Autowired
    private CatalogRepository catalogRepository;
    @Override
    public Iterable<Catalog> findAll() {
        return catalogRepository.findAll();
    }

    @Override
    public Optional<Catalog> findById(Long id) {
        return catalogRepository.findById(id);
    }

    @Override
    public Catalog save(Catalog catalog) {
        return (Catalog) catalogRepository.save(catalog);
    }

    @Override
    public void delete(Long id) {

    }
}
