package poo.play_button;

import poo.config.Config;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.scene.text.Font;

/**
 * @class PlayButton
 * @brief Clase que representa un botón de inicio junto con un título y descripción para la pantalla de bienvenida del juego.
 *
 * Esta clase extiende VBox y organiza los elementos visuales, como el título, la descripción
 * y el botón para iniciar el juego, en una disposición vertical centrada.
 */
public class PlayButton extends VBox {

    /**
     * @brief Constructor que inicializa la pantalla de bienvenida con sus elementos.
     *
     * @param playAction Acción que se ejecutará al presionar el botón "Iniciar Intento".
     */
    public PlayButton(EventHandler<ActionEvent> playAction) {

        /**
         * @var title
         * @brief Título principal del juego que aparece en la pantalla de bienvenida.
         */
        Text title = new Text("Snake Game");
        title.setFont(Font.font(60));
        title.setTranslateY(-80); // Mueve el título hacia arriba
        title.setStyle("-fx-font-weight: bold;"); // Definiendo el estilo en negrita

        /**
         * @var welcome
         * @brief Texto de bienvenida que se muestra al usuario.
         */
        Text welcome = new Text(
                "¡Bienvenido(a) al Juego!");
        welcome.setFont(Font.font(30));

        /**
         * @var description
         * @brief Texto que explica las reglas del juego y controles.
         */
        Text description = new Text(
                "Observaciones: \nLas manzanas valen 3 puntos y las pinyas valen 1 punto. \nUsa las flechas o las teclas W, A, S y D para mover la serpiente!");
        description.setFont(Font.font(30));

        welcome.setTranslateY(-20);
        description.setTranslateY(-20);

        /**
         * @var play
         * @brief Botón que permite al usuario iniciar el juego.
         */
        Button play = new Button("Iniciar Intento");
        play.setFont(Font.font(40));
        play.setOnAction(playAction);
        play.setTranslateY(40);

        // Estableciendo el tamaño del VBox igual al tamaño de la escena. Ayuda a la hora de
        // centralizar el Label
        this.setMinWidth(Config.width);
        this.setMinHeight(Config.height);

        this.setSpacing(20); // Espaciado entre los elementos
        this.getChildren().addAll(title, description, play);

        this.setAlignment(Pos.CENTER); // Alineación centrada
    }

}
