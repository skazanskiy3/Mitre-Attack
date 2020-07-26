package com.demo.mitreattack.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Map;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AttackInfo {

    public static final String MAP_EXAMPLE = "{\n" +
            "    \"object_marking_refs\": \"ArrayList\",\n" +
            "    \"created\": \"String\",\n" +
            "    \"description\": \"String\",\n" +
            "    \"type\": \"String\",\n" +
            "    \"x_mitre_platforms\": \"ArrayList\",\n" +
            "    \"labels\": \"ArrayList\",\n" +
            "    \"x_mitre_aliases\": \"ArrayList\",\n" +
            "    \"x_mitre_version\": \"String\",\n" +
            "    \"name\": \"String\",\n" +
            "    \"modified\": \"String\",\n" +
            "    \"id\": \"String\",\n" +
            "    \"created_by_ref\": \"String\",\n" +
            "    \"external_references\": \"ArrayList\"\n" +
            "  }";
    public static final String ATTACK_INFO_EXAMPLE = "\"{\\\"object_marking_refs\\\":[\\\"marking-definition--fa42a846-8d90-4e51-bc29-71d5b4802168\\\"],\\\"created\\\":\\\"2018-10-17T00:14:20.652Z\\\",\\\"description\\\":\\\"[ROKRAT](https:\\\\/\\\\/attack.mitre.org\\\\/software\\\\/S0240) is a cloud-based remote access tool (RAT) used by [APT37](https:\\\\/\\\\/attack.mitre.org\\\\/groups\\\\/G0067). This software has been used to target victims in South Korea. [APT37](https:\\\\/\\\\/attack.mitre.org\\\\/groups\\\\/G0067) used ROKRAT during several campaigns in 2016 through 2018. (Citation: Talos ROKRAT) (Citation: Talos Group123)\\\",\\\"type\\\":\\\"malware\\\",\\\"x_mitre_platforms\\\":[\\\"Windows\\\"],\\\"labels\\\":[\\\"malware\\\"],\\\"x_mitre_aliases\\\":[\\\"ROKRAT\\\"],\\\"x_mitre_version\\\":\\\"2.1\\\",\\\"name\\\":\\\"ROKRAT\\\",\\\"modified\\\":\\\"2020-05-21T17:07:02.274Z\\\",\\\"id\\\":\\\"malware--60a9c2f0-b7a5-4e8e-959c-e1a3ff314a5f\\\",\\\"created_by_ref\\\":\\\"identity--c78cb6e5-0c4b-4611-8297-d1b8b55e40b5\\\",\\\"external_references\\\":[{\\\"source_name\\\":\\\"mitre-attack\\\",\\\"url\\\":\\\"https:\\\\/\\\\/attack.mitre.org\\\\/software\\\\/S0240\\\",\\\"external_id\\\":\\\"S0240\\\"},{\\\"source_name\\\":\\\"ROKRAT\\\",\\\"description\\\":\\\"(Citation: Talos ROKRAT 2) (Citation: Talos Group123)\\\"},{\\\"url\\\":\\\"https:\\\\/\\\\/blog.talosintelligence.com\\\\/2017\\\\/04\\\\/introducing-rokrat.html\\\",\\\"description\\\":\\\"Mercer, W., Rascagneres, P. (2017, April 03). Introducing ROKRAT. Retrieved May 21, 2018.\\\",\\\"source_name\\\":\\\"Talos ROKRAT\\\"},{\\\"url\\\":\\\"https:\\\\/\\\\/blog.talosintelligence.com\\\\/2018\\\\/01\\\\/korea-in-crosshairs.html\\\",\\\"description\\\":\\\"Mercer, W., Rascagneres, P. (2018, January 16). Korea In The Crosshairs. Retrieved May 21, 2018.\\\",\\\"source_name\\\":\\\"Talos Group123\\\"},{\\\"url\\\":\\\"https:\\\\/\\\\/blog.talosintelligence.com\\\\/2017\\\\/11\\\\/ROKRAT-Reloaded.html\\\",\\\"description\\\":\\\"Mercer, W., Rascagneres, P. (2017, November 28). ROKRAT Reloaded. Retrieved May 21, 2018.\\\",\\\"source_name\\\":\\\"Talos ROKRAT 2\\\"}]}\"";

    @JsonProperty
    @Schema(title = "Keys and data types for jsonString", example = MAP_EXAMPLE)
    private Map<String, String> jsonKeysAndDataTypes;

    @JsonProperty
    @Schema(title = "Attack info as json string", example = ATTACK_INFO_EXAMPLE)
    private String jsonString;
}
