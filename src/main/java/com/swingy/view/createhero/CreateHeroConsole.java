package com.swingy.view.createhero;

import com.swingy.controller.Create;
import com.swingy.view.gameplay.GameConsole;

import java.util.Scanner;

public class CreateHeroConsole implements CreateHeroView {
    private Create createController;

    @Override
    public void start() {
        createController = new Create(this);
        getUserInput();
    }

    @Override
    public void getUserInput() {
        String name = "";
        String heroClass = "";
        Scanner in = new Scanner(System.in);

        System.out.println("Please enter your name...");
        name = in.nextLine();

        System.out.println("Classes: \t attack \t defense \t hitpoints\n" +
                "Mastermind:  \t 40 \t         20 \t         100\n" +
                "Blaze:   \t 30 \t         15 \t         90\n" +
                "Quicksand:   \t 25 \t         25 \t         90\n" +
                "Slingshot:  \t 40 \t         30 \t         120\n" +
                "Apex:     \t 45 \t         10 \t         80\n" +
                "Titan:   \t 25 \t         20 \t         110\n" +
                "Please enter your favourite hero name : ");
        heroClass = in.nextLine();

        System.out.println("Please type in \"continue\" to processed game or type in \"leave\" to abort game");
        while (in.hasNext()){
            String option = in.nextLine();
            if (option.equalsIgnoreCase("continue")){
                createController.createOption(name, heroClass);
                break;
            } else if (option.equalsIgnoreCase("leave")) {
                System.out.println("See you later, bye...");
            }
            else
                System.out.println("Unknown command. Please enter \"continue\" or \"leave\"...");
        }
    }

    @Override
    public void showErrorMessage(String message) {
        System.out.println("ERROR: " + message);
    }

    @Override
    public void openGame() {
        new GameConsole().start();
    }
}
