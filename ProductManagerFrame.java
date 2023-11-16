import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.SwingUtilities;

public class ProductManagerFrame extends JFrame {
    private GerenciadorProdutos gerenciador;
    private JTextField nomeField, precoField, categoriaField, dimensoesField;
    private JButton addButton, removeButton, updateButton;
    private JTable productTable;
    private DefaultTableModel tableModel;
    private JComboBox<String> productTypeComboBox;
    private CardLayout cardLayout;
    private JPanel cardPanel;
    private JTextField productNameField, productPriceField, productDigitalFormatField, productPhysicalDimensionField;
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                GerenciadorProdutos gerenciador = new GerenciadorProdutos();
                ProductManagerFrame frame = new ProductManagerFrame(gerenciador);
                frame.setVisible(true);
            }
        });
    }

    public ProductManagerFrame(GerenciadorProdutos gerenciador) {
        initializeComponents();
        initializeLayout();
        attachEventHandlers();
        this.gerenciador = gerenciador;

    }

    private void initializeComponents() {
        nomeField = new JTextField(15);
        precoField = new JTextField(10);
        categoriaField = new JTextField(10);
        dimensoesField = new JTextField(10);

        addButton = new JButton("Adicionar");
        removeButton = new JButton("Remover");
        updateButton = new JButton("Atualizar");

        tableModel = new DefaultTableModel();
        tableModel.setColumnIdentifiers(new String[]{"Nome", "Preço", "Categoria", "Dimensões"});
        productTable = new JTable(tableModel);
    }

    private void initializeLayout() {
        setTitle("Gerenciador de Produtos");
        setSize(800, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel inputPanel = new JPanel();
        inputPanel.add(new JLabel("Nome:"));
        inputPanel.add(nomeField);
        inputPanel.add(new JLabel("Preço:"));
        inputPanel.add(precoField);
        inputPanel.add(new JLabel("Categoria:"));
        inputPanel.add(categoriaField);
        inputPanel.add(new JLabel("Dimensões:"));
        inputPanel.add(dimensoesField);

        JPanel buttonPanel = new JPanel();
        buttonPanel.add(addButton);
        buttonPanel.add(removeButton);
        buttonPanel.add(updateButton);

        Container container = getContentPane();
        container.add(inputPanel, BorderLayout.NORTH);
        container.add(new JScrollPane(productTable), BorderLayout.CENTER);
        container.add(buttonPanel, BorderLayout.SOUTH);
    }

    private void attachEventHandlers() {
        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                addProduct();
            }
        });

        removeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                removeProduct();
            }
        });

        updateButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                updateProduct();
            }
        });
    }

    private void addProduct() {

        String nome = nomeField.getText();
        double preco = Double.parseDouble(precoField.getText());
        String categoria = categoriaField.getText();
        String dimensoes = dimensoesField.getText();

        ProdutoFisico produto = new ProdutoFisico(nome, "Descrição", preco, categoria, dimensoes);
        gerenciador.adicionarProduto(produto);
        updateTable();
    }

    private void removeProduct() {
        int selectedRow = productTable.getSelectedRow();
        if (selectedRow >= 0) {

            String nome = (String) tableModel.getValueAt(selectedRow, 0);


            gerenciador.removerProduto(nome);


            tableModel.removeRow(selectedRow);
        } else {
            JOptionPane.showMessageDialog(this, "Selecione um produto para remover.", "Aviso", JOptionPane.WARNING_MESSAGE);
        }
    }

    private void updateProduct() {

        int selectedRow = productTable.getSelectedRow();
        if (selectedRow >= 0) {
            String nome = nomeField.getText();
            double preco = Double.parseDouble(precoField.getText());
            String categoria = categoriaField.getText();
            String dimensoes = dimensoesField.getText();

            ProdutoFisico produtoAtualizado = new ProdutoFisico(nome, "Descrição Atualizada", preco, categoria, dimensoes);

            updateTable();
        }
    }

    private void updateTable() {
        tableModel.setRowCount(0);

        for (IProduto produto : gerenciador.getProdutos()) {
            if (produto instanceof ProdutoFisico) {
                ProdutoFisico prod = (ProdutoFisico) produto;
                tableModel.addRow(new Object[]{
                        prod.getNome(),
                        prod.getPreco(),
                        prod.getCategoria(),
                        prod.getDimensoes()
                });
            }
        }
    }
}
