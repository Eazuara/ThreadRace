/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package relayrace;

import java.util.ArrayList;
import java.util.Random;

/**
 *
 * @author esteb
 */
public class RelayRace implements Runnable {
    
    private Team equipo;
    private Lane carril;
    private long initialTime;    

public RelayRace(Team eq, Lane carr, long initial) {
    this.equipo = eq;
    this.carril = carr;
    this.initialTime = initial;
        
        
    } 
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        long init = System.currentTimeMillis();
        
        int[] atletas1 = new int[3];
        int[] atletas2 = new int[3];
        int[] atletas3 = new int[3];
        int[] atletas4 = new int[3];
        
        agregarAtletas(atletas1);
        agregarAtletas(atletas2);
        agregarAtletas(atletas3);
        agregarAtletas(atletas4);
        
        int var1 = sumar(atletas1);
        int var2 = sumar(atletas2);
        int var3 = sumar(atletas3);
        int var4 = sumar(atletas4);
                
        Team equipo1 = new Team("Equipo 1", atletas1);
        Team equipo2 = new Team("Equipo 2", atletas2);
        Team equipo3 = new Team("Equipo 3", atletas3);
        Team equipo4 = new Team("Equipo 4", atletas4);
        
        
        
        ThreadLane carril01 = new ThreadLane(" 01 ", equipo1, init);
        ThreadLane carril02 = new ThreadLane(" 02 ", equipo2, init);
        ThreadLane carril03 = new ThreadLane(" 03 ", equipo3, init);
        ThreadLane carril04 = new ThreadLane(" 04 ", equipo4, init);
        
        
        carril01.start();
        carril02.start();
        carril03.start();
        carril04.start();
        
    }

    @Override
    public void run() {
         this.carril.beginRace(this.equipo, this.initialTime);
    }
    
     public static int sumar(ArrayList<Integer> arr) {
        int suma=0;
        
        for (int i = 0; i<arr.size(); i++) {
            suma += arr.get(i);
        }
        return suma;
    }
    
    public static int sumar(int[] arr) {
        int suma=0;
        
        for (int i = 0; i<arr.length; i++) {
            suma += arr[i];
        }
        return suma;
    }
    
    private static int randomInt(int min, int max) {

		if (min >= max) {
			throw new IllegalArgumentException("max must be greater than min");
		}

		Random r = new Random();
		return r.nextInt((max - min) + 1) + min;
    }
    
    private static ArrayList<Integer> agregar(int suma, ArrayList<Integer> atletas){
        int random = 0;
        while(suma<=45) {
            atletas.add(random);
            suma = sumar(atletas);
            System.out.println(suma);
            random = randomInt(15,25);
        }
        return atletas;
    }
    
    private static int[] agregarAtletas(int[] equipo) {
        for(int i = 0; i<equipo.length; i++) {
            equipo[i] = randomInt(15,20);
            System.out.println(equipo[i]);
        }    
        return equipo;
    }
    
}
    

