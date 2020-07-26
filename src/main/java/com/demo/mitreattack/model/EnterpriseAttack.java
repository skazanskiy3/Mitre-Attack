package com.demo.mitreattack.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import org.json.simple.JSONArray;

@Data
public class EnterpriseAttack {

    @JsonProperty("type")
    private String type;

    @JsonProperty("id")
    private String id;

    @JsonProperty("spec_version")
    private String specVersion;

    @JsonProperty("objects")
    private JSONArray objects;
}
