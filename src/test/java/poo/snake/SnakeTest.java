package poo.snake;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import javafx.application.Platform;
import javafx.scene.canvas.Canvas;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import org.testfx.framework.junit5.ApplicationTest;
import poo.config.Config;
import poo.scenario.Scenario;

public class SnakeTest extends ApplicationTest {

    private Snake snake;
    private Stage stage;

    @Override
    public void start(Stage stage) {
        this.stage = stage;
    }

    @BeforeEach
    public void setUp() {
        snake = new Snake();
    }

    @Test
    public void testInitialHeadPosition() {
        Canvas head = snake.getHead();
        assertNotNull(head);
        assertEquals(Config.width / 2 - Config.squareSize, head.getTranslateX());
        assertEquals(Config.height / 2 - Config.squareSize, head.getTranslateY());
    }

    @Test
    public void testSetPosition() {
        snake.setPosition(100, 200);
        assertEquals(100, snake.getPosicionX());
        assertEquals(200, snake.getPosicionY());
    }

    @Test
    public void testResetGame() {
        snake.setPosition(100, 200);
        snake.resetGame();
        assertEquals(Config.width / 2 - Config.squareSize, snake.getPosicionX());
        assertEquals(Config.height / 2 - Config.squareSize, snake.getPosicionY());
        assertEquals(Color.GREEN, snake.getHead().getGraphicsContext2D().getFill());
    }

    @Test
    public void testDeadSnake() {
        snake.deadSnake();
        assertEquals(Color.BLACK, snake.getHead().getGraphicsContext2D().getFill());
    }

    @Test
    public void testChangeSnakeColor() {
        snake.changeSnakeColor(Color.BLUE);
        assertEquals(Color.BLUE, snake.getHead().getGraphicsContext2D().getFill());
    }

    @Test
    public void testBodyCollision() {
        Platform.runLater(() -> {
            Scenario scenario = new Scenario(stage, snake, null, null);
            snake.setPosition(100, 200);
            snake.eatApple(scenario);
            snake.setPosition(100, 200);
            assertTrue(snake.bodyCollision(100, 200));
            assertFalse(snake.bodyCollision(300, 400));
        });
    }
}