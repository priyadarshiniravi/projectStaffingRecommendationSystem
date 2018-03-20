package com.thoughtworks.ranking;

import com.thoughtworks.models.Location;
import com.thoughtworks.models.Staff;
import com.thoughtworks.models.StaffSkillSet;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static com.thoughtworks.ranking.WeightConfig.locationWeight;
import static com.thoughtworks.ranking.WeightConfig.skillWeight;

public class DataProcessor {
    public static List<Double> getAttributeScores(Staff staff, Location location, List<String> requiredSkillSet) {
        List<Double> attributeScore = new ArrayList<>();
        attributeScore.add(staff.getLocation().equals(location) ? 1 : 0.0);
        for (String requiredSkill: requiredSkillSet) {
            Optional<StaffSkillSet> staffSkillSet = staff.getSkillSet().stream().filter(s -> s.getName().equals(requiredSkill)).findAny();
            attributeScore.add(staffSkillSet.map(StaffSkillSet::getRating).orElse((0.0)));
        }
        return attributeScore;
    }
    
    public static List<Double> getAttributeWeights(List<String> requiredSkillSet) {
        List<Double> attributeScore = new ArrayList<>();
        attributeScore.add(locationWeight);
        requiredSkillSet.forEach(s -> attributeScore.add(skillWeight));
        return attributeScore;
    }
}
