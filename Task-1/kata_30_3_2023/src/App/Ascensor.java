package App;

import java.util.Arrays;
import java.util.List;

public class Ascensor {
    private final int numFloors = 15;
    private int actualFloor;

    public Ascensor(){
        actualFloor = 0;
    }


    public void subir(int desiredFloor){
        System.out.printf("%n");
        System.out.println();
        if(desiredFloor < actualFloor || desiredFloor < 0){
            System.out.println("No puedes subir a un piso inferior!");
            return;
        } else if (desiredFloor == actualFloor) {
            System.out.println("Ya estas en este piso");
            return;
        }
        while(desiredFloor != actualFloor){
            System.out.printf("Estas en el piso %d, subiendo...%n", actualFloor++);
        }
        System.out.printf("Has llegado al piso %d%n",actualFloor);
    }

    public void bajar(int desiredFloor){
        System.out.printf("%n");
        if(desiredFloor > actualFloor || desiredFloor < 0){
            System.out.println("No puedes subir a un piso inferior!");
            return;
        } else if (desiredFloor == actualFloor) {
            System.out.println("Ya estas en este piso");
            return;
        }
        while(desiredFloor != actualFloor){
            System.out.printf("Estas en el piso %d, bajando...%n", actualFloor--);
        }
        System.out.printf("Has llegado al piso %d%n",actualFloor);
    }

    public void printCurrentPosition(){
        char[] floors = {'-','-','-','-','-','-','-','-','-','-','-','-','-','-','-'};
        floors[(actualFloor == 0) ? 0 : actualFloor-1] = '#';
        for(char c : floors){
            System.out.print(c);
        }
        System.out.println();
    }
}
