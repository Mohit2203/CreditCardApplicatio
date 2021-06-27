package com.project.es.creditcard.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.project.es.creditcard.model.CreditCardDetail;

@Repository
public interface CardProcessingRepository extends JpaRepository<CreditCardDetail, Long> {

	public List<CreditCardDetail> findAll();
	public CreditCardDetail findByCardNumber(String card);

}
