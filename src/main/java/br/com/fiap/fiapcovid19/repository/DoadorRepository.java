
package br.com.fiap.fiapcovid19.repository;

import br.com.fiap.fiapcovid19.model.Doador;

import br.com.fiap.fiapcovid19.model.TipoSanguineo;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DoadorRepository extends MongoRepository<Doador, Integer> {

    public List<Doador> findByTipoSanguineo(TipoSanguineo tipoSanguineo);
    public List<Doador> findByCidade(Integer cidade);

}