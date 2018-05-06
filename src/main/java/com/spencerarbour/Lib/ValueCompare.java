package com.spencerarbour.Lib;

public class ValueCompare
{
    public static RelativeValue getRelativeValue(int value, int otherValue)
    {
        if(value > otherValue)
        {
            return RelativeValue.GREATER;
        }

        else if (value == otherValue)
        {
            return RelativeValue.EQUAL;
        }
        else
        {
            return RelativeValue.LESS;
        }
    }
}
