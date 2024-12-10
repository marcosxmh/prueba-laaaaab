package poo.try_again_button;

import static org.junit.jupiter.api.Assertions.*;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.testfx.framework.junit5.ApplicationTest;
import poo.config.Config;
import poo.Archivo;

import java.util.List;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

public class TryAgainButtonTest extends ApplicationTest {

    private TryAgainButton tryAgainButton;
    private boolean buttonClicked;

    @Override
    public void start(Stage stage) {
        // Initialize TryAgainButton with a test action
        EventHandler<ActionEvent> buttonAction = event -> buttonClicked = true;
        tryAgainButton = new TryAgainButton(buttonAction);
        StackPane root = new StackPane(tryAgainButton);
        stage.setScene(new Scene(root));
        stage.show();
    }

    @BeforeEach
    public void setUp() {
        buttonClicked = false;
    }

    @Test
    public void testButtonAction() throws InterruptedException {
        CountDownLatch latch = new CountDownLatch(1);
        Platform.runLater(() -> {
            Button button = (Button) tryAgainButton.lookup(".button");
            assertNotNull(button);
            button.fire();
            assertTrue(buttonClicked);
            latch.countDown();
        });
        latch.await(5, TimeUnit.SECONDS);
    }

//    @Test
//    public void testScoreDisplay() throws InterruptedException {
//        CountDownLatch latch = new CountDownLatch(1);
//        Platform.runLater(() -> {
//            Config.score = 100;
//            tryAgainButton = new TryAgainButton(event -> {});
//            StackPane root = new StackPane(tryAgainButton);
//            root.getChildren().add(new Label("Puntuacion: " + Config.score));
//            assertNotNull(root);
//            assertTrue(root.getChildren().stream()
//                    .anyMatch(node -> node instanceof Label &&
//                            ((Label) node).getText().contains("Puntuacion: 100")));
//            latch.countDown();
//        });
//        latch.await(5, TimeUnit.SECONDS);
//    }
}