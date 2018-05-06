package com.spencerarbour.Lib;

public enum WinResult
{
    USER_WIN ("!!You Win!!"),
    COMP_WIN("!!The Computer Wins!!"),
    TIE("!!It's a Tie!!");

    private String _result;
    private WinResult(String result)
    {
        _result = result;
    }

    @Override
    public String toString()
    {
        return _result;
    }
}
