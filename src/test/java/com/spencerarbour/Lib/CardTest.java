package com.spencerarbour.Lib;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;

class CardTest
{
    private Suite _suite = Suite.CLUB;
    private Rank _rank = Rank.KING;
    Card _card = new Card(_suite, _rank);

    @Test
    public void testGetSuiteFromCard()
    {
        assertEquals(_card.getSuite(), _suite);
    }

    @Test
    public void testGetRank()
    {
        assertEquals(_card.getRank(), _rank);
    }
}