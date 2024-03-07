package com.pmli.lifeasia.translator.util.validation;

import com.pmli.lifeasia.translator.initialize.MasterStore;
import com.pmli.lifeasia.translator.model.Validation;
import com.pmli.lifeasia.translator.model.agent.CreateRequestDTO;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Component;

@Component
public class CreateValidator {
    private final static Logger log = LogManager.getLogger(CreateValidator.class);

    public static Validation validate(CreateRequestDTO createRequestDTO, MasterStore masterStore){
        Validation validation = new Validation();
        log.info("CreateValidator::validate::Entering into initial request validation process.");
        //validateAgentType(createRequestDTO, validation, masterStore);
        //validateAreaCode(createRequestDTO,validation,masterStore);
        validateGender(createRequestDTO,validation,masterStore);
        validateMarryd(createRequestDTO,validation,masterStore);
        validateSalutation(createRequestDTO, validation, masterStore);
        validateSoe(createRequestDTO,validation,masterStore);
        validateState(createRequestDTO,validation,masterStore);
        validatePinCode(createRequestDTO,validation,masterStore);
        return validation;
    }

    private static void validatePinCode(CreateRequestDTO createRequestDTO, Validation validation, MasterStore masterStore) {
        String pinCode = createRequestDTO.getMailingAddress().getPinCode();
        if(pinCode.length() < 5 || pinCode.length() > 6){
            validation.setValid(false);
            validation.getErrors().put("PinCodeError","PinCode is less than 5 or greater than 6");
            log.error("CreateValidator::validate::validatePinCode::PinCodeError::PinCode is less than 5 or greater than 6");
        }
    }

    private static void validateAgentType(CreateRequestDTO createRequestDTO, Validation validation, MasterStore masterStore) {
        String agentType = createRequestDTO.getAgentType();
        String agentTypeCode = masterStore.getAgentTypeMap().get(agentType);
        if(agentTypeCode==null){
            validation.setValid(false);
            validation.getErrors().put("AgentTypeError","AgentType Does not Exists.");
            log.error("CreateValidator::validate::validateAgentType::AgentTypeError::AgentType Does not Exists.");
        }else{
            createRequestDTO.setAgentType(agentTypeCode);
            log.info("CreateValidator::validate::validateAgentType::Success");
        }
    }

    private static void validateAreaCode(CreateRequestDTO createRequestDTO, Validation validation, MasterStore masterStore) {
        String areaCode = createRequestDTO.getUnitCode();
        String areaCodeCode = masterStore.getAreaCodeMap().get(areaCode);
        if(areaCodeCode==null){
            validation.setValid(false);
            validation.getErrors().put("AreaCodeError","AreaCode Does not Exists.");
            log.error("CreateValidator::validate::validateAreaCode::AreaCodeError::AreaCode Does not Exists.");
        }else{
            createRequestDTO.setUnitCode(areaCodeCode);
            log.info("CreateValidator::validate::validateAreaCode::Success");
        }
    }

    private static void validateGender(CreateRequestDTO createRequestDTO, Validation validation, MasterStore masterStore) {
        String gender = createRequestDTO.getGender();
        String genderCode = masterStore.getGenderMap().get(gender);
        if(genderCode==null){
            validation.setValid(false);
            validation.getErrors().put("GenderError","Gender Does not Exists.");
            log.error("CreateValidator::validate::validateGender::GenderError::Gender Does not Exists.");
        }else {
            createRequestDTO.setGender(genderCode);
            log.info("CreateValidator::validate::validateGender::Success");
        }
    }

    private static void validateMarryd(CreateRequestDTO createRequestDTO, Validation validation, MasterStore masterStore) {
        String marryd = createRequestDTO.getMaritalStatus();
        String marrydCode = masterStore.getMarrydMap().get(marryd);
        if(marrydCode==null){
            validation.setValid(false);
            validation.getErrors().put("MarrydError","Marital Status Does not Exists.");
            log.error("CreateValidator::validate::validateMarryd::MarrydError::Marital Status Does not Exists.");
        }else{
            createRequestDTO.setMaritalStatus(marrydCode);
            log.info("CreateValidator::validate::validateMarryd::Success");
        }
    }

    private static void validateSalutation(CreateRequestDTO createRequestDTO, Validation validation, MasterStore masterStore) {
        String salutation = createRequestDTO.getAgentName().getSalutation();
        String salutationCode = masterStore.getSalutationMap().get(salutation);
        if(salutationCode==null){
            validation.setValid(false);
            validation.getErrors().put("SalutationError","Salutation Does not Exists.");
            log.error("CreateValidator::validate::validateSalutation::SalutationError::Salutation Does not Exists.");
        }else{
            createRequestDTO.getAgentName().setSalutation (salutationCode);
            log.info("CreateValidator::validate::validateSalutation::Success");
        }
    }

    private static void validateSoe(CreateRequestDTO createRequestDTO, Validation validation, MasterStore masterStore) {
        String soe = createRequestDTO.getEvidence();
        //String soeCode = masterStore.getAgentTypeMap().get(soe);
        if(!(soe==null) && !("PAN".equalsIgnoreCase(soe))){
            validation.setValid(false);
            validation.getErrors().put("SoeError","Evidence only 'PAN' allowed.");
            log.error("CreateValidator::validate::validateSoe::validateSoe::Evidence only 'PAN' allowed.");
        }else {
            createRequestDTO.setEvidence("SAPPAN    ");
            log.info("CreateValidator::validate::validateSoe::Evidence Set as::SAPPAN    ");
        }
    }

    private static void validateState(CreateRequestDTO createRequestDTO, Validation validation, MasterStore masterStore) {
        String state = createRequestDTO.getMailingAddress().getState();
        String stateCode = masterStore.getStateMap().get(state);
        if(stateCode==null){
            validation.setValid(false);
            validation.getErrors().put("StateError","State Does not Exists.");
            log.error("CreateValidator::validate::validateState::StateError::State Does not Exists.");
        }else{
            createRequestDTO.getMailingAddress().setState(stateCode);
            log.info("CreateValidator::validate::validateState::Success");
        }
    }

}
