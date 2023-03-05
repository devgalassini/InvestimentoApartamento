package entidades;

import java.text.ParseException;

public class UNA extends AbstractServiceFacul {
	private int Periodos_3 = 18;
	private int mensalidade = 500;

	public UNA() {

	}

	@Override
	public String format() throws ParseException {
		StringBuilder bd = new StringBuilder();
		bd.append("Gastos com Faculdade : " + String.format("%.2f", calcularConta()) + "\n");
		return bd.toString();
	}

	public int getPeriodos_3() {
		return Periodos_3;
	}

	public void setPeriodos_3(int periodos_3) {
		Periodos_3 = periodos_3;
	}

	public double getMensalidade() {
		return mensalidade;
	}

	public void setMensalidade(int mensalidade) {
		this.mensalidade = mensalidade;
	}

}
