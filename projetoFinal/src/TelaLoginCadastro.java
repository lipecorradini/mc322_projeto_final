import javax.swing.*;
import java.awt.*;

public class TelaLoginCadastro extends Tela {
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

        //Criando painel
        SpringLayout layout = new SpringLayout();
        painelLoginCadastro = new JPanel(layout);

        //Criando textfields e labels para login e cadastro
        this.textFieldUsuario = new JTextField(10);
        this.labelUsuario = new JLabel("Usuário: ");
        this.labelUsuario.setLabelFor(textFieldUsuario);

        this.passwordFieldSenha = new JPasswordField(10);
        this.labelSenha = new JLabel("Senha: ");
        this.labelSenha.setLabelFor(passwordFieldSenha);

        //Adicionando labels no painel
        this.painelLoginCadastro.add(labelUsuario);
        this.painelLoginCadastro.add(textFieldUsuario);
        this.painelLoginCadastro.add(labelSenha);
        this.painelLoginCadastro.add(passwordFieldSenha);

        //Settando Spring Layout
        String norte = SpringLayout.NORTH;
        String oeste = SpringLayout.WEST;
        String centroHorizontal = SpringLayout.HORIZONTAL_CENTER;
        String centroVertical = SpringLayout.VERTICAL_CENTER;

        layout.putConstraint(oeste, labelUsuario, -100, centroHorizontal, painelLoginCadastro);
        layout.putConstraint(norte, labelUsuario, -80, centroVertical, painelLoginCadastro);
        layout.putConstraint(oeste, textFieldUsuario,  -20, centroHorizontal, painelLoginCadastro);
        layout.putConstraint(norte, textFieldUsuario, -80, centroVertical, painelLoginCadastro);

        layout.putConstraint(oeste, labelSenha, -100, centroHorizontal, painelLoginCadastro);
        layout.putConstraint(norte, labelSenha, -40, centroVertical, painelLoginCadastro);
        layout.putConstraint(oeste, passwordFieldSenha, -20, centroHorizontal, painelLoginCadastro);
        layout.putConstraint(norte, passwordFieldSenha, -40, centroVertical, painelLoginCadastro);

        ImageIcon imagemFrase = new ImageIcon("../lib/frase_efeito_login_cadastro.jpeg");
        ImageIcon imagemLogo = new ImageIcon("../lib/logo_loja.jpeg");

        JLabel imagem1 = new JLabel(imagemFrase);
        this.painelLoginCadastro.add(imagem1);

    }

    public JPanel getPainelLoginCadastro() {
        return this.painelLoginCadastro;
    }
}