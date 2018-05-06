package com.spencerarbour.Lib;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;

class CardTest
{
    private Suite _suite = Suite.CLUB;
    private Rank _rank = Rank.KING;

    private Suite _suiteMock = mock(Suite.class);
    private Rank _rankMock = mock(Rank.class);

    @Test
    public void testGetSuiteFromCard()
    {
        Card _card = new Card(_suite, _rank);
        assertEquals(_card.getSuite(), _suite);
    }
}