package com.spencerarbour.Lib;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class UserInputTest
{
    private ConsoleLayer _consoleLayer = mock(ConsoleLayer.class);
    private String _player_move_instructions = "Choose '1-52' to cut the deck or 'q' to quit the game: ";

    @DisplayName("Check proper user inputs are returned")
    @ParameterizedTest(name = "{index} => userInput={0}")
    @MethodSource("userInputProvider")
    public void testIfUserProvidesValidInput_InputReturned(String userInput)
    {
        doNothing().when(_consoleLayer).printLine(_player_move_instructions);
        when(_consoleLayer.getInput()).thenReturn(userInput);

        assertEquals(new UserInput(_consoleLayer).getUserInput(), userInput);
        verify(_consoleLayer, times(1)).printLine(anyString());
    }

    public static Stream<String> userInputProvider()
    {
        return Stream.of("q", "01", "1", "09", "9", "32", "50", "52");
    }

    @DisplayName("Check proper user inputs are returned")
    @ParameterizedTest(name = "{index} => userInput={0}")
    @MethodSource("invalidUserInputProvider")
    public void testIfUserProvidesInvalidInput_ThrowError(String userInput)
    {
        doNothing().when(_consoleLayer).printLine(_player_move_instructions);
        when(_consoleLayer.getInput()).thenReturn(userInput);

        assertThrows(IllegalArgumentException.class, () ->
        {
            new UserInput(_consoleLayer).getUserInput();
        });
        verify(_consoleLayer, times(1)).printLine(anyString());

    }

    public static Stream<String> invalidUserInputProvider()
    {
        return Stream.of("qq", "p", "00", "0", "53");
    }

}