package com.spencerarbour.Lib;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

class SuiteTest
{
    @DisplayName("Check that proper relative values are returned when comparing ranks")
    @ParameterizedTest(name = "{index} => suite={0}, otherSuite={1}, relativeValue={2}")
    @MethodSource("suiteProvider")
    void testProperRelativeValuesReturned(Suite suite, Suite otherSuite, RelativeValue relativeValue)
    {
        assertEquals(suite.compareValue(otherSuite), relativeValue);
    }

    private static Stream<Arguments> suiteProvider()
    {
        return Stream.of(
            Arguments.of(Suite.CLUB, Suite.CLUB, RelativeValue.EQUAL),
            Arguments.of(Suite.CLUB, Suite.DIAMOND, RelativeValue.LESS),
            Arguments.of(Suite.CLUB, Suite.HEART, RelativeValue.LESS),
            Arguments.of(Suite.CLUB, Suite.SPADE, RelativeValue.LESS),
            Arguments.of(Suite.DIAMOND, Suite.CLUB, RelativeValue.GREATER),
            Arguments.of(Suite.DIAMOND, Suite.DIAMOND, RelativeValue.EQUAL),
            Arguments.of(Suite.DIAMOND, Suite.HEART, RelativeValue.LESS),
            Arguments.of(Suite.DIAMOND, Suite.SPADE, RelativeValue.LESS),
            Arguments.of(Suite.HEART, Suite.CLUB, RelativeValue.GREATER),
            Arguments.of(Suite.HEART, Suite.DIAMOND, RelativeValue.GREATER),
            Arguments.of(Suite.HEART, Suite.HEART, RelativeValue.EQUAL),
            Arguments.of(Suite.HEART, Suite.SPADE, RelativeValue.LESS),
            Arguments.of(Suite.SPADE, Suite.CLUB, RelativeValue.GREATER),
            Arguments.of(Suite.SPADE, Suite.DIAMOND, RelativeValue.GREATER),
            Arguments.of(Suite.SPADE, Suite.HEART, RelativeValue.GREATER),
            Arguments.of(Suite.SPADE, Suite.SPADE, RelativeValue.EQUAL)
        );
    }
}