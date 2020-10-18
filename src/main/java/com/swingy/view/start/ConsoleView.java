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

        System.out.println("(1) - CREATE - to create hero");
        System.out.println("(2) - CHOOSE - to select already created hero");
        Scanner in = new Scanner(System.in);

        while (in.hasNext()){
            String option = in.nextLine();
            if (option.equalsIgnoreCase("1")){
                start.createHeroOpt();
                break;
            }
            else if (option.equalsIgnoreCase("2")){
                start.selectHeroOpt();
                break;
            }
            else {
                System.out.println("Please enter commands (1) - Create or (2) - Choose");
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
