package com.spencerarbour.Lib;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

class WinGetterTest
{
    private Card _userCard = mock(Card.class);
    private Card _compCard = mock(Card.class);

    @Test
    public void testCompWins_byRank()
    {
        when(_userCard.compareRankValue(_compCard)).thenReturn(RelativeValue.LESS);
        assertEquals(WinGetter.findWinner(_userCard, _compCard), WinResult.COMP_WIN);
    }

    @Test
    public void testUserWins_byRank()
    {
        when(_userCard.compareRankValue(_compCard)).thenReturn(RelativeValue.GREATER);
        assertEquals(WinGetter.findWinner(_userCard, _compCard), WinResult.USER_WIN);
    }

    @Test
    public void testCompWins_bySuite()
    {
        when(_userCard.compareRankValue(_compCard)).thenReturn(RelativeValue.EQUAL);
        when(_userCard.compareSuiteValue(_compCard)).thenReturn(RelativeValue.LESS);
        assertEquals(WinGetter.findWinner(_userCard, _compCard), WinResult.COMP_WIN);
    }

    @Test
    public void testUserWins_bySuite()
    {
        when(_userCard.compareRankValue(_compCard)).thenReturn(RelativeValue.EQUAL);
        when(_userCard.compareSuiteValue(_compCard)).thenReturn(RelativeValue.GREATER);
        assertEquals(WinGetter.findWinner(_userCard, _compCard), WinResult.USER_WIN);
    }

    @Test
    public void testTie()
    {
        when(_userCard.compareRankValue(_compCard)).thenReturn(RelativeValue.EQUAL);
        when(_userCard.compareSuiteValue(_compCard)).thenReturn(RelativeValue.EQUAL);
        assertEquals(WinGetter.findWinner(_userCard, _compCard), WinResult.TIE);
    }
}