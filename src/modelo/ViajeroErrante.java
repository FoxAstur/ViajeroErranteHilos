package modelo;

import static java.lang.Thread.sleep;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;
import modelo.Estados;

public class ViajeroErrante extends Thread {

    List<Info> informaciones = new ArrayList<>();
    private boolean hasGanado = false;
    private int fila;
    private int columna;
    //indicar la casilla Inicial
    private final int posicionInicalFilas = 7;
    private final int posicionIncialColumnas = 7;
    //indicar la casilla de salida
    private final int posicionSalidaFilas = 0;
    private final int posicionSalidaColumnas = 3;
    //uso del enum
    private Estados muevete;
    private int numeroDeViajeros;
    //Contadores
    private static int contadorLeft;
    private static int contadorRight;
    private static int contadorDown;
    private static int contadorUp;
    private static int contadorSleep;
    private static int identificadorViajeros;

    Info estadisticas = null;

    public int getNumeroDeViajeros() {
        return numeroDeViajeros;
    }

    public void setNumeroDeViajeros(int numeroDeViajeros) {
        this.numeroDeViajeros = numeroDeViajeros;
    }

    @Override
    public void run() {

       
        movimiento();
        

        
    }

    //mostrar las estadisticas
    public void estadisticas() {

        for (Info f : informaciones) {
            System.out.println(f);
        }

    }

    
    //Funcionamiento del viajero Errante.
    public void movimiento() {

        Random lanzamiento = new Random(System.currentTimeMillis());

        fila = posicionInicalFilas;
        columna = posicionIncialColumnas;

        while (!hasGanado) {

            int resultado = lanzamiento.nextInt(4);

            switch (resultado) {
                case 0:
                    muevete = muevete.up;
                    contadorUp++;

                    break;
                case 1:
                    muevete = muevete.right;
                    contadorRight++;
                    
                    break;
                case 2:
                    muevete = muevete.down;
                    contadorDown++;
                    
                    break;
                case 3:
                    muevete = muevete.left;
                    contadorLeft++;

                    break;
                case 4:
                    muevete = muevete.sleep;
                    contadorSleep++;
                    
                    break;
                default:
                    break;
            }

            switch (muevete) {

                case up:
                   
                    if (fila == 0) {

                        if (fila == posicionSalidaFilas && columna == posicionSalidaColumnas) {

                            System.out.println("Has Salido");
                            hasGanado = true;

                        } else {

                            System.out.println("Limite por arriba");

                        }
                    } else {

                        fila = fila - 1;
                    }
                    break;

                case right:
                    
                    if (columna == 7) {

                        System.out.println("Limite por la derecha");

                    } else {

                        columna = columna + 1;
                    }

                    break;

                case down:
                   
                    if (fila == 7) {

                        System.out.println("Limite por abajo");

                    } else {

                        fila = fila + 1;

                    }

                    break;

                case left:
                    
                    if (columna == 0) {

                        System.out.println("Limite por la izquierda");

                    } else {

                        columna = columna - 1;

                        break;

                    }
                case sleep:
                    
                     {
                        try {
                            sleep(1000);
                            System.out.println("Vamos a descansar");
                        } catch (InterruptedException ex) {
                            Logger.getLogger(ViajeroErrante.class.getName()).log(Level.SEVERE, null, ex);
                        }
                    }
                    break;

            }

        }
        
        estadisticas = new Info();
        estadisticas.setContadorUp(contadorUp);
        estadisticas.setContadorLeft(contadorLeft);
        estadisticas.setContadorRight(contadorRight);
        estadisticas.setContadorDown(contadorDown);
        estadisticas.setContadorSleep(contadorSleep);
        estadisticas.setNombre("Viajero " + identificadorViajeros);
        informaciones.add(estadisticas);

    }

}
