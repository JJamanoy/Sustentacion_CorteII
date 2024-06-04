package com.cerveceria.cerveceria;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.cerveceria.cerveceria.domain.Cerveceria;
import com.cerveceria.cerveceria.repository.CerveceriaRepository;

@CrossOrigin(origins = "http://localhost:8081")
@RestController
@RequestMapping("/api")
public class CerveriaController {
    
    @Autowired
    CerveceriaRepository cerveceriaRepository;

    @GetMapping("/cervecerias")
    public ResponseEntity<List<Cerveceria>> getAllCervecerias(@RequestParam(required = false) String nombre){
        try{
            List<Cerveceria> cervecerias = new ArrayList<Cerveceria>();

            if(nombre==null)
                cervecerias.addAll(cerveceriaRepository.findAll());
            else
                cervecerias.addAll(cerveceriaRepository.findByNombreContaining(nombre));
            return new ResponseEntity<>(cervecerias, HttpStatus.OK);
            } catch(Exception e){
                return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
            }      
    }

    @GetMapping("/cervecerias/{id}")
    public ResponseEntity<Cerveceria> getCerveceriaById(@PathVariable("id") long id){
        Optional<Cerveceria> cerveceriaData = cerveceriaRepository.findById(id);

        if(cerveceriaData.isPresent()){
            return new ResponseEntity<>(cerveceriaData.get(), HttpStatus.OK);
        } else{
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping("/cervecerias")
    public ResponseEntity<Cerveceria> createCerveceria(@RequestBody Cerveceria cerveceria){
        try{
            Cerveceria _cerveceria = cerveceriaRepository
                    .save(new Cerveceria(cerveceria.getNombre(), cerveceria.getDepartamento(), cerveceria.getMunicipio(), cerveceria.getNomenclatura(), cerveceria.getMarca_cerveza(), cerveceria.getStock()));
            return new ResponseEntity<>(_cerveceria, HttpStatus.CREATED);
        } catch(Exception e){
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("/cervecerias/{id}")
    public ResponseEntity<Cerveceria> updateCerveceria(@PathVariable("id") long id, @RequestBody Cerveceria cerveceria){
        Optional<Cerveceria> cerveceriaData = cerveceriaRepository.findById(id);

        if(cerveceriaData.isPresent()){
            Cerveceria _cerveceria = cerveceriaData.get();
            _cerveceria.setNombre(cerveceria.getNombre());
            _cerveceria.setDepartamento(cerveceria.getDepartamento());
            _cerveceria.setMunicipio(cerveceria.getMunicipio());
            _cerveceria.setNomenclatura(cerveceria.getNomenclatura());
            _cerveceria.setMarca_cerveza(cerveceria.getMarca_cerveza());
            _cerveceria.setStock(cerveceria.getStock());
            return new ResponseEntity<>(cerveceriaRepository.save(_cerveceria), HttpStatus.OK);
        } else{
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/cervecerias/{id}")
    public ResponseEntity<HttpStatus> deleteCerveceria (@PathVariable("id") long id){
        try{
            cerveceriaRepository.deleteById(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception e){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping("cervecerias")
    public ResponseEntity<HttpStatus> deleteAllCervecerias(){
        try{
            cerveceriaRepository.deleteAll();
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch(Exception e){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
