import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.RenderingHints;
import java.awt.event.ActionEvent;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;

/** Atividade prática: menus, painéis, fontes, cores e eventos em Java Swing. */
public class ControleClientes extends JFrame {
    private static final String INICIAL = "inicial";
    private static final String CADASTRO = "cadastro";
    private static final String RELATORIOS = "relatorios";
    private final CardLayout cards = new CardLayout();
    private final JPanel conteudo = new JPanel(cards);

    public ControleClientes() {
        super("MENU, ITENS DE MENU, FONTES");
        configurarJanela();
        setJMenuBar(criarMenu());
        conteudo.add(criarPainelInicial(), INICIAL);
        conteudo.add(criarPainelCadastro(), CADASTRO);
        conteudo.add(criarPainelRelatorios(), RELATORIOS);
        add(conteudo, BorderLayout.CENTER);
        cards.show(conteudo, INICIAL);
    }

    private void configurarJanela() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(600, 400);
        setMinimumSize(new Dimension(600, 400));
        setResizable(false);
        setLocationRelativeTo(null);
        getContentPane().setBackground(new Color(238, 238, 238));
    }

    private JMenuBar criarMenu() {
        JMenuBar barra = new JMenuBar();
        barra.setFont(new Font("Arial", Font.PLAIN, 12));
        JMenu arquivo = new JMenu("Arquivo");
        JMenuItem novo = new JMenuItem("Novo", UIManager.getIcon("FileView.fileIcon"));
        novo.addActionListener(e -> cards.show(conteudo, CADASTRO));
        JMenuItem sair = new JMenuItem("Sair", UIManager.getIcon("OptionPane.errorIcon"));
        sair.addActionListener(e -> dispose());
        arquivo.add(novo);
        arquivo.add(sair);

        JMenu relatorio = new JMenu("Relatório");
        JMenuItem cliente = new JMenuItem("Cliente", UIManager.getIcon("OptionPane.informationIcon"));
        cliente.addActionListener(e -> { cards.show(conteudo, RELATORIOS); mostrarRelatorioClientes(e); });
        JMenuItem fornecedor = new JMenuItem("Fornecedor", UIManager.getIcon("OptionPane.informationIcon"));
        fornecedor.addActionListener(e -> { cards.show(conteudo, RELATORIOS); mostrarRelatorioFornecedores(e); });
        relatorio.add(cliente);
        relatorio.add(fornecedor);

        JMenu sobre = new JMenu("Sobre");
        JMenuItem info = new JMenuItem("Info", UIManager.getIcon("OptionPane.questionIcon"));
        info.addActionListener(e -> JOptionPane.showMessageDialog(this,
                "Atividade prática de Java Swing\nAluno: SEU NOME AQUI", "Sobre", JOptionPane.INFORMATION_MESSAGE));
        sobre.add(info);
        barra.add(arquivo);
        barra.add(relatorio);
        barra.add(sobre);
        return barra;
    }

    private JPanel criarPainelInicial() {
        JPanel painel = new JPanel(new GridBagLayout());
        painel.setBackground(Color.YELLOW);
        painel.setBorder(BorderFactory.createEmptyBorder(25, 20, 15, 20));
        GridBagConstraints c = new GridBagConstraints();
        c.gridx = 0;
        c.fill = GridBagConstraints.HORIZONTAL;
        JLabel titulo = new JLabel("CONTROLE DE CLIENTES", SwingConstants.CENTER);
        titulo.setForeground(new Color(0, 110, 0));
        titulo.setFont(new Font("Arial", Font.BOLD, 18));
        c.gridy = 0;
        c.weighty = 0.20;
        painel.add(titulo, c);
        c.gridy = 1;
        c.weighty = 0.65;
        c.fill = GridBagConstraints.NONE;
        painel.add(new LogoUnifagoc(), c);
        JButton cadastrar = criarBotao("Novo cadastro");
        cadastrar.addActionListener(e -> cards.show(conteudo, CADASTRO));
        c.gridy = 2;
        c.weighty = 0.15;
        painel.add(cadastrar, c);
        return painel;
    }

    private JPanel criarPainelCadastro() {
        JPanel painel = new JPanel(new GridBagLayout());
        painel.setBackground(new Color(255, 248, 190));
        painel.setBorder(BorderFactory.createEmptyBorder(25, 80, 25, 80));
        GridBagConstraints c = new GridBagConstraints();
        c.insets = new java.awt.Insets(7, 7, 7, 7);
        c.fill = GridBagConstraints.HORIZONTAL;
        JLabel titulo = new JLabel("CADASTRO DE CLIENTE", SwingConstants.CENTER);
        titulo.setFont(new Font("Arial", Font.BOLD, 18));
        titulo.setForeground(new Color(0, 100, 0));
        c.gridx = 0; c.gridy = 0; c.gridwidth = 2;
        painel.add(titulo, c);
        c.gridwidth = 1;
        adicionarCampo(painel, c, 1, "Nome:");
        adicionarCampo(painel, c, 2, "E-mail:");
        adicionarCampo(painel, c, 3, "Telefone:");
        JPanel botoes = new JPanel();
        botoes.setOpaque(false);
        JButton salvar = criarBotao("Salvar");
        salvar.addActionListener(e -> JOptionPane.showMessageDialog(this, "Cliente salvo com sucesso!"));
        JButton cancelar = criarBotao("Cancelar");
        cancelar.addActionListener(e -> cards.show(conteudo, INICIAL));
        botoes.add(salvar); botoes.add(cancelar);
        c.gridx = 0; c.gridy = 4; c.gridwidth = 2;
        painel.add(botoes, c);
        return painel;
    }

    private void adicionarCampo(JPanel painel, GridBagConstraints c, int linha, String texto) {
        c.gridx = 0; c.gridy = linha; c.weightx = 0;
        JLabel label = new JLabel(texto);
        label.setFont(new Font("Arial", Font.BOLD, 13));
        painel.add(label, c);
        c.gridx = 1; c.weightx = 1;
        painel.add(new JTextField(18), c);
    }

    private JPanel criarPainelRelatorios() {
        JPanel painel = new JPanel(new BorderLayout(12, 25));
        painel.setBackground(new Color(255, 255, 100));
        painel.setBorder(BorderFactory.createEmptyBorder(45, 70, 45, 70));
        JLabel titulo = new JLabel("RELATÓRIOS", SwingConstants.CENTER);
        titulo.setFont(new Font("Arial", Font.BOLD, 20));
        titulo.setForeground(new Color(0, 100, 0));
        painel.add(titulo, BorderLayout.NORTH);
        JPanel botoes = new JPanel(new GridLayout(1, 2, 20, 0));
        botoes.setOpaque(false);
        JButton clientes = criarBotao("Clientes");
        clientes.addActionListener(this::mostrarRelatorioClientes);
        JButton fornecedores = criarBotao("Fornecedores");
        fornecedores.addActionListener(this::mostrarRelatorioFornecedores);
        botoes.add(clientes);
        botoes.add(fornecedores);
        painel.add(botoes, BorderLayout.CENTER);
        return painel;
    }

    private JButton criarBotao(String texto) {
        JButton botao = new JButton(texto);
        botao.setFont(new Font("Arial", Font.BOLD, 13));
        botao.setBackground(new Color(50, 130, 100));
        botao.setForeground(Color.WHITE);
        botao.setFocusPainted(false);
        return botao;
    }

    private void mostrarRelatorioClientes(ActionEvent e) {
        JOptionPane.showMessageDialog(this, "Relatório de clientes");
    }

    private void mostrarRelatorioFornecedores(ActionEvent e) {
        JOptionPane.showMessageDialog(this, "Relatório de fornecedores");
    }

    /** Logo desenhado em Swing para não depender de arquivo externo. */
    private static class LogoUnifagoc extends JPanel {
        LogoUnifagoc() { setPreferredSize(new Dimension(168, 168)); setOpaque(false); }
        @Override protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            Graphics2D g2 = (Graphics2D) g.create();
            g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
            g2.setPaint(new GradientPaint(0, 0, new Color(70, 145, 130), 168, 168, new Color(46, 113, 101)));
            g2.fillRect(0, 0, 168, 168);
            g2.setColor(Color.WHITE);
            g2.setFont(new Font("Arial", Font.BOLD, 130));
            g2.drawString("U", 29, 130);
            g2.dispose();
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new ControleClientes().setVisible(true));
    }
}
