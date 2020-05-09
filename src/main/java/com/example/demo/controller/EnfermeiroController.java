package com.example.demo.controller;

import com.example.demo.model.EnfermeiroEntity;
import com.example.demo.repository.EnfermeiroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.persistence.Access;
import java.util.ArrayList;
import java.util.List;

@RestController
    @RequestMapping("/enfermeiro")
    public class EnfermeiroController {
        @Autowired EnfermeiroRepository enfermeiroRepository;
        @GetMapping
        public ResponseEntity<List<EnfermeiroEntity>> findAll(){
            return new ResponseEntity<List<EnfermeiroEntity>>( (List<EnfermeiroEntity>) this.enfermeiroRepository.findAll(), new HttpHeaders(), HttpStatus.OK);

        }
        @GetMapping(path ="/{id}")
        public ResponseEntity<EnfermeiroEntity> findById(@PathVariable ("id") long id) {
            if(this.enfermeiroRepository.findById(id).isPresent()){
                return new ResponseEntity<EnfermeiroEntity>(this.enfermeiroRepository.findById(id).get(), new HttpHeaders(),HttpStatus.OK);
            }
            return new ResponseEntity<EnfermeiroEntity>(HttpStatus.NOT_FOUND);
        }
        public ResponseEntity<EnfermeiroEntity> cadastrar(@RequestBody EnfermeiroEntity enfermeiroEntity) {
            return new ResponseEntity<EnfermeiroEntity>(this.enfermeiroRepository.save(enfermeiroEntity), new HttpHeaders(), HttpStatus.CREATED);
        }

        @PutMapping(value = "/{id}")
        public ResponseEntity<EnfermeiroEntity> atualizar (@PathVariable("id") long id, @RequestBody EnfermeiroEntity enfermeiroEntity) throws Exception{
            if ( id == 0 || !this.enfermeiroRepository.existsById(id)){
                throw new Exception("Código não encontrado ou inexistente");
            }
            return new ResponseEntity<EnfermeiroEntity>(this.enfermeiroRepository.save(enfermeiroEntity), new HttpHeaders(), HttpStatus.OK);
        }
    }
