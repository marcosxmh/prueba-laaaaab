package poo.try_again_button;

import poo.config.Config;
import poo.scenario.Scenario;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;

// Clase que gestiona el Game Over y el Reinicio - VBox coloca un elemento debajo del otro
public class TryAgainButton extends VBox {

    Scenario scenario;

    public TryAgainButton(EventHandler<ActionEvent> buttonAction) {

        Label gameOver = new Label("Fin del juego");
        gameOver.setFont(Font.font(100)); // Comando que establece el tamaño del label
        gameOver.setTranslateY(-80); // Mueve el título hacia arriba
        gameOver.setTextFill(Color.BLACK); // Estableciendo el color del label

        Label scoreText = new Label("Puntuación: " + Config.score);
        scoreText.setFont(Font.font(40));
        scoreText.setTranslateY(-20);
        // scoreText.setTextFill(Color.GREEN);

        Button tryAgainButton = new Button("Reintentar");
        tryAgainButton.setFont(Font.font(40));
        tryAgainButton.setTranslateY(40); // Mueve el título hacia arriba
        tryAgainButton.setOnAction(buttonAction); // Acción del botón de Reintentar al hacer clic

        // Establece el tamaño de VBox igual al tamaño de la escena. Ayuda a centrar el label
        this.setMinWidth(Config.width);
        this.setMinHeight(Config.height);

        // Al extender VBox, el comando entiende que el objeto es el propio VBox
        this.getChildren().addAll(gameOver, scoreText, tryAgainButton);

        this.setAlignment(Pos.CENTER); // Alinea todos los elementos de VBox al centro

    }

}
