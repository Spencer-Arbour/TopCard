package com.spencerarbour.Lib;

import java.util.Scanner;

public class ConsoleLayer
{
    //Validation will be handled elsewhere. Not unit tested
    public String getInput()
    {
        Scanner scanner = new Scanner(System.in);
        return scanner.next();
    }

    public void printLineWithNewLine(Object printable)
    {
        System.out.println(printable);
    }

    public void printLine(Object printable)
    {
        System.out.print(printable);
    }
}
