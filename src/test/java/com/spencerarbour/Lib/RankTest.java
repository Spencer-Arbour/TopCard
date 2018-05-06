package com.spencerarbour.Lib;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

class RankTest
{
    @DisplayName("Check that proper relative values are returned when comparing ranks")
    @ParameterizedTest(name = "{index} => rank={0}, otherRank={1}, relativeValue={2}")
    @MethodSource("rankProvider")
    void testProperRelativeValuesReturned(Rank rank, Rank otherRank, RelativeValue relativeValue)
    {
        assertEquals(rank.compareValue(otherRank), relativeValue);
    }

    private static Stream<Arguments> rankProvider()
    {
        return Stream.of(
            Arguments.of(Rank.TWO, Rank.TWO, RelativeValue.EQUAL),
            Arguments.of(Rank.TWO, Rank.THREE, RelativeValue.LESS),
            Arguments.of(Rank.THREE, Rank.FOUR, RelativeValue.LESS),
            Arguments.of(Rank.FOUR, Rank.FIVE, RelativeValue.LESS),
            Arguments.of(Rank.FIVE, Rank.SIX, RelativeValue.LESS),
            Arguments.of(Rank.SIX, Rank.SEVEN, RelativeValue.LESS),
            Arguments.of(Rank.SEVEN, Rank.EIGHT, RelativeValue.LESS),
            Arguments.of(Rank.EIGHT, Rank.NINE, RelativeValue.LESS),
            Arguments.of(Rank.NINE, Rank.TEN, RelativeValue.LESS),
            Arguments.of(Rank.TEN, Rank.JACK, RelativeValue.LESS),
            Arguments.of(Rank.JACK, Rank.QUEEN, RelativeValue.LESS),
            Arguments.of(Rank.QUEEN, Rank.KING, RelativeValue.LESS),
            Arguments.of(Rank.KING, Rank.ACE, RelativeValue.LESS),
            Arguments.of(Rank.ACE, Rank.KING, RelativeValue.GREATER)
        );
    }
}