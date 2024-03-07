package com.pmli.lifeasia.translator.repo;

import com.pmli.lifeasia.translator.model.client.ClientCRPMessageBodyRequestDTO;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClientCRPRequestRepository extends MongoRepository<ClientCRPMessageBodyRequestDTO,String>
{
}
