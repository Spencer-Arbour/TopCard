package com.spencerarbour.Lib;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

class ValueCompareTest
{
    @DisplayName("Check that proper relative values are returned")
    @ParameterizedTest(name = "{index} => value={0}, otherValue={1}, relativeValue={2}")
    @MethodSource("valueProvider")
    void testProperRelativeValuesReturned(int value, int otherValue, RelativeValue relativeValue)
    {
        assertEquals(ValueCompare.getRelativeValue(value, otherValue), relativeValue);
    }
    private static Stream<Arguments> valueProvider()
    {
        return Stream.of(
            Arguments.of(1, 1, RelativeValue.EQUAL),
            Arguments.of(2, 1, RelativeValue.GREATER),
            Arguments.of(0, 1, RelativeValue.LESS)
        );
    }
}