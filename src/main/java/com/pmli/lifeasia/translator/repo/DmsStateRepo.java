package com.pmli.lifeasia.translator.repo;

import com.pmli.lifeasia.translator.model.DmsState;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DmsStateRepo extends MongoRepository<DmsState,String> {
}
