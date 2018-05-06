package com.spencerarbour.Lib;

import com.spencerarbour.Lib.Hand;
import com.spencerarbour.Lib.HandRenderer;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Matchers.anyList;
import static org.mockito.Mockito.*;

class HandTest
{
    private Card _card = mock(Card.class);
    private HandRenderer _handRenderer = mock(HandRenderer.class);

    @DisplayName("Check that only deck cuts outside 1-52 throw error")
    @ParameterizedTest(name = "{index} => rank={0}, otherRank={1}, relativeValue={2}")
    @MethodSource("numberOfCardsProvider")
    public void testHandIsProperSize_afterCardIsAdded(int numberOfCards)
    {
        Hand hand = new Hand(_handRenderer);
        for(int i = 0; i < numberOfCards; i++)
        {
            hand.addCard(_card);
        }
        assertEquals(hand.getNumberOfCards(), numberOfCards);
    }

    public static Stream<Integer> numberOfCardsProvider()
    {
        return Stream.of(1, 53, 0);
    }

    @Test
    public void testHandRendererUsed()
    {
        doNothing().when(_handRenderer).renderHand(anyList());
        new Hand(_handRenderer).renderHand();

        verify(_handRenderer, times(1)).renderHand(anyList());
    }
}