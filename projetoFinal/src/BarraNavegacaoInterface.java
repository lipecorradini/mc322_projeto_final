import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public interface BarraNavegacaoInterface {
    JPanel getBarraNavPanel();

    void setBarraNavPanel(JPanel barraNavPanel);

    JButton getBotaoHome();

    void setBotaoHome(JButton botaoHome);

    JButton getBotaoPerfil();

    void setBotaoPerfil(JButton botaoPerfil);

    JButton getBotaoCarrinho();

    void setBotaoCarrinho(JButton botaoCarrinho);

    void actionPerformed(ActionEvent e);
}
