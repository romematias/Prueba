package ar.edu.banco.dominio;

public class CuentaCorriente extends Cuenta {

	private Boolean estaEnDeuda=false;
	private Double descubierto;
	
	public CuentaCorriente(Integer cbu, Double saldo, Double descubierto) {
		super(cbu, saldo);
		setTipoCuenta(TipoDeCuenta.CUENTA_CORRIENTE);
		this.descubierto=descubierto;
	}

//	@Override
//	public Boolean extraerDinero(Double monto) {
//		if(monto<=this.getSaldo()) {
//			this.setSaldo(getSaldo()-monto);
//			return true;
//		} 
//		if (monto>this.getSaldo() && monto<(this.getSaldo()+this.descubierto)) {
//			
//			Double descubiertoUsado=monto-this.getSaldo();
//			Double comision=(descubiertoUsado*5)/100;
//			this.setSaldo(getSaldo()-monto-comision);
//			
//			this.descubierto=descubiertoUsado+comision;
//			
//			if(this.getEstadoDeuda()==false) {
//				this.estaEnDeuda=true;
//			}
//			return true;
//		}
//		return false;
//	}

	@Override
	public Boolean extraerDinero(Double monto) {
		if(monto<=this.getSaldo()) {
			this.setSaldo(getSaldo()-monto);
			return true;
		}
		if (monto>this.getSaldo() && monto<=(this.getSaldo()+this.descubierto)) {
			Double descubiertoUsado=monto-this.getSaldo();
			Double comision=((descubiertoUsado*5)/100);
			this.setSaldo(0.0);
			this.descubierto=this.descubierto-(descubiertoUsado+comision);
			return true;
		}
		return false;
	}
	
	@Override
	public Boolean depositarDinero(Double monto) {
		if(monto>0) {
			if (this.getDescubierto()==150.00) {
			this.setSaldo(getSaldo()+monto);
			return true;
			}
			
			if (this.getDescubierto()<150 && monto>=this.getDescubierto()) {
				Double saldoASumar=monto-getDescubierto();
				this.descubierto=150.00;
				this.setSaldo(getSaldo()+saldoASumar);
				return true;
			}
			if (monto<this.getDescubierto()) {
				this.descubierto+=monto;
				return true;
			}
		}
		return false;
	}
	
	public Boolean getEstadoDeuda() {
		return this.estaEnDeuda;
	}
	
	public Double getDescubierto() {
		return this.descubierto;
	}
}
