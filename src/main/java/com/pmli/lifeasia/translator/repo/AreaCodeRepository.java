package com.pmli.lifeasia.translator.repo;

import com.pmli.lifeasia.translator.model.master.AreaCode;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AreaCodeRepository extends MongoRepository<AreaCode,String> {
}
