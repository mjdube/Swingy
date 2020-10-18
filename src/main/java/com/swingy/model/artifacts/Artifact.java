package com.swingy.model.artifacts;

public abstract class Artifact {
    private int points = 0;
    protected String name = "";

    public Artifact(String name, int points){
        this.name = name;
        this.points = points;
    }

    public int getPoints(){
        return this.points;
    }

    public String getName() {
        if (this.name == "")
            return "nothing";
        return name;
    }

    public String artifactInfo(){
        return name + ": " + points ;
    }
}
