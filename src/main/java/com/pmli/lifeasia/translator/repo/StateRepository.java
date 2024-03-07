package com.pmli.lifeasia.translator.repo;

import com.pmli.lifeasia.translator.model.master.State;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StateRepository extends MongoRepository<State,String> {
}
