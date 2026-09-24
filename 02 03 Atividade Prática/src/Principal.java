import javax.swing.SwingUtilities;

/** Ponto de entrada da aplicação. */
public class Principal {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new Janela().setVisible(true));
    }
}
