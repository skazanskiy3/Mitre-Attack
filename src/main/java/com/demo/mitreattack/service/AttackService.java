package com.demo.mitreattack.service;

import com.demo.mitreattack.exception.ResourceNotFoundException;
import com.demo.mitreattack.model.AttackInfo;
import com.demo.mitreattack.model.EnterpriseAttack;
import com.demo.mitreattack.model.EnterpriseAttackInfoIndex;
import com.demo.mitreattack.model.ProcessedEnterpriseAttack;
import com.fasterxml.jackson.core.JsonProcessingException;
import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

import javax.validation.constraints.NotEmpty;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

@Service
public class AttackService {

    private final AttackFileProcessingService attackFileProcessingService;

    private ProcessedEnterpriseAttack processedEnterpriseAttack;
    private EnterpriseAttackInfoIndex enterpriseAttackInfoIndex;

    @Autowired
    public AttackService(AttackFileProcessingService attackFileProcessingService) throws JsonProcessingException {
        this.attackFileProcessingService = attackFileProcessingService;
        this.processedEnterpriseAttack = getProcessedAttacks();

        this.enterpriseAttackInfoIndex = new EnterpriseAttackInfoIndex(
                processedEnterpriseAttack.getType(),
                processedEnterpriseAttack.getId(),
                processedEnterpriseAttack.getSpecVersion(),
                processedEnterpriseAttack.getObjects().keySet().size(),
                processedEnterpriseAttack.getObjects().keySet());
    }

    public Mono<AttackInfo> getAttackById(@NotEmpty String id){

        AttackInfo attackInfo = processedEnterpriseAttack.getObjects().get(id);

        if(attackInfo == null)
            return Mono.error(new ResourceNotFoundException(id));

        return Mono.just(attackInfo);
    }

    public Mono<EnterpriseAttackInfoIndex> getAttackInfo(){
        return Mono.just(enterpriseAttackInfoIndex);
    }

    protected ProcessedEnterpriseAttack getProcessedAttacks() throws JsonProcessingException {

        EnterpriseAttack attack = attackFileProcessingService.getAttackJson();

        ProcessedEnterpriseAttack processedEnterpriseAttack = new ProcessedEnterpriseAttack(
                attack.getId(), attack.getType(), attack.getSpecVersion());

        for(Object attackObject : attack.getObjects()) {
            LinkedHashMap<String, Object> linkedHashMap = (LinkedHashMap<String, Object>) attackObject;

            // get all possible keys and data types for "objects" property
            Map<String, String> objectProperties = new HashMap<>();

            String attackId = (String) linkedHashMap.get("id");

            for(String key : linkedHashMap.keySet()) {
                objectProperties.put(key, linkedHashMap.get(key).getClass().getSimpleName());
            }

            String jsonString = new JSONObject(linkedHashMap).toString();
            AttackInfo attackInfoDTO = new AttackInfo(objectProperties, jsonString);

            processedEnterpriseAttack.getObjects().put(attackId, attackInfoDTO);
        }

        return processedEnterpriseAttack;
    }
}
