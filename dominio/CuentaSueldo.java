package ar.edu.banco.dominio;

public class CuentaSueldo extends Cuenta {

	public CuentaSueldo(Integer cbu, Double saldoInicial) {
		super(cbu, saldoInicial);
		setTipoCuenta(TipoDeCuenta.SUELDO);
	}

	@Override
	public Boolean extraerDinero(Double monto) {
		
		Boolean sePudoExtraer=false;		
		if(monto<=getSaldo() && monto>0) {
			setSaldo(getSaldo()-monto);
			sePudoExtraer=true;
		}
		return sePudoExtraer;
	}

	

}
