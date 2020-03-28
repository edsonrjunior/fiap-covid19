
package br.com.fiap.fiapcovid19.repository;

import br.com.fiap.fiapcovid19.model.Doador;

import br.com.fiap.fiapcovid19.model.TipoSanguineo;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DoadorRepository extends MongoRepository<Doador, String> {

    @Query("{'tipoSanguineo' : ?0 , 'cidade' : ?1}")
    public List<Doador> findByTipoSanguineoOrCidade(TipoSanguineo tipoSanguineo, Integer cidade);
    public List<Doador> findByCidade(Integer cidade);

}