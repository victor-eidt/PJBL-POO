import javax.swing.*;

public class Main {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            GerenciadorProdutos gerenciador = new GerenciadorProdutos(); // Crie a instância aqui
            ProductManagerFrame frame = new ProductManagerFrame(gerenciador); // Passe como argumento
            frame.setVisible(true);
        });
    }
}