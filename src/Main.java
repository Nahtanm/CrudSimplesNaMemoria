import br.com.InterfaceDao.IClienteDao;
import br.com.crud.domain.Cliente;
import br.com.implement.ClienteMapDao;

import javax.swing.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    private static IClienteDao iClienteDao;

    public static void main(String[] args) {
        Cliente cliente = new Cliente("Nahtanm",
                "Piaui", "Teresina",
                "1213654878", "cristo rei",
                "546464132", "10");

        String opcao = "0";

        iClienteDao = new ClienteMapDao();

        while (!opcao.equals("5")) {
            opcao = JOptionPane.showInputDialog(null,
                    "1 - Cadastrar.  2 - Consultar. " +
                            "\n3 - Exclusão.  4 - Alterar. " +
                            "\n5 - Sair.",
                    "Cadastro"
                    , JOptionPane.INFORMATION_MESSAGE);

            switch (opcao) {
                case "1":
                    opcaoCadastrar();
                    break;
                case "2":
                    String cpf = JOptionPane.showInputDialog(null,
                            "Informe o CPF:",
                            "Consulta"
                            , JOptionPane.INFORMATION_MESSAGE);

                    Cliente clienteConsulta = opcaoConsultar(Long.valueOf(cpf));

                    JOptionPane.showMessageDialog(null,
                            clienteConsulta,
                            "Cadastro"
                            , JOptionPane.INFORMATION_MESSAGE);
                    break;
                case "3":
                    cpf = JOptionPane.showInputDialog(null,
                            "Informe o CPF:",
                            "Excluir"
                            , JOptionPane.INFORMATION_MESSAGE);
                    opcaoExcluir(Long.valueOf(cpf));
                    break;
                case "4":
                    opcaoAlterar();
                    break;
                default:
                    JOptionPane.showMessageDialog(null,
                            "Obrigado por utilizar nosso applicativo!",
                            "Cadastro"
                            , JOptionPane.INFORMATION_MESSAGE);
            }
        }

    }

    public static void opcaoCadastrar() {
        String[] list = {"Nome", "Estado", "Cidade", "Numero",
                "Endereço", "Telefone", "Cpf"};
        List<String> dados = new ArrayList<>();
        String opcao;
        for (int i = 0; i < list.length; i++) {
            opcao = JOptionPane.showInputDialog(null,
                    list[i] + ":",
                    "Cadastro"
                    , JOptionPane.INFORMATION_MESSAGE);

            dados.add(opcao);

        }
        Cliente cliente = new Cliente(dados.get(0), dados.get(1), dados.get(2),
                dados.get(3), dados.get(4), dados.get(5), dados.get(6));
        iClienteDao.cadastrar(cliente);
    }

    public static Cliente opcaoConsultar(Long cpf) {
        return iClienteDao.consultar(cpf);
    }

    public static void opcaoExcluir(Long cpf) {
        iClienteDao.excluir(cpf);
    }

    public static void opcaoAlterar() {
        String[] list = {"Nome", "Estado", "Cidade", "Numero",
                "Endereço", "Telefone", "Cpf"};
        List<String> dados = new ArrayList<>();
        String opcao;
        for (int i = 0; i < list.length; i++) {
            opcao = JOptionPane.showInputDialog(null,
                    list[i] + ":",
                    "Alterar cadastro"
                    , JOptionPane.INFORMATION_MESSAGE);

            dados.add(opcao);

        }
        Cliente cliente = new Cliente(dados.get(0), dados.get(1), dados.get(2),
                dados.get(3), dados.get(4), dados.get(5), dados.get(6));
        iClienteDao.alterar(cliente);
    }
}