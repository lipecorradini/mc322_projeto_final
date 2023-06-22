import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.io.FileWriter;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class TelaLoginCadastro extends Tela implements ActionListener{
    public JLayeredPane paneCamadasLoginCadastro;
    public JPanel painelLoginCadastro;
    public JTextField textFieldUsuario;
    public JPasswordField passwordFieldSenha;
    public JButton botaoLogin;
    public JButton botaoCadastro;
    public JLabel labelUsuario;
    public JLabel labelSenha;
    public Main app;
    public boolean mostrarBarraNavegacao;

    //Constructor
    public TelaLoginCadastro(boolean mostrarBarraNavegacao,
                            Main app) {
        super(mostrarBarraNavegacao);
        this.app = app;

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
        botaoCadastro.addActionListener(this);
        botaoLogin.addActionListener(this);
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

    public boolean createUser(String username, String password) {
        try {
            String nomeNovoArquivo = "users/" + username + ".txt";
            File arquivo = new File(nomeNovoArquivo);
            if (arquivo.createNewFile()) {
                try {
                    FileWriter editorArquivo = new FileWriter(nomeNovoArquivo);
                    editorArquivo.write(username + "\n" + password);
                    editorArquivo.close();
                    return true;
                } catch (IOException f) {
                    f.printStackTrace();
                    return false;
                } 
            } else {
                return false;
            }
        } catch (IOException e) {
            return false;
        }
    }

    public boolean checksUser(String tentativaUsername, String tentativaPassowrd) {
        try {
            String nomeArquivo = "users/" + tentativaUsername + ".txt";
            File arquivo = new File(nomeArquivo);
            Scanner scanner = new Scanner(arquivo);
            int i = 0;
            while (scanner.hasNextLine()) {
                i++;
                if (i == 1) { //looking at first line, t.i., username
                    if (tentativaUsername == scanner.nextLine()) {
                        continue;
                    } else {
                        return false;
                    }
                } else { //looking at second line, t.i., passowrd
                    if (tentativaPassowrd == scanner.next()) {
                        return true;
                    } else {
                        return false;
                    }
                }
            }
            scanner.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            return false;
        }
        return false;
    }

    public void alteraVisibilidade(boolean bool) {
        if (bool == true) {
            paneCamadasLoginCadastro.setVisible(true);
        } else {
            paneCamadasLoginCadastro.setVisible(false);
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == botaoLogin) {
            String tentativaUser = textFieldUsuario.getText();
            String tentativaSenha = String.valueOf(passwordFieldSenha.getPassword());
            boolean temp = checksUser(tentativaUser, tentativaSenha);
            if (temp) {
                System.out.println("LOGIN FEITO");
            } else {
                System.out.println("DEU RUIM");
            }
        } else if (e.getSource() == botaoCadastro) {
            String novoUser = textFieldUsuario.getText();
            String novoSenha = String.valueOf(passwordFieldSenha.getPassword());
            boolean temp = createUser(novoUser, novoSenha);
        }
    }
}