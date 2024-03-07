package com.pmli.lifeasia.translator.repo;

import com.pmli.lifeasia.translator.model.agent.AgentCreateResponseDTO;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AgentCreateResponseRepository extends MongoRepository<AgentCreateResponseDTO,String>
{
}
