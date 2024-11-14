package poo.canvas_utils_square;

import poo.config.Config;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Paint;

//Clase Canvas usada para la creación de "dibujos" del juego
public class CanvasUtilsSquares {

    // Construyendo un cuadrado con un color determinado
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
