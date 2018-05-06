package com.spencerarbour.Lib;

import java.util.ArrayList;
import java.util.List;

public class Hand
{
    private List<Card> _cards = new ArrayList<>();
    private HandRenderer _handRenderer;

    public Hand(HandRenderer handRenderer)
    {
        _handRenderer = handRenderer;
    }

    public Hand addCard(Card card)
    {
        _cards.add(card);
        return this;
    }

    public int getNumberOfCards()
    {
        return _cards.size();
    }

    public void renderHand()
    {
        _handRenderer.renderHand(_cards);
    }
}
