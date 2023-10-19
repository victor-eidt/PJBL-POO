import java.util.List;
import java.util.ArrayList;

class GerenciadorProdutos {
    private List<IProduto> produtos;

    public GerenciadorProdutos() {
        this.produtos = new ArrayList<IProduto>();
    }

    public void adicionarProduto(IProduto produto) {
        produtos.add(produto);
    }

    public void removerProduto(IProduto produto) {
        produtos.remove(produto);
    }

    public void atualizarProduto(IProduto produtoAntigo, IProduto produtoNovo) {
        int indice = produtos.indexOf(produtoAntigo);
        if (indice != -1) {
            produtos.set(indice, produtoNovo);
        }
    }

    public void exibirTodosProdutos() {
        for (IProduto produto : produtos) {
            produto.exibirInformacoes();
            System.out.println("-------------------------");
        }
    }
}