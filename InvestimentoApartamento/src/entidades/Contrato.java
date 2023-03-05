package entidades;

import java.text.ParseException;

import servicos.ServicoBanco;
import servicos.ServicoBitCoin;
import servicos.ServicoFaculdade;

public class Contrato {

	private ServicoBitCoin conta1;
	private ServicoBanco conta2;
	private ServicoFaculdade conta3;

	public Contrato(ServicoBitCoin conta1, ServicoBanco conta2, ServicoFaculdade conta3) {
		this.conta1 = conta1;
		this.conta2 = conta2;
		this.conta3 = conta3;
	}

	private double totalFacul_bit() {
		return conta1.getValorAGanhar() - conta3.calcularConta();
	}

	private double totalFinal() {
		return totalFacul_bit() + conta2.getAmount();
	}

	public String formated() throws ParseException {
		StringBuilder bd = new StringBuilder();
		bd.append("---INFORMA합ES----\n");
		bd.append("---INFORMA합ES BITCOIN---\n");
		bd.append(conta2.format() + "\n");
		bd.append("----------------\n");
		bd.append("---INFORMA합ES BANCO DO BRASIL---\n");
		bd.append(conta1.format() + "\n");
		bd.append("----------------\n");
		bd.append("---INFORMA합ES FACULDADE---\n");
		bd.append(conta3.format() + "\n");
		bd.append(" TOTAL - FACULDADE : " + String.format("%.2f", totalFacul_bit()) + " (18 x 500)-Bitcoin \n");
		bd.append("----------------\n");
		bd.append("---TOTAL GERAL---\n");
		bd.append("Total ganho em 08/02/2024 :" + totalFinal() + "\n");
		bd.append("---INFORMA합ES----\n");
		return bd.toString();
	}

	public ServicoBitCoin getConta1() {
		return conta1;
	}

	public void setConta1(ServicoBitCoin conta1) {
		this.conta1 = conta1;
	}

	public ServicoBanco getConta2() {
		return conta2;
	}

	public void setConta2(ServicoBanco conta2) {
		this.conta2 = conta2;
	}

	public ServicoFaculdade getConta3() {
		return conta3;
	}

	public void setConta3(ServicoFaculdade conta3) {
		this.conta3 = conta3;
	}

}
