package com.swingy.view.choose;

import com.swingy.controller.Choose;
import com.swingy.view.createhero.CreateHeroConsole;
import com.swingy.view.gameplay.GameConsole;

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class ChooseConsole implements ChooseView {
    private Choose chooseController;
    Scanner in;

    private void getInput() {
        in = new Scanner(System.in);

        System.out.println();
        System.out.println("(1) - CREATE - to create hero");
        System.out.println("(2) - CHOOSE - to select previous hero");
        System.out.println("Commands ( (1) - CREATE, (2) - CHOOSE)");

        while (in.hasNext()) {
            String option = in.nextLine();

            if (option.equalsIgnoreCase("1")) {
                new CreateHeroConsole().start();
                break;
            } else if (option.equalsIgnoreCase("2")) {
                if (prevHeroes().size() > 0) {
                    System.out.println("Please choose previous to use...");
                    int i = 0;
                    for (String hero : prevHeroes()) {
                        System.out.println("["+ i++ +"]" + " " + hero);
                    }
                    chosenHero(prevHeroes());
                    break;
                } else {
                    System.out.println("Please create a Hero");
                    new CreateHeroConsole().start();
                    break;
                }
            } else {
                System.out.println("Unknown command");
            }
        }
    }

    private ArrayList<String> prevHeroes() {
        int i = 0;
        String text = "";
        ArrayList<String> prevHeroes = new ArrayList<>();
        try {
            File file = new File("Heroes.txt");
            BufferedReader br = new BufferedReader(new FileReader(file));
            while ((text = br.readLine()) != null)
                prevHeroes.add(text);
        } catch (FileNotFoundException e) {
            System.out.println("No file Heroes found");
        } catch (IOException e) {
            System.out.println("No file to read");
        }
        return prevHeroes;
    }


    @Override
    public void start() {
        chooseController = new Choose(this);
        getInput();
    }

    @Override
    public void updateInfo(String info) {
        System.out.println(info);
    }

    @Override
    public void showErrorMessage(String message) {
        System.out.println("Error" + message);
        getInput();
    }

    @Override
    public void openGame() {
        new GameConsole().start();
    }

    @Override
    public void openCreateHero() {
        new CreateHeroConsole().start();
    }

    public void chosenHero(ArrayList<String> prevHeroes){
        in = new Scanner(System.in);
        try {
            while (in.hasNext()){
                String option = in.nextLine();
                if (isValidStringNumber(option) == true) {
                    String heroDetail = prevHeroes().get(Integer.parseInt(option));
                    System.out.println(heroDetail);
                    chooseController.onSelectedBtn(heroDetail);
                    break;
                }
                else {
                    System.out.println("Please enter a number...");
                }
            }
        } catch (IndexOutOfBoundsException e){
            System.out.println("Please try again and choose available option...");
        }
    }

    private boolean isValidStringNumber(String stringNumber)
    {
        if(stringNumber.isEmpty())
            return false;
        stringNumber = stringNumber.replaceAll(" ", "");
        char charNumber[] = stringNumber.toCharArray();
        for(int i =0 ; i<charNumber.length ;i++)
        {
            if(!Character.isDigit(charNumber[i]))
                return false;
        }
        return true;
    }
}
