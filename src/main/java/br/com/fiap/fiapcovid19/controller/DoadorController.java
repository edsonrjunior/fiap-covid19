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

    @ApiOperation(value = "Lista doadores por Tipo Sanguíneo e Cidade")
    @GetMapping(produces = "application/json")
    public ResponseEntity<List<DoadorDTO>> findByTipoSanguineo(
            @RequestParam(required = false, value = "tipoSanguineo") TipoSanguineo tipoSanguineo,
            @RequestParam(required = false, value = "cidade") Integer cidade){

        List<Doador> list = service.findAll(tipoSanguineo, cidade);
        List<DoadorDTO> listDTO = list.stream().map(x -> new DoadorDTO(x)).collect(Collectors.toList());

        return ResponseEntity.ok().body(listDTO);
    }

    @ApiOperation(value = "Retorna o cadastro de um doador")
    @GetMapping(produces = "application/json", value = "/{cpf}")
    public ResponseEntity<DoadorDTO> findByTipoSanguineo(@PathVariable String cpf){

        Doador doador = service.findById(cpf);
        return ResponseEntity.ok().body(new DoadorDTO(doador));
    }

    @ApiOperation(value = "Atualiza doador")
    @RequestMapping(method=RequestMethod.PUT, value = "{cpf}")
    public ResponseEntity<Void> update(@RequestBody DoadorDTO doadorDTO){
        Doador doador = service.fromDTO(doadorDTO);
        doador = service.insert(doador);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{cpf}").buildAndExpand(doador.getCpf()).toUri();
        return ResponseEntity.created(uri).build();
    }

    @ApiOperation(value = "Deleta doador")
    @DeleteMapping("/{cpf}")
    public ResponseEntity<Void> delete(@PathVariable String cpf) {
        service.delete(cpf);
        return ResponseEntity.noContent().build();
    }
}
