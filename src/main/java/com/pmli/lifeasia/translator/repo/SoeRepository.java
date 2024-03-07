package com.pmli.lifeasia.translator.repo;

import com.pmli.lifeasia.translator.model.master.Soe;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SoeRepository extends MongoRepository<Soe,String> {
}
