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

//Clase que verifica el movimiento de la serpiente en un bucle
public class KeyEventLoop {

    private Scenario scenario;
    private KeyCode currentDirection; // Dirección actual en la que se mueve la serpiente
    private Snake snake;
    private Timeline timeline;
    private KeyFrame keyFrame;
    private Apple apple;
    private Pineapple pineapple;

    // Es necesario usar la coordenada de la serpiente en el método StartLoop
    public KeyEventLoop(Scenario scenario, Snake snake, Apple apple, Pineapple pineapple) {
        this.scenario = scenario;
        this.snake = snake;
        this.apple = apple;
        this.pineapple = pineapple;

        // Usando sintaxis lambda. Cuando ocurra tal evento "e", realizar acciones
        // específicas
        this.scenario.keyPressed(e -> {

            KeyCode key = e.getCode(); // Verifica qué tecla fue presionada

            // !(currentDirection.equals(KeyCode.LEFT)) impide que la serpiente vaya en
            // la dirección contraria a la que iba. Evita errores

            // Derecha
            if (key.equals(KeyCode.RIGHT) || key.equals(KeyCode.D) && !KeyCode.LEFT.equals(currentDirection)) {
                currentDirection = key;
            }

            // Izquierda
            if (key.equals(KeyCode.LEFT) || key.equals(KeyCode.A) && !KeyCode.RIGHT.equals(currentDirection)) {
                currentDirection = key;
            }

            // Arriba
            if (key.equals(KeyCode.UP) || key.equals(KeyCode.W) && !KeyCode.DOWN.equals(currentDirection)) {
                currentDirection = key;
            }

            // Abajo
            if (key.equals(KeyCode.DOWN) || key.equals(KeyCode.S) && !KeyCode.UP.equals(currentDirection)) {
                currentDirection = key;
            }

        });

        startLoop(); // Llamando al bucle
    }

    public void startLoop() {
        timeline = new Timeline(); // Instancia de Timeline

        // Auxiliar para el timeline
        keyFrame = new KeyFrame(Duration.millis(160), e -> {
            Integer posicionX = snake.getPosicionX();
            Integer posicionY = snake.getPosicionY();

            // Si la dirección es igual, mueve hacia la derecha
            if (KeyCode.RIGHT.equals(currentDirection) || KeyCode.D.equals(currentDirection)) {
                posicionX += Config.squareSize; // Se mueve hacia la derecha una posición equivalente al tamaño del cuadrado
            }

            if (KeyCode.LEFT.equals(currentDirection) || KeyCode.A.equals(currentDirection)) {
                posicionX -= Config.squareSize;
            }

            // En el eje Y, para subir se resta
            if (KeyCode.UP.equals(currentDirection) || KeyCode.W.equals(currentDirection)) {
                posicionY -= Config.squareSize;
            }

            // Para bajar, se suma
            if (KeyCode.DOWN.equals(currentDirection) || KeyCode.S.equals(currentDirection)) {
                posicionY += Config.squareSize;
            }

            // Verifica si la serpiente ha cruzado algún borde de la pantalla (escena)
            // -Config.squareSize se usa porque cuando posicionX = Config.width, una parte ya
            // está fuera de la pantalla
            // También verifica si hubo colisión entre la cabeza y algún elemento del cuerpo
            if (posicionX < 0 || posicionX > Config.width - Config.squareSize
                    || posicionY < 0 || posicionY > Config.height - Config.squareSize
                    || snake.bodyCollision(posicionX, posicionY)) {
                gameOver();
            } else {
                // Verifica si la posición de la cabeza de la serpiente coincide con la posición de la comida (manzana
                // o piña)
                if (posicionX.equals(apple.getPosicionX()) && posicionY.equals(apple.getPosicionY())) {
                    this.apple.setRandomPosition(); // Asigna una nueva posición aleatoria para la comida
                    this.snake.eatApple(scenario);
                } else if (posicionX.equals(pineapple.getPosicionX())
                        && posicionY.equals(pineapple.getPosicionY())) {
                    this.pineapple.setRandomPosition();
                    this.snake.eatPineapple(scenario);
                }

                this.snake.setPosition(posicionX, posicionY); // Estableciendo las posiciones
            }
        });

        timeline.getKeyFrames().add(keyFrame);
        timeline.setCycleCount(Integer.MAX_VALUE); // Ejecuta el Timeline un "número" infinito de veces
        timeline.play(); // Ejecuta el timeline
    }

    // El método para el keyEventLoop y activa la clase TryAgainButton
    public void gameOver() {
        timeline.stop();
        this.currentDirection = null; // Hace que la serpiente se quede quieta
        this.snake.deadSnake();

        // Usando "this" porque pasa como parámetro el propio keyEventLoop
        this.scenario.showGameOver(this);
    }

}
