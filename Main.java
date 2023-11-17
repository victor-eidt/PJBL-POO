import javax.swing.*;

public class Main {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            GerenciadorProdutos gerenciador = new GerenciadorProdutos();
            ProductManagerFrame frame = new ProductManagerFrame(gerenciador);
            frame.setVisible(true);
        });
    }
}