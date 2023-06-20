import javax.swing.*;
import java.awt.*;

public class TelaHome extends Tela {

  public JButton botaoExplorar;
  public JFrame frameHome;

  //Construtor
  public TelaHome(JButton botaoExplorar,
                  JFrame frameHome,
                  boolean mostrarBarraNavegacao,
                  Color backgroundColor,
                  BarraNavegacao barraNavegacao,
                  boolean estaLogado,
                  String titulo,
                  JFrame frame) {
    super(mostrarBarraNavegacao, backgroundColor, barraNavegacao, estaLogado, titulo, frame);
    this.frameHome = new JFrame();
    this.frameHome.setSize(390, 844);

    //Configurações básicas da Janela
    titulo = "Tela Home";
    this.frameHome.setTitle(titulo);
    this.frameHome.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    this.frameHome.setLocationRelativeTo(null);

    //Definção de Layout
    this.frameHome.setLayout(new BorderLayout());

    //Painel da imagem de fundo
    JPanel painelImagem = new JPanel(){
        @Override
        public void paintComponent(Graphics g){
            super.paintComponent(g);
            Image imagem = new ImageIcon("/home/p8pablo/mc322_projeto_final/projetoFinal/lib/Home.jpg").getImage();
            g.drawImage(imagem, 0, 0, getWidth(), getHeight(), this);
        }
    };

    //Painel para o tamanho da imagem
    painelImagem.setPreferredSize(new Dimension(390, 844));

    //Painel para o botão
    JPanel painelBotao = new JPanel(new FlowLayout(FlowLayout.CENTER));

    //Cria o botão
    this.botaoExplorar = new JButton("Explore");

    //Adiciona o botão ao seu painel
    painelBotao.add(botaoExplorar);

    //Adiciona os paineis ao frame
    this.frameHome.add(painelImagem, BorderLayout.CENTER);
    this.frameHome.add(painelBotao, BorderLayout.SOUTH);
  }

    public JButton getBotaoExplorar() {
        return this.botaoExplorar;
    }

    public void setBotaoExplorar(JButton botaoExplorar) {
        this.botaoExplorar = botaoExplorar;
    }

    public JFrame getFrameHome() {
        return this.frameHome;
    }


    

}
