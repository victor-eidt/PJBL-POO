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

    public void receberProdutos(String nomeProduto, int quantidadeRecebida) {

        Produto produtoExistente = buscarProdutoPeloNome(nomeProduto);

        if (produtoExistente != null) {
            produtoExistente.adicionarEstoque(quantidadeRecebida);
        } else {
            System.out.println("Produto não encontrado!");
        }
    }

    public void venderProduto(String nomeProduto, int quantidadeVendida) {

        Produto produtoExistente = buscarProdutoPeloNome(nomeProduto);

        if (produtoExistente != null) {

            if (produtoExistente.getQuantidadeEmEstoque() < quantidadeVendida) {
                System.out.println("Estoque insuficiente para venda!");
            } else {
                produtoExistente.removerEstoque(quantidadeVendida);
            }

        } else {
            System.out.println("Produto não encontrado!");
        }
    }
    private Produto buscarProdutoPeloNome(String nomeProduto) {

        for (Produto produto : produtos) {
            if (produto.getNome().equals(nomeProduto)) {
                return produto;
            }
        }
        return null;
    }
}