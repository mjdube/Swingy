package com.swingy.controller;

import com.swingy.model.artifacts.Armor;
import com.swingy.model.artifacts.Helm;
import com.swingy.model.artifacts.Weapon;
import com.swingy.model.game.GamePlayer;
import com.swingy.model.players.CharacterClass;
import com.swingy.model.players.Hero;
import com.swingy.view.choose.ChooseView;

public class Choose {
    private ChooseView chooseView;
    private GamePlayer gamePlayer;
    private Armor armor;
    private Weapon weapon;
    private Helm helm;

    public Choose(ChooseView chooseView){
        this.chooseView = chooseView;
        this.gamePlayer = GamePlayer.getInstance();
    }

    public void onSelectedBtn(String heroString){
        int split = 0;
        Hero hero;
        String splitString[] = heroString.split(" ");
        String heroDetail[][] = new String[10][];

        if ((split = splitString.length) == 10){
            for (int i = 0; i < split; i++){
                for (int j = 0; j < 2; j++) {
                    heroDetail[i] = splitString[i].split(":");
                }
            }
        }
        else
        {
            System.out.println("There's missing value...");
            System.out.println("Please create a new hero");
            chooseView.openCreateHero();
            return;
        }
        hero = CharacterClass.newPlayer(heroDetail[0][1], heroDetail[1][1]);
        hero.setLevel(Integer.parseInt(heroDetail[2][1]));
        hero.setExperience(Integer.parseInt(heroDetail[3][1]));
        hero.setAttack(Integer.parseInt(heroDetail[4][1]));
        hero.setDefense(Integer.parseInt(heroDetail[5][1]));
        hero.setHitpoints(Integer.parseInt(heroDetail[6][1]));
        if (Integer.parseInt(heroDetail[7][1]) != 0) {
            weapon = new Weapon(heroDetail[7][0], Integer.parseInt(heroDetail[7][1]));
            hero.heroWeapon(weapon);
        }
        if (Integer.parseInt(heroDetail[8][1]) != 0) {
            armor = new Armor(heroDetail[8][0], Integer.parseInt(heroDetail[7][1]));
            hero.heroArmor(armor);
        }
        if (Integer.parseInt(heroDetail[9][1]) != 0) {
            helm = new Helm(heroDetail[9][0], Integer.parseInt(heroDetail[9][1]));
            hero.heroHelm(helm);
        }
        hero.validate();
        gamePlayer.initGame(hero);
        chooseView.openGame();
    }

    public void onCreateBtn(){
        chooseView.openCreateHero();
    }
}
