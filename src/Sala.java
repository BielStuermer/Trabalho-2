/**
 * Classe Sala
 */
public class Sala {

    private int numero;
    private int predio;
    private int capacidade;

    public Sala(int numero, int predio, int capacidade) {
        this.numero = numero;
        this.predio = predio;
        this.capacidade = capacidade;
    }

    public int getNumero() {
        return numero;
    }

    public int getPredio() {
        return predio;
    }

    public int getCapacidade() {
        return capacidade;
    }

    @Override
    public String toString() {
        return String.format("Sala %d (Prédio %d) - Capacidade: %d pessoas", numero, predio, capacidade);
    }
}