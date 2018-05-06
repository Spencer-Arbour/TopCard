package com.spencerarbour.Lib;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Deck
{
    private List<Card> _cards = new ArrayList<>();
    private ConsoleLayer _consoleLayer;

    public Deck(ConsoleLayer consoleLayer)
    {
        _consoleLayer = consoleLayer;
    }

    public Deck buildDeck()
    {
        for (Suite suite: Suite.values())
        {
            for (Rank rank: Rank.values())
            {
                _cards.add(new Card(suite, rank));
            }
        }
        this.shuffle();
        return this;
    }

    public void shuffle()
    {
        Collections.shuffle(_cards);
    }

    public Card cutDeck(int cutPoint) throws IndexOutOfBoundsException
    {
        try
        {
            return _cards.get(cutPoint-1);
        } catch (IndexOutOfBoundsException e) {
            _consoleLayer.printLineWithNewLine(
                    String.format("The point '%s' is greater then the size of the deck", cutPoint)
            );
            throw e;
        }
    }
}
