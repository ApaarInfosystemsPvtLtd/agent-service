package com.pmli.lifeasia.translator.repo;

import com.pmli.lifeasia.translator.Exception.agent.AgentFailure;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AgentModificationFailureRepository extends MongoRepository<AgentFailure,String>
{
}
