package br.com.fiap.fiapcovid19.service;

import br.com.fiap.fiapcovid19.model.Doador;
import br.com.fiap.fiapcovid19.repository.DoadorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DoadorService {

    @Autowired
    private DoadorRepository repository;

    public List<Doador> findByTipoSanguineo(String tipoSanguineo){
        return repository.findByTipoSanguineo(tipoSanguineo);
    }


    public List<Doador> findByCidade(String cidade){
        return repository.findByCidade(cidade);
    }
}
