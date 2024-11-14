package poo.scenario;

import poo.Arquivo;
import poo.play_button.PlayButton;
import poo.snake.Snake;
import poo.config.Config;
import poo.food.apple.Apple;
import poo.food.pineapple.Pineapple;
import poo.key_event_loop.KeyEventLoop;
import poo.try_again_button.TryAgainButton;
import javafx.event.EventHandler;
import javafx.scene.Node;
import javafx.scene.input.KeyEvent;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class Scenario {

    private Scene scene; // Escena de JavaFX
    public Group container = new Group(); // Contiene todos los elementos que estarán en la escena
    private Snake snake;
    private Apple apple;
    private Pineapple pineapple;
    // private Arquivo file = new Arquivo();

    public Scenario(Stage primaryStage, Snake snake, Apple apple, Pineapple pineapple) {
        // Creando la escena
        this.scene = new Scene(container, Config.width, Config.height); // Group - Ancho - Alto
        primaryStage.setScene(scene); // Configurando la escena en la clase Scene
        primaryStage.setTitle("Snake Game - Proyecto POO by Douglas Souza");
        primaryStage.show(); // Mostrando la ventana

        this.snake = snake;
        this.apple = apple;
        this.pineapple = pineapple;

        // KeyEventLoop keyEventLoop = new KeyEventLoop(this, snake, apple, pineapple);
        new KeyEventLoop(this, snake, apple, pineapple);

        // Botón play que se debe presionar antes para comenzar el juego
        // Cuando se presiona, agrega la serpiente y las comidas a la escena
        PlayButton playButton = new PlayButton(e -> {
            cleanScene();

            // Colocando el Canvas de la cabeza en una lista Children dentro de container
            container.getChildren().add(snake.getHead());

            // Colocando el Canvas de apple y pineapple dentro del container
            container.getChildren().add(apple.getApple());
            container.getChildren().add(pineapple.getPineapple());
        });

        // Agrega el playButton a la escena
        this.container.getChildren().addAll(playButton);

    }

    // Método que retorna una acción cuando se presiona cierta tecla
    public void keyPressed(EventHandler<? super KeyEvent> keyAction) {
        this.scene.setOnKeyPressed(keyAction);
    }

    // Método que llama a la clase TryAgainButton
    public void showGameOver(KeyEventLoop keyEventLoop) {
        TryAgainButton tryAgainButton = new TryAgainButton(e -> {
            Integer scoreTotal = Config.score;
            // file.writeScores(scoreTotal, Config.tries);
            Arquivo.writeScores(scoreTotal, Config.tries); // Escribiendo la puntuación anterior en ArchivoPuntos.txr
            Config.tries += 1; // Incrementa el número de intentos
            Config.score = 0; // Igualando la puntuación a 0 para los otros intentos
            cleanScene();
            snake.changeSnakeColor(Color.GREEN);

            this.container.getChildren().add(this.snake.resetGame()); // Reagregando instancia de la cabeza

            // Reagregando instancias de apple y pineapple
            this.container.getChildren().add(apple.getApple());
            this.container.getChildren().add(pineapple.getPineapple());
            keyEventLoop.startLoop();
        });

        this.container.getChildren().add(tryAgainButton); // Agrega el tryAgainButton a la escena
    }

    // Limpia los elementos de la pantalla cuando ocurre el Game Over
    public void cleanScene() {
        // Limpiando toda la lista Children de container
        this.container.getChildren().remove(0, this.container.getChildren().size());
    }

    // La clase Node es el padre de todos los elementos de JavaFX, así que el resto extiende Node
    public void addSnakeBodyPart(Node node) {
        this.container.getChildren().add(node); // Agrega el parámetro recibido al container
    }

}
