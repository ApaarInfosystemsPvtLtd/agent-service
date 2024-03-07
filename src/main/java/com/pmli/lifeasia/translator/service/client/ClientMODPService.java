package com.pmli.lifeasia.translator.service.client;

import com.pmli.lifeasia.translator.Exception.client.ClientFailure;
import com.pmli.lifeasia.translator.Exception.client.ClientSuccess;
import com.pmli.lifeasia.translator.model.DmsState;
import com.pmli.lifeasia.translator.model.client.ClientMODPMessageBodyRequestDTO;
import com.pmli.lifeasia.translator.model.client.ClientMODPMessageBodyResponseDTO;

import java.util.List;

public interface ClientMODPService
{
    /*ClientMODPMessageBodyRequestDTO saveClient(ClientMODPMessageBodyRequestDTO clientCRPMessageBodyRequestDTO);*/
    List<ClientMODPMessageBodyResponseDTO> modifyClient(ClientMODPMessageBodyRequestDTO clientCRPMessageBodyRequestDTO, DmsState state);
    void SuccessClientRequest(ClientSuccess clientSuccess);
    void FailureClientRequest(ClientFailure clientFailure);
}
