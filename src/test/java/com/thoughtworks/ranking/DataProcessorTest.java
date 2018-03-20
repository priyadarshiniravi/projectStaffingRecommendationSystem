package com.thoughtworks.ranking;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.thoughtworks.models.Staff;
import org.junit.Test;

import java.io.IOException;
import java.util.List;

import static com.thoughtworks.models.Location.BANGLORE;
import static com.thoughtworks.models.Location.CHENNAI;
import static java.util.Arrays.asList;
import static org.assertj.core.api.Assertions.assertThat;

public class DataProcessorTest {
    private ObjectMapper objectMapper = new ObjectMapper();
    
    @Test
    public void shouldGetAttributeScoreForStaffWithSameLocationAndSkillSet() throws Exception {
        Staff staff = getStaff();
        
        List<Double> attributeScore = DataProcessor.getAttributeScores(staff, BANGLORE, asList("Java", "Android"));
        
        assertThat(attributeScore).containsExactly(1.0, 3.0, 4.0);
    }
    
    @Test
    public void shouldGetAttributeScoreForStaffWithDifferentLocation() throws Exception {
        Staff staff = getStaff();
        
        List<Double> attributeScore = DataProcessor.getAttributeScores(staff, CHENNAI, asList("Ruby", "Clojure"));
        
        assertThat(attributeScore).containsExactly(0.0, 0.0, 0.0);
    }
    
    @Test
    public void shouldGetWeightScore() throws Exception {
        Staff staff = getStaff();
        
        List<Double> attributeScore = DataProcessor.getAttributeWeights(asList("Ruby", "Clojure"));
        
        assertThat(attributeScore).containsExactly(10.0, 0.2, 0.2);
    }
    
    private Staff getStaff() throws IOException {
        String staffJson =
                "{\n" +
                        "    \"id\": 1,\n" +
                        "    \"location\": \"BANGLORE\",\n" +
                        "    \"name\": \"Deondre\",\n" +
                        "    \"role\": \"BA\",\n" +
                        "    \"skillSet\": [\n" +
                        "      {\n" +
                        "        \"name\": \"Android\",\n" +
                        "        \"rating\": 4\n" +
                        "      },\n" +
                        "      {\n" +
                        "        \"name\": \"Java\",\n" +
                        "        \"rating\": 3\n" +
                        "      }\n" +
                        "    ],\n" +
                        "    \"travelPreference\": {\n" +
                        "      \"domestic\": true,\n" +
                        "      \"international\": true\n" +
                        "    }\n" +
                        "  }";
        
        return objectMapper.readValue(staffJson, Staff.class);
    }
}