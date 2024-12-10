package poo.food.apple;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import javafx.scene.canvas.Canvas;
import poo.config.Config;

import java.lang.reflect.Field;

public class AppleTest {

//    @BeforeEach
//    public void setUp() throws Exception {
//        setFinalStatic(Config.class.getDeclaredField("squareSize"), 40);
//        setFinalStatic(Config.class.getDeclaredField("width"), 400);
//        setFinalStatic(Config.class.getDeclaredField("height"), 400);
//    }
//
//    private void setFinalStatic(Field field, Object newValue) throws Exception {
//        field.setAccessible(true);
//        field.set(null, newValue);
//    }
//
//    @Test
//    public void testAppleCreation() {
//        // Create an Apple instance
//        Apple apple = new Apple();
//
//        // Verify the apple is created and is not null
//        assertNotNull(apple.getApple());
//
//        // Verify the size of the canvas
//        Canvas appleCanvas = apple.getApple();
//        assertEquals((double) Config.squareSize, appleCanvas.getWidth());
//        assertEquals((double) Config.squareSize, appleCanvas.getHeight());
//
//        // Verify the position of the apple is within the game area
//        int posX = apple.getPosicionX();
//        int posY = apple.getPosicionY();
//        assertTrue(posX >= 0 && posX < Config.width);
//        assertTrue(posY >= 0 && posY < Config.height);
//    }
//
//    @Test
//    public void testSetRandomPosition() {
//        Apple apple = new Apple();
//        apple.setRandomPosition();
//
//        int posX = apple.getPosicionX();
//        int posY = apple.getPosicionY();
//
//        // Verify the position of the apple is within the game area
//        assertTrue(posX >= 0 && posX < Config.width);
//        assertTrue(posY >= 0 && posY < Config.height);
//    }
}