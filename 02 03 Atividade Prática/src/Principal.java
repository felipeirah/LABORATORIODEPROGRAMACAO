import javax.swing.SwingUtilities;
import javax.swing.UIManager;

/** Ponto de entrada do Sistema Bancário. @author Felipe Junior */
public class Principal {
    public static void main(String[] args) {
        configurarAparencia();
        SwingUtilities.invokeLater(() -> new Janela().setVisible(true));
    }

    private static void configurarAparencia() {
        try {
            for (UIManager.LookAndFeelInfo info : UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    UIManager.setLookAndFeel(info.getClassName());
                    return;
                }
            }
        } catch (Exception ignored) {
            // A aplicação continua com a aparência padrão caso Nimbus não exista.
        }
    }
}
