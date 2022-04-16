public class CalculadorPrimos {
    private final int MAX_PRIMOS;
    private final boolean[] esPrimo;

    public CalculadorPrimos(int maxPrimos) {
        MAX_PRIMOS = maxPrimos;
        esPrimo = new boolean[maxPrimos];
        for (int i = 0; i < esPrimo.length; i++) {
            esPrimo[i] = i >= 2;
        }
        calcularPrimos();
    }

    private void calcularPrimos() {
        int cotaSuperior = (int) Math.sqrt(MAX_PRIMOS) + 1;
        if (MAX_PRIMOS >= 2) tacharPrimos(2);
        for (int i = 1; i <= cotaSuperior; i+=2) {
            if (i > 1 && esPrimo[i]) {
                tacharPrimos(i);
            }
        }
    }

    private void tacharPrimos(int num) {
        for (int i = 2*num; i < esPrimo.length; i+= num)
            esPrimo[i] = false;
    }

    public boolean[] getEsPrimo() {
        return esPrimo;
    }
}
