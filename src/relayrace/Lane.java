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
public class Lane {
   private String name;

    public Lane(String name) {
        this.name = name;
    }
    
    
    
    public void beginRace(Team equipo, long timestamp) {
        System.out.println("El carril "+this.name+ " comienza a procesar al equipo"
                + equipo.getName() + " en el tiempo: " + (System.currentTimeMillis()-timestamp)/1000
        +" segundos");
        
        for (int i = 0; i < equipo.getAtletas().length; i++) {
            this.esperar(equipo.getAtletas()[i]);
            System.out.println("Termina de correr el atleta "+(i+1) +
                    "del equipo "+ equipo.getName()+
                    " -> tiempo: "+ (System.currentTimeMillis()-timestamp)/1000 +
                    "segundos");
            
            System.out.println("\n");
        }
        
        System.out.println("El carril "+this.name+" ha terminado de procesar al equipo " +
                equipo.getName()+ " en el tiempo: " + (System.currentTimeMillis()-timestamp)/1000 +
                " segundos");
        
    }
    
    private void esperar(int segundos) {
        try {
            Thread.sleep(segundos*1000);
        } catch (InterruptedException ex) {
            Thread.currentThread().interrupt();
        }
    }
    
    
}
