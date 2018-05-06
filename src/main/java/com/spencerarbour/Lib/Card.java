package com.spencerarbour.Lib;

public class Card
{
    private Suite _suite;
    private Rank _rank;


    public Card(Suite suite, Rank rank)
    {
        _suite = suite;
        _rank = rank;
    }

    public Suite getSuite()
    {
        return _suite;
    }

    public Rank getRank()
    {
        return _rank;
    }

    public RelativeValue compareSuiteValue(Card otherCard)
    {
        return _suite.compareValue(otherCard.getSuite());
    }

    public RelativeValue compareRankValue(Card otherCard)
    {
        return _rank.compareValue(otherCard.getRank());
    }
}
