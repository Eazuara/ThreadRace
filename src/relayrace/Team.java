/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package relayrace;

/**
 *
 * @author esteb
 */
public class Team {
 private String name;
    //private ArrayList<Integer> atletas;
    private int[] atletas;

    public Team(String name, int[] atletas) {
        this.name = name;
        this.atletas = atletas;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int[] getAtletas() {
        return atletas;
    }

    public void setAtletas(int[] atletas) {
        this.atletas = atletas;
    }
    
    
    
}