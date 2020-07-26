package com.demo.mitreattack.service;

import com.demo.mitreattack.model.EnterpriseAttack;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.junit.MockitoJUnitRunner;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@RunWith(MockitoJUnitRunner.class)
class AttackFileProcessingServiceTest {

    private AttackFileProcessingService attackFileProcessingService = new AttackFileProcessingService();

    @Test
    public void getAttackJson() throws IOException {

        EnterpriseAttack attack = attackFileProcessingService.getAttackJson();

        assertNotNull(attack);
        assertEquals("bundle", attack.getType());
        assertEquals("bundle--4ee91158-54a2-4744-8722-be32f062b9e8", attack.getId());
        assertEquals("2.0", attack.getSpecVersion());

        assertNotNull(attack.getObjects());
    }
}