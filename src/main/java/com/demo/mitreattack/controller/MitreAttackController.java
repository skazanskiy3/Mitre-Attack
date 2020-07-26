package com.demo.mitreattack.controller;

import com.demo.mitreattack.model.AttackInfo;
import com.demo.mitreattack.model.EnterpriseAttackInfoIndex;
import com.demo.mitreattack.service.AttackService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/api/v1")
@Tag(name = "Threat Intel")
public class MitreAttackController {

    private final AttackService attackService;

    @Autowired
    public MitreAttackController(AttackService attackService){
        this.attackService = attackService;
    }

    @Operation(summary = "", responses = {
            @ApiResponse(responseCode = "200", description = "get attack ids",
                    content = @Content(mediaType = MediaType.APPLICATION_JSON_VALUE,
                            schema = @Schema(implementation = EnterpriseAttackInfoIndex.class)))
    }, tags = {"Threat Intel"})
    @GetMapping(value = "/mitre-attacks", produces = MediaType.APPLICATION_JSON_VALUE)
    public Mono<EnterpriseAttackInfoIndex> getAttackInfo() {
        return attackService.getAttackInfo();
    }

    @Operation(summary = "", responses = {
            @ApiResponse(responseCode = "200", description = "get attack threat context",
                    content = @Content(mediaType = MediaType.APPLICATION_JSON_VALUE,
                            schema = @Schema(implementation = AttackInfo.class))),
            @ApiResponse(responseCode = "404", description = "No data exists")
    }, tags = {"Threat Intel"})
    @GetMapping(value = "/mitre-attack/{attack-id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public Mono<AttackInfo> getAttackInfoById(
            @Parameter(description = "mitre attack id", required = true) @PathVariable("attack-id") String attackId) {
        return attackService.getAttackById(attackId);
    }
}
