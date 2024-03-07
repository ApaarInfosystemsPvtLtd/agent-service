package com.pmli.lifeasia.translator.service.client;

import com.pmli.lifeasia.translator.Exception.client.ClientFailure;
import com.pmli.lifeasia.translator.Exception.client.ClientSuccess;
import com.pmli.lifeasia.translator.model.DmsState;
import com.pmli.lifeasia.translator.model.client.ClientCRPMessageBodyRequestDTO;
import com.pmli.lifeasia.translator.model.client.ClientCRPMessageBodyResponseDTO;
import java.util.List;

public interface ClientCRPService
{
    /*ClientCRPMessageBodyRequestDTO saveClient(ClientCRPMessageBodyRequestDTO clientCRPMessageBodyRequestDTO);*/
    List<ClientCRPMessageBodyResponseDTO> createClient(ClientCRPMessageBodyRequestDTO clientCRPMessageBodyRequestDTO, DmsState state);
    void SuccessClientRequest(ClientSuccess clientSuccess);
    void FailureClientRequest(ClientFailure clientFailure);
}
