package ra.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import ra.model.Catalog;
import ra.service.ICatalogService;

import java.util.List;

@Controller
@RequestMapping("/api/catalogs")
@CrossOrigin(origins = "*")
public class CatalogController {
    @Autowired
    private ICatalogService catalogService;
    @GetMapping
    public ResponseEntity<List<Catalog>> findAll(){
        List<Catalog> list = (List<Catalog>) catalogService.findAll();
        if (list.isEmpty()){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(list,HttpStatus.OK);
        }
    }
}
