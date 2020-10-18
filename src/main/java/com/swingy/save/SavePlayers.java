package com.swingy.save;

import com.swingy.model.players.Hero;

import java.io.*;

public class SavePlayers {
    File file = new File("Heroes.txt");

    public void saveHero(Hero hero){
        try {
            if (file.exists() == true) {
                PrintWriter in = new PrintWriter(new FileWriter(file, true));
                in.append(hero.getHeroClass() + " " + hero.getName() + "\n");
                in.close();
            } else if (file.exists() == false){
                BufferedWriter bw = new BufferedWriter(new FileWriter(file));
                bw.write(hero.getHeroClass() + " " + hero.getName() + "\n");
                bw.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
