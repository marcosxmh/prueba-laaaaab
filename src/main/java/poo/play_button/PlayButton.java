package poo.play_button;

import poo.config.Config;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.scene.text.Font;

public class PlayButton extends VBox {

    public PlayButton(EventHandler<ActionEvent> playAction) {

        // Título del juego
        Text title = new Text("Snake Game");
        title.setFont(Font.font(60));
        title.setTranslateY(-80); // Mueve el título hacia arriba
        title.setStyle("-fx-font-weight: bold;"); // Definiendo el estilo en negrita

        Text welcome = new Text(
                "¡Bienvenido(a) al Juego!");
        welcome.setFont(Font.font(30));

        Text description = new Text(
                "Observaciones: \nLas manzanas valen 3 puntos y las pinyas valen 1 punto. \nUsa las flechas o las teclas W, A, S y D para mover la serpiente!");
        description.setFont(Font.font(30));

        welcome.setTranslateY(-20);
        description.setTranslateY(-20);

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
