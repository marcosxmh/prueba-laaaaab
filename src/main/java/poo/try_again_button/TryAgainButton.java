package poo.try_again_button;

import poo.config.Config;
import poo.Archivo;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.Text;

import java.util.List;

public class TryAgainButton extends StackPane {

    public TryAgainButton(EventHandler<ActionEvent> buttonAction) {

        // Fondo blanco detrás del Scoreboard
        Rectangle background = new Rectangle(Config.width - 100, Config.height - 200);
        background.setFill(Paint.valueOf("WHITE")); // Fondo blanco
        background.setArcWidth(20); // Bordes redondeados
        background.setArcHeight(20);

        // Contenedor principal
        VBox content = new VBox();
        content.setAlignment(Pos.CENTER);
        content.setSpacing(20);

        // Título de Game Over
        Label gameOver = new Label("Fin del juego");
        gameOver.setFont(Font.font(100));
        gameOver.setTextFill(Color.BLACK);

        // Mostrar la puntuación actual
        Label scoreText = new Label("Puntuacion: " + Config.score);
        scoreText.setFont(Font.font("Arial", 40));

        // Obtener las mejores puntuaciones
        List<String> topScores = Archivo.getTopScores(5);

        // Crear el Scoreboard
        VBox scoreboard = new VBox();
        scoreboard.setSpacing(10);
        scoreboard.setAlignment(Pos.CENTER);

        Text scoreboardTitle = new Text("Mejores Puntuaciones");
        scoreboardTitle.setFont(Font.font("Arial", 40));
        scoreboard.getChildren().add(scoreboardTitle);

        for (String entry : topScores) {
            Text scoreEntry = new Text(entry);
            scoreEntry.setFont(Font.font("Arial", 20));
            scoreboard.getChildren().add(scoreEntry);
        }

        // Botón de reintentar
        Button tryAgainButton = new Button("Reintentar");
        tryAgainButton.setFont(Font.font(40));
        tryAgainButton.setOnAction(buttonAction);

        // Agregar elementos al contenedor principal
        content.getChildren().addAll(gameOver, scoreText, scoreboard, tryAgainButton);

        // Agregar fondo y contenido al StackPane
        this.getChildren().addAll(background, content);
        this.setAlignment(Pos.CENTER);
    }
}
