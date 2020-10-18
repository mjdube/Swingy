package com.swingy.view.start;

import com.swingy.controller.Start;
import com.swingy.view.choose.ChooseConsole;
import com.swingy.view.createhero.CreateHeroConsole;

import java.util.Scanner;

public class ConsoleView implements BeginView {
    private Start start;

    @Override
    public void begin() {
        start = new Start(this);

        System.out.println("CREATE => Create a new hero...");
        System.out.println("CHOOSE => Choose and select an existing hero...");
        System.out.println("EXIT => Exit the game");
        System.out.println("Commands to type: create, choose or exit");
        Scanner in = new Scanner(System.in);

        while (in.hasNext()){
            String option = in.nextLine();
            if (option.equalsIgnoreCase("create")){
                start.createHeroOpt();
                break;
            }
            else if (option.equalsIgnoreCase("choose")){
                start.selectHeroOpt();
                break;
            }
            else if (option.equalsIgnoreCase("exit")){
                System.out.println("Bye...");
                break;
            }
            else {
                System.out.println("Commands to type: create, choose or exit");
            }
        }
    }

    @Override
    public void createHero() {
        new CreateHeroConsole().start();
    }

    @Override
    public void chooseHero() {
        new ChooseConsole().start();
    }
}
