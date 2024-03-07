package com.pmli.lifeasia.translator.repo;

import com.pmli.lifeasia.translator.model.client.ClientMODPMessageBodyRequestDTO;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClientMODPRequestRepository extends MongoRepository<ClientMODPMessageBodyRequestDTO,String>
{
}
