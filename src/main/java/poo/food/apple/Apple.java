package poo.food.apple;

import poo.canvas_utils_square.CanvasUtilsSquares;
import poo.config.Config;
import poo.food.Food;
import javafx.scene.canvas.Canvas;
import javafx.scene.paint.Color;

/**
 * @class Apple
 * @brief Representa una comida tipo "manzana" en el juego de la serpiente.
 *
 * Esta clase extiende la clase base `Food` y proporciona funcionalidad específica
 * para las manzanas, como su creación, color y posición aleatoria dentro del área del juego.
 */
public class Apple extends Food {

    /**
     * @brief Representa la manzana como un objeto Canvas.
     */
    private Canvas apple;

    /**
     * @brief Constructor de la clase `Apple`.
     *
     * Inicializa una manzana llamando a los métodos para crearla gráficamente y
     * establecer su posición inicial aleatoria.
     */
    public Apple() {
        creatingFood();
        setRandomPosition();
    }

    /**
     * @brief Crea gráficamente la manzana como un cuadrado rojo.
     *
     * Este método utiliza la utilidad `CanvasUtilsSquares` para generar
     * un Canvas de color rojo que representa la manzana.
     */
    protected void creatingFood() {
        this.apple = CanvasUtilsSquares.buildingSquare(Color.RED);
    }

    /**
     * @brief Asigna una posición aleatoria a la manzana dentro del área del juego.
     *
     * Calcula una posición aleatoria dentro de los límites del área de juego definida
     * por la configuración (`Config`) y aplica esas coordenadas al Canvas de la manzana.
     */
    public void setRandomPosition() {
        this.apple.setTranslateX(randomNumbers(0, Config.width - Config.squareSize));
        this.apple.setTranslateY(randomNumbers(0, Config.height - Config.squareSize));
    }

    /**
     * @brief Obtiene el objeto `Canvas` que representa gráficamente la manzana.
     *
     * @return Un objeto Canvas con la representación visual de la manzana.
     */
    public Canvas getApple() {
        return apple;
    }

    /**
     * @brief Obtiene la posición X actual de la manzana.
     *
     * @return Un valor entero que representa la posición X de la manzana en el área del juego.
     */
    @Override
    public Integer getPosicionX() {
        return (int) this.apple.getTranslateX(); // Obtiene la posición X y hace el casting de double a int
    }

    /**
     * @brief Obtiene la posición Y actual de la manzana.
     *
     * @return Un valor entero que representa la posición Y de la manzana en el área del juego.
     */
    @Override
    public Integer getPosicionY() {
        return (int) this.apple.getTranslateY();
    }
}