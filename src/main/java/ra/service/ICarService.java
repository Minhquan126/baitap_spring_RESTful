package ra.service;

import ra.model.Car;

public interface ICarService extends IGeneric<Car,Long>{
    Iterable<Car> searchByCatalogId(Long id);
}
