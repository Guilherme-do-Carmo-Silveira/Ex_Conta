package controller;

import javax.swing.JOptionPane;

import docarmo.ListaObject.ListaEncadeadaObj;
import model.Conta;

public class BancoController {

	ListaEncadeadaObj[] tabela;

	public BancoController() {
		tabela = new ListaEncadeadaObj[4];
		for (int i = 0; i < 4; i++) {
			tabela[i] = new ListaEncadeadaObj();
		}
	}

	public void Inserir() {

		Conta c = new Conta();
		int tam, numconta;

		c.setNome(JOptionPane.showInputDialog("Insira o seu Nome"));

		do {
			numconta = Integer.parseInt(JOptionPane.showInputDialog("Insira o numero da conta de 1 - 4 digitos"));
			String Dig = Integer.toString(numconta);
			String[] numcontaaux = Dig.split("");
			tam = numcontaaux.length;
			c.setNumConta(numconta);
		} while (tam < 1 || tam > 4);

		c.setSaldo(Double.parseDouble(JOptionPane.showInputDialog("Digite o saldo da Conta")));

		int pos = HashMode(numconta);

		if (tabela[pos].isEmpty()) {
			tabela[pos].addFirst(c);
			System.out.println("A conta " + c.getNumConta() + " foi criada");
		} else {
			try {
				tabela[pos].addLast(c);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

	}

	private int HashMode(int numconta) {
		String Dig = Integer.toString(numconta);
		String[] numcontaaux = Dig.split("");
		int tam = numcontaaux.length;
		return (tam - 1);
	}

	public void Consultar() {

		boolean status = false;
		int pos = 0;

		int Numcont = Integer.parseInt(JOptionPane.showInputDialog("Digite o Numero da Conta"));
		pos = HashMode(Numcont);

		int tam = tabela[pos].size();
		for (int i = 0; i < tam; i++) {
			Conta c = new Conta();
			try {
				c = (Conta) tabela[pos].get(i);
			} catch (Exception e1) {
				e1.printStackTrace();
			}
			if (c.getNumConta() == Numcont) {
				try {
					c = (Conta) tabela[pos].get(i);
					System.out.println(c);
					status = true;
					break;
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}
		if (status == false) {
			System.out.println("Conta nao foi encotrada");
		}
		System.out.println("=====================================================================");

	}

	public void Excluir() {
		boolean status = false;
		int pos = 0;

		int Numcont = Integer.parseInt(JOptionPane.showInputDialog("Digite o Numero da Conta"));
		pos = HashMode(Numcont);

		int tam = tabela[pos].size();
		for (int i = 0; i < tam; i++) {
			Conta c = new Conta();
			try {
				c = (Conta) tabela[pos].get(i);
				if (c.getNumConta() == Numcont) {
					tabela[pos].remove(i);
					System.out.println("A conta " + Numcont + " foi removida");
					System.out.println("=====================================================================");

					status = true;
					break;
				}
			} catch (Exception e1) {
				e1.printStackTrace();
			}
		}
		if (status == false) {
			System.out.println("\nConta nao foi encotrada");
			System.out.println("=====================================================================");

		}
	}

}
