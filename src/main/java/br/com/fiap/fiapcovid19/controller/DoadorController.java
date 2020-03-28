package br.com.fiap.fiapcovid19.controller;

import br.com.fiap.fiapcovid19.dto.DoadorDTO;
import br.com.fiap.fiapcovid19.model.Doador;
import br.com.fiap.fiapcovid19.service.DoadorService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping(value = "/doadores")
public class DoadorController {

    private DoadorService service;

    @RequestMapping(value="/{tipo}", method=RequestMethod.GET)
    public ResponseEntity<List<DoadorDTO>> findByTipoSanguineo(@PathVariable String tipo){
        List<Doador> list = service.findByTipoSanguineo(tipo);
        List<DoadorDTO> listDTO = list.stream().map(x -> new DoadorDTO(x)).collect(Collectors.toList());

        return ResponseEntity.ok().body(listDTO);
    }
}
