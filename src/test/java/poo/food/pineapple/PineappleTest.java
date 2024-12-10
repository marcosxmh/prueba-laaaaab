package poo.food.pineapple;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import javafx.scene.canvas.Canvas;
import poo.config.Config;

import java.lang.reflect.Field;

public class PineappleTest {
//
//    @BeforeEach
//    public void setUp() throws Exception {
//        setFinalStatic(Config.class.getDeclaredField("squareSize"), 40);
//        setFinalStatic(Config.class.getDeclaredField("oneQuarterWidthDown"), 0);
//        setFinalStatic(Config.class.getDeclaredField("oneQuarterWidthUp"), 400);
//        setFinalStatic(Config.class.getDeclaredField("oneQuarterfHeightUp"), 0);
//        setFinalStatic(Config.class.getDeclaredField("oneQuarterfHeightDown"), 400);
//    }
//
//    private void setFinalStatic(Field field, Object newValue) throws Exception {
//        field.setAccessible(true);
//        field.set(null, newValue);
//    }
//
//    @Test
//    public void testPineappleCreation() {
//        // Create a Pineapple instance
//        Pineapple pineapple = new Pineapple();
//
//        // Verify the pineapple is created and is not null
//        assertNotNull(pineapple.getPineapple());
//
//        // Verify the size of the canvas
//        Canvas pineappleCanvas = pineapple.getPineapple();
//        assertEquals((double) Config.squareSize, pineappleCanvas.getWidth());
//        assertEquals((double) Config.squareSize, pineappleCanvas.getHeight());
//
//        // Verify the position of the pineapple is within the game area
//        int posX = pineapple.getPosicionX();
//        int posY = pineapple.getPosicionY();
//        assertTrue(posX >= Config.oneQuarterWidthDown && posX < Config.oneQuarterWidthUp);
//        assertTrue(posY >= Config.oneQuarterfHeightUp && posY < Config.oneQuarterfHeightDown);
//    }
//
//    @Test
//    public void testSetRandomPosition() {
//        Pineapple pineapple = new Pineapple();
//        pineapple.setRandomPosition();
//
//        int posX = pineapple.getPosicionX();
//        int posY = pineapple.getPosicionY();
//
//        // Verify the position of the pineapple is within the game area
//        assertTrue(posX >= Config.oneQuarterWidthDown && posX < Config.oneQuarterWidthUp);
//        assertTrue(posY >= Config.oneQuarterfHeightUp && posY < Config.oneQuarterfHeightDown);
//    }
}