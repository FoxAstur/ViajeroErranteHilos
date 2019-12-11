
package modelo;

//clase para guardar la informacion de las estadisticas de los hilos
public class Info {
    
 
    
   private int contadorUp;
   private int contadorDown;
   private int contadorLeft;
   private int contadorRight;
   private int contadorSleep;
   private String nombre;

    public Info() {
    }
   

    public Info(int contadorUp, int contadorDown, int contadorLeft, int contadorRight, int contadorSleep,String nombre) {
        this.contadorUp = contadorUp;
        this.contadorDown = contadorDown;
        this.contadorLeft = contadorLeft;
        this.contadorRight = contadorRight;
        this.contadorSleep = contadorSleep;
        this.nombre = nombre;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    @Override
    public String toString() {
        return "Info{" + "contadorUp=" + contadorUp + ", contadorDown=" + contadorDown + ", contadorLeft=" + contadorLeft + ", contadorRight=" + contadorRight + ", contadorSleep=" + contadorSleep + ", nombre=" + nombre + '}';
    }

   


    public int getContadorUp() {
        return contadorUp;
    }

    public void setContadorUp(int contadorUp) {
        this.contadorUp = contadorUp;
    }

    public int getContadorDown() {
        return contadorDown;
    }

    public void setContadorDown(int contadorDown) {
        this.contadorDown = contadorDown;
    }

    public int getContadorLeft() {
        return contadorLeft;
    }

    public void setContadorLeft(int contadorLeft) {
        this.contadorLeft = contadorLeft;
    }

    public int getContadorRight() {
        return contadorRight;
    }

    public void setContadorRight(int contadorRight) {
        this.contadorRight = contadorRight;
    }

    public int getContadorSleep() {
        return contadorSleep;
    }

    public void setContadorSleep(int contadorSleep) {
        this.contadorSleep = contadorSleep;
    }


    
}
