package br.com.rubythree.escola.conector;

public class Testa_conexao {
    public static void main(String[] args) {
        new ConnectionFactory().getConnection();
        System.out.println("Conexão criada com sucesso");
    }
}
