import javax.swing.*;
import java.awt.*;

public class Ventana extends JFrame {

    public Ventana (boolean[] esPrimo) {
        setTitle("Prime spiral");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        // setLocationRelativeTo(null);
        Panel panel = new Panel(esPrimo);
        add(panel, BorderLayout.CENTER);
        pack();
        setVisible(true);
    }
}
