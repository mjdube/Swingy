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
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPoints(int points) {
        this.points = points;
    }

    public String artifactInfo(){
        return name + ": " + points ;
    }
}
