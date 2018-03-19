package com.thoughtworks.ranking;

import org.junit.Test;

import static java.util.Arrays.asList;
import static org.assertj.core.api.Java6Assertions.assertThat;

public class WeightedSumTest {
    @Test
    public void shouldReturnZeroIfArrayLengthsAreNotEqual() throws Exception {
        assertThat(WeightedSum.compute(asList(1, 2), asList(0.3, 0.4, 0.5))).isEqualTo(0);
    }
    
    @Test
    public void shouldComputeIfArrayLengthsAreEqual() throws Exception {
        assertThat(WeightedSum.compute(asList(25, 20, 15, 30),
                asList(0.20, .15, .40	, .25)))
                .isEqualTo(21.50);
    }
}