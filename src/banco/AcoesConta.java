package banco;

public interface AcoesConta {

	void sacar(double valor);
	void depositar(double valor);
	void transferir(double valor, AcoesConta contaDestino);
	void imprimirExtrato();
}
