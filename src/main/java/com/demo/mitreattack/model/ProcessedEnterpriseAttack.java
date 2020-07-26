package com.demo.mitreattack.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.HashMap;
import java.util.Map;

@Data
public class ProcessedEnterpriseAttack {

    @JsonProperty("id")
    private String id;

    @JsonProperty("type")
    private String type;

    @JsonProperty("spec_version")
    private String specVersion;

    @JsonProperty("objects")
    private Map<String, AttackInfo> objects = new HashMap<>();

    public ProcessedEnterpriseAttack(String id, String type, String specVersion) {
        this.id = id;
        this.type = type;
        this.specVersion = specVersion;
    }
}
