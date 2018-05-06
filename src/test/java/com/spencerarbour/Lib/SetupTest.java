package com.spencerarbour.Lib;

import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.instanceOf;
import static org.mockito.Matchers.anyString;
import static org.mockito.Mockito.*;

class SetupTest
{
    private ConsoleLayer _consoleLayer = mock(ConsoleLayer.class);
    private Setup _setup;

    @Test
    public void testSetupIsFluentInterface()
    {
        doNothing().when(_consoleLayer).printLineWithNewLine(anyString());
        Setup fluentSetup = _setup = new Setup(_consoleLayer)
               .banner()
               .rules();

        verify(_consoleLayer, times(2)).printLineWithNewLine(anyString());
        assertThat(fluentSetup, instanceOf(Setup.class));
    }

    @Test
    public void testSetupCreatesDeck()
    {
        _setup = new Setup(_consoleLayer);
        assertThat(_setup.getDeck(), instanceOf(Deck.class));
    }
}