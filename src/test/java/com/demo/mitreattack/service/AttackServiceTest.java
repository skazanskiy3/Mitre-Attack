package com.demo.mitreattack.service;

import com.demo.mitreattack.model.AttackInfo;
import com.demo.mitreattack.model.EnterpriseAttackInfoIndex;
import com.demo.mitreattack.model.ProcessedEnterpriseAttack;
import com.fasterxml.jackson.core.JsonProcessingException;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.jupiter.api.Assertions.*;

@ActiveProfiles("test")
@RunWith(SpringRunner.class)
@SpringBootTest
class AttackServiceTest {

    @Autowired
    private AttackService attackService;

    @Test
    public void getAttackInfo() {

        EnterpriseAttackInfoIndex info = attackService.getAttackInfo().block();

        assertNotNull(info);
        assertFalse(info.getMitreAttackIds().isEmpty());
        assertTrue(info.getNumberOfAttacks() > 0);
    }

    @Test
    public void getAttackById() {

        EnterpriseAttackInfoIndex info = attackService.getAttackInfo().block();

        assertNotNull(info);
        String id = info.getMitreAttackIds().iterator().next();

        AttackInfo attackInfo = attackService.getAttackById(id).block();

        assertNotNull(attackInfo);
        assertFalse(attackInfo.getJsonKeysAndDataTypes().isEmpty());
        assertNotNull(attackInfo.getJsonString());
    }

    @Test
    public void getAttackDTOs() throws JsonProcessingException {

        ProcessedEnterpriseAttack attack = attackService.getProcessedAttacks();

        assertNotNull(attack);
        assertEquals("bundle", attack.getType());
        assertEquals("bundle--4ee91158-54a2-4744-8722-be32f062b9e8", attack.getId());
        assertEquals("2.0", attack.getSpecVersion());

        assertNotNull(attack.getObjects());
        assertFalse(attack.getObjects().isEmpty());
    }
}