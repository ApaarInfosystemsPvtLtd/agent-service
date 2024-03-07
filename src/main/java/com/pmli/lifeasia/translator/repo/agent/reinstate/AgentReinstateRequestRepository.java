package com.pmli.lifeasia.translator.repo.agent.reinstate;

import com.pmli.lifeasia.translator.model.agent.reinstate.AgentReinstateMessageBody;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AgentReinstateRequestRepository extends MongoRepository<AgentReinstateMessageBody,String>
{
}
