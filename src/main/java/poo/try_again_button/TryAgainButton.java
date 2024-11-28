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

/**
 * @class TryAgainButton
 * @brief Clase que representa un botón de "Reintentar" al finalizar el juego.
 * Esta clase muestra una pantalla con el mensaje "Fin del juego",
 * la puntuación actual del jugador y las mejores puntuaciones.
 * Además, permite al jugador reintentar el juego con el botón "Reintentar".
 */
public class TryAgainButton extends StackPane {

    /**
     * @brief Constructor de la clase TryAgainButton.
     * Crea la interfaz gráfica que se muestra cuando el jugador finaliza el juego.
     * Muestra el fondo, la puntuación, el mensaje de fin de juego y las mejores puntuaciones,
     * junto con un botón para reintentar el juego.
     *
     * @param buttonAction Acción a ejecutar cuando se hace clic en el botón de reintentar.
     */
    public TryAgainButton(EventHandler<ActionEvent> buttonAction) {

        // Fondo blanco detrás del Scoreboard
        // Se crea un rectángulo blanco con bordes redondeados que sirve de fondo.
        Rectangle background = new Rectangle(Config.width - 100, Config.height - 200);
        background.setFill(Paint.valueOf("WHITE"));
        background.setArcWidth(20);
        background.setArcHeight(20);

        // Contenedor principal que organiza los elementos dentro del TryAgainButton
        VBox content = new VBox();
        content.setAlignment(Pos.CENTER);
        content.setSpacing(20);

        // Texto de fin del juego
        Label gameOver = new Label("Fin del juego");
        gameOver.setFont(Font.font(100));
        gameOver.setTextFill(Color.BLACK);

        // Texto que muestra la puntuación actual
        Label scoreText = new Label("Puntuacion: " + Config.score);
        scoreText.setFont(Font.font("Arial", 40));

        // Obtener las mejores puntuaciones desde un archivo
        List<String> topScores = Archivo.getTopScores(5);

        // Contenedor para mostrar las mejores puntuaciones
        VBox scoreboard = new VBox();
        scoreboard.setSpacing(10);
        scoreboard.setAlignment(Pos.CENTER);

        // Título del scoreboard
        Text scoreboardTitle = new Text("Mejores Puntuaciones");
        scoreboardTitle.setFont(Font.font("Arial", 40));
        scoreboard.getChildren().add(scoreboardTitle);

        // Añadir las mejores puntuaciones al scoreboard
        for (String entry : topScores) {
            Text scoreEntry = new Text(entry);
            scoreEntry.setFont(Font.font("Arial", 20));
            scoreboard.getChildren().add(scoreEntry);
        }

        // Botón para reintentar el juego
        Button tryAgainButton = new Button("Reintentar");
        tryAgainButton.setFont(Font.font(40));
        tryAgainButton.setOnAction(buttonAction);

        // Añadir todos los elementos a la interfaz
        content.getChildren().addAll(gameOver, scoreText, scoreboard, tryAgainButton);

        // Añadir todo el contenido y el fondo al StackPane
        this.getChildren().addAll(background, content);
        this.setAlignment(Pos.CENTER);
    }
}
