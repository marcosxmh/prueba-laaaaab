package poo.config;

//Clase creada para almacenar variables estáticas para la configuración general del juego de la serpiente
public class Config {

    public static final Integer width = 880; // Usando INTEGER por si en algún momento el valor es nulo
    public static final Integer height = 640;
    public static final Integer squareSize = 40;
    public static final Integer oneQuarterWidthUp = 660; // Tres cuartos
    public static final Integer oneQuarterWidthDown = 220; // Un cuarto
    public static final Integer oneQuarterfHeightUp = 480;
    public static final Integer oneQuarterfHeightDown = 160;
    public static Integer score = 0;
    public static Integer tries = 0; // Usado para guardar el número de intentos

}
