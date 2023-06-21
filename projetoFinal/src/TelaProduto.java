import java.awt.*;
import javax.swing.*;

public class TelaProduto extends Tela {
    
    private ImageIcon blusaProduto;
    private ImageIcon tituloProduto;
    private ImageIcon descricaoProduto;
    private int precoBlusa;
    private char tamanhoBlusa;
    //private BarraTamanho barraTamanho
    // barra com 3 botoes de p, m, g

    public JLayeredPane paneTelaProduto;
    public JButton botaoTamanhoP;
    public JButton botaoTamanhoM;
    public JButton botaoTamanhoG;

    public TelaProduto(boolean mostrarBarraNavegacao, BarraNavegacao barraNavegacao, ImageIcon blusaProduto, ImageIcon tituloProduto, ImageIcon descricaoProduto){
        
        super(mostrarBarraNavegacao, barraNavegacao);
        this.blusaProduto = blusaProduto;
        this.tituloProduto = tituloProduto;
        this.descricaoProduto = descricaoProduto;
        this.precoBlusa = 100;
        this.tamanhoBlusa = 'd'; // comeca como default

        // Definicao do layout do layeredPane
        paneTelaProduto = new JLayeredPane();
        paneTelaProduto.setPreferredSize(new Dimension(390, 844));

        // Adicionando a imagem de fundo 
        ImageIcon imagemFundo = new ImageIcon("lib/TelaFundoProduto.jpg"); // alterar a imagem para a própria da tela produto
        JLabel painelImagemFundo = new JLabel(imagemFundo);
        painelImagemFundo.setBounds(0, 0, 390, 844);

        // Criando um Label para as imagens da blusa, do titulo e da descrição
        JLabel labelBlusaProduto = new JLabel(blusaProduto);
        JLabel labelTituloProdutoAbaixo = new JLabel(tituloProduto); // título de baixo
        JLabel labelTituloProdutoAcima = new JLabel(tituloProduto); // titulo de cima
        JLabel labelDescricaoProduto = new JLabel(descricaoProduto);

        // Ajustando o tamanho das imagens da blusa, do título e da descrição
        labelBlusaProduto.setBounds(63, 230, 283, 219);
        labelTituloProdutoAbaixo.setBounds(40, 571, 274, 71);
        labelTituloProdutoAcima.setBounds(29, 113, 274, 71);
        labelDescricaoProduto.setBounds(40, 633, 350, 120);

        // Carregando as Imagens dos botões
        ImageIcon imagemBotaoP = new ImageIcon("lib/tamanhoP.jpg");
        ImageIcon imagemBotaoM = new ImageIcon("lib/tamanhoM.jpg");
        ImageIcon imagemBotaoG = new ImageIcon("lib/tamanhoG.jpg");

        // Adicionando Imagens aos botões dos tamanhos
        JButton botaoTamanhoP = new JButton(imagemBotaoP);
        JButton botaoTamanhoM = new JButton(imagemBotaoM);
        JButton botaoTamanhoG = new JButton(imagemBotaoG);

        // Ajustando o tamanho e posicionamento dos botões dos tamanhos
        botaoTamanhoP.setBounds(55, 505, 37, 45);
        botaoTamanhoM.setBounds(176, 505, 37, 45);
        botaoTamanhoG.setBounds(295, 505, 37, 45);

        // Ajustando a borda dos botões
        botaoTamanhoP.setBorderPainted(false);
        botaoTamanhoM.setBorderPainted(false);
        botaoTamanhoG.setBorderPainted(false);
        
        // Ajustando as camadas do panel que serão colocadas as imagens
        paneTelaProduto.add(painelImagemFundo, Integer.valueOf(0));
        paneTelaProduto.add(labelBlusaProduto, Integer.valueOf(2));
        paneTelaProduto.add(labelTituloProdutoAbaixo, Integer.valueOf(1));
        paneTelaProduto.add(labelTituloProdutoAcima, Integer.valueOf(1));
        paneTelaProduto.add(labelDescricaoProduto,  Integer.valueOf(1));

        // Ajustando as camadas do panel que serão colocados os botões
        paneTelaProduto.add(botaoTamanhoP, Integer.valueOf(2));
        paneTelaProduto.add(botaoTamanhoM, Integer.valueOf(2));
        paneTelaProduto.add(botaoTamanhoG, Integer.valueOf(2));

    }

    public JLayeredPane getLayeredPane(){
        return this.paneTelaProduto;
    }

    public ImageIcon getImageBlusaProduto(){
        return this.blusaProduto;
    }

    public ImageIcon getImageTituloProduto(){
        return this.tituloProduto;
    }

    public int getPrecoBlusaProduto(){
        return this.precoBlusa;
    }

    public char getTamanhoBlusa(){
        return this.tamanhoBlusa;
    }

    public void setTamanhoBlusa(char tamanhoBlusa){ // somente P, M ou G
        this.tamanhoBlusa = tamanhoBlusa;
    }

}
