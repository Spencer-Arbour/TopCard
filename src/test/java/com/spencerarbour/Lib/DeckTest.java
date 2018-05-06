package com.spencerarbour.Lib;

import org.hamcrest.core.IsEqual;
import org.hamcrest.core.IsNot;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.instanceOf;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class DeckTest
{
    private ConsoleLayer _consoleLayer = mock(ConsoleLayer.class);
    private Deck _deck = new Deck(_consoleLayer).buildDeck();

    @DisplayName("Check that only deck cuts outside 1-52 throw error")
    @ParameterizedTest(name = "{index} => rank={0}, otherRank={1}, relativeValue={2}")
    @MethodSource("invalidCutProvider")
    public void testInvalidDeckCuts(int cut)
    {
        String warning = String.format("The point '%s' is greater then the size of the deck", cut);
        doNothing().when(_consoleLayer).printLineWithNewLine(warning);

        assertThrows(IndexOutOfBoundsException.class, () -> { _deck.cutDeck(cut); });
        verify(_consoleLayer, times(1)).printLineWithNewLine(warning);
    }

    public static Stream<Integer> invalidCutProvider()
    {
        return Stream.of(-1, 0, 53);
    }

    @DisplayName("Check that only deck cuts outside 1-52 throw error")
    @ParameterizedTest(name = "{index} => rank={0}, otherRank={1}, relativeValue={2}")
    @MethodSource("validCutProvider")
    public void testValidDeckCuts(int cut)
    {
        assertThat(_deck.cutDeck(cut), instanceOf(Card.class));
    }

    public static Stream<Integer> validCutProvider()
    {
        return Stream.of(1, 30, 52);
    }

    @Test
    public void testDeckIsReorganizedAfterShuffle()
    {
        Card cardsBeforeShuffle[] = _getOrderOfCardsFromDeck();
        _deck.shuffle();
        Card cardsAfterShuffle[] = _getOrderOfCardsFromDeck();
        assertThat(cardsBeforeShuffle, IsNot.not(IsEqual.equalTo(cardsAfterShuffle)));
    }

    private Card[] _getOrderOfCardsFromDeck()
    {
        int numberOfCards = 52;
        Card cards[] = new Card[numberOfCards];
        for(int i=1; i <= numberOfCards; i++)
        {
            cards[i-1] = _deck.cutDeck(i);
        }
        return cards;
    }
}