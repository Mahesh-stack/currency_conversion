package com.boot.test.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.boot.test.entity.CurrencyConversionEntity;

@Repository
public interface CurrencyConversionRepository extends JpaRepository<CurrencyConversionEntity, Integer> {

}
