package com.spencerarbour.Lib;

public enum Colour
{
    ANSI_BLUE("\u001B[34m"),
    ANSI_RED("\u001B[31m"),
    ANSI_RESET("\u001B[0m");

    private String _colour;

    private Colour(String colour)
    {
        _colour = colour;
    }

    @Override
    public String toString()
    {
        return _colour;
    }
}
