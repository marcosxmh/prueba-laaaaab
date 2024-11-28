package poo.canvas_utils_square;

import poo.config.Config;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Paint;

/**
 * @class CanvasUtilsSquares
 * @brief Clase utilizada para la creación de "dibujos" en el juego.
 *
 * Esta clase contiene métodos estáticos para generar elementos visuales en forma de cuadrados
 * con propiedades configurables, como el color.
 */
public class CanvasUtilsSquares {

    /**
     * @brief Crea un objeto Canvas con un cuadrado de un color específico.
     *
     * Este método genera un objeto Canvas de tamaño predeterminado y dibuja un cuadrado
     * sólido del color especificado dentro del Canvas.
     *
     * @param color El color del cuadrado, especificado como un objeto de tipo Paint.
     * @return Un objeto Canvas que contiene el cuadrado dibujado.
     */
    public static Canvas buildingSquare(Paint color) {
        Canvas square = new Canvas(Config.squareSize, Config.squareSize); // Creando un cuadrado
        GraphicsContext gc = square.getGraphicsContext2D(); // Usado para agregar elementos al objeto

        // Primero se establece el color, luego se dibuja en el Canvas
        gc.setFill(color); // Estableciendo el color del cuadrado

        // Dibujando un objeto cuadrado en el Canvas
        gc.fillRect(0, 0, Config.squareSize, Config.squareSize); // Posición x - Posición y - tamaño

        return square;
    }
}
