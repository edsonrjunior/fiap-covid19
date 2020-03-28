package br.com.fiap.fiapcovid19.service;

import br.com.fiap.fiapcovid19.dto.DoadorDTO;
import br.com.fiap.fiapcovid19.model.Doador;
import br.com.fiap.fiapcovid19.model.TipoSanguineo;
import br.com.fiap.fiapcovid19.repository.DoadorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
public class DoadorService {

    @Autowired
    private DoadorRepository repository;

    public List<Doador> findAll(TipoSanguineo tipoSanguineo, Integer cidade){

        List<Doador> lista = null;

        if (tipoSanguineo != null && cidade != null) {
            lista = repository.findByTipoSanguineoOrCidade(tipoSanguineo, cidade);
        } else {
            lista = repository.findAll();
        }
        return lista;
    }

    public List<Doador> findByCidade(Integer cidade){
        return repository.findByCidade(cidade);
    }

    public Doador insert(Doador user) {
        return repository.save(user);
    }

    public void delete(String cpf) {

        repository.deleteById(cpf);

    }

    public Doador fromDTO(DoadorDTO doadorDTO) {
        return new Doador(doadorDTO.getCpf(),
                doadorDTO.getNome(),
                doadorDTO.getTipoSanguineo(),
                doadorDTO.getCidade(),
                doadorDTO.getUF(),
                doadorDTO.getIdade(),
                doadorDTO.getEmail(),
                doadorDTO.getTelefone());
    }

    public Doador findById(String cpf) {
        return repository.findById(cpf).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "CPF nao encontrado"));
    }
}
