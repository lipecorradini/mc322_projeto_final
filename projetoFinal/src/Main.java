import javax.swing.*;
import java.awt.*;

public class Main extends JFrame {
    public CardLayout layoutTelas;
    public JPanel painelPrincipal;
    public JFrame framePrincipal;

    public TelaHome telaHome;
    public TelaLoginCadastro telaLoginCadastro;

    public Main() {
        //instanciando layout e panel
        layoutTelas = new CardLayout();
        painelPrincipal = new JPanel(layoutTelas);
        framePrincipal = new JFrame();

        //instanciando telas
        telaHome = new TelaHome(false, this);
        telaLoginCadastro = new TelaLoginCadastro(false, this);

        //Adicionando telas ao painel 
        painelPrincipal.add(telaHome.getLayeredPane(), "Home");
        painelPrincipal.add(telaLoginCadastro.getPainelLoginCadastro(), "Login / Cadastro");

        //Settando frame do aplicativo
        framePrincipal.getContentPane().add(painelPrincipal);
        framePrincipal.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        framePrincipal.setSize(390, 844);
        framePrincipal.setLocationRelativeTo(null);
        framePrincipal.setVisible(true);
    }

    public void mostrarTela(String nomeTela) {
        layoutTelas.show(painelPrincipal, nomeTela);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new Main();
        });

    }
}



    // public Main() {
    //     JFrame frameExibicao = new JFrame();
    //     frameExibicao.setSize(390, 844);
    //     frameExibicao.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    //     telaLoginCadastro.alteraVisibilidade(false);
    //     frameExibicao.add(telaLoginCadastro.getPainelLoginCadastro());
    //     telaHome.alteraVisibilidade(true);
    //     frameExibicao.add(telaHome.getLayeredPane());
    //     // telaHome.addActionListener(ouvidorHome);
    //     frameExibicao.setVisible(true);
    // }