package com.demo.mitreattack.service;

import com.demo.mitreattack.exception.FileProcessingException;
import com.demo.mitreattack.model.EnterpriseAttack;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.util.Objects;

@Slf4j
@Service
public class AttackFileProcessingService {

    private static final String FILE_NAME = "enterprise-attack.json";

    protected EnterpriseAttack getAttackJson() throws JsonProcessingException {

        String string = getStringFromFile();

        ObjectMapper objectMapper = new ObjectMapper();

        return objectMapper.readValue(string, EnterpriseAttack.class);
    }

    private String getStringFromFile() {
        try {
            URI resource = Objects.requireNonNull(getClass().getClassLoader().getResource(FILE_NAME)).toURI();

            File file = new File(resource);
            return Files.readString(file.toPath(), StandardCharsets.UTF_8);
        } catch (IOException e) {
            String message = "read file error " + e.getMessage();
            log.error(message);
            throw new FileProcessingException(message);
        } catch (URISyntaxException e) {
            String message = String.format("file not found with path %s %s", FILE_NAME, e.getMessage());
            log.error(message);
            throw new FileProcessingException(message);
        }
    }
}
