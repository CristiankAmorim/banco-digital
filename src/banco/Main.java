package banco;

public class Main {

	public static void main(String[] args) {
		
			Cliente cliente = new Cliente("Cristian");
			Conta cc = new ContaCorrente(cliente);
			Conta poupanca = new ContaPoupanca(cliente);
			
			cc.depositar(100);
			cc.transferir(20, poupanca);
			
			cc.imprimirExtrato();
			poupanca.imprimirExtrato();
			
	}

}
