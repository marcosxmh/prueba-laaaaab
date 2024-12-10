package poo.canvas_utils_square;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import javafx.scene.canvas.Canvas;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;
import poo.config.Config;

public class CanvasUtilsSquaresTest {

    @Test
    public void testBuildingSquare() {
        Paint color = Color.RED;
        Canvas canvas = CanvasUtilsSquares.buildingSquare(color);

        // Verify the size of the canvas
        assertEquals((double) Config.squareSize, canvas.getWidth());
        assertEquals((double) Config.squareSize, canvas.getHeight());

        // Verify the color of the square (this is a bit tricky since we can't directly access the color)
        // We can check if the GraphicsContext has the correct fill color set
        assertEquals(color, canvas.getGraphicsContext2D().getFill());
    }
}