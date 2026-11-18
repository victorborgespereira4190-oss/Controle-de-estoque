import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    private static final Scanner teclado = new Scanner(System.in);
    private static final ArrayList<Produto> produtos = new ArrayList<>();

    public static void main(String[] args) {
        int opcao;
        do {
            mostrarMenu();
            opcao = lerInteiro("Escolha uma opção: ");
            switch (opcao) {
                case 1: cadastrar(); break;
                case 2: listar(); break;
                case 3: buscar(); break;
                case 4: registrarVenda(); break;
                case 5: mostrarValorTotal(); break;
                case 6: System.out.println("Programa encerrado. Até mais!"); break;
                default: System.out.println("Opção inválida. Tente novamente.");
            }
        } while (opcao != 6);
    }

    private static void mostrarMenu() {
        System.out.println("\n===== ESTOQUE DA CANTINA =====");
        System.out.println("1 - Cadastrar produto");
        System.out.println("2 - Listar produtos");
        System.out.println("3 - Buscar produto pelo código");
        System.out.println("4 - Registrar venda");
        System.out.println("5 - Valor total do estoque");
        System.out.println("6 - Sair");
    }

    private static int lerInteiro(String mensagem) {
        while (true) {
            System.out.print(mensagem);
            String texto = teclado.nextLine().trim();
            try { return Integer.parseInt(texto); }
            catch (NumberFormatException e) { System.out.println("Digite um número inteiro válido."); }
        }
    }

    private static double lerPreco(String mensagem) {
        while (true) {
            System.out.print(mensagem);
            String texto = teclado.nextLine().trim().replace(',', '.');
            try {
                double numero = Double.parseDouble(texto);
                if (Double.isFinite(numero)) return numero;
            } catch (NumberFormatException ignored) { }
            System.out.println("Digite um preço válido, como 5,50.");
        }
    }

    private static Produto encontrar(int codigo) {
        for (Produto produto : produtos) {
            if (produto.getCodigo() == codigo) return produto;
        }
        return null;
    }

    private static void cadastrar() {
        int codigo = lerInteiro("Código do produto: ");
        if (encontrar(codigo) != null) {
            System.out.println("Já existe um produto com esse código.");
            return;
        }
        System.out.print("Nome do produto: ");
        String nome = teclado.nextLine().trim();
        if (nome.isEmpty()) {
            System.out.println("O nome não pode ficar vazio.");
            return;
        }
        double preco = lerPreco("Preço unitário: R$ ");
        if (preco <= 0) {
            System.out.println("O preço precisa ser maior que zero.");
            return;
        }
        int quantidade = lerInteiro("Quantidade inicial: ");
        if (quantidade < 0) {
            System.out.println("A quantidade não pode ser negativa.");
            return;
        }
        produtos.add(new Produto(codigo, nome, preco, quantidade));
        System.out.println("Produto cadastrado com sucesso!");
    }

    private static void listar() {
        if (produtos.isEmpty()) {
            System.out.println("Nenhum produto cadastrado.");
            return;
        }
        System.out.println("\n--- PRODUTOS CADASTRADOS ---");
        for (Produto produto : produtos) System.out.println(produto);
    }

    private static void buscar() {
        int codigo = lerInteiro("Código para buscar: ");
        Produto produto = encontrar(codigo);
        System.out.println(produto == null ? "Produto não encontrado." : produto);
    }

    private static void registrarVenda() {
        int codigo = lerInteiro("Código do produto vendido: ");
        Produto produto = encontrar(codigo);
        if (produto == null) {
            System.out.println("Produto não encontrado.");
            return;
        }
        int unidades = lerInteiro("Quantidade vendida: ");
        if (unidades <= 0) {
            System.out.println("A quantidade vendida precisa ser maior que zero.");
        } else if (produto.vender(unidades)) {
            System.out.println("Venda registrada! Estoque restante: " + produto.getQuantidade());
        } else {
            System.out.println("Estoque insuficiente. Venda recusada; estoque mantido em " + produto.getQuantidade() + ".");
        }
    }

    private static void mostrarValorTotal() {
        double total = 0;
        for (Produto produto : produtos) total += produto.valorEmEstoque();
        System.out.printf(java.util.Locale.forLanguageTag("pt-BR"), "Valor total do estoque: R$ %.2f%n", total);
    }
}
