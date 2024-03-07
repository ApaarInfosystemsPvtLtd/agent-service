package com.pmli.lifeasia.translator.repo.agent.terminate;

import com.pmli.lifeasia.translator.model.agent.terminate.AgentTerminateMessageBody;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AgentTerminateRequestRepository extends MongoRepository<AgentTerminateMessageBody,String>
{
}
