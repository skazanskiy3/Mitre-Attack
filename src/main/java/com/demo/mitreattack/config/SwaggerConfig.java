/*
 *
 *  *
 *  *   COPYRIGHT © 2019 HONEYWELL INTERNATIONAL SARL
 *  *
 *  *   This software is a copyrighted work and/or information protected as a trade
 *  *   secret. Legal rights of Honeywell Inc. in this software are distinct from
 *  *   ownership of any medium in which the software is embodied. Copyright or trade
 *  *   secret notices included must be reproduced in any copies authorized by
 *  *   Honeywell Inc. The information in this software is subject to change without
 *  *   notice and should not be considered as a commitment by Honeywell Inc.
 *  *
 *
 */

package com.demo.mitreattack.config;

import io.swagger.v3.oas.annotations.enums.SecuritySchemeType;
import io.swagger.v3.oas.annotations.security.SecurityScheme;
import io.swagger.v3.oas.models.Components;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import io.swagger.v3.oas.models.servers.Server;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

//TODO: Add Security across endpoints
@Configuration
@SecurityScheme(
        name = "bearerAuth",
        type = SecuritySchemeType.HTTP,
        bearerFormat = "JWT",
        scheme = "bearer"
)
public class SwaggerConfig {

    @Bean
    public OpenAPI customOpenAPI() {
        return new OpenAPI()
                .components(new Components())
                .info(new Info().title("MITRE Attack Threat Context API"));
    }
}
