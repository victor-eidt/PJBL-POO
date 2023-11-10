import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ProductManagerFrame extends JFrame {
    private JTextField productNameField;
    private JTextField productPriceField;
    private JTextField productQuantityField;
    private JButton addButton;
    private JTable productTable;
    private GerenciadorProdutos gerenciadorProdutos;

    public ProductManagerFrame(GerenciadorProdutos gerenciador) {
        this.gerenciadorProdutos = gerenciador;
        initializeComponents();
    }

    private void initializeComponents() {
        setTitle("Gerenciador de Produtos");
        setSize(800, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());


        JPanel inputPanel = new JPanel();
        productNameField = new JTextField(10);
        productPriceField = new JTextField(10);
        productQuantityField = new JTextField(10);
        addButton = new JButton("Adicionar Produto");

        inputPanel.add(new JLabel("Nome:"));
        inputPanel.add(productNameField);
        inputPanel.add(new JLabel("Preço:"));
        inputPanel.add(productPriceField);
        inputPanel.add(new JLabel("Quantidade:"));
        inputPanel.add(productQuantityField);
        inputPanel.add(addButton);


        productTable = new JTable();
        JScrollPane scrollPane = new JScrollPane(productTable);


        add(inputPanel, BorderLayout.NORTH);
        add(scrollPane, BorderLayout.CENTER);


        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String nome = productNameField.getText();
                double preco = Double.parseDouble(productPriceField.getText());
                int quantidade = Integer.parseInt(productQuantityField.getText());


                ProdutoFisico produto = new ProdutoFisico(nome, "Descrição", preco, "Categoria", "Dimensões");
                produto.setQuantidadeEmEstoque(quantidade);
                gerenciadorProdutos.adicionarProduto(produto);

            }
        });
    }

    public static void main(String[] args) {
        GerenciadorProdutos gerenciador = new GerenciadorProdutos();
        SwingUtilities.invokeLater(() -> {
            ProductManagerFrame frame = new ProductManagerFrame(gerenciador);
            frame.setVisible(true);
        });
    }
}
