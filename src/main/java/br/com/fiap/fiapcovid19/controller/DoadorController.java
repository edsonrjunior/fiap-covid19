package br.com.fiap.fiapcovid19.controller;

import br.com.fiap.fiapcovid19.dto.DoadorDTO;
import br.com.fiap.fiapcovid19.model.Doador;
import br.com.fiap.fiapcovid19.service.DoadorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping(value = "/doadores")
public class DoadorController {

    @Autowired
    private DoadorService service;

    @RequestMapping(method=RequestMethod.POST)
    public ResponseEntity<Void> insert(@RequestBody DoadorDTO doadorDTO){
        Doador doador = service.fromDTO(doadorDTO);
        doador = service.insert(doador);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(doador.getId()).toUri();
        return ResponseEntity.created(uri).build();
    }

    @RequestMapping(value="/{tipo}", method=RequestMethod.GET)
    public ResponseEntity<List<DoadorDTO>> findByTipoSanguineo(@PathVariable String tipo){
        List<Doador> list = service.findByTipoSanguineo(tipo);
        List<DoadorDTO> listDTO = list.stream().map(x -> new DoadorDTO(x)).collect(Collectors.toList());

        return ResponseEntity.ok().body(listDTO);
    }
}
