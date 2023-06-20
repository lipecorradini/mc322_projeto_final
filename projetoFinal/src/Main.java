


import javax.swing.*;

public class Main {

  public static void main(String[] args) {
    SwingUtilities.invokeLater(() -> {
      TelaHome telaHome = new TelaHome(
                                      false,
                                      null,
                                      new BarraNavegacao(),
                                      false,
                                      "null",
                                      new JFrame());
      //configuracao frame exibicao
      JFrame frameExibicao = new JFrame();
      frameExibicao.setSize(470, 930);
      frameExibicao.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      frameExibicao.add(telaHome.getLayeredPane());
      frameExibicao.setVisible(true);

      TelaLoginCadastro telaLoginCadastro = new TelaLoginCadastro(false,
                                                                  null, 
                                                                  new BarraNavegacao(), 
                                                                  false, 
                                                                  "null", 
                                                                  new JFrame());
      telaLoginCadastro.getFrameLoginCadastro().setVisible(true);
    });
    

  }
}
