package br.com.fiap.fiapcovid19.controller;

import br.com.fiap.fiapcovid19.dto.DoadorDTO;
import br.com.fiap.fiapcovid19.model.Doador;
import br.com.fiap.fiapcovid19.model.TipoSanguineo;
import br.com.fiap.fiapcovid19.service.DoadorService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

@Api
@RestController
@CrossOrigin
@RequestMapping(value = "/doadores")
public class DoadorController {

    @Autowired
    private DoadorService service;

    @ApiOperation(value = "Cadastra novo doador")
    @RequestMapping(method=RequestMethod.POST)
    public ResponseEntity<Void> insert(@RequestBody DoadorDTO doadorDTO){
        Doador doador = service.fromDTO(doadorDTO);
        doador = service.insert(doador);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{cpf}").buildAndExpand(doador.getCpf()).toUri();
        return ResponseEntity.created(uri).build();
    }

    @ApiOperation(value = "Lista doadores por tipo sanguineo")
    @GetMapping(produces = "application/json")
    public ResponseEntity<List<DoadorDTO>> findByTipoSanguineo(@RequestParam(required = false, value = "tipoSanguineo") TipoSanguineo tipoSanguineo){
        List<Doador> list = service.findByTipoSanguineo(tipoSanguineo);
        List<DoadorDTO> listDTO = list.stream().map(x -> new DoadorDTO(x)).collect(Collectors.toList());

        return ResponseEntity.ok().body(listDTO);
    }

    @RequestMapping(method=RequestMethod.PUT)
    public ResponseEntity<Void> update(@RequestBody DoadorDTO doadorDTO){
        Doador doador = service.fromDTO(doadorDTO);
        doador = service.insert(doador);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{cpf}").buildAndExpand(doador.getCpf()).toUri();
        return ResponseEntity.created(uri).build();
    }

    @DeleteMapping(value="/{id}")
    public ResponseEntity<Void> delete(@PathVariable Integer id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }
}
