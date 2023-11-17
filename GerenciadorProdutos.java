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

    public void removerProduto(String produto) {
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

        Produto produtoExistente = (Produto) buscarProdutoPeloNome(nomeProduto);

        if (produtoExistente != null) {
            produtoExistente.adicionarEstoque(quantidadeRecebida);
        } else {
            System.out.println("Produto não encontrado!");
        }
    }

    public List<IProduto> getProdutos() {
        return new ArrayList<>(produtos);

    public void venderProduto(String nomeProduto, int quantidadeVendida) {

        Produto produtoExistente = (Produto) buscarProdutoPeloNome(nomeProduto);

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
    private IProduto buscarProdutoPeloNome(String nomeProduto) {
        for (IProduto produto : produtos) {
            if (produto.getNome().equals(nomeProduto)) {
                return produto;
            }
        }
        return null;
    }
}