package com.spencerarbour.Lib;

public class WinGetter
{
    public static WinResult findWinner(Card userCard, Card compCard)
    {
        if(userCard.compareRankValue(compCard).equals(RelativeValue.EQUAL))
        {
            if(userCard.compareSuiteValue(compCard).equals(RelativeValue.EQUAL))
            {
                return WinResult.TIE;
            }
            else if(userCard.compareSuiteValue(compCard).equals(RelativeValue.GREATER))
            {
                return WinResult.USER_WIN;
            }
            else
            {
                return WinResult.COMP_WIN;
            }
        }
        else if(userCard.compareRankValue(compCard).equals(RelativeValue.GREATER))
        {
            return WinResult.USER_WIN;
        }
        else
        {
            return WinResult.COMP_WIN ;
        }
    }
}
