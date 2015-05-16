package modelo;

import java.util.Random;

public class GeneradorDeClave {

    private GeneradorDeClave() {
    }

    public static GeneradorDeClave obtenerInstancia() {
        if (instancia == null) {
            instancia = new GeneradorDeClave();
        }
        return instancia;
    }

    public String GenerarClave() {
        Random random = new Random();
        int num = random.nextInt(99);
        while (num < 9) {
            num = random.nextInt(99);
        }
        return animales[random.nextInt(animales.length)] + colores[random.nextInt(colores.length)] + num;
    }

    private static GeneradorDeClave instancia = null;
    private static String[] colores = {"Amarillo", "Azul", "Morado", "Verde",
        "Negro", "Anaranjado", "Rojo", "Cafe", "Amarillo", "Celeste"};
    private static String[] animales = {"Perro", "Gato", "Leon", "Tigre", "Mono",
        "Oso", "Lagarto", "Pajaro", "Rana", "Pato", "Elefante"};
}//end class
