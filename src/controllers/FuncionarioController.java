package controllers;

import java.util.UUID;

import javax.swing.JOptionPane;

import entities.Endereco;
import entities.Funcionario;
import interfaces.funcionarioRepository;
import repositories.FuncionarioRepositoryTxt;
import repositories.FuncionarioRepositoryXml;

public class FuncionarioController {

	public void cadastrarFuncionario() {

		var funcionario = obterDadosFuncionario();
		funcionario.setEndereco(obterDadosEndereco());

		// criando uma variável da interface
		funcionarioRepository funcionarioRepository = null;

		// Escolher o tipo de arquivo desejado
		var tipo = JOptionPane.showInputDialog("ESCOLHA (1)TXT ou (2)XML:");
		switch (tipo) {
		case "1":
			funcionarioRepository = new FuncionarioRepositoryTxt(); // POLIMORFISMO
			break;
		case "2":
			funcionarioRepository = new FuncionarioRepositoryXml(); // POLIMORFISMO
			break;
		}
		// exportar os dados para arquivo
		funcionarioRepository.exportarDados(funcionario);
	}

	private Funcionario obterDadosFuncionario() {

		var funcionario = new Funcionario();
	

		funcionario.setId(UUID.randomUUID());
		funcionario.setNome(JOptionPane.showInputDialog("Informe Nome do Funcionário:"));
		funcionario.setCpf(JOptionPane.showInputDialog("Informe o CPF do Funcionário:"));
		funcionario.setMatricula(JOptionPane.showInputDialog("Informe o Matricula do Funcionário:"));
		

		return funcionario;

	}

	private Endereco obterDadosEndereco() {

		var endereco = new Endereco();

		endereco.setId(UUID.randomUUID());
		endereco.setLogradouro(JOptionPane.showInputDialog("Informe o Logradouro do Funcionário:"));
		endereco.setNumero(JOptionPane.showInputDialog("Informe o numero:"));
		endereco.setComplemento(JOptionPane.showInputDialog("Informe o Complemento:"));
		endereco.setBairro(JOptionPane.showInputDialog("Informe o Bairro:"));
		endereco.setCidade(JOptionPane.showInputDialog("Informe a Cidade:"));
		endereco.setEstado(JOptionPane.showInputDialog("Informe o Estado:"));
		endereco.setCep(JOptionPane.showInputDialog("Informe o cep:"));

		return endereco;
	}

}
