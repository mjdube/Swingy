package com.swingy.view.gameplay;

import com.swingy.controller.Game;
import com.swingy.model.game.GamePlayer;
import com.swingy.model.players.Hero;

import java.io.*;
import java.util.Scanner;

public class GameConsole implements GamePlay {
    private Game gameController;
    private Scanner in;

    @Override
    public void start() {
        gameController = new Game(this);
        gameController.onStart();
    }

    @Override
    public void update(GamePlayer game) {
        System.out.println("----------INFO----------");
        System.out.println(game.getHero().heroInfo());
        System.out.println("------------------------");
        getUserInput();
    }

    private void getUserInput() {
        in = new Scanner(System.in);

        System.out.println("NORTH, EAST, SOUTH, WEST - to move to this direction");
        System.out.println("Commands (NORTH, EAST, SOUTH, WEST) or (Exit to exit the game):");

        while (in.hasNext()) {
            String option = in.nextLine();

            if (option.equalsIgnoreCase("north") || option.equalsIgnoreCase("east") || option.equalsIgnoreCase("south") || option.equalsIgnoreCase("west")) {
                gameController.onMove(option);
                break;
            } else if (option.equalsIgnoreCase("exit")){
                System.out.println("Nothing will be saved on this current level, bye...");
                break;
            } else {
                System.out.println("Commands to type: NORTH, SOUTH, WEST OR EAST");
            }
        }
    }

    @Override
    public void gameFinished(Hero hero) {
        System.out.println("See you next time Player");
        savePlayers(hero);
    }

    @Override
    public void showMessage(String message) {
        System.out.println(message);
    }

    @Override
    public void getVillainCollisionInput() {
        in = new Scanner(System.in);

        System.out.println();
        System.out.println("You moved to position occupied by villain");
        System.out.println("FIGHT => to fight with villain");
        System.out.println("RUN => to run, 50% chance to move to the previous position");
        System.out.println("Commands (FIGHT, RUN):");

        while (in.hasNext()) {
            String option = in.nextLine();
            if (option.equalsIgnoreCase("fight")) {
                gameController.onFight();
                break;
            } else if (option.equalsIgnoreCase("run")) {
                gameController.onRun();
                break;
            } else {
                System.out.println("Unknown command");
            }
        }
    }

    @Override
    public boolean replaceArtifact(String replaceMessage) {
        in = new Scanner(System.in);

        System.out.println();
        System.out.println("Would you like to replace " + replaceMessage + "?");
        System.out.println("LEAVE => to leave your artifact");
        System.out.println("REPLACE => to replace by new artifact");
        System.out.println("Commands (LEAVE, REPLACE)");

        while (in.hasNext()) {
            String option = in.nextLine();

            if (option.equalsIgnoreCase("leave")) {
                return false;
            } else if (option.equalsIgnoreCase("replace")) {
                return true;
            } else {
                System.out.println("Unknown command");
            }
        }
        return false;
    }

    public void savePlayers(Hero hero){
        String heroDetails = hero.heroInfo().replace("\n", " ");
        File file = new File("Heroes.txt");
        try {
            if (file.exists() == true) {
                PrintWriter in = new PrintWriter(new FileWriter(file, true));
                in.append(heroDetails + "\n");
                in.close();
            } else if (file.exists() == false){
                BufferedWriter bw = new BufferedWriter(new FileWriter(file));
                bw.write(heroDetails + "\n");
                bw.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}