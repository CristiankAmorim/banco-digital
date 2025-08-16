package banco;

import java.util.Random;

public class Conta implements AcoesConta {

	Random aleatorio = new Random();
	private static final String AGENCIA = "1234-5";
	private static int GERANUMEROCONTA = 1000;
	
	protected String agencia;
	protected int nueroDaConta;
	protected double saldo;
	protected Cliente cliente;
	
	public Conta(Cliente cliente) {
		this.agencia = Conta.AGENCIA;
		this.nueroDaConta = GERANUMEROCONTA += aleatorio.nextInt(999) + 1;
		this.cliente = cliente;
	}

	@Override
	public void sacar(double valor) {
		if(valor <= this.saldo) {
			this.saldo -= valor;
			System.out.printf("\nSaque realizado com sucesso | Valor: R$%.2f", valor);
			if(valor <= 0) {
				System.out.println("\nValor inválido para saque");
			}
		}else {
			throw new SaldoInsuficienteException("\nSaldo Insuficiente");
		}		
	}

	@Override
	public void depositar(double valor) {
		if(valor > 0 ) {
			this.saldo += valor;
			System.out.printf("\nDepósito realizado com sucesso | Valor: R$%.2f", valor);
		}else {
			System.out.println("\nValor inválido para depósito");
		}
	}

	@Override
	public void transferir(double valor, AcoesConta contaDestino) {
		this.sacar(valor);
		contaDestino.depositar(valor);
	}

	@Override
	public void imprimirExtrato() {
		
	} 
	
	public String getAgencia() {
		return agencia;
	}

	public int getNueroDaConta() {
		return nueroDaConta;
	}

	public double getSaldo() {
		return saldo;
	}

	protected void imprimirInformacoesComuns() {
		System.out.println(String.format("Titular: %s", this.cliente.getNome()));
		System.out.println(String.format("Agencia: %s", this.agencia));
		System.out.println(String.format("Número da Conta: %s", this.nueroDaConta));
		System.out.println(String.format("Saldo: %s", this.saldo));
	}
	
	
}
