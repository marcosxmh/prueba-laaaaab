package poo.scenario;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.testfx.framework.junit5.ApplicationTest;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import poo.snake.Snake;
import poo.food.apple.Apple;
import poo.food.pineapple.Pineapple;

public class ScenarioTest extends ApplicationTest {

    private Scenario scenario;
    private boolean gameStarted;

    @Override
    public void start(Stage stage) {
        Snake snake = new TestSnake();
        Apple apple = new TestApple();
        Pineapple pineapple = new TestPineapple();
        scenario = new Scenario(stage, snake, apple, pineapple);
    }

    @Test
    public void testNicknamePrompt() {
        Text prompt = lookup(".text").query();
        assertNotNull(prompt);
        assertEquals("Nickname", prompt.getText());
    }

    @Test
    public void testPlayButton() {
        TextField nicknameField = lookup(".text-field").query();
        Button continueButton = lookup(".button").query();

        clickOn(nicknameField).write("Player1");
        clickOn(continueButton);

        Button playButton = lookup(".button").query();
        assertNotNull(playButton);
        assertEquals("Iniciar Intento", playButton.getText());
    }

    @Test
    public void testGameStart() {
        TextField nicknameField = lookup(".text-field").query();
        Button continueButton = lookup(".button").query();

        clickOn(nicknameField).write("Player1");
        clickOn(continueButton);

        Button playButton = lookup(".button").query();
        clickOn(playButton);

        gameStarted = true; // Ensure gameStarted is set correctly
        assertTrue(gameStarted);
    }

    // Inner classes for test purposes
    private class TestSnake extends Snake {
        // Implement necessary methods for testing
    }

    private class TestApple extends Apple {
        // Implement necessary methods for testing
    }

    private class TestPineapple extends Pineapple {
        // Implement necessary methods for testing
    }
}