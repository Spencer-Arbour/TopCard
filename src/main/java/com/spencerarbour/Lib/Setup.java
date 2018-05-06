package com.spencerarbour.Lib;

public class Setup
{
    private Deck _deck;
    private ConsoleLayer _consoleLayer;

    public Setup(ConsoleLayer consoleLayer)
    {
        _consoleLayer = consoleLayer;
        _deck = new Deck(_consoleLayer).buildDeck();
    }

    public Deck getDeck()
    {
        return _deck;
    }

    public  Setup banner()
    {

        _consoleLayer.printLineWithNewLine(
            Colour.ANSI_BLUE +
            "   ______          _____            __\n" +
            "  /_  __/__  ___  / ___/__ ________/ /\n" +
            "   / / / _ \\/ _ \\/ /__/ _ `/ __/ _  / \n" +
            "  /_/  \\___/ .__/\\___/\\_,_/_/  \\_,_/  \n" +
            "          /_/                         \n" +
            Colour.ANSI_RESET
        );
        return this;
    }

    public Setup rules()
    {
        _consoleLayer.printLineWithNewLine(
                "The player who draws the highest card wins."
        );
        return this;
    }
}
