package br.com.fiap.fiapcovid19.service;

import br.com.fiap.fiapcovid19.dto.DoadorDTO;
import br.com.fiap.fiapcovid19.model.Doador;
import br.com.fiap.fiapcovid19.model.TipoSanguineo;
import br.com.fiap.fiapcovid19.repository.DoadorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DoadorService {

    @Autowired
    private DoadorRepository repository;

    public List<Doador> findByTipoSanguineo(TipoSanguineo tipoSanguineo){
        return repository.findByTipoSanguineo(tipoSanguineo);
    }

    public List<Doador> findByCidade(Integer cidade){
        return repository.findByCidade(cidade);
    }

    public Doador insert(Doador user) {
        return repository.save(user);
    }

    public void delete(Integer id) {
        repository.findById(id);
        repository.deleteById(id);
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
}
