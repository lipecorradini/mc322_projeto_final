import javax.swing.ImageIcon;

public class Pedido {

    private String corProduto;
    private char tamanhoProduto;

    public ImageIcon imagemProduto;
    public ImageIcon tituloProduto; // pode ser String em ultimo caso

    public Pedido(String corProduto, char tamanhoProduto){
        this.corProduto = corProduto;
        this.tamanhoProduto = tamanhoProduto;

        // Instanciando as imagens e os títulos de acordo com o produto
        if (this.corProduto.equals("preta")) {
            this.imagemProduto = new ImageIcon("lib/camisetaPretaFrente.jpg");
            this.tituloProduto = new ImageIcon("lib/tituloCamisetaPreta.jpg");
        } else if (this.corProduto.equals("marrom")) {
            this.imagemProduto = new ImageIcon("lib/camisetaMarromFrente.jpg");
            this.tituloProduto = new ImageIcon("lib/tituloCamisetaMarrom.jpg");
        } else if (this.corProduto.equals("offwhite")) {
            this.imagemProduto = new ImageIcon("lib/camisetaOffWhiteFrente.jpg");
            this.tituloProduto = new ImageIcon("lib/tituloCamisetaOffWhite.jpg");
        } else if (this.corProduto.equals("branca")) {
            this.imagemProduto = new ImageIcon("lib/camisetaBrancaFrente.jpg");
            this.tituloProduto = new ImageIcon("lib/tituloCamisetaBranca.jpg");
        }
    }

    public String getCorProduto() {
        return corProduto;
    }
    
    public void setCorProduto(String corProduto) {
        this.corProduto = corProduto;
    }
    
    public char getTamanhoProduto() {
        return tamanhoProduto;
    }
    
    public void setTamanhoProduto(char tamanhoProduto) {
        this.tamanhoProduto = tamanhoProduto;
    }
    
    public ImageIcon getImagemProduto() {
        return imagemProduto;
    }
    
    public void setImagemProduto(ImageIcon imagemProduto) {
        this.imagemProduto = imagemProduto;
    }
    
    public ImageIcon getTituloProduto() {
        return tituloProduto;
    }
    
    public void setTituloProduto(ImageIcon tituloProduto) {
        this.tituloProduto = tituloProduto;
    }



    
    
}
