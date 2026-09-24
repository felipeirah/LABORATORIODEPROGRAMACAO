import java.awt.event.KeyEvent;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JRadioButton;
import javax.swing.JSeparator;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

/** Formulário bancário da atividade prática 02 | 03. */
public class Janela extends JFrame {
    private JLabel jlAgencia;
    private JTextField jtfAgencia;
    private JLabel jlConta;
    private JTextField jtfConta;
    private JSeparator jSeparator01;
    private JLabel jlNome;
    private JTextField jtfNome;
    private JLabel jlEndereco;
    private JTextField jtfEndereco;
    private JLabel jlTelefone;
    private JTextField jtfTelefone;
    private JLabel jlCpf;
    private JTextField jtfCpf;
    private JRadioButton jrbCorrente;
    private JRadioButton jrbPoupanca;
    private ButtonGroup bgContas;
    private JSeparator jSeparator02;
    private JButton jbConsultar;
    private JButton jbAtualizar;
    private JButton jbFechar;

    public Janela() {
        super("Laboratório de Programação");
        setSize(400, 255);
        setLocationRelativeTo(null);
        setResizable(false);
        getContentPane().setLayout(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        criarComponentes();
    }

    private void criarComponentes() {
        jlAgencia = new JLabel("Código da Agência:");
        jlAgencia.setBounds(10, 10, 110, 18);
        add(jlAgencia);
        jtfAgencia = new JTextField();
        jtfAgencia.setBounds(125, 10, 50, 20);
        add(jtfAgencia);
        jlConta = new JLabel("Número da Conta:");
        jlConta.setBounds(205, 10, 105, 18);
        add(jlConta);
        jtfConta = new JTextField();
        jtfConta.setBounds(315, 10, 60, 20);
        add(jtfConta);
        jSeparator01 = new JSeparator();
        jSeparator01.setBounds(10, 40, 365, 10);
        add(jSeparator01);

        jlNome = criarRotuloDireita("Nome:", 10, 50);
        jtfNome = criarCampo(75, 50);
        jlEndereco = criarRotuloDireita("Endereço:", 10, 75);
        jtfEndereco = criarCampo(75, 75);
        jlTelefone = criarRotuloDireita("Telefone:", 10, 100);
        jtfTelefone = criarCampo(75, 100);
        jlCpf = criarRotuloDireita("CPF:", 10, 125);
        jtfCpf = criarCampo(75, 125);

        jrbCorrente = new JRadioButton("Conta Corrente");
        jrbCorrente.setBounds(100, 150, 111, 20);
        jrbCorrente.setMnemonic(KeyEvent.VK_C);
        jrbCorrente.setSelected(true);
        add(jrbCorrente);
        jrbPoupanca = new JRadioButton("Conta Poupança");
        jrbPoupanca.setBounds(225, 150, 118, 20);
        jrbPoupanca.setMnemonic(KeyEvent.VK_P);
        add(jrbPoupanca);
        bgContas = new ButtonGroup();
        bgContas.add(jrbCorrente);
        bgContas.add(jrbPoupanca);

        jSeparator02 = new JSeparator();
        jSeparator02.setBounds(10, 180, 365, 10);
        add(jSeparator02);
        jbConsultar = new JButton("Consultar");
        jbConsultar.setBounds(35, 190, 100, 23);
        jbConsultar.setMnemonic(KeyEvent.VK_S);
        jbConsultar.addActionListener(e -> jbAtualizar.setEnabled(true));
        add(jbConsultar);
        jbAtualizar = new JButton("Atualizar");
        jbAtualizar.setBounds(145, 190, 100, 23);
        jbAtualizar.setMnemonic(KeyEvent.VK_A);
        jbAtualizar.setEnabled(false);
        add(jbAtualizar);
        jbFechar = new JButton("Fechar");
        jbFechar.setBounds(225, 190, 100, 23);
        jbFechar.setMnemonic(KeyEvent.VK_F);
        jbFechar.addActionListener(e -> dispose());
        add(jbFechar);
    }

    private JLabel criarRotuloDireita(String texto, int x, int y) {
        JLabel rotulo = new JLabel(texto);
        rotulo.setHorizontalAlignment(SwingConstants.RIGHT);
        rotulo.setBounds(x, y, 60, 18);
        add(rotulo);
        return rotulo;
    }

    private JTextField criarCampo(int x, int y) {
        JTextField campo = new JTextField();
        campo.setBounds(x, y, 300, 20);
        add(campo);
        return campo;
    }
}
