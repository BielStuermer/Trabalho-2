/**
 * Classe App
 */

import java.util.*;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.BufferedReader;

public class App {

    public static void listarProfessores(List<Professor> professores) {
        System.out.println(">> Professores disponíveis:");
        for (int i = 0; i < professores.size(); i++) {
            System.out.printf("%d) %s%n", i, professores.get(i).getNome());
        }
    }

    public static void listarSalas(List<Sala> salas) {
        System.out.println(">> Salas disponíveis:");
        for (int j = 0; j < salas.size(); j++) {
            System.out.printf("%d) Sala %d%n", j, salas.get(j).getNumero());
        }
    }

    public static void main(String[] args) throws IOException {

        List<Professor> professores = new ArrayList<>();
        List<Sala> salas = new ArrayList<>();
        List<Atividade> atividades = new ArrayList<>();

        InputStreamReader stream = new InputStreamReader(System.in);
        BufferedReader rd = new BufferedReader(stream);

        int op;
        boolean sair = false;

        while (!sair) {
            System.out.println("\n***** GESTÃO DE ATIVIDADES DE CAPACITAÇÃO *****");
            System.out.println("1 | Cadastrar professor");
            System.out.println("2 | Cadastrar sala");
            System.out.println("3 | Cadastrar atividade");
            System.out.println("4 | Listar atividades");
            System.out.println("5 | Listar professores");
            System.out.println("6 | Listar salas");
            System.out.println("7 | Listar atividades com valor acima de X");
            System.out.println("8 | Sair");
            System.out.print("Escolha uma opção: ");
            op = Integer.parseInt(rd.readLine());

            switch (op) {
                case 1:
                    System.out.print("Matrícula (apenas números): ");
                    int mat = Integer.parseInt(rd.readLine());
                    System.out.print("Nome completo: ");
                    String nomeProf = rd.readLine();
                    System.out.print("Experiência (exemplo: 1.2 [um ano e dois meses]): ");
                    double anos = Double.parseDouble(rd.readLine());

                    
                    Professor prof = new Professor(mat, nomeProf, anos);

                    professores.add(prof);
                    System.out.println("Professor(a) cadastrado(a) com sucesso!");
                    break;

                case 2:
                    System.out.print("Número da sala: ");
                    int numero = Integer.parseInt(rd.readLine());
                    System.out.print("Prédio: ");
                    int predio = Integer.parseInt(rd.readLine());
                    System.out.print("Capacidade: ");
                    int capacidade = Integer.parseInt(rd.readLine());

                 
                    Sala sala = new Sala(numero, predio, capacidade);

                    salas.add(sala);
                    System.out.println("Sala cadastrada com sucesso!");
                    break;

                case 3:
                    if (professores.isEmpty() || salas.isEmpty()) {
                        System.out.println("Cadastre pelo menos um(a) professor(a) e uma sala antes.");
                        break;
                    }
                    System.out.print("Nome da atividade: ");
                    String nomeAtiv = rd.readLine();
                    System.out.print("Duração (em minutos): ");
                    int duracao = Integer.parseInt(rd.readLine());
                    System.out.print("Valor total: R$ ");
                    double valor = Double.parseDouble(rd.readLine());

                    listarProfessores(professores);
                    System.out.print("Escolha o professor: ");
                    int ip = Integer.parseInt(rd.readLine());
                    Professor p = professores.get(ip);

                    listarSalas(salas);
                    System.out.print("Escolha a sala: ");
                    int is = Integer.parseInt(rd.readLine());
                    Sala s = salas.get(is);

                    
                    Atividade atividade = new Atividade(nomeAtiv, duracao, valor, p, s);

                    atividades.add(atividade);
                    System.out.println("Atividade cadastrada com sucesso!");
                    break;

                case 4:
                    System.out.println("\n--------- Lista de Atividades ---------");
                    if (atividades.isEmpty()) {
                        System.out.println("Nenhuma atividade cadastrada até o momento.");
                    } else {
                        for (Atividade a : atividades) {
                            a.exibirDados();
                        }
                    }
                    break;

                case 5:
                    listarProfessores(professores);
                    break;

                case 6:
                    listarSalas(salas);
                    break;

                case 7:
                    if (atividades.isEmpty()) {
                        System.out.println("Nenhuma atividade cadastrada para filtrar.");
                        break;
                    }
                    System.out.print("Informe o valor mínimo: R$ ");
                    double minimo = Double.parseDouble(rd.readLine());
                    System.out.println("\nAtividades com valor acima de R$ " + minimo + ":");
                    for (Atividade a : atividades) {
                        if (a.getValor() > minimo) {
                            a.exibirDados();
                        }
                    }
                    break;

                case 8:
                    sair = true;
                    System.out.println("Encerrando sistema...");
                    break;

                default:
                    System.out.println("Opção inválida. Tente novamente.");
            }
        }
        rd.close();
    }
}