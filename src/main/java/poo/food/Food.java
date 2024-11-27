package poo.food;

import poo.config.Config;

public abstract class Food {

    protected abstract void creatingFood();

    // Estableciendo un valor aleatorio para la posición X e Y del método Food randomNumbers
    // se utiliza por herencia (clase de alimento infantil de manzana y pinya)
    public Integer randomNumbers(Integer min, Integer max) {
        // Fórmula para recibir números aleatorios
        int value = (int) (Math.random() * ((max - min) + 1)) + min;

        // necesitamos obtener un valor que sea múltiplo de 40 para que se ajuste a la pantalla
        return value - (value % Config.squareSize);
    }

    // Método utilizado para obtener la coordenada X de Food
    public abstract Integer getPosicionX();

    // Método utilizado para obtener la coordenada y de Food
    public abstract Integer getPosicionY();

}
