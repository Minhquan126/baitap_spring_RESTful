package ra.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ra.dao.CarRepository;
import ra.model.Car;

import java.util.Optional;
@Service
public class CarServiceIMPL implements ICarService{
    @Autowired
    private CarRepository carRepository;
    @Override
    public Iterable<Car> findAll() {
        return carRepository.findAll();
    }

    @Override
    public Optional<Car> findById(Long id) {
        return carRepository.findById(id);
    }

    @Override
    public Car save(Car car) {
        return carRepository.save(car);
    }

    @Override
    public void delete(Long id) {
carRepository.deleteById(id);
    }

    @Override
    public Iterable<Car> searchByCatalogId(Long id) {
        return carRepository.searchByCatalogId(id);
    }
}
