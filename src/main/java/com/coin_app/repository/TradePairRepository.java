package com.coin_app.repository;

import com.coin_app.entity.TradePair;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TradePairRepository extends CrudRepository<TradePair, Integer> {

}
