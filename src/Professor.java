/**
 * Classe Professor
 */
public class Professor {

    private int matricula;
    private String nome;
    private double experiencia; 

    public Professor(int matricula, String nome, double experiencia) {
        this.matricula = matricula;
        this.nome = nome;
        this.experiencia = experiencia;
    }

    public int getMatricula() {
        return matricula;
    }

    public String getNome() {
        return nome;
    }

    public double getExperiencia() {
        return experiencia;
    }

    @Override
    public String toString() {
        return String.format("%s (Matrícula: %d, Experiência: %.1f anos)", nome, matricula, experiencia);
    }
}