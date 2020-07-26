package com.demo.mitreattack.controller;

import com.demo.mitreattack.model.AttackInfo;
import com.demo.mitreattack.model.EnterpriseAttackInfoIndex;
import com.demo.mitreattack.service.AttackFileProcessingService;
import com.demo.mitreattack.service.AttackService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import reactor.core.publisher.Mono;

import java.util.Map;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.doReturn;
import static reactor.core.publisher.Mono.when;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {MitreAttackController.class, AttackService.class, AttackFileProcessingService.class})
@SpringBootTest
class MitreAttackControllerUnitTest {

    @Mock
    private AttackService attackService;

    private MitreAttackController mitreAttackController;

    @BeforeEach
    public void setup(){
        mitreAttackController = new MitreAttackController(attackService);
    }

    @Test
    void getAttackInfo() {

        EnterpriseAttackInfoIndex attackInfoIndex = new EnterpriseAttackInfoIndex(
                "bundle", "bundle-id", "2.0", 10, Set.of("ids"));

        doReturn(Mono.just(attackInfoIndex)).when(attackService).getAttackInfo();

        EnterpriseAttackInfoIndex response = mitreAttackController.getAttackInfo().block();

        assertEquals(attackInfoIndex, response);
    }

    @Test
    void getAttackInfoById() {

        AttackInfo attackInfo = new AttackInfo(Map.of("key", "String"), "\"{\\\"key\\\":\\\"some-string\\\"}\"");

        String id = "some-id";

        doReturn(Mono.just(attackInfo)).when(attackService).getAttackById(id);

        AttackInfo response = mitreAttackController.getAttackInfoById(id).block();

        assertEquals(attackInfo, response);
    }
}