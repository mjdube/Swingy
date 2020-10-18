package com.swingy.model.players;

import com.swingy.model.artifacts.Artifact;

public class Villain extends Players {
    private Artifact artifact;

    public Villain(String name, int attack, int defense, int hitpoints, Artifact artifact) {
        super(name, attack, defense, hitpoints);
        this.artifact = artifact;
    }

    public Artifact getArtifact(){
        return this.artifact;
    }
}
