package it.test.corsospring.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import it.test.corsospring.model.Prodotto;

public interface ProdottoRepository extends JpaRepository<Prodotto, Integer> {

}
