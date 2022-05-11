package test;

import static org.junit.Assert.*;

import org.junit.Test;

import entities.Banco;
import entities.Cliente;
import entities.Cuenta;
import entities.CuentaSueldo;

public class TestBanco {

	@Test
	public void queSePuedaCrearUnBanco() {
		//Preparacion
		Banco nacion;
		final String NOMBRE_ESPERADO = "Banco Nacion";
		
		//Ejecucion
		nacion = new Banco(NOMBRE_ESPERADO);
		
		//Validacion
		assertNotNull(nacion);
	}
	
	@Test
	public void queSePuedaCrearUnCliente() {
		//Preparacion
		Cliente nuevo;
		final String NOMBRE_ESPERADO = "Martin";
		final String CBU_ESPERADO = "20524368792";
				
		//Ejecucion
		nuevo = new Cliente(NOMBRE_ESPERADO,CBU_ESPERADO);
				
		//Validacion
		assertNotNull(nuevo);
	}
	
	@Test
	public void queSePuedaRegistrarUnClienteEnUnBanco() {
		//Preparacion
		Banco nacion;
		final String NOMBRE_BANCO_ESPERADO = "Banco Nacion";
		Cliente nuevo;
		final String NOMBRE_CLIENTE_ESPERADO = "Martin";
		final String CBU_ESPERADO = "20524368792";
		final Integer VALOR_ESPERADO1 = 1;
		
		//Ejecucion
		nacion = new Banco(NOMBRE_BANCO_ESPERADO);
		nuevo = new Cliente(NOMBRE_CLIENTE_ESPERADO, CBU_ESPERADO);
		
		nacion.registrarCliente(nuevo);
		
		//Validacion
		assertEquals(VALOR_ESPERADO1,(Integer)nacion.getCuentas().size());
	}
	
	@Test
	public void queUnClientePuedaAbrirUnaCuentaSueldo() {
		//Preparacion
		Banco nacion;
		final String NOMBRE_BANCO_ESPERADO = "Banco Nacion";
		Cliente nuevo;
		final String NOMBRE_CLIENTE_ESPERADO = "Martin";
		final String DNI_ESPERADO = "20524368792";
		Cuenta cuentaSueldo;
		final Double SALDO_ESPERADO = 100.0;
		final String CBU_ASOCIADO_ESPERADO = "1234";
		
		//Ejecucion
		nacion = new Banco(NOMBRE_BANCO_ESPERADO);
		nuevo = new Cliente(NOMBRE_CLIENTE_ESPERADO, DNI_ESPERADO);
		cuentaSueldo = new CuentaSueldo(CBU_ASOCIADO_ESPERADO,SALDO_ESPERADO,nuevo);
		
		nacion.registrarCliente(nuevo);
		nacion.registrarCuenta(cuentaSueldo);
		
		//Validacion
		assertEquals(NOMBRE_CLIENTE_ESPERADO,cuentaSueldo.getCliente().getNombre());
	}
	
	@Test
	public void queSePuedaRealizarUnaExtraccionEnUnaCuentaSueldo() {
		//Preparacion
		Banco nacion;
		final String NOMBRE_BANCO_ESPERADO = "Banco Nacion";
		Cliente nuevo;
		final String NOMBRE_CLIENTE_ESPERADO = "Martin";
		final String DNI_ESPERADO = "20524368792";
		Cuenta cuentaSueldo;
		final Double SALDO_ESPERADO = 100.0;
		final String CBU_ASOCIADO_ESPERADO = "1234";
		final Double MONTO_A_EXTRAER_ESPERADO = 50.0;
		final Double SALDO_LUEGO_DE_EXTRAER_ESPERADO = 50.0;
		
		//Ejecucion
		nacion = new Banco(NOMBRE_BANCO_ESPERADO);
		nuevo = new Cliente(NOMBRE_CLIENTE_ESPERADO, DNI_ESPERADO);
		cuentaSueldo = new CuentaSueldo(CBU_ASOCIADO_ESPERADO,SALDO_ESPERADO,nuevo);
		
		nacion.registrarCliente(nuevo);
		nacion.registrarCuenta(cuentaSueldo);
		cuentaSueldo.extraer(MONTO_A_EXTRAER_ESPERADO);
		
		//Validacion
		assertEquals(SALDO_LUEGO_DE_EXTRAER_ESPERADO,cuentaSueldo.getSaldo());
	}
	
	@Test
	public void queSePuedaCrearUnaCajaDeAhorros() {
		//Preparacion
		Banco nacion;
		final String NOMBRE_BANCO_ESPERADO = "Banco Nacion";
		Cliente nuevo;
		final String NOMBRE_CLIENTE_ESPERADO = "Martin";
		final String DNI_ESPERADO = "20524368792";
		Cuenta cajaDeAhorros;
		final Double SALDO_ESPERADO = 100.0;
		final String CBU_ASOCIADO_ESPERADO = "1234";
		final Double MONTO_A_EXTRAER_ESPERADO = 50.0;
		final Double SALDO_LUEGO_DE_EXTRAER_ESPERADO = 50.0;
		
		//Ejecucion
		nacion = new Banco(NOMBRE_BANCO_ESPERADO);
		nuevo = new Cliente(NOMBRE_CLIENTE_ESPERADO, DNI_ESPERADO);
		cajaDeAhorros = new CajaDeAhorros(CBU_ASOCIADO_ESPERADO,SALDO_ESPERADO,nuevo);
		
		nacion.registrarCliente(nuevo);
		nacion.registrarCuenta(cajaDeAhorros);
		cajaDeAhorros.extraer(MONTO_A_EXTRAER_ESPERADO);
		
		//Validacion
		assertEquals(NOMBRE_CLIENTE_ESPERADO,cajaDeAhorros.getCliente().getNombre());
	}

	@Test
	public void queSeCobreElCostoAdicionalLuegoDeLaQuintaExtraccionDeUnaCajaDeAhorros() {
		//Preparacion
		Banco nacion;
		final String NOMBRE_BANCO_ESPERADO = "Banco Nacion";
		Cliente nuevo;
		final String NOMBRE_CLIENTE_ESPERADO = "Martin";
		final String DNI_ESPERADO = "20524368792";
		Cuenta cajaDeAhorros;
		final Double SALDO_ESPERADO = 1000.0;
		final String CBU_ASOCIADO_ESPERADO = "1234";
		final Double MONTO_A_EXTRAER_ESPERADO = 100.0;
		final Double SALDO_LUEGO_DE_EXTRAER_ESPERADO = 394.0;
		
		//Ejecucion
		nacion = new Banco(NOMBRE_BANCO_ESPERADO);
		nuevo = new Cliente(NOMBRE_CLIENTE_ESPERADO, DNI_ESPERADO);
		cajaDeAhorros = new CajaDeAhorros(CBU_ASOCIADO_ESPERADO,SALDO_ESPERADO,nuevo);
		
		nacion.registrarCliente(nuevo);
		nacion.registrarCuenta(cajaDeAhorros);
		cajaDeAhorros.extraer(MONTO_A_EXTRAER_ESPERADO);
		cajaDeAhorros.extraer(MONTO_A_EXTRAER_ESPERADO);
		cajaDeAhorros.extraer(MONTO_A_EXTRAER_ESPERADO);
		cajaDeAhorros.extraer(MONTO_A_EXTRAER_ESPERADO);
		cajaDeAhorros.extraer(MONTO_A_EXTRAER_ESPERADO);
		cajaDeAhorros.extraer(MONTO_A_EXTRAER_ESPERADO);
		
		//Validacion
		assertEquals(SALDO_LUEGO_DE_EXTRAER_ESPERADO,cajaDeAhorros.getSaldo());
	}
}