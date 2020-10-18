package com.swingy.app;


import com.swingy.view.start.ConsoleView;

public class App
{
    public static void main( String[] args )
    {
        if (args.length == 1)
        {
            try {
                if (args[0].equalsIgnoreCase("Console"))
                    new ConsoleView().begin();
            } catch (NullPointerException e){
                System.out.println("ERROR: Value is missing, please try again...");
            }
        } else {
            System.out.println("Please enter 1 argument, \"Console\"");
        }
    }
}
