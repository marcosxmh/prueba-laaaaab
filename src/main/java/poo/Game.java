package poo;

import poo.food.apple.Apple;
import poo.food.pineapple.Pineapple;
import poo.scenario.Scenario;
import poo.snake.Snake;
import javafx.application.Application;
import javafx.stage.Stage;

/**
 * @class Game
 * @brief Clase principal que inicia el juego de la serpiente.
 * Esta clase extiende de la clase `Application` de JavaFX para crear la interfaz gráfica y ejecutar el juego.
 */
public class Game extends Application {

    /**
     * @brief Método principal que lanza la aplicación JavaFX.
     * Este método inicializa la aplicación y se encarga de invocar el ciclo de vida de la misma.
     *
     * @param args Argumentos de línea de comandos pasados al programa (no se usan en este caso).
     */
    public static void main(String[] args) {
        Application.launch(Game.class, args);
    }

    /**
     * @brief Método que configura y muestra la escena del juego.
     * Este método se ejecuta cuando la aplicación se inicia. Crea los objetos principales del juego
     * (serpiente, manzana, piña) y configura la escena en la ventana.
     *
     * @param stage El escenario (ventana) de la aplicación JavaFX.
     * @throws Exception Si ocurre un error al inicializar el escenario.
     */
    @Override
    public void start(Stage stage) throws Exception {
        Snake snake = new Snake();
        Apple apple = new Apple();
        Pineapple pineapple = new Pineapple();

        new Scenario(stage, snake, apple, pineapple);
    }

}
