package com.pmli.lifeasia.translator.repo;

import com.pmli.lifeasia.translator.model.master.Marryd;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MarrydRepository extends MongoRepository<Marryd,String> {
}
