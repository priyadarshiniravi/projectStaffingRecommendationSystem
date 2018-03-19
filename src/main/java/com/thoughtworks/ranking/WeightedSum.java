package com.thoughtworks.ranking;

import java.util.List;

public class WeightedSum {
    
    private static final double DEFAULT_WEIGHTED_SUM = 0.0;
    
    public static Double compute(List<Integer> data, List<Double> weights)
    {
        Double weightSum = DEFAULT_WEIGHTED_SUM;
        if (data.size() == weights.size()) {
            for (int index = 0; index < weights.size(); index++) {
                weightSum += data.get(index) * weights.get(index);
            }
        }
        return weightSum;
    }
}
