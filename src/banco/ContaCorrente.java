package banco;

public class ContaCorrente extends Conta {

	public ContaCorrente(Cliente cliente) {
		super(cliente);
	}
	
	public void imprimirExtrato() {
		System.out.println("\n=== Extrato da Conta Corrente===");
		super.imprimirInformacoesComuns();
	}

}
