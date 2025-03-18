// Classe abstrata Produto
abstract class Produto {
    private int id;
    private String nome;
    private String fabricante;
    private String marca;

    // Construtor
    public Produto(int id, String nome, String fabricante, String marca) {
        this.id = id;
        this.nome = nome;
        this.fabricante = fabricante;
        this.marca = marca;
    }

    // Getters e Setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getFabricante() {
        return fabricante;
    }

    public void setFabricante(String fabricante) {
        this.fabricante = fabricante;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    // Método abstrato
    public abstract void mostrarInformacoes();
}

// Classe Eletrico (herda de Produto)
class Eletrico extends Produto {
    private double potencia; // Potência em watts (exemplo de característica para produtos elétricos)
    private String tipoDeConexao; // Tipo de conexão elétrica (ex: 110V, 220V, USB)

    // Construtor
    public Eletrico(int id, String nome, String fabricante, String marca, double potencia, String tipoDeConexao) {
        super(id, nome, fabricante, marca);
        this.potencia = potencia;
        this.tipoDeConexao = tipoDeConexao;
    }

    // Getters e Setters
    public double getPotencia() {
        return potencia;
    }

    public void setPotencia(double potencia) {
        this.potencia = potencia;
    }

    public String getTipoDeConexao() {
        return tipoDeConexao;
    }

    public void setTipoDeConexao(String tipoDeConexao) {
        this.tipoDeConexao = tipoDeConexao;
    }

    @Override
    public void mostrarInformacoes() {
        System.out.println("Produto Elétrico:");
        System.out.println("ID: " + getId());
        System.out.println("Nome: " + getNome());
        System.out.println("Fabricante: " + getFabricante());
        System.out.println("Marca: " + getMarca());
        System.out.println("Potência: " + potencia + " watts");
        System.out.println("Tipo de Conexão: " + tipoDeConexao);
    }
}

// Classe Ventilador (herda de Eletrico)
class Ventilador extends Eletrico {
    private int quantidadeDeVelocidades; // Quantidade de velocidades do ventilador

    // Construtor
    public Ventilador(int id, String nome, String fabricante, String marca, double potencia, String tipoDeConexao, int quantidadeDeVelocidades) {
        super(id, nome, fabricante, marca, potencia, tipoDeConexao);
        this.quantidadeDeVelocidades = quantidadeDeVelocidades;
    }

    // Getter e Setter
    public int getQuantidadeDeVelocidades() {
        return quantidadeDeVelocidades;
    }

    public void setQuantidadeDeVelocidades(int quantidadeDeVelocidades) {
        this.quantidadeDeVelocidades = quantidadeDeVelocidades;
    }

    @Override
    public void mostrarInformacoes() {
        super.mostrarInformacoes();
        System.out.println("Quantidade de Velocidades: " + quantidadeDeVelocidades);
    }
}

// Classe SecadorDeCabelo (herda de Eletrico)
class SecadorDeCabelo extends Eletrico {
    private boolean possuiIons; // Indica se o secador tem tecnologia de emissão de íons

    // Construtor
    public SecadorDeCabelo(int id, String nome, String fabricante, String marca, double potencia, String tipoDeConexao, boolean possuiIons) {
        super(id, nome, fabricante, marca, potencia, tipoDeConexao);
        this.possuiIons = possuiIons;
    }

    // Getter e Setter
    public boolean isPossuiIons() {
        return possuiIons;
    }

    public void setPossuiIons(boolean possuiIons) {
        this.possuiIons = possuiIons;
    }

    @Override
    public void mostrarInformacoes() {
        super.mostrarInformacoes();
        System.out.println("Possui Tecnologia de Íons: " + (possuiIons ? "Sim" : "Não"));
    }
}

// Classe Principal para testar
public class Estoque {
    public static void main(String[] args) {
        // Criando objetos de tipos diferentes de produtos elétricos
        Produto ventilador = new Ventilador(1, "Ventilador Turbo", "Arno", "Arno", 120.0, "220V", 3);
        Produto secadorDeCabelo = new SecadorDeCabelo(2, "Secador Shine", "Philips", "Philips", 2000.0, "110V", true);

        // Usando o polimorfismo para chamar o método de exibição
        ventilador.mostrarInformacoes();
        System.out.println();
        secadorDeCabelo.mostrarInformacoes();
    }
}
