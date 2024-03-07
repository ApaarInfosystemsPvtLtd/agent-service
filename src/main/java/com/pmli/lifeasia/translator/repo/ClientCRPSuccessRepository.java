package com.pmli.lifeasia.translator.repo;

import com.pmli.lifeasia.translator.Exception.client.ClientSuccess;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClientCRPSuccessRepository extends MongoRepository<ClientSuccess,String>
{
}
