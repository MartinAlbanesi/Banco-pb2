package entities;

import java.util.*;

public class Banco {
	private String nombre;
	private HashSet<Cliente> clientes;
	private HashSet<Cuenta> cuentas;
	
	public Banco(String nombre) {
		this.nombre = nombre;
		this.clientes = new HashSet<Cliente>();
		this.cuentas = new HashSet<Cuenta>();
	}
	
	public void registrarCliente(Cliente nuevo) {
		clientes.add(nuevo);
	}
	
	public void registrarCuenta(Cuenta cuentaSueldo) {
		cuentas.add(cuentaSueldo);
	}
	
	
	//GETTERS Y SETTERS
	
	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public HashSet<Cliente> getClientes() {
		return clientes;
	}

	public void setClientes(HashSet<Cliente> clientes) {
		this.clientes = clientes;
	}

	public HashSet<Cuenta> getCuentas() {
		return cuentas;
	}

	public void setCuentas(HashSet<Cuenta> cuentas) {
		this.cuentas = cuentas;
	}
	
}
