package poo.snake;

import poo.canvas_utils_square.CanvasUtilsSquares;
import poo.config.Config;
import poo.scenario.Scenario;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;
import java.util.ArrayList;
import java.util.List;

//Construcción del personaje - Snake
public class Snake {

    private Canvas head; // Cabeza de la serpiente
    // Almacena los bloques (cuerpo) en Canvas
    private List<Canvas> body = new ArrayList<Canvas>(); // Lista para almacenar el cuerpo de la serpiente

    // Va a almacenar el historial de posiciones (Integer) de la serpiente
    // Se usará para hacer que las partes del cuerpo se coloquen exactamente una posición
    // antes que la de la cabeza
    private List<Integer[]> positionHistory = new ArrayList<>();

    public Snake() {
        buildingSnake();
    }

    public void setHeadOnCenter() {
        // Estableciendo la posición de la cabeza en el centro de la escena
        this.head.setTranslateX(Config.width / 2 - Config.squareSize);
        this.head.setTranslateY(Config.height / 2 - Config.squareSize);
    }

    // Construyendo la serpiente
    private void buildingSnake() {
        this.head = CanvasUtilsSquares.buildingSquare(Color.TRANSPARENT); // Crea un canvas transparente
        GraphicsContext gc = this.head.getGraphicsContext2D(); // Obtiene el contexto gráfico 2D
        gc.setFill(Color.GREEN); // Establece el color de relleno como verde
        double radius = Config.squareSize / 2; // Calcula el radio del círculo
        gc.fillOval(0, 0, radius * 2, radius * 2); // Dibuja un círculo en la posición (0, 0) con el radio calculado
        this.setHeadOnCenter(); // Establece la posición de la cabeza en el centro
    }

    // Retorna el Canvas de la cabeza
    public Canvas getHead() {
        return this.head; // Retorna la instancia de la serpiente
    }

    // Método utilizado para obtener la coordenada X
    public Integer getPosicionX() {
        return (int) this.head.getTranslateX(); // Obtiene la posición X y realiza el casting de double a int
    }

    // Método utilizado para obtener la coordenada Y
    public Integer getPosicionY() {
        return (int) this.head.getTranslateY();
    }

    // Realiza todo el movimiento de la cabeza y el cuerpo de la serpiente
    public void setPosition(Integer x, Integer y) {
        this.head.setTranslateX(x);
        this.head.setTranslateY(y);

        // Funciona como una pila
        for (int i = 0; i < body.size(); i++) {
            Canvas bodyPart = body.get(i); // Almacena en bodyPart el elemento de la lista en la posición i

            // Nota: El elemento más viejo está al final de la pila, por lo que tiene el índice más bajo
            // Se obtiene la posición de mayor valor (mayor índice)
            // Tamaño 10 (de 0 a 9), por eso la resta. El i en el primer ciclo es 0, por eso la suma de 1.
            Integer[] posicion = this.positionHistory.get(positionHistory.size() - (i + 1));

            // Estableciendo las posiciones a 0
            bodyPart.setTranslateX(posicion[0]);
            bodyPart.setTranslateY(posicion[1]);

            // Eliminando posiciones innecesarias
            // Solo es necesario el tamaño de la serpiente y una posición adicional
            if (positionHistory.size() > body.size() + 1) {
                positionHistory.remove(0); // Elimina el ítem más viejo, en este caso el de menor índice (0)
            }
        }

        // Instanciando un nuevo Array de Integer, inicializado con las posiciones x y y
        this.positionHistory.add(new Integer[] { x, y });
    }

    // Método que retorna el Canvas
    public Canvas resetGame() {
        setHeadOnCenter(); // Establece la cabeza en el centro
        Canvas headInstance;
        headInstance = getHead();

        changeSnakeColor(Color.GREEN); // Cambia el color de rojo a verde al reiniciar

        this.positionHistory.clear(); // Limpia el historial
        this.body.clear(); // Limpia la lista del cuerpo

        return headInstance;
    }

    public void deadSnake() {
        changeSnakeColor(Color.BLACK); // Cambia el color de la serpiente a negro cuando muere
    }

    public void changeSnakeColor(Paint color) {
        GraphicsContext gc = getHead().getGraphicsContext2D();
        gc.clearRect(0, 0, Config.squareSize, Config.squareSize); // Limpia el Canvas
        gc.setFill(color); // Rellena el círculo con el color especificado
        double radius = Config.squareSize / 2; // Calcula el radio del círculo
        gc.fillOval(0, 0, radius * 2, radius * 2); // Dibuja un círculo con el radio calculado
    }

    public void eatApple(Scenario scenario) {
        // Cada parte del cuerpo de la serpiente es un cuadrado de color verde
        Canvas bodyPart = CanvasUtilsSquares.buildingSquare(Color.GREEN);
        scenario.addSnakeBodyPart(bodyPart);
        this.body.add(bodyPart); // Agrega el bodyPart a la lista (body) que contendrá todo
        Config.score += 3;
    }

    public void eatPineapple(Scenario scenario) {
        Canvas bodyPart = CanvasUtilsSquares.buildingSquare(Color.GREEN);
        scenario.addSnakeBodyPart(bodyPart);
        this.body.add(bodyPart);
        Config.score += 1;
    }

    // Verifica la colisión entre la serpiente y su cuerpo
    // Los parámetros x e y son las coordenadas de la cabeza de la serpiente. Se usa un for-each
    // con la lista del cuerpo
    // Si la cabeza colide con alguna parte del cuerpo, retorna true
    public boolean bodyCollision(Integer x, Integer y) {

        // La variable bodyPart recibe cada elemento de la lista (pila) body
        for (Canvas bodyPart : this.body) {
            Integer bodyPositionX = (int) bodyPart.getTranslateX(); // Obtiene la posición X de bodyPart
            Integer bodyPositionY = (int) bodyPart.getTranslateY(); // Obtiene la posición Y de bodyPart

            // Si las posiciones de bodyPart son iguales a las posiciones pasadas por parámetro
            if (bodyPositionX.equals(x) && bodyPositionY.equals(y)) {
                return true; // Retorna true si hay colisión
            }
        }

        return false;
    }
}
