import javax.swing.*;
import java.awt.*;

public class TelaLoginCadastro extends Tela {
    public JLayeredPane paneCamadasLoginCadastro;
    public JPanel painelLoginCadastro;
    public JTextField textFieldUsuario;
    public JPasswordField passwordFieldSenha;
    public JButton botaoLogin;
    public JButton botaoCadastro;
    public JLabel labelUsuario;
    public JLabel labelSenha;

    //Constructor
    public TelaLoginCadastro(boolean mostrarBarraNavegacao,
                            Color backgroundColor) {
        super(mostrarBarraNavegacao, backgroundColor);

        paneCamadasLoginCadastro = new JLayeredPane();
        paneCamadasLoginCadastro.setPreferredSize(new Dimension(390, 844));

        //Criando painel login
        SpringLayout layout = new SpringLayout();
        painelLoginCadastro = new JPanel(layout);
        painelLoginCadastro.setBackground(Color.white);
        painelLoginCadastro.setBounds(100, 309, 500, 100);
        painelLoginCadastro.setOpaque(false);

        //Criando textfields e labels para login e cadastro
        this.textFieldUsuario = new JTextField(10);
        this.textFieldUsuario.setPreferredSize(new Dimension(100, 30));
        this.labelUsuario = new JLabel("Usuário: ");
        this.labelUsuario.setLabelFor(textFieldUsuario);

        this.passwordFieldSenha = new JPasswordField(10);
        this.passwordFieldSenha.setPreferredSize(new Dimension(100, 30));
        this.labelSenha = new JLabel("Senha: ");
        this.labelSenha.setLabelFor(passwordFieldSenha);

        // Adicionando labels no painel
        this.painelLoginCadastro.add(labelUsuario);
        this.painelLoginCadastro.add(textFieldUsuario);
        this.painelLoginCadastro.add(labelSenha);
        this.painelLoginCadastro.add(passwordFieldSenha);

        //Settando Spring Layout
        String norte = SpringLayout.NORTH;
        String oeste = SpringLayout.WEST;
        String leste = SpringLayout.EAST;
        String sul = SpringLayout.SOUTH;
        
        layout.putConstraint(oeste, labelUsuario, 5, oeste, painelLoginCadastro);
        layout.putConstraint(norte, labelUsuario, 7, norte, painelLoginCadastro);
        layout.putConstraint(oeste, textFieldUsuario, 5, leste, labelUsuario);
        layout.putConstraint(norte, textFieldUsuario, 2, norte, painelLoginCadastro);

        layout.putConstraint(oeste, labelSenha, 9, oeste, painelLoginCadastro);
        layout.putConstraint(norte, labelSenha, 33, sul, labelUsuario);
        layout.putConstraint(oeste, passwordFieldSenha, 12, leste, labelSenha);
        layout.putConstraint(norte, passwordFieldSenha, 20, sul, textFieldUsuario);

        //Importando e colocando imagem de fundo
        ImageIcon imagemFundo = new ImageIcon("lib/Login.jpg");
        JLabel labelImagemFundo = new JLabel(imagemFundo);
        labelImagemFundo.setBounds(0, 0, 390, 844);

        //Criando botões de login e cadastro e setando suas posições
        ImageIcon iconImagemBotaoCadastro = new ImageIcon("lib/botaoCadastrar.jpg");
        ImageIcon iconImagemBotaoLogin = new ImageIcon("lib/botaoLogin.jpg");
        botaoCadastro = new JButton(iconImagemBotaoCadastro);
        botaoLogin = new JButton(iconImagemBotaoLogin);
        botaoCadastro.setBorderPainted(false);
        botaoLogin.setBorderPainted(false);
        botaoCadastro.setBounds(123, 454, 143, 47);
        botaoLogin.setBounds(123, 520, 143, 47);

        //Adicionando as camadas ao pane
        paneCamadasLoginCadastro.add(labelImagemFundo, Integer.valueOf(0));
        paneCamadasLoginCadastro.add(painelLoginCadastro, Integer.valueOf(1));
        paneCamadasLoginCadastro.add(botaoCadastro, Integer.valueOf(2));
        paneCamadasLoginCadastro.add(botaoLogin, Integer.valueOf(3));
    }

    public JLayeredPane getPainelLoginCadastro() {
        return this.paneCamadasLoginCadastro;
    }
}