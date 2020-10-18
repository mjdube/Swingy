package com.swingy.controller;

import com.swingy.view.start.BeginView;

public class Start {
    private BeginView begin;

    public Start(BeginView begin){
        this.begin = begin;
    }

    public void selectHeroOpt(){
        begin.chooseHero();
    }

    public void createHeroOpt(){
        begin.createHero();
    }


}
