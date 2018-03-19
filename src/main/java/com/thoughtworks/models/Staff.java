package com.thoughtworks.models;

import lombok.Getter;

import java.util.List;

@Getter
public class Staff {
    Long id;
    Location location;
    String name;
    Role role;
    List<StaffSkillSet> skillSet;
    TravelPreference travelPreference;
}
