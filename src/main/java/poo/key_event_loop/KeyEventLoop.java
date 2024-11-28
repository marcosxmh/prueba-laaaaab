package poo.key_event_loop;

import poo.scenario.Scenario;
import poo.snake.Snake;
import poo.config.Config;
import poo.food.apple.Apple;
import poo.food.pineapple.Pineapple;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.scene.input.KeyCode;
import javafx.util.Duration;

/**
 * @class KeyEventLoop
 * @brief Clase encargada de manejar el bucle principal del juego, incluyendo el movimiento de la serpiente y la detección de colisiones.
 *
 * Esta clase también interpreta las entradas del teclado para dirigir a la serpiente y gestiona
 * las interacciones con elementos del escenario, como la comida.
 */
public class KeyEventLoop {

    private Scenario scenario;
    private KeyCode currentDirection;
    private Snake snake;
    private Timeline timeline;
    private KeyFrame keyFrame;
    private Apple apple;
    private Pineapple pineapple;

    /**
     * @brief Constructor que inicializa el bucle de eventos del juego.
     *
     * @param scenario Escenario principal del juego.
     * @param snake Instancia de la serpiente.
     * @param apple Comida de tipo manzana.
     * @param pineapple Comida de tipo piña.
     */
    public KeyEventLoop(Scenario scenario, Snake snake, Apple apple, Pineapple pineapple) {
        this.scenario = scenario;
        this.snake = snake;
        this.apple = apple;
        this.pineapple = pineapple;

        // Configuración del evento para manejar teclas presionadas
        this.scenario.keyPressed(e -> {

            KeyCode key = e.getCode(); // Captura la tecla presionada

            // Cambiar la dirección de la serpiente, evitando que se mueva hacia la dirección opuesta
            if (key.equals(KeyCode.RIGHT) || key.equals(KeyCode.D) && !KeyCode.LEFT.equals(currentDirection)) {
                currentDirection = key;
            }

            if (key.equals(KeyCode.LEFT) || key.equals(KeyCode.A) && !KeyCode.RIGHT.equals(currentDirection)) {
                currentDirection = key;
            }

            if (key.equals(KeyCode.UP) || key.equals(KeyCode.W) && !KeyCode.DOWN.equals(currentDirection)) {
                currentDirection = key;
            }

            if (key.equals(KeyCode.DOWN) || key.equals(KeyCode.S) && !KeyCode.UP.equals(currentDirection)) {
                currentDirection = key;
            }

        });

        startLoop(); // Inicia el bucle principal
    }

    /**
     * @brief Inicia el bucle principal del juego, donde se maneja el movimiento de la serpiente y las colisiones.
     */
    public void startLoop() {
        timeline = new Timeline(); // Inicialización del timeline

        // Configuración de las acciones en cada fotograma del bucle
        keyFrame = new KeyFrame(Duration.millis(160), e -> {
            Integer posicionX = snake.getPosicionX();
            Integer posicionY = snake.getPosicionY();

            // Actualiza la posición de la serpiente según la dirección actual
            if (KeyCode.RIGHT.equals(currentDirection) || KeyCode.D.equals(currentDirection)) {
                posicionX += Config.squareSize;
            }

            if (KeyCode.LEFT.equals(currentDirection) || KeyCode.A.equals(currentDirection)) {
                posicionX -= Config.squareSize;
            }

            if (KeyCode.UP.equals(currentDirection) || KeyCode.W.equals(currentDirection)) {
                posicionY -= Config.squareSize;
            }

            if (KeyCode.DOWN.equals(currentDirection) || KeyCode.S.equals(currentDirection)) {
                posicionY += Config.squareSize;
            }

            // Verifica colisiones con los bordes o el cuerpo de la serpiente
            if (posicionX < 0 || posicionX > Config.width - Config.squareSize
                    || posicionY < 0 || posicionY > Config.height - Config.squareSize
                    || snake.bodyCollision(posicionX, posicionY)) {
                gameOver();
            } else {
                // Verifica si la serpiente come una manzana o una piña
                if (posicionX.equals(apple.getPosicionX()) && posicionY.equals(apple.getPosicionY())) {
                    this.apple.setRandomPosition(); // Asigna una nueva posición a la manzana
                    this.snake.eatApple(scenario);
                } else if (posicionX.equals(pineapple.getPosicionX())
                        && posicionY.equals(pineapple.getPosicionY())) {
                    this.pineapple.setRandomPosition();
                    this.snake.eatPineapple(scenario);
                }

                this.snake.setPosition(posicionX, posicionY); // Actualiza la posición de la serpiente
            }
        });

        timeline.getKeyFrames().add(keyFrame);
        timeline.setCycleCount(Integer.MAX_VALUE); // Ejecuta el bucle indefinidamente
        timeline.play(); // Inicia el timeline
    }

    /**
     * @brief Detiene el bucle principal y gestiona el fin del juego.
     *
     * Este método detiene el movimiento de la serpiente, muestra la pantalla de "Game Over"
     * y prepara la aplicación para reiniciar.
     */
    public void gameOver() {
        timeline.stop();
        this.currentDirection = null; // Detiene el movimiento de la serpiente
        this.snake.deadSnake(); // Marca a la serpiente como "muerta"

        // Muestra la pantalla de "Game Over"
        this.scenario.showGameOver(this);
    }

}
