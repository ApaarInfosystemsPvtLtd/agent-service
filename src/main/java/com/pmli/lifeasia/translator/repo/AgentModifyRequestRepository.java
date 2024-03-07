package com.pmli.lifeasia.translator.repo;

import com.pmli.lifeasia.translator.model.agent.AgentModifyRequestDTO;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AgentModifyRequestRepository extends MongoRepository<AgentModifyRequestDTO,String>
{
}
