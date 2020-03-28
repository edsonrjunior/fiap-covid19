
package br.com.fiap.fiapcovid19.repository;

import br.com.fiap.fiapcovid19.model.Doador;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DoadorRepository extends JpaRepository<Doador, Integer> {

    public List<Doador> findByTipoSanguineo(String tipoSanguineo);
    public List<Doador> findByCidade(String cidade);

}