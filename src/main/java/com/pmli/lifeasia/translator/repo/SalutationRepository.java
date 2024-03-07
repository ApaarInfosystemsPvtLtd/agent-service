package com.pmli.lifeasia.translator.repo;

import com.pmli.lifeasia.translator.model.master.Salutation;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SalutationRepository extends MongoRepository<Salutation,String> {
}
