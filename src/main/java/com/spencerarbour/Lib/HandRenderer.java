package com.spencerarbour.Lib;

import java.util.ArrayList;
import java.util.List;

public class HandRenderer
{
    private ConsoleLayer _consoleLayer;

    public HandRenderer(ConsoleLayer consoleLayer)
    {
        _consoleLayer = consoleLayer;

    }
    public void renderHand(List<Card> cards)
    {
        List<String[]> cardParts = _buildHandRender(cards);

        for (int i = 0; i < cardParts.get(0).length; i++)
        {
            for (String[] card: cardParts)
            {
                _consoleLayer.printLine(card[i]);
            }
            _consoleLayer.printLineWithNewLine("");
        }

    }

    private List<String[]> _buildHandRender(List<Card> cards)
    {
        List<String[]> cardParts = new ArrayList<>();
        for(Card card: cards)
        {
            String[] cardDesign = _getCardDesign(card.getSuite());
            String cardRank = card.getRank().toString();
            String[] cardRender =
                {
                    ".--------.",
                    "|        |",
                    _getCardTopValue(cardDesign[0], cardRank),
                    _getCardSymbolValue(cardDesign[0], cardDesign[1]),
                    _getCardSymbolValue(cardDesign[0], cardDesign[2]),
                    _getCardBottomValue(cardDesign[0], cardRank),
                    "|        |",
                    "`________'"
                };
            cardParts.add(cardRender);
        }
        return cardParts;
    }

    private static String[] _getCardDesign(Suite suite)
    {
        switch (suite)
        {
            case SPADE:
                return new String[]
                    {
                        Colour.ANSI_BLUE.toString(),
                        "/\\",
                        "(__)"
                    };
            case CLUB:
                return new String[]
                    {
                        Colour.ANSI_BLUE.toString(),
                        "()",
                        "()()"
                    };
            case HEART:
                return new String[]
                    {
                        Colour.ANSI_RED.toString(),
                        "(\\/)",
                        "\\/"
                    };
            default:
                return new String[]
                    {
                        Colour.ANSI_RED.toString(),
                        "/\\",
                        "\\/"
                    };
        }
    }

    private String _getCardTopValue(String colour, String cardValue)
    {
        return "|"+ colour + String.format("%2s", cardValue) + Colour.ANSI_RESET.toString() + ".--.  |";

    }

    private String _getCardBottomValue(String colour, String cardValue)
    {
        return "|  .--."+ colour + String.format("%-2s", cardValue) + Colour.ANSI_RESET.toString() + "|";
    }

    private String _getCardSymbolValue(String colour, String symbol)
    {
        if(symbol.length() == 2)
        {
            return "|  :" + colour + symbol + Colour.ANSI_RESET.toString() + ":  |";
        }
        return "|  " + colour + symbol + Colour.ANSI_RESET.toString() + "  |";
    }
}

