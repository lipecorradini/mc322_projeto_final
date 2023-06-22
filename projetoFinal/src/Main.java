import javax.swing.*;
import java.awt.*;

public class Main extends JFrame {
    public CardLayout layoutTelas;
    public JPanel painelPrincipal;
    public JFrame framePrincipal;

    public TelaHome telaHome;
    public TelaLoginCadastro telaLoginCadastro;
    public TelaEssentials telaEssentials;
    public TelaProduto telaCamisetaPreta;
    public TelaProduto telaCamisetaMarrom;
    public TelaProduto telaCamisetaOffWhite;
    public TelaProduto telaCamisetaBranca;
    public BarraNavegacao barraNavegacao;

    public Main() {
        //instanciando layout e panel
        layoutTelas = new CardLayout();
        painelPrincipal = new JPanel(layoutTelas);
        framePrincipal = new JFrame();

        //instanciando telas
        barraNavegacao = new BarraNavegacao(); 
        telaHome = new TelaHome(false, this);
        telaLoginCadastro = new TelaLoginCadastro(false, this);
        telaEssentials = new TelaEssentials(true, this);
        telaCamisetaPreta = new TelaProduto(false, new ImageIcon("lib/camisetaPretaTras.jpg"), new ImageIcon("lib/tituloCamisetaPreta.jpg"), new ImageIcon("lib/TESTEdescricao.jpg"), this);
        telaCamisetaMarrom = new TelaProduto(false, new ImageIcon("lib/camisetaMarromTras.jpg"), new ImageIcon("lib/tituloCamisetaMarrom.jpg"), new ImageIcon("lib/TESTEdescricao.jpg"), this);
        telaCamisetaOffWhite = new TelaProduto(false, new ImageIcon("lib/camisetaOffWhiteTras.jpg"), new ImageIcon("lib/tituloCamisetaOffWhite.jpg"), new ImageIcon("lib/TESTEdescricao.jpg"), this);
        telaCamisetaBranca = new TelaProduto(false, new ImageIcon("lib/camisetaBrancaTras.jpg"), new ImageIcon("lib/tituloCamisetaBranca.jpg"), new ImageIcon("lib/TESTEdescricao.jpg"), this);

        //Adicionando telas ao painel 
        painelPrincipal.add(telaHome.getLayeredPane(), "Home");
        painelPrincipal.add(telaLoginCadastro.getPainelLoginCadastro(), "Login");
        painelPrincipal.add(telaEssentials.getEssentialsPane(), "Essentials");
        painelPrincipal.add(telaCamisetaPreta.getLayeredPane(), "Preta");
        painelPrincipal.add(telaCamisetaMarrom.getLayeredPane(), "Marrom");
        painelPrincipal.add(telaCamisetaOffWhite.getLayeredPane(), "OffWhite");
        painelPrincipal.add(telaCamisetaBranca.getLayeredPane(), "Branca");
        painelPrincipal.add(barraNavegacao.getBarraNavPanel(), "Barra");

        //Settando frame do aplicativo
        framePrincipal.getContentPane().add(painelPrincipal);
        framePrincipal.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        framePrincipal.setSize(390, 844);
        framePrincipal.setLocationRelativeTo(null);
        framePrincipal.setVisible(true);
    }

    public void mostrarTela(String nomeTela ) { // boolean mostrarBarraNavegacao
        layoutTelas.show(painelPrincipal, nomeTela);
        // if (mostrarBarraNavegacao) {
        //     layoutTelas.show(painelPrincipal, "Barra");
        // }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new Main();
        });

    }
}
