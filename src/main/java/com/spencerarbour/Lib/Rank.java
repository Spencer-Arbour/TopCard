package com.spencerarbour.Lib;

public enum Rank
{
    TWO(2, "02"),
    THREE(3, "03"),
    FOUR(4, "04"),
    FIVE(5, "05"),
    SIX(6, "06"),
    SEVEN(7, "07"),
    EIGHT(8, "08"),
    NINE(9, "09"),
    TEN(10, "10"),
    JACK(11, "J"),
    QUEEN(12, "Q"),
    KING(13, "K"),
    ACE(14, "A");

    private final int _value;
    private final String _rank;

    private Rank(int value, String rank)
    {
        _value = value;
        _rank = rank;
    }

    public RelativeValue compareValue(Rank otherRank)
    {
        return ValueCompare.getRelativeValue(_value, otherRank._value);
    }

    @Override
    public String toString()
    {
        return _rank;
    }
}
