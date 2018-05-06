package com.spencerarbour.Lib;

public enum Suite
{
    CLUB(0),
    DIAMOND(1),
    HEART(2),
    SPADE(3);

    private final int _value;

    private Suite(int value)
    {
        _value = value;
    }

    public RelativeValue compareValue(Suite otherSuite)
    {
        return ValueCompare.getRelativeValue(_value, otherSuite._value);
    }
}
