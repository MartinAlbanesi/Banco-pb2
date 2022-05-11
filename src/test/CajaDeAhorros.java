package test;

import entities.Cliente;
import entities.Cuenta;

public class CajaDeAhorros extends Cuenta {
	final Double comision;
	Double costoAdicional;
	Integer contExtracciones;
	
	public CajaDeAhorros(String cbu, Double saldo, Cliente cliente) {
		super(cbu,saldo,cliente);
		this.costoAdicional = 0.0;
		this.contExtracciones = 0;
		this.comision = 6.0;
	}

	@Override
	public void extraer(Double monto) {
		costoAdicional = cobrarCostoAdicional();
		if(getSaldo() >= monto) {
			setSaldo(getSaldo()-monto-costoAdicional);
		}
		this.contExtracciones++;
	}
	
	public Double cobrarCostoAdicional() {
		if(this.contExtracciones >= 5) {
			return comision;
		}
		return 0.0;
	}
}
