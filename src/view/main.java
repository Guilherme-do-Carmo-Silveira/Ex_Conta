package view;

import javax.swing.JOptionPane;

import controller.BancoController;

public class main {

	public static void main(String[] args) {
		
		BancoController c = new BancoController();
		
		int opc = 0;
		String morador = "";
		while (opc != 9) {
			opc = Integer.parseInt(JOptionPane.showInputDialog("1 - Cadastrar Conta \n2 - Consultar Conta \n3 - Excluir Conta \n9 - Finaliza"));
			switch (opc) {
			case 1:
				c.Inserir();
				System.out.println("=====================================================================");
				break;
			case 2:
				c.Consultar();
				break;
			case 3: 
				c.Excluir();
				break;
			case 9:
				JOptionPane.showMessageDialog(null, "Programa finalizado");
				break;
			default:
				JOptionPane.showMessageDialog(null, "Opção Inválida");
			} // FECHA SWITCH
		}
	}

}
