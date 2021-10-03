package ar.edu.banco.dominio;

public class CajaAhorro extends Cuenta {

	private Integer contadorExtracciones;
	
	public CajaAhorro(Integer cbu, Double saldo) {
		super(cbu, saldo);
		setTipoCuenta(TipoDeCuenta.CAJA_AHORRO);
		this.contadorExtracciones=0;
	}

	@Override
	public Boolean extraerDinero(Double monto) {
		
		Boolean sePudoExtraer=false;
		
		Double maximoMontoExtraer=getSaldo();
		
		if(contadorExtracciones>=5) {
			maximoMontoExtraer=getSaldo()-6;
		}
		
		if (monto<=maximoMontoExtraer) {
			if (contadorExtracciones<5) {
				setSaldo(getSaldo()-monto);
					
			} else {
				setSaldo(getSaldo()-monto-6);
			}
			contadorExtracciones++;
			sePudoExtraer=true;
		}
		return sePudoExtraer;
	}

}
