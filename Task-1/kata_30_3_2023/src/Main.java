
public class Main {
    public static void main(String[] args) {
        int[][] matriz = generarMatriz();
        mostrarMatriz(matriz);
        int suma = suma(matriz);
        System.out.println("la suma de la diagonal es: " + suma);
    }

    public static int[][] generarMatriz(){
        int[][] array = new int[4][4];
        for(int i = 0; i<4; i++){
            for(int j = 0; j<4; j++){
                array[i][j] = (int)Math.floor(Math.random()*10+1);
            }
        }
        return array;
    }

    public static int suma(int[][] matriz){
        int i = 0;
        int suma = 0;
        while(i!=4){
            suma += matriz[i][i];
            i++;
        }

        return suma;
    }

    public static void mostrarMatriz(int[][] matriz){
        System.out.println("Matriz:");
        for(int i = 0; i<4; i++){
            for(int j = 0; j<4; j++){
                System.out.print(matriz[i][j]);
                System.out.print("|");
            }
            System.out.println();
        }
    }
}