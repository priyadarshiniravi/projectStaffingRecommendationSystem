package com.thoughtworks.ranking;

import java.util.List;

public class WeightedSum {
    public static Double compute(List<Integer> data, List<Double> weights)
    {
        Double weightSum = 0.0;
        if (data.size() == weights.size()) {
            for (int index = 0; index < weights.size(); index++) {
                weightSum += data.get(index) * weights.get(index);
            }
        }
        return weightSum;
    }
}
