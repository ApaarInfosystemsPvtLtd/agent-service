package com.pmli.lifeasia.translator.repo;

import com.pmli.lifeasia.translator.model.agent.AgentCreateRequestDTO;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AgentCreateRequestRepository extends MongoRepository<AgentCreateRequestDTO,String>
{
    
}
