package com.swingy.controller;

import com.swingy.model.game.GamePlayer;
import com.swingy.model.players.CharacterClass;
import com.swingy.model.players.Hero;
import com.swingy.view.createhero.CreateHeroView;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;
import java.util.Set;

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
        hero.validate();
        gamePlayer.initGame(hero);
        create.openGame();
    }



}
