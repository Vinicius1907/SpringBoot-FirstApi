package br.com.itautesteapi.ApiPessoas.controller;

import br.com.itautesteapi.ApiPessoas.entity.Pessoas;
import br.com.itautesteapi.ApiPessoas.service.PessoasService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RequiredArgsConstructor
@RestController
@RequestMapping("pessoas/v1")
public class PessoasController {

    private final PessoasService service;

    @GetMapping
    public ResponseEntity <List<Pessoas>> findAll(){
        List<Pessoas> pessoas = service.findAll();
        return new ResponseEntity<>(pessoas, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Pessoas> findById(@PathVariable String id){
        Pessoas idPessoa = service.findById(id);
        return new ResponseEntity<>(idPessoa,HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Pessoas> create(@RequestBody Pessoas pessoas){
        Pessoas novaPessoa = service.create(pessoas);
        return new ResponseEntity<>(novaPessoa, HttpStatus.OK);
    }

    @PatchMapping("/{id}")
    public ResponseEntity<Pessoas> update(@RequestBody Pessoas novosDados, @PathVariable String id){
        Pessoas update = service.update(novosDados ,id);
        return new ResponseEntity<>(update, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable String id){
        service.delete(id);
    }

}
