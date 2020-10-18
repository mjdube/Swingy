package com.swingy.controller;

import com.swingy.model.game.GamePlayer;
import com.swingy.model.players.CharacterClass;
import com.swingy.model.players.Hero;
import com.swingy.view.createhero.CreateHeroView;

public class Create {
    private CreateHeroView create;
    private GamePlayer gamePlayer;

    public Create(CreateHeroView create){
        this.create = create;
        this.gamePlayer = GamePlayer.getInstance();
    }

    public void createOption(String heroName, String heroClass){
        Hero hero;
        hero = CharacterClass.newPlayer(heroName, heroClass);
        gamePlayer.initGame(hero);
        create.openGame();
    }

}
