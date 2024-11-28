package poo.scenario;

import poo.Archivo;
import poo.play_button.PlayButton;
import poo.snake.Snake;
import poo.config.Config;
import poo.food.apple.Apple;
import poo.food.pineapple.Pineapple;
import poo.key_event_loop.KeyEventLoop;
import poo.try_again_button.TryAgainButton;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.event.EventHandler;
import javafx.scene.input.KeyEvent;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.geometry.Pos;

/**
 * @class Scenario
 * @brief Clase que administra la escena principal del juego, incluyendo pantallas de inicio, juego y finalización.
 *
 * Esta clase configura los elementos visuales y lógicos del juego, como la interfaz inicial para ingresar el nickname,
 * el inicio del juego, y la pantalla de "Game Over". También gestiona los eventos de teclado y la limpieza de la escena.
 */
public class Scenario {

    private Scene scene; // Escena de JavaFX
    public Group container = new Group(); // Contiene todos los elementos que estarán en la escena
    private Snake snake;
    private Apple apple;
    private Pineapple pineapple;
    private String nickname; // Nickname del jugador

    /**
     * @brief Constructor de la clase Scenario.
     *
     * Inicializa la escena principal, asigna la ventana de la aplicación, y muestra la pantalla inicial.
     *
     * @param primaryStage Ventana principal de la aplicación.
     * @param snake Objeto que representa la serpiente.
     * @param apple Objeto que representa la manzana.
     * @param pineapple Objeto que representa la piña.
     */
    public Scenario(Stage primaryStage, Snake snake, Apple apple, Pineapple pineapple) {
        // Crear la escena
        this.scene = new Scene(container, Config.width, Config.height);
        primaryStage.setScene(scene);
        primaryStage.setTitle("Snake Game - Proyecto POO");
        primaryStage.show();

        this.snake = snake;
        this.apple = apple;
        this.pineapple = pineapple;

        // Mostrar la pantalla inicial para ingresar el nickname
        pedirNickname(() -> mostrarPlayButton());
    }

    /**
     * @brief Muestra una interfaz para que el jugador ingrese su nickname.
     *
     * Una vez ingresado el nickname, llama a la función proporcionada como parámetro.
     *
     * @param onNicknameEntered Acción a ejecutar después de que se ingrese el nickname.
     */
    private void pedirNickname(Runnable onNicknameEntered) {
        // Limpiar la escena antes de mostrar la pantalla inicial
        cleanScene();

        // Crear la pantalla para ingresar el nickname
        VBox nicknamePane = new VBox();
        nicknamePane.setAlignment(Pos.CENTER);
        nicknamePane.setSpacing(20);

        Text prompt = new Text("Ingrese su nickname:");
        TextField nicknameField = new TextField();
        nicknameField.setPromptText("Nickname");
        nicknameField.setMaxWidth(300);

        Button continueButton = new Button("Continuar");
        continueButton.setOnAction(e -> {
            this.nickname = nicknameField.getText();
            if (!nickname.isEmpty()) {
                onNicknameEntered.run(); // Mostrar el PlayButton
                this.container.getChildren().remove(nicknamePane);
            }
        });

        nicknamePane.getChildren().addAll(prompt, nicknameField, continueButton);
        this.container.getChildren().add(nicknamePane);
    }

    /**
     * @brief Muestra la pantalla del botón de inicio del juego.
     */
    private void mostrarPlayButton() {
        cleanScene();

        // Crear el PlayButton
        PlayButton playButton = new PlayButton(e -> {
            iniciarJuego();
        });

        // Agregar el PlayButton a la escena
        this.container.getChildren().add(playButton);
    }

    /**
     * @brief Inicia el juego, incluyendo la configuración de los eventos de teclado y los elementos iniciales.
     */
    private void iniciarJuego() {
        cleanScene();

        // Inicializar el KeyEventLoop para manejar eventos de teclado
        new KeyEventLoop(this, snake, apple, pineapple);

        // Agregar elementos iniciales del juego
        container.getChildren().add(snake.getHead());
        container.getChildren().add(apple.getApple());
        container.getChildren().add(pineapple.getPineapple());
    }

    /**
     * @brief Configura el manejo de eventos de teclado en la escena.
     *
     * @param keyAction Acción a realizar cuando se presiona una tecla.
     */
    public void keyPressed(EventHandler<? super KeyEvent> keyAction) {
        this.scene.setOnKeyPressed(keyAction); // Configura los eventos de teclado
    }

    /**
     * @brief Muestra la pantalla de "Game Over" y reinicia el juego si el jugador decide intentarlo nuevamente.
     *
     * @param keyEventLoop Referencia al bucle de eventos actual del juego.
     */
    public void showGameOver(KeyEventLoop keyEventLoop) {
        // Guardar el nickname y la puntuación
        Archivo.writeScore(nickname, Config.score);

        // Crear el botón de reinicio
        TryAgainButton tryAgainButton = new TryAgainButton(e -> {
            Config.score = 0; // Reiniciar el puntaje para el nuevo intento
            cleanScene();
            snake.changeSnakeColor(javafx.scene.paint.Color.GREEN);

            // Reagregar elementos iniciales
            container.getChildren().add(snake.resetGame());
            container.getChildren().add(apple.getApple());
            container.getChildren().add(pineapple.getPineapple());

            // Pedir nuevamente el nickname antes de reiniciar
            pedirNickname(() -> mostrarPlayButton());
        });

        this.container.getChildren().add(tryAgainButton);
    }

    /**
     * @brief Limpia todos los elementos visibles en la escena.
     */
    public void cleanScene() {
        // Limpiar todos los elementos de la pantalla
        this.container.getChildren().clear();
    }

    /**
     * @brief Agrega una nueva parte al cuerpo de la serpiente en la escena.
     *
     * @param node Nodo gráfico que representa la nueva parte de la serpiente.
     */
    public void addSnakeBodyPart(Node node) {
        this.container.getChildren().add(node);
    }
}
