package principal;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import modelo.Info;
import modelo.ViajeroErrante;

public class Principal {
    
                   
    private static final int numeroDeViajeros = 20;

    public static void main(String[] args) {

        //ViajeroErrante viajero = new ViajeroErrante();

        //array list para poder hace rlos joins
        List<ViajeroErrante> listViajeros = new ArrayList<>();
        
        ViajeroErrante viajero =  null;
        // viajero.movimiento();
      
       
        
            for(int i = 0; i < numeroDeViajeros; i++){
            
            viajero = new ViajeroErrante(); 
            viajero.start();
            viajero.setName("Viajero" +i);
            System.out.println("Ha empezado el viajero"+ viajero);
            listViajeros.add(viajero);
            
            }
            

            //unir los hilos
            for(ViajeroErrante v : listViajeros){
               
            try {
                
                v.join();
                System.out.println("Ha temrinado el viajero "+v);
            } catch (InterruptedException ex) {
                Logger.getLogger(Principal.class.getName()).log(Level.SEVERE, null, ex);
            }
                
            }
        
            //mostrar las estadisticas
            viajero.estadisticas();
    }

}
