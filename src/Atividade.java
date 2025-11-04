/*
 * Classe Atividade
 */
public class Atividade {

    private String nome;
    private int duracao; 
    private double valor;
    private Professor professor;
    private Sala sala;

    public Atividade(String nome, int duracao, double valor, Professor professor, Sala sala) {
        this.nome = nome;
        this.duracao = duracao;
        this.valor = valor;
        this.professor = professor;
        this.sala = sala;
    }

    public String getNome() {
        return nome;
    }

    public int getDuracao() {
        return duracao;
    }

    public double getValor() {
        return valor;
    }

    public Professor getProfessor() {
        return professor;
    }

    public Sala getSala() {
        return sala;
    }

    
    public void exibirDados() {
        System.out.printf("%s | %d min | R$ %.2f | %s | Sala %d (Prédio %d)%n",
                nome, duracao, valor, professor.getNome(), sala.getNumero(), sala.getPredio());
    }
}