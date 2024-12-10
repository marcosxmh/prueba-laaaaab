package poo.play_button;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.testfx.framework.junit5.ApplicationTest;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;

public class PlayButtonTest extends ApplicationTest {

    private PlayButton playButton;
    private boolean buttonClicked;

    @Override
    public void start(Stage stage) {
        buttonClicked = false;
        EventHandler<ActionEvent> playAction = event -> buttonClicked = true;
        playButton = new PlayButton(playAction);
        stage.setScene(new Scene(playButton));
        stage.show();
    }

    @Test
    public void testButtonInitialization() {
        Button play = (Button) playButton.lookup(".button");
        assertNotNull(play);
        assertEquals("Iniciar Intento", play.getText());
    }

    @Test
    public void testButtonClick() {
        Button play = (Button) playButton.lookup(".button");
        clickOn(play);
        assertTrue(buttonClicked);
    }
}