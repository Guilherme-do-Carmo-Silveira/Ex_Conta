package model;

public class Conta {
	
	private int NumConta;
	private String Nome;
	private double Saldo;
	
	public int getNumConta() {
		return NumConta;
	}
	public void setNumConta(int numConta) {
		NumConta = numConta;
	}
	public String getNome() {
		return Nome;
	}
	public void setNome(String nome) {
		Nome = nome;
	}
	public double getSaldo() {
		return Saldo;
	}
	public void setSaldo(double saldo) {
		Saldo = saldo;
	}
	
	@Override
	public String toString() {
		return "NumConta: " + NumConta + " | Nome: " + Nome + " | Saldo: " + Saldo;
	}
	
	

}
