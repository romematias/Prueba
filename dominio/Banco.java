package ar.edu.banco.dominio;

public class Banco {
		
	private Cliente [] clientes;
	private Cuenta [] cuentas;
		
		
	public Banco() {
		this.clientes=new Cliente[1000];
		this.cuentas=new Cuenta[5000];
			
	}
	
	public Boolean agregarCliente(Cliente clienteNuevo) {
		for (int i = 0; i < clientes.length; i++) {
			if(clientes[i]==null) {
				clientes[i]=clienteNuevo;
				return true;
			}
		}
	return false;
	}
}


