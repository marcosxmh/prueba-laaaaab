package poo.food.pineapple;

import poo.canvas_utils_square.CanvasUtilsSquares;
import poo.config.Config;
import poo.food.Food;
import javafx.scene.canvas.Canvas;
import javafx.scene.paint.Color;

/**
 * Clase para representar la comida Pineapple (Piña).
 */
public class Pineapple extends Food {

    private Canvas pineapple;

    /**
     * Constructor de la clase Pineapple.
     * Inicializa la comida y establece una posición aleatoria.
     */
    public Pineapple() {
        creatingFood();
        setRandomPosition();
    }

    /**
     * Método para crear la comida Pineapple.
     * Construye un cuadrado amarillo que representa la piña.
     */
    @Override
    protected void creatingFood() {
        this.pineapple = CanvasUtilsSquares.buildingSquare(Color.YELLOW);
    }

    /**
     * Método para establecer una posición aleatoria para la piña.
     * Utiliza valores de configuración para determinar los límites de la posición.
     */
    public void setRandomPosition() {
        this.pineapple
                .setTranslateX(randomNumbers(Config.oneQuarterWidthDown, Config.oneQuarterWidthUp - Config.squareSize));
        this.pineapple.setTranslateY(
                randomNumbers(Config.oneQuarterfHeightUp, Config.oneQuarterfHeightDown - Config.squareSize));
    }

    /**
     * Método para obtener el objeto Canvas que representa la piña.
     *
     * @return el objeto Canvas de la piña.
     */
    public Canvas getPineapple() {
        return pineapple;
    }

    /**
     * Método para obtener la posición X de la piña.
     *
     * @return la posición X como un entero.
     */
    @Override
    public Integer getPosicionX() {
        return (int) this.pineapple.getTranslateX(); // Obtiene la posición X y hace el Casting de double a int
    }

    /**
     * Método para obtener la posición Y de la piña.
     *
     * @return la posición Y como un entero.
     */
    @Override
    public Integer getPosicionY() {
        return (int) this.pineapple.getTranslateY();
    }

}