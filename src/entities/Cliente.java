package entities;

public class Cliente {
	private String nombre;
	private String dni;
	
	public Cliente(String nombre, String cbu) {
		this.nombre = nombre;
		this.dni = cbu;
		
	}

	//GETTERS Y SETTERS
	
	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getCbu() {
		return dni;
	}

	public void setCbu(String cbu) {
		this.dni = cbu;
	}

	//HASH E EQUALS
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((dni == null) ? 0 : dni.hashCode());
		return result;
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Cliente other = (Cliente) obj;
		if (dni == null) {
			if (other.dni != null)
				return false;
		} else if (!dni.equals(other.dni))
			return false;
		return true;
	}
	
}
