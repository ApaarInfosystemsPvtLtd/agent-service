package com.pmli.lifeasia.translator.util;

import com.pmli.lifeasia.translator.model.agent.AgentCreateRequestDTO;
import com.pmli.lifeasia.translator.model.agent.AgentModifyRequestDTO;
import com.pmli.lifeasia.translator.model.agent.CreateRequestDTO;
import com.pmli.lifeasia.translator.model.agent.ModifyRequestDTO;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Component;
import java.util.Arrays;

@Component
public class AgentModelMapper
{
    private final static Logger log = LogManager.getLogger(AgentModelMapper.class);

    /*Agent mapping for creation of the Agent */
    public AgentCreateRequestDTO createAgentMap(CreateRequestDTO createRequestDTO){

        AgentCreateRequestDTO agentCreateRequestDTO = new AgentCreateRequestDTO();
        try {
            agentCreateRequestDTO.setAgentCode(createRequestDTO.getAgentCode());
            agentCreateRequestDTO.setreportingManager(createRequestDTO.getReportingManager());
            agentCreateRequestDTO.setAgentBranch(createRequestDTO.getBranchCode());
            /* Agent Name Mapping. */
            agentCreateRequestDTO.setsalutation(createRequestDTO.getAgentName().getSalutation());
            agentCreateRequestDTO.setfirstName(createRequestDTO.getAgentName().getFirstName());
            agentCreateRequestDTO.setlastName(createRequestDTO.getAgentName().getLastName());
            /*Agent Mailing Address Mapping.*/
            agentCreateRequestDTO.setaddressType("R");
            agentCreateRequestDTO.setaddressLine01(createRequestDTO.getMailingAddress().getAddressLine01());
            agentCreateRequestDTO.setaddressLine02(createRequestDTO.getMailingAddress().getAddressLine02());
            agentCreateRequestDTO.setaddressLine03(createRequestDTO.getMailingAddress().getAddressLine03());
            agentCreateRequestDTO.setcity(createRequestDTO.getMailingAddress().getCity());
            agentCreateRequestDTO.setpinCode(createRequestDTO.getMailingAddress().getPinCode());
            agentCreateRequestDTO.setstate(createRequestDTO.getMailingAddress().getState());
            /*Agent Phone-Numbers Mapping.*/
            agentCreateRequestDTO.setphoneNumber01(createRequestDTO.getMailingAddress().getPhoneNumbers().getPrimary().getPhoneNumber());
            //agentCreateRequestDTO.setCtrycode(createRequestDTO.getMailingAddress().getPhoneNumbers().getPrimary().getCountryCode());
            agentCreateRequestDTO.setphoneNumber02(createRequestDTO.getMailingAddress().getPhoneNumbers().getAlternate().getPhoneNumber());
            //agentCreateRequestDTO.setCtrycode(createRequestDTO.getMailingAddress().getPhoneNumbers().getAlternate().getCountryCode());

            agentCreateRequestDTO.setmaritalStatus(createRequestDTO.getMaritalStatus());
            agentCreateRequestDTO.setdateOfAppointment(createRequestDTO.getDateOfAppointment());
            agentCreateRequestDTO.setLicenseIssuanceDate(createRequestDTO.getLicenseIssuanceDate());
            agentCreateRequestDTO.setlicenceExpiryDate(createRequestDTO.getExpiryDate());
            agentCreateRequestDTO.setdateOfBirth(createRequestDTO.getDateOfBirth());
            agentCreateRequestDTO.setsourceOfEvidence(createRequestDTO.getEvidence());
            agentCreateRequestDTO.setagentType(createRequestDTO.getAgentType());
            agentCreateRequestDTO.setaddressProof(createRequestDTO.getAddressProof());
            agentCreateRequestDTO.setgender(createRequestDTO.getGender());
            agentCreateRequestDTO.setareaCode(createRequestDTO.getUnitCode());
            agentCreateRequestDTO.setAccountPayee(createRequestDTO.getAccountPayee());
            agentCreateRequestDTO.setCertificateNumber(createRequestDTO.getCertificateNumber());
            agentCreateRequestDTO.setSecuityno(createRequestDTO.getBankEmployeeCode());
            agentCreateRequestDTO.setMinimumAmount(createRequestDTO.getMinimumCommissionAmount());
            agentCreateRequestDTO.setPayflag(createRequestDTO.getAllowCommissionPayment());

            agentCreateRequestDTO.setClntfthr(//nullDataFormatter(createRequestDTO.getFatherName().getSalutation())
                    nullDataFormatter(createRequestDTO.getFatherName().getFirstName()));
            //nullDataFormatter(createRequestDTO.getFatherName().getMiddleName())+
            //nullDataFormatter(createRequestDTO.getFatherName().getLastName()));

            agentCreateRequestDTO.setRmblphone(createRequestDTO.getMailingAddress().getPhoneNumbers().getPrimary().getPhoneNumber());
            agentCreateRequestDTO.setAadhar_number(createRequestDTO.getAadharNumber());
            agentCreateRequestDTO.setRinternet(createRequestDTO.getEmailAddress());
            agentCreateRequestDTO.setRtaxidnum(createRequestDTO.getTaxProofNumber());
            agentCreateRequestDTO.setTaxcde(createRequestDTO.getTaxCode());
            agentCreateRequestDTO.setBankEmployeeCode(createRequestDTO.getBankEmployeeCode());
            //agentCreateRequestDTO.setBankacckey(createRequestDTO.getBankAccountNumber());
        }catch (Exception e){
            e.printStackTrace();
            log.error("AgentModelMapper::createAgentMap::Error{}", Arrays.asList(e.getStackTrace()));
        }
        return agentCreateRequestDTO;
    }

    /*Agent mapping for modification of the Agent */
    public AgentModifyRequestDTO modifyAgentMap(ModifyRequestDTO modifyRequestDTO){

        AgentModifyRequestDTO agentModifyRequestDTO = new AgentModifyRequestDTO();
        try {
            agentModifyRequestDTO.setclientCode(modifyRequestDTO.getClientCode());
            agentModifyRequestDTO.setagentCode(modifyRequestDTO.getAgentCode());
            agentModifyRequestDTO.setreportingManager(modifyRequestDTO.getReportingManager());
            agentModifyRequestDTO.setagentBranch(modifyRequestDTO.getBranchCode());

            //Agent Name Mapping.
            agentModifyRequestDTO.setsalutation(modifyRequestDTO.getAgentName().getSalutation());
            agentModifyRequestDTO.setfirstName(modifyRequestDTO.getAgentName().getFirstName());
            agentModifyRequestDTO.setlastName(modifyRequestDTO.getAgentName().getLastName());

            //Agent Mailing Address Mapping.
            agentModifyRequestDTO.setaddressType("R");
            agentModifyRequestDTO.setaddressLine01(modifyRequestDTO.getMailingAddress().getAddressLine01());
            agentModifyRequestDTO.setaddressLine02(modifyRequestDTO.getMailingAddress().getAddressLine02());
            agentModifyRequestDTO.setaddressLine03(modifyRequestDTO.getMailingAddress().getAddressLine03());
            agentModifyRequestDTO.setcity(modifyRequestDTO.getMailingAddress().getCity());
            agentModifyRequestDTO.setpinCode(modifyRequestDTO.getMailingAddress().getPinCode());
            agentModifyRequestDTO.setstate(modifyRequestDTO.getMailingAddress().getState());

            //Agent Phone Numbers Mapping.
            agentModifyRequestDTO.setphoneNumber01(modifyRequestDTO.getMailingAddress().getPhoneNumbers().getPrimary().getPhoneNumber());
            //agentCreateRequestDTO.setCtrycode(createRequestDTO.getMailingAddress().getPhoneNumbers().getPrimary().getCountryCode());
            agentModifyRequestDTO.setphoneNumber02(modifyRequestDTO.getMailingAddress().getPhoneNumbers().getAlternate().getPhoneNumber());
            //agentCreateRequestDTO.setCtrycode(createRequestDTO.getMailingAddress().getPhoneNumbers().getAlternate().getCountryCode());

            agentModifyRequestDTO.setmaritalStatus(modifyRequestDTO.getMaritalStatus());
            //agentModifyRequestDTO.setDtetrm(modifyRequestDTO.getDateOfTermination());
            agentModifyRequestDTO.setdateOfAppointment(modifyRequestDTO.getDateOfAppointment());
            agentModifyRequestDTO.setlicenceNumber(modifyRequestDTO.getCertificateNumber());
            agentModifyRequestDTO.setlicenceStartDate(modifyRequestDTO.getLicenseIssuanceDate());
            agentModifyRequestDTO.setlicenceExpiryDate(modifyRequestDTO.getExpiryDate());
            agentModifyRequestDTO.setdateOfBirth(modifyRequestDTO.getDateOfBirth());
            agentModifyRequestDTO.setsourceOfEvidence(modifyRequestDTO.getEvidence());
            agentModifyRequestDTO.setZagntsts(modifyRequestDTO.getAgentStatus());
            agentModifyRequestDTO.setagentType(modifyRequestDTO.getAgentType());
            agentModifyRequestDTO.setaddressProof(modifyRequestDTO.getAddressProof());
            agentModifyRequestDTO.setgender(modifyRequestDTO.getGender());
            agentModifyRequestDTO.setareaCode(modifyRequestDTO.getUnitCode());

            agentModifyRequestDTO.setRmblphone(modifyRequestDTO.getMailingAddress().getPhoneNumbers().getPrimary().getPhoneNumber());
            agentModifyRequestDTO.setAadhar_number(modifyRequestDTO.getAadharNumber());
            agentModifyRequestDTO.setRinternet(modifyRequestDTO.getEmailAddress());
            agentModifyRequestDTO.setRtaxidnum(modifyRequestDTO.getTaxProofNumber());
            agentModifyRequestDTO.setPaysel(modifyRequestDTO.getAccountPayee());
            agentModifyRequestDTO.setMinsta(modifyRequestDTO.getMinimumCommissionAmount());
            agentModifyRequestDTO.setPayflag(modifyRequestDTO.getAllowCommissionPayment());

            /**New changes Added:
            * Author: Akshay Bhor
            * Date: 28-06-2022
            * Suggested By: Logic Suggested by Shivam Dubey
             * Raised By: DOPS team (Rohit Mainkar) */
            agentModifyRequestDTO.setSecuityno(modifyRequestDTO.getBankEmployeeCode());
        }catch (Exception e){
            e.printStackTrace();
            log.error("AgentModelMapper::modifyAgentMap::Error{}", Arrays.asList(e.getStackTrace()));
        }

        return agentModifyRequestDTO;

    }

    private String nullDataFormatter(String message){
        String finalString="";
        if(message!=null){
            return message;
        }
        return finalString;
    }


    private String middleNameNullDataFormatter(String message){
        String finalString="";
        if(message!=null){
            return " "+message;
        }
        return finalString;
    }

}
