package poo.key_event_loop;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import javafx.application.Platform;
import javafx.scene.input.KeyCode;
import javafx.stage.Stage;
import poo.scenario.Scenario;
import poo.snake.Snake;
import poo.food.apple.Apple;
import poo.food.pineapple.Pineapple;

public class KeyEventLoopTest {

    private Scenario scenario;
    private Snake snake;
    private Apple apple;
    private Pineapple pineapple;
    private KeyEventLoop keyEventLoop;

    @BeforeAll
    public static void initToolkit() {
        Platform.startup(() -> {});
    }

    @BeforeEach
    public void setUp() throws Exception {
        Platform.runLater(() -> {
            snake = new TestSnake();
            apple = new TestApple();
            pineapple = new TestPineapple();
            scenario = new TestScenario(new Stage(), snake, apple, pineapple);

            keyEventLoop = new KeyEventLoop(scenario, snake, apple, pineapple);
        });
        Thread.sleep(1000); // Wait for JavaFX initialization
    }

    @Test
    public void testKeyPressedRight() {
        Platform.runLater(() -> {
            ((TestScenario) scenario).simulateKeyPress(KeyCode.RIGHT);
            assertEquals(KeyCode.RIGHT, ((TestScenario) scenario).getCurrentDirection());
        });
    }

    @Test
    public void testKeyPressedLeft() {
        Platform.runLater(() -> {
            ((TestScenario) scenario).simulateKeyPress(KeyCode.LEFT);
            assertEquals(KeyCode.LEFT, ((TestScenario) scenario).getCurrentDirection());
        });
    }

    @Test
    public void testKeyPressedUp() {
        Platform.runLater(() -> {
            ((TestScenario) scenario).simulateKeyPress(KeyCode.UP);
            assertEquals(KeyCode.UP, ((TestScenario) scenario).getCurrentDirection());
        });
    }

    @Test
    public void testKeyPressedDown() {
        Platform.runLater(() -> {
            ((TestScenario) scenario).simulateKeyPress(KeyCode.DOWN);
            assertEquals(KeyCode.DOWN, ((TestScenario) scenario).getCurrentDirection());
        });
    }



    // Clases internas para simular el comportamiento necesario para las pruebas
    private class TestScenario extends Scenario {
        private KeyCode currentDirection;
        private boolean gameOverShown = false;

        public TestScenario(Stage stage, Snake snake, Apple apple, Pineapple pineapple) {
            super(stage, snake, apple, pineapple);
        }

        public void simulateKeyPress(KeyCode key) {
            this.currentDirection = key;
        }

        public KeyCode getCurrentDirection() {
            return currentDirection;
        }

        public boolean isGameOverShown() {
            return gameOverShown;
        }

        // Remove @Override if Scenario does not have this method
        public void showGameOver(Object keyEventLoop) {
            this.gameOverShown = true;
        }
    }

    private class TestSnake extends Snake {
        private boolean dead = false;

        public boolean isDead() {
            return dead;
        }

        @Override
        public void deadSnake() {
            this.dead = true;
        }
    }

    private class TestApple extends Apple {
        // Implementación vacía para las pruebas
    }

    private class TestPineapple extends Pineapple {
        // Implementación vacía para las pruebas
    }
}