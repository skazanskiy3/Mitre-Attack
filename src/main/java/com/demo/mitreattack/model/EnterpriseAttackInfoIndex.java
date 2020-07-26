package com.demo.mitreattack.model;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.Set;

@AllArgsConstructor
@Data
public class EnterpriseAttackInfoIndex {

    @Schema(title = "Type", example = "bundle")
    private String type;

    @Schema(title = "Id", example = "bundle--4ee91158-54a2-4744-8722-be32f062b9e8")
    private String id;

    @Schema(title = "Spec Version", example = "2.0")
    private String specVersion;

    @Schema(title = "Number of Attacks", example = "100")
    private int numberOfAttacks;
    @Schema(title = "Attack Ids", example = "[\"malware--60a9c2f0-b7a5-4e8e-959c-e1a3ff314a5f\"]")
    private Set<String> mitreAttackIds;
}
