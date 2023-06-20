import javax.swing.*;
import java.awt.*;

public class TelaLoginCadastro extends Tela {
    public JFrame frameLoginCadastro;
    public JTextField textFieldUsuario;
    public JPasswordField passwordFieldSenha;
    public JButton botaoLogin;
    public JButton botaoCadastro;
    public JLabel labelUsuario;
    public JLabel labelSenha;

    //Constructor
    public TelaLoginCadastro(boolean mostrarBarraNavegacao,
                            Color backgroundColor,
                            BarraNavegacao barraNavegacao,
                            boolean estaLogado,
                            String titulo,
                            JFrame frame) {
        super(mostrarBarraNavegacao, backgroundColor, barraNavegacao, estaLogado, titulo, frame);
        
        //Criação e setup do frame
        this.frameLoginCadastro = new JFrame();
        this.frameLoginCadastro.setSize(390, 844);
        titulo = "Login e Cadastro";
        this.frameLoginCadastro.setTitle(titulo);
        this.frameLoginCadastro.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.frameLoginCadastro.setLocationRelativeTo(null);
        this.frameLoginCadastro.setLayout(new FlowLayout());

        //Criação do campo de usuário e senha
        this.textFieldUsuario = new JTextField(10);
        this.labelUsuario = new JLabel("Usuário: ");
        labelUsuario.setLabelFor(textFieldUsuario);

        this.passwordFieldSenha = new JPasswordField(10);
        this.labelSenha = new JLabel("Usuário: ");
        labelSenha.setLabelFor(passwordFieldSenha);

        //Adiciona componentes ao frame
        this.frameLoginCadastro.add(labelUsuario);
        this.frameLoginCadastro.add(textFieldUsuario);
        this.frameLoginCadastro.add(labelSenha);
        this.frameLoginCadastro.add(passwordFieldSenha);

    }

    public JFrame getFrameLoginCadastro() {
        return this.frameLoginCadastro;
    }
}