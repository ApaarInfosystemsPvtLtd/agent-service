package com.pmli.lifeasia.translator.repo;

import com.pmli.lifeasia.translator.Exception.client.ClientFailure;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClientFailureRepository extends MongoRepository<ClientFailure,String>
{
}
