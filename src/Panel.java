import javax.swing.*;
import java.awt.*;

public class Panel extends JPanel {

    private final int tamCelda;
    private final boolean[] esPrimo;
    private final int tamPantalla;
    private final int filas;

    private final int E = 0;
    private final int S = 1;
    private final int W = 2;
    private final int N = 3;

    public Panel(boolean[] esPrimo) {
        this.esPrimo = esPrimo;
        filas = (int) Math.sqrt(esPrimo.length);
        tamPantalla = 720;
        tamCelda = tamPantalla / filas;
        setPreferredSize(new Dimension(tamPantalla, tamPantalla));
        setSize(new Dimension(tamPantalla, tamPantalla));
    }

    public void paint(Graphics graphics) {
        Graphics2D grafico = (Graphics2D) graphics;
        grafico.setPaint(new Color(4, 6, 26));
        grafico.fillRect(0,0, tamPantalla, tamPantalla);



        grafico.setPaint(new Color(245, 194, 12));
        int x = 0, y = 0;
        int antX = x, antY = y;
        grafico.translate(tamPantalla/2, tamPantalla/2);
        int numPasos = 1;
        int estado = E, contadorGiros = 1;
        float grosorLinea = tamCelda * 0.05f;
        int tamCirculo = (int) (tamCelda*0.7);

        for (int i = 1; i <= filas*filas; i++) {
            grafico.setStroke(new BasicStroke(grosorLinea));
            grafico.drawLine(antX, antY, x, y);
            if (esPrimo[i-1]) {
                grafico.setStroke(new BasicStroke(0));
                grafico.fillOval(x-tamCirculo/2, y-tamCirculo/2,
                        tamCirculo,tamCirculo);
            }
            antX = x;
            antY = y;
            switch (estado) {
                case E -> x += tamCelda;
                case S -> y -= tamCelda;
                case W -> x -= tamCelda;
                case N -> y += tamCelda;
            }

            if (i % numPasos == 0) {
                estado = (estado + 1) % 4;
                contadorGiros++;
                if (contadorGiros % 2 == 0) {
                    numPasos++;
                }
            }
        }
    }
}
