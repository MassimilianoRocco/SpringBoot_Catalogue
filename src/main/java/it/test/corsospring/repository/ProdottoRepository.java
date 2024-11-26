package it.test.corsospring.repository;

import org.springframework.data.repository.CrudRepository;

import it.test.corsospring.model.Prodotto;

public interface ProdottoRepository extends CrudRepository<Prodotto, Integer> {

}
