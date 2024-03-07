package com.pmli.lifeasia.translator.repo;

import com.pmli.lifeasia.translator.Exception.agent.AgentSuccess;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AgentModificationSuccessRepository extends MongoRepository<AgentSuccess,String>
{
}
