package entities;

public class CuentaSueldo extends Cuenta {

	public CuentaSueldo(String cbu, Double saldo, Cliente cliente) {
		super(cbu, saldo, cliente);
	}

	@Override
	public void extraer(Double monto) {
		if(getSaldo() >= monto) {
			setSaldo(getSaldo()-monto);
		}
	}
}
