package screens;

import javax.swing.*;

public class Main {

  public static void main(String[] args) {
    SwingUtilities.invokeLater(() -> {
      TelaHome telaHome = new TelaHome(
        new JButton(),
        new JFrame(),
        false,
        null,
        new BarraNavegacao(),
        false,
        "null",
        new JFrame()
      );
      telaHome.getFrameHome().setVisible(true);
    });
  }
}
