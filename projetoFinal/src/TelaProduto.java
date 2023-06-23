import java.awt.*;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.lang.Math;

public class TelaProduto extends Tela implements ActionListener {
    private ImageIcon imagensCamiseta[];
    private ImageIcon tituloProduto;
    private ImageIcon descricaoProduto;
    private int precoBlusa;
    public int indiceFoto;
    private char tamanhoBlusa;
    public Main app;
    public JLayeredPane paneTelaProduto;
    public JLabel labelBlusaProduto;
    public JButton botaoTamanhoP;
    public JButton botaoTamanhoM;
    public JButton botaoTamanhoG;
    public JButton botaoVoltar;
    public JButton botaoAvancaFoto;
    public JButton botaoVoltaFoto;
    //private BarraTamanho barraTamanho
    // barra com 3 botoes de p, m, g

    public TelaProduto(boolean mostrarBarraNavegacao, 
                        String corCamiseta,
                        Main app){
        super(mostrarBarraNavegacao);
        organizaImagensTela(corCamiseta);
        this.precoBlusa = 100;
        this.tamanhoBlusa = 'd'; // comeca como default
        this.app = app;
        this.indiceFoto = 0;

        // Definicao do layout do layeredPane
        paneTelaProduto = new JLayeredPane();
        paneTelaProduto.setPreferredSize(new Dimension(390, 844));

        // Adicionando a imagem de fundo 
        ImageIcon imagemFundo = new ImageIcon("lib/TelaFundoProduto.jpg"); // alterar a imagem para a própria da tela produto
        JLabel painelImagemFundo = new JLabel(imagemFundo);
        painelImagemFundo.setBounds(0, 0, 390, 844);

        // Criando um Label para as imagens da blusa, do titulo e da descrição
        this.labelBlusaProduto = new JLabel();
        this.labelBlusaProduto.setIcon(imagensCamiseta[0]);
        JLabel labelTituloProdutoAbaixo = new JLabel(tituloProduto); // título de baixo
        JLabel labelTituloProdutoAcima = new JLabel(tituloProduto); // titulo de cima
        JLabel labelDescricaoProduto = new JLabel(descricaoProduto);

        // Ajustando o tamanho das imagens da blusa, do título e da descrição
        // labelBlusaProduto.setBounds(63, 230, 283, 219);
        labelBlusaProduto.setBounds(52, 241, 286, 217);
        labelTituloProdutoAbaixo.setBounds(40, 571, 274, 71);
        labelTituloProdutoAcima.setBounds(29, 113, 274, 71);
        labelDescricaoProduto.setBounds(40, 633, 350, 120);

        // Carregando as Imagens dos botões
        ImageIcon imagemBotaoP = new ImageIcon("lib/tamanhoP.jpg");
        ImageIcon imagemBotaoM = new ImageIcon("lib/tamanhoM.jpg");
        ImageIcon imagemBotaoG = new ImageIcon("lib/tamanhoG.jpg");
        ImageIcon imagemBotaoVoltar = new ImageIcon("lib/icon _arrow left_.png");
        ImageIcon imagemBotaoAvancaFoto = new ImageIcon("lib/botaoAvancaFoto.jpg");
        ImageIcon imagemBotaoVoltaFoto = new ImageIcon("lib/botaoVoltaFoto.jpg");

        // Adicionando Imagens aos botões dos tamanhos
        botaoTamanhoP = new JButton(imagemBotaoP);
        botaoTamanhoM = new JButton(imagemBotaoM);
        botaoTamanhoG = new JButton(imagemBotaoG);
        botaoVoltar = new JButton(imagemBotaoVoltar);
        botaoAvancaFoto = new JButton(imagemBotaoAvancaFoto);
        botaoVoltaFoto = new JButton(imagemBotaoVoltaFoto);

        // Ajustando o tamanho e posicionamento dos botões dos tamanhos
        botaoTamanhoP.setBounds(55, 505, 37, 45);
        botaoTamanhoM.setBounds(176, 505, 37, 45);
        botaoTamanhoG.setBounds(295, 505, 37, 45);
        botaoVoltar.setBounds(40, 44, 25, 18);
        botaoAvancaFoto.setBounds(350, 365, 14, 22);
        botaoVoltaFoto.setBounds(25, 368, 11, 19);

        // Ajustando a borda dos botões
        botaoTamanhoP.setBorderPainted(false);
        botaoTamanhoM.setBorderPainted(false);
        botaoTamanhoG.setBorderPainted(false);
        botaoVoltar.setBorderPainted(false);
        botaoVoltar.setBackground(new Color(0,0,0,0));
        botaoAvancaFoto.setBorderPainted(false);
        botaoVoltaFoto.setBorderPainted(false);

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
        paneTelaProduto.add(botaoVoltar, Integer.valueOf(2));
        paneTelaProduto.add(botaoAvancaFoto, Integer.valueOf(2));
        paneTelaProduto.add(botaoVoltaFoto, Integer.valueOf(2));
        
        // Action listener botao voltar
        botaoVoltar.addActionListener(this);
        botaoAvancaFoto.addActionListener(this);
        botaoVoltaFoto.addActionListener(this);
    }

    public JLayeredPane getLayeredPane(){
        return this.paneTelaProduto;
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

    public ImageIcon getTituloProduto() {
        return this.tituloProduto;
    }

    public void setTituloProduto(ImageIcon tituloProduto) {
        this.tituloProduto = tituloProduto;
    }

    public ImageIcon getDescricaoProduto() {
        return this.descricaoProduto;
    }

    public void setDescricaoProduto(ImageIcon descricaoProduto) {
        this.descricaoProduto = descricaoProduto;
    }

    public int getPrecoBlusa() {
        return this.precoBlusa;
    }

    public void setPrecoBlusa(int precoBlusa) {
        this.precoBlusa = precoBlusa;
    }

    public Main getApp() {
        return this.app;
    }

    public void setApp(Main app) {
        this.app = app;
    }

    public JLayeredPane getPaneTelaProduto() {
        return this.paneTelaProduto;
    }

    public void setPaneTelaProduto(JLayeredPane paneTelaProduto) {
        this.paneTelaProduto = paneTelaProduto;
    }

    public JButton getBotaoTamanhoP() {
        return this.botaoTamanhoP;
    }

    public void setBotaoTamanhoP(JButton botaoTamanhoP) {
        this.botaoTamanhoP = botaoTamanhoP;
    }

    public JButton getBotaoTamanhoM() {
        return this.botaoTamanhoM;
    }

    public void setBotaoTamanhoM(JButton botaoTamanhoM) {
        this.botaoTamanhoM = botaoTamanhoM;
    }

    public JButton getBotaoTamanhoG() {
        return this.botaoTamanhoG;
    }

    public void setBotaoTamanhoG(JButton botaoTamanhoG) {
        this.botaoTamanhoG = botaoTamanhoG;
    }

    public JButton getBotaoAvancaFoto() {
        return this.botaoAvancaFoto;
    }

    public void setBotaoAvancaFoto(JButton botaoAvancaFoto) {
        this.botaoAvancaFoto = botaoAvancaFoto;
    }

    public JButton getBotaoVoltaFoto() {
        return this.botaoVoltaFoto;
    }

    public void setbotaoVoltaFoto(JButton botaoVoltaFoto) {
        this.botaoVoltaFoto = botaoVoltaFoto;
    }

    public JButton getBotaoVoltar() {
        return this.botaoVoltar;
    }

    public void setBotaoVoltar(JButton botaoVoltar) {
        this.botaoVoltar = botaoVoltar;
    }
    
    public void organizaImagensTela(String corCamiseta) {
        this.imagensCamiseta = new ImageIcon[2];
        if (corCamiseta.equals("preta")) {
            this.imagensCamiseta[0] = new ImageIcon("lib/camisetaPretaFrente.jpg");
            this.imagensCamiseta[1] = new ImageIcon("lib/camisetaPretaTras.jpg");
            this.tituloProduto = new ImageIcon("lib/tituloCamisetaPreta.jpg");
        } else if (corCamiseta.equals("marrom")) {
            this.imagensCamiseta[0] = new ImageIcon("lib/camisetaMarromFrente.jpg");
            this.imagensCamiseta[1] = new ImageIcon("lib/camisetaMarromTras.jpg");
            this.tituloProduto = new ImageIcon("lib/tituloCamisetaMarrom.jpg");
        } else if (corCamiseta.equals("offwhite")) {
            this.imagensCamiseta[0] = new ImageIcon("lib/camisetaOffWhiteFrente.jpg");
            this.imagensCamiseta[1] = new ImageIcon("lib/camisetaOffWhiteTras.jpg");
            this.tituloProduto = new ImageIcon("lib/tituloCamisetaOffWhite.jpg");
        } else if (corCamiseta.equals("branca")) {
            this.imagensCamiseta[0] = new ImageIcon("lib/camisetaBrancaFrente.jpg");
            this.imagensCamiseta[1] = new ImageIcon("lib/camisetaBrancaTras.jpg");
            this.tituloProduto = new ImageIcon("lib/tituloCamisetaBranca.jpg");
        }
        this.descricaoProduto = new ImageIcon("lib/TESTEdescricao.jpg");
    }

    public int decideIndiceImagem(int indice) {
        if (Math.abs(indice) % 2 == 0) {
            return 0;
        } else {
            return 1;
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == getBotaoVoltar()) {
            app.mostrarTela("Essentials");
        } else if (e.getSource() == getBotaoAvancaFoto()) {
            this.indiceFoto++;
            this.labelBlusaProduto.setIcon(imagensCamiseta[decideIndiceImagem(indiceFoto)]);
        } else if (e.getSource() == getBotaoVoltaFoto()) {
            this.indiceFoto--;
            this.labelBlusaProduto.setIcon(imagensCamiseta[decideIndiceImagem(indiceFoto)]);
        }
        
    }

}
