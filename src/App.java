public class App {
    private static final int FILAS = 51;
    private static final int COLUMNAS = FILAS;

    public static void main(String[] args) {
        CalculadorPrimos calculadorPrimos = new CalculadorPrimos(FILAS * COLUMNAS);
        boolean[] esPrimo = calculadorPrimos.getEsPrimo();
        new Ventana(esPrimo);
    }
}
