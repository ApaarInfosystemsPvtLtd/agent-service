package com.pmli.lifeasia.translator.initialize;

import com.pmli.lifeasia.translator.model.master.*;
import com.pmli.lifeasia.translator.repo.*;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import java.util.HashMap;
import java.util.Map;


@Component
@Scope(value="singleton")
public class MasterStore {
    @Autowired
    AgentTypeRepository agentTypeRepository;

    @Autowired
    AreaCodeRepository areaCodeRepo;

    @Autowired
    GenderRepository genderRepo;

    @Autowired
    MarrydRepository marrydRepo;

    @Autowired
    SalutationRepository salutationRepo;

    @Autowired
    SoeRepository soeRepo;

    @Autowired
    StateRepository stateRepo;

    private final static Logger log = LogManager.getLogger(MasterStore.class);

    private Map<String,String> agentTypeMap = new HashMap<>();
    private Map<String,String> areaCodeMap = new HashMap<>();
    private Map<String,String> genderMap = new HashMap<>();
    private Map<String,String> marrydMap = new HashMap<>();
    private Map<String,String> salutationMap = new HashMap<>();
    private Map<String,String> soeMap = new HashMap<>();
    private Map<String,String> stateMap = new HashMap<>();

    public Map<String, String> getAgentTypeMap() {
        return agentTypeMap;
    }

    public void setAgentTypeMap(Map<String, String> agentTypeMap) {
        this.agentTypeMap = agentTypeMap;
    }

    public Map<String, String> getAreaCodeMap() {
        return areaCodeMap;
    }

    public void setAreaCodeMap(Map<String, String> areaCodeMap) {
        this.areaCodeMap = areaCodeMap;
    }

    public Map<String, String> getGenderMap() {
        return genderMap;
    }

    public void setGenderMap(Map<String, String> genderMap) {
        this.genderMap = genderMap;
    }

    public Map<String, String> getMarrydMap() {
        return marrydMap;
    }

    public void setMarrydMap(Map<String, String> marrydMap) {
        this.marrydMap = marrydMap;
    }

    public Map<String, String> getSalutationMap() {
        return salutationMap;
    }

    public void setSalutationMap(Map<String, String> salutationMap) {
        this.salutationMap = salutationMap;
    }

    public Map<String, String> getSoeMap() {
        return soeMap;
    }

    public void setSoeMap(Map<String, String> soeMap) {
        this.soeMap = soeMap;
    }

    public Map<String, String> getStateMap() {
        return stateMap;
    }

    public void setStateMap(Map<String, String> stateMap) {
        this.stateMap = stateMap;
    }


    public void initialize(){
        initializeAgentType();
        initializeAreaCode();
        initializeGender();
        initializeMarryd();
        initializeSalutation();
        initializeSoe();
        initializeState();

    }

    public void clear() {
        getAgentTypeMap().clear();
        getAreaCodeMap().clear();
        getGenderMap().clear();
        getMarrydMap().clear();
        getSalutationMap().clear();
        getSoeMap().clear();
        getStateMap().clear();
    }

    private void initializeAgentType(){

        for(AgentType agentType:agentTypeRepository.findAll()){
            agentTypeMap.put(agentType.getTitle(),agentType.getCode());
        }
        log.info("agentTypeMap::{}",getAgentTypeMap());
    }

    private void initializeAreaCode(){
        for(AreaCode areaCode:areaCodeRepo.findAll()){
            areaCodeMap.put(areaCode.getTitle(),areaCode.getCode());
        }
        log.info("areaCodeMap::{}",getAreaCodeMap());
    }

    private void initializeGender(){
        for(Gender gender:genderRepo.findAll()){
            genderMap.put(gender.getTitle(),gender.getCode());
        }
        log.info("genderMap::{}",getGenderMap());
    }

    private void initializeMarryd(){
        for(Marryd marryd:marrydRepo.findAll()){
            marrydMap.put(marryd.getTitle(),marryd.getCode());
        }
        log.info("marrydMap::{}",getMarrydMap());
    }

    private void initializeSalutation(){
        for(Salutation salutation:salutationRepo.findAll()){
            salutationMap.put(salutation.getTitle(),salutation.getCode());
        }
        log.info("salutationMap::{}",getSalutationMap());
    }

    private void initializeSoe(){
        for(Soe soe:soeRepo.findAll()){
            soeMap.put(soe.getTitle(),soe.getCode());
        }
        log.info("soeMap::{}",getSoeMap());
    }

    private void initializeState(){
        for(State state:stateRepo.findAll()){
            stateMap.put(state.getTitle(),state.getCode());
        }
        log.info("stateMap::{}",getStateMap());
    }

}
