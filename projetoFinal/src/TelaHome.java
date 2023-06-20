import java.awt.*;
import javax.swing.*;

public class TelaHome extends Tela {

  public JLayeredPane layeredPane;
  public JButton botaoExplorar;

  //Construtor
  public TelaHome(
    boolean mostrarBarraNavegacao,
    Color backgroundColor,
    BarraNavegacao barraNavegacao,
    boolean estaLogado,
    String titulo,
    JFrame frame
  ) {
    super(
      mostrarBarraNavegacao,
      backgroundColor,
      barraNavegacao,
      estaLogado,
      titulo,
      frame
    );


    //Definção de Layout
    layeredPane = new JLayeredPane();
    layeredPane.setPreferredSize(new Dimension(390, 844));

    //Painel da imagem de fundo
    JPanel painelImagem = new JPanel() {
      @Override
      public void paintComponent(Graphics g) {
        super.paintComponent(g);
        Image imagem = new ImageIcon(
          "/home/p8pablo/mc322_projeto_final/projetoFinal/lib/Home.jpg"
        )
          .getImage();
        g.drawImage(imagem, 0, 0, getWidth(), getHeight(), this);
      }
    };

    //Painel para o tamanho da imagem
    painelImagem.setBounds(0, 0, 390, 844);

    //Cria o botão
    ImageIcon imageIcon = new ImageIcon(
      "/home/p8pablo/mc322_projeto_final/projetoFinal/lib/Botao_explore.jpg"
    );
    botaoExplorar = new JButton(imageIcon);

    //Posiciona o botao
    botaoExplorar.setBounds(118, 642, 153, 39);

    // Adiciona o painel da imagem e o botão ao JLayeredPane em diferentes camadas
    layeredPane.add(painelImagem, Integer.valueOf(0)); // Camada mais baixa
    layeredPane.add(botaoExplorar, Integer.valueOf(1)); // Camada mais alta
    
  }


  public JLayeredPane getLayeredPane() {
    return this.layeredPane;
  }

  public void setLayeredPane(JLayeredPane layeredPane) {
    this.layeredPane = layeredPane;
  }

  public JButton getBotaoExplorar() {
    return this.botaoExplorar;
  }

  public void setBotaoExplorar(JButton botaoExplorar) {
    this.botaoExplorar = botaoExplorar;
  }


}
