package poo.config;

/**
 * @class Config
 * @brief Clase que almacena variables estáticas para la configuración general del juego de la serpiente.
 *
 * Esta clase contiene constantes y variables estáticas utilizadas para configurar dimensiones,
 * valores predefinidos y estados relacionados con el juego de la serpiente.
 */
public class Config {

    /**
     * @brief Ancho de la ventana del juego.
     * Usando Integer para permitir valores nulos si se requiere en algún contexto futuro.
     */
    public static final Integer width = 880;

    /**
     * @brief Altura de la ventana del juego.
     * Usando Integer para permitir valores nulos si se requiere en algún contexto futuro.
     */
    public static final Integer height = 640;

    /**
     * @brief Tamaño de un cuadrado en la cuadrícula del juego.
     */
    public static final Integer squareSize = 40;

    /**
     * @brief Coordenada X que representa tres cuartos del ancho del juego.
     */
    public static final Integer oneQuarterWidthUp = 660;

    /**
     * @brief Coordenada X que representa un cuarto del ancho del juego.
     */
    public static final Integer oneQuarterWidthDown = 220;

    /**
     * @brief Coordenada Y que representa tres cuartos de la altura del juego.
     */
    public static final Integer oneQuarterfHeightUp = 480;

    /**
     * @brief Coordenada Y que representa un cuarto de la altura del juego.
     */
    public static final Integer oneQuarterfHeightDown = 160;

    /**
     * @brief Puntaje actual del jugador en el juego.
     */
    public static Integer score = 0;

    /**
     * @brief Número de intentos realizados por el jugador.
     */
    public static Integer tries = 0;
}