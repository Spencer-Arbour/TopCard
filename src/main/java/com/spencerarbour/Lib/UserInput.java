package com.spencerarbour.Lib;


public class UserInput
{
    private ConsoleLayer _consoleLayer;

    public UserInput(ConsoleLayer consoleLayer)
    {
        this._consoleLayer = consoleLayer;
    }

    public String getUserInput() throws IllegalArgumentException
    {
        _consoleLayer.printLine("Choose '1-52' to cut the deck or 'q' to quit the game: ");
        String input = _consoleLayer.getInput();

        if(input.toLowerCase().contentEquals("q") || input.matches("^0?[1-9]|[1-4][0-9]|5[0-2]"))
        {
            return input;
        }

        throw new IllegalArgumentException(String.format("The argument provided '%s' is invalid", input));
    }
}
