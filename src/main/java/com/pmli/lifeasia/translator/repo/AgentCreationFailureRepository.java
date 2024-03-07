package com.pmli.lifeasia.translator.repo;

import com.pmli.lifeasia.translator.Exception.agent.AgentFailure;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface AgentCreationFailureRepository extends MongoRepository<AgentFailure,String> {
}
