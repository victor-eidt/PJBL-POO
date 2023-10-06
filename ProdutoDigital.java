class ProdutoDigital extends Produto {
    private String formato;

    public ProdutoDigital(String nome, String descricao, double preco, String categoria, String formato) {
        super(nome, descricao, preco, categoria);
        this.formato = formato;
    }

    public String getFormato() { return formato; }
    public void setFormato(String formato) { this.formato = formato; }

    @Override
    public void exibirInformacoes() {
        super.exibirInformacoes();
        System.out.println("Formato: " + formato);
    }
}