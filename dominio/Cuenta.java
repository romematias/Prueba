package ar.edu.banco.dominio;

public abstract class Cuenta {
	
	private	Integer cbu;
	private Double saldo;
	private TipoDeCuenta tipo;
	
	public Cuenta (Integer cbu, Double saldo) {
		this.cbu=cbu;
		this.saldo=saldo;
	}
	
		
	public Integer getCbu() {
		return cbu;
	}
	public void setCbu(Integer cbu) {
		this.cbu = cbu;
	}


	public Double getSaldo() {
		return saldo;
	}
	public void setSaldo(Double saldo) {
		this.saldo = saldo;
	}


	public TipoDeCuenta getTipo() {
		return tipo;
	}
	public void setTipoCuenta(TipoDeCuenta tipo) {
		this.tipo = tipo;
	}


	public abstract Boolean extraerDinero(Double monto);

	
	public Boolean depositarDinero(Double monto) {
		Boolean sePudoDepositar=false;
		
		if(monto>0) {
			this.saldo+=monto;
			sePudoDepositar=true;
		}
		return sePudoDepositar;
	}
}
