public class Main {
    public static void main(String[] args) {
        GerenciadorProdutos gerenciador = new GerenciadorProdutos();

        ProdutoFisico produtoFisico = new ProdutoFisico("Notebook", "Gamer", 3000.00,"Computadores","17 polegadas");
        ProdutoDigital produtoDigital = new ProdutoDigital("E-book de Java", "http://download-link.com", 1000,"Curso","E-book");

        gerenciador.adicionarProduto(produtoFisico);
        gerenciador.adicionarProduto(produtoDigital);

        System.out.println("Produtos disponíveis:");
        gerenciador.exibirTodosProdutos();

        gerenciador.receberProdutos("Notebook", 5);

        gerenciador.venderProduto("Notebook", 10);

        System.out.println("Produtos após recebimento e venda:");
        gerenciador.exibirTodosProdutos();
    }
}
