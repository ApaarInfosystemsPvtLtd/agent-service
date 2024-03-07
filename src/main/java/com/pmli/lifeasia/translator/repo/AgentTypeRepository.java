package com.pmli.lifeasia.translator.repo;

import com.pmli.lifeasia.translator.model.master.AgentType;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository(value = "agentTypeRepo")
public interface AgentTypeRepository extends MongoRepository<AgentType,String> {
}
