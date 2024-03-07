package com.pmli.lifeasia.translator.repo;

import com.pmli.lifeasia.translator.model.agent.AgentModificationMessageBodyRequestDTO;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AgentModificationRequestRepository extends MongoRepository<AgentModificationMessageBodyRequestDTO,String>
{
}
