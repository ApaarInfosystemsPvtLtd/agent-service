package com.pmli.lifeasia.translator.util.validation;

import com.pmli.lifeasia.translator.initialize.MasterStore;
import com.pmli.lifeasia.translator.model.agent.ModifyRequestDTO;
import com.pmli.lifeasia.translator.model.Validation;
import org.springframework.stereotype.Component;

@Component
public class ModifyValidator {
    public static Validation validate(ModifyRequestDTO modifyRequestDTO, MasterStore masterStore){
        Validation validation = new Validation();
        //validateAgentType(modifyRequestDTO, validation, masterStore);
        //validateAreaCode(modifyRequestDTO,validation,masterStore);
        validateGender(modifyRequestDTO,validation,masterStore);
        validateMarryd(modifyRequestDTO,validation,masterStore);
        validateSalutation(modifyRequestDTO, validation, masterStore);
        validateSoe(modifyRequestDTO,validation,masterStore);
        validateState(modifyRequestDTO,validation,masterStore);
        validatePinCode(modifyRequestDTO,validation,masterStore);
        return validation;
    }

    private static void validatePinCode(ModifyRequestDTO createRequestDTO, Validation validation, MasterStore masterStore) {
        String pinCode = createRequestDTO.getMailingAddress().getPinCode();
        if(pinCode.length() < 5 || pinCode.length() > 6){
            validation.setValid(false);
            validation.getErrors().put("PinCodeError","PinCode is less than 5 or greater than 6");
        }
    }


    private static void validateAgentType(ModifyRequestDTO createRequestDTO, Validation validation, MasterStore masterStore) {
        String agentType = createRequestDTO.getAgentType();
        String agentTypeCode = masterStore.getAgentTypeMap().get(agentType);
        if(agentTypeCode==null){
            validation.setValid(false);
            validation.getErrors().put("AgentTypeError","AgentType Does not Exists.");
        }else{
            createRequestDTO.setAgentType(agentTypeCode);
        }
    }

    private static void validateAreaCode(ModifyRequestDTO createRequestDTO, Validation validation, MasterStore masterStore) {
        String areaCode = createRequestDTO.getUnitCode();
        String areaCodeCode = masterStore.getAreaCodeMap().get(areaCode);
        if(areaCodeCode==null){
            validation.setValid(false);
            validation.getErrors().put("AreaCodeError","AreaCode Does not Exists.");
        }else{
            createRequestDTO.setUnitCode(areaCodeCode);
        }
    }


    private static void validateGender(ModifyRequestDTO createRequestDTO, Validation validation, MasterStore masterStore) {
        String gender = createRequestDTO.getGender();
        String genderCode = masterStore.getGenderMap().get(gender);
        if(genderCode==null){
            validation.setValid(false);
            validation.getErrors().put("GenderError","Gender Does not Exists.");
        }
        else {
            createRequestDTO.setGender(genderCode);
        }
    }

    private static void validateMarryd(ModifyRequestDTO createRequestDTO, Validation validation, MasterStore masterStore) {
        String marryd = createRequestDTO.getMaritalStatus();
        String marrydCode = masterStore.getMarrydMap().get(marryd);
        if(marrydCode==null){
            validation.setValid(false);
            validation.getErrors().put("MarrydError","Marital Status Does not Exists.");
        }
        else{
            createRequestDTO.setMaritalStatus(marrydCode);
        }
    }


    private static void validateSalutation(ModifyRequestDTO createRequestDTO, Validation validation, MasterStore masterStore) {
        String salutation = createRequestDTO.getAgentName().getSalutation();
        String salutationCode = masterStore.getSalutationMap().get(salutation);
        if(salutationCode==null){
            validation.setValid(false);
            validation.getErrors().put("SalutationError","Salutation Does not Exists.");
        }else{
            createRequestDTO.getAgentName().setSalutation (salutationCode);
        }
    }

    private static void validateSoe(ModifyRequestDTO createRequestDTO, Validation validation, MasterStore masterStore) {
        String soe = createRequestDTO.getEvidence();
        //String soeCode = masterStore.getAgentTypeMap().get(soe);
        if(!(soe==null) && !("PAN".equalsIgnoreCase(soe))){
            validation.setValid(false);
            validation.getErrors().put("SoeError","Evidence only 'PAN' allowed.");
        }
        else {
            createRequestDTO.setEvidence("SAPPAN    ");
        }
    }

    private static void validateState(ModifyRequestDTO createRequestDTO, Validation validation, MasterStore masterStore) {
        String state = createRequestDTO.getMailingAddress().getState();
        String stateCode = masterStore.getStateMap().get(state);
        if(stateCode==null){
            validation.setValid(false);
            validation.getErrors().put("StateError","State Does not Exists.");
        }
        else{
            createRequestDTO.getMailingAddress().setState(stateCode);
        }
    }
}
