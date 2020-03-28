package br.com.fiap.fiapcovid19.service;

import br.com.fiap.fiapcovid19.dto.DoadorDTO;
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

    public List<Doador> findByCidade(Integer cidade){
        return repository.findByCidade(cidade);
    }

    public Doador insert(Doador user) {
        return repository.insert(user);
    }

    public void delete(Integer id) {
        repository.findById(id);
        repository.deleteById(id);
    }

    public Doador fromDTO(DoadorDTO doadorDTO) {
        return new Doador(doadorDTO.getId(), doadorDTO.getNome(), doadorDTO.getTipoSanguineo(), doadorDTO.getCidade(), doadorDTO.getUF(), doadorDTO.getIdade(), doadorDTO.getCpf(), doadorDTO.getEmail(), doadorDTO.getTelefone());
    }
}
