package com.spencerarbour;

import com.spencerarbour.Lib.*;

import java.util.Random;

public class TopCard
{
    public static void main( String[] args )
    {
        String usersCut;
        Card userCard;
        Card computerCard;
        ConsoleLayer _consoleLayer = new ConsoleLayer();
        UserInput userInput = new UserInput(_consoleLayer);
        HandRenderer handRenderer = new HandRenderer(_consoleLayer);

        Deck deck = new Setup(new ConsoleLayer()).banner().rules().getDeck();
        while(true)
        {
            try
            {
                usersCut = userInput.getUserInput();
                if(usersCut.equals("q"))
                {
                    break;
                }
                else
                {
                    userCard = deck.cutDeck(Integer.parseInt(usersCut));
                    computerCard = deck.cutDeck(new Random().nextInt(52) + 1);
                    new Hand(handRenderer).addCard(userCard).addCard(computerCard).renderHand();
                    _consoleLayer.printLineWithNewLine(
                            WinGetter.findWinner(userCard, computerCard)
                    );
                    deck.shuffle();
                }
            } catch (IllegalArgumentException | IndexOutOfBoundsException e){
                System.out.println(e.getMessage());
            }
        }
        _consoleLayer.printLineWithNewLine("Thanks for playing :)");
    }
}
