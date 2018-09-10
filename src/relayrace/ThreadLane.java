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
public class ThreadLane extends Thread{
    
        private String name;

	private Team team;

	private long beginTime;

	// Constructor, getter & setter
         public ThreadLane(String name, Team team, long beginTime) {
        this.name = name;
        this.team = team;
        this.beginTime = beginTime;
        
    }

    public void run() {
        System.out.println("En el carril "+this.name+
                " ha comenzado a correr el equipo "+this.team.getName()+
                " en el tiempo: "+ (System.currentTimeMillis() - beginTime)/1000 +
                " segundos");
        System.out.println("\n");
        System.out.println("\n");
        for (int i = 0; i < this.team.getAtletas().length; i++) {
            this.esperar(team.getAtletas()[i]);
            System.out.println("Finalizo el atleta "+(i+1)+
                    " del equipo "+this.team.getName()+" ->tiempo: " +
                    (System.currentTimeMillis() - this.beginTime)/1000 +
                    " segundos");
           System.out.println("\n");
            
            
        }
        
        System.out.println("En el carril "+this.name+" termina el equipo "+
                this.team.getName() + " en el tiempo " + 
                (System.currentTimeMillis()-this.beginTime)/1000 + "segundos");
    }
    
    private void esperar(int segundos) {
        try {
            Thread.sleep(segundos*1000);
        } catch (InterruptedException ex) {
            Thread.currentThread().interrupt();
        }
    }
}