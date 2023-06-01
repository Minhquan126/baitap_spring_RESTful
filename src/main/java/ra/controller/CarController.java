package ra.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import ra.model.Car;
import ra.service.ICarService;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/api/cars")
@CrossOrigin(origins = "*")
public class CarController {
    @Autowired
    private ICarService carService;
    @GetMapping
    public ResponseEntity<List<Car>> findAll(){
        List<Car> list = (List<Car>) carService.findAll();
        if (list.isEmpty()){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(list,HttpStatus.OK);
        }
    }
    @PostMapping("create")
    public ResponseEntity<Car> create(@RequestBody Car car){
        Car c = carService.save(car);
        return new ResponseEntity<>(c,HttpStatus.CREATED);
    }
    @PutMapping("update/{id}")
    public ResponseEntity<Car> update(@PathVariable("id") Long id,@RequestBody Car car){
        Optional<Car> c = carService.findById(id);
        if (c.isPresent()){
            carService.save(car);
            return new ResponseEntity<>(car,HttpStatus.CREATED);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
    @DeleteMapping("delete/{id}")
    public ResponseEntity<Car> delete(@PathVariable("id") Long id){
        Optional<Car> car = carService.findById(id);
        if (car.isPresent()){
            carService.delete(id);
            return new ResponseEntity<>(HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
    @GetMapping("/{id}")
    public ResponseEntity<Car> findById(@PathVariable("id") Long id){
        Optional<Car> car = carService.findById(id);
        if (car.isPresent()){
            return new ResponseEntity<>(car.get(),HttpStatus.CREATED);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
    @GetMapping("searchByCatalogId/{id}")
    public ResponseEntity<List<Car>> searchByCatalogId(@PathVariable("id") Long id){
        List<Car> list = (List<Car>) carService.searchByCatalogId(id);
        if (list.isEmpty()){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(list,HttpStatus.OK);
        }
    }
}
