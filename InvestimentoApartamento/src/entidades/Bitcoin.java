package entidades;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import enumerados.SituacaoBitcoin;
import personalizada.Erro;

public class Bitcoin extends AbstractServiceInvestimentoBitCoin {
	List<Double> listMeses = new ArrayList<>();
	final Double valorFixo = 2500.0;
	private double porcento = 0.1;
	private int tempoContrato = 36;
	private Date dataComeço;
	private int mesAtual;
	private int valorInicial = 25000;

	public String validationMonth() throws Erro {
		if (mesAtual < 0 || mesAtual > tempoContrato) {
			throw new Erro("Tempo de Contrato Inválido");
		} else {
			return "";
		}
	}

	public Bitcoin() {
		super();
	}

	public Double getValorMes(int parcela) {
		return listMeses.get(parcela - 1);
	}

	public Bitcoin(Integer mesAtual) throws Erro {
		this.mesAtual = mesAtual;
		for (int i = 1; i <= mesAtual; i++) {
			setMeses(valorFixo);
		}

		validationMonth();
	}

	public List<Double> getListMeses() {
		return listMeses;
	}

	public void setMeses(double parcela) {
		listMeses.add(parcela);
	}

	private final SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

	@Override
	public double calcularConta() {
		double soma = 0;
		for (Double lista : listMeses) {
			soma = soma + lista;
		}
		return soma;
	}

	public double quantiaPorMes() {
		return porcento * valorInicial;
	}

	public Date calcularDate() throws ParseException {
		String date = "08/02/2021";
		dataComeço = sdf.parse(date);
		Calendar cal = Calendar.getInstance();
		cal.setTime(dataComeço);
		cal.add(Calendar.MONTH, tempoContrato);
		Date dataFinal = cal.getTime();
		return dataFinal;
	}

	private SituacaoBitcoin situacao;

	public SituacaoBitcoin getSituação() {
		return situacao;
	}

	public void setSituação(SituacaoBitcoin situacao) {
		this.situacao = situacao;
	}

	int mesesRestantes;
	double total;
	double valorAGanhar;

	@Override
	public String format() throws ParseException {
		calcularDate();
		StringBuilder bd = new StringBuilder();
		bd.append("Começo : " + sdf.format(dataComeço) + "\n");
		bd.append("Final : " + sdf.format(calcularDate()) + "\n");
		bd.append("Tempo de Contrato Atual : " + mesAtual + "\n");
		bd.append("Tempo de Contrato Total : " + tempoContrato + "\n");
		if (mesAtual < 10) {
			bd.append("Faltam " + (10 - mesAtual) + " meses para começar a lucrar\n");

			setSituação(SituacaoBitcoin.valueOf("PREJUIZO"));
		} else if (mesAtual == 10) {
			bd.append("Mês 10 ");
			setSituação(SituacaoBitcoin.valueOf("NEUTRO"));
		} else {
			System.out.println("Período de Lucro !!!");
			setSituação(SituacaoBitcoin.valueOf("LUCRO"));
		}
		bd.append("Quantia á ganhar por mês : " + String.format("%.2f", quantiaPorMes()) + "\n");
		bd.append("Dinheiro ganho até agora : " + String.format("%.2f", calcularConta()) + "\n");
		total = quantiaPorMes() * tempoContrato;
		valorAGanhar = total - calcularConta();
		bd.append("Restante á ganhar :  " + String.format("%.2f", total) + " - "
				+ String.format("%.2f", calcularConta()) + " = " + String.format("%.2f", valorAGanhar) + "\n");
		mesesRestantes = tempoContrato - mesAtual;
		bd.append("Meses Restantes de Contrato : " + mesesRestantes + " X " + String.format("%.2f", quantiaPorMes())
				+ " = " + String.format("%.2f", mesesRestantes * quantiaPorMes()) + "\n");

		bd.append(" Total :  " + String.format("%.2f", total) + " | Isso - "
				+ String.format("%.2f", (total - calcularConta())) + " = " + String.format("%.2f", calcularConta())
				+ "\n");

		return bd.toString();
	}

	public Double getPorcento() {
		return porcento;
	}

	public void setPorcento(Double porcento) {
		this.porcento = porcento;
	}

	public Integer getTempoContrato() {
		return tempoContrato;
	}

	public void setTempoContrato(Integer tempoContrato) {
		this.tempoContrato = tempoContrato;
	}

	public Date getDataComeço() {
		return dataComeço;
	}

	public void setDataComeço(Date dataComeço) {
		this.dataComeço = dataComeço;
	}

	public Integer getMesAtual() {
		return mesAtual;
	}

	public void setMesAtual(Integer mesAtual) {
		this.mesAtual = mesAtual;
	}

	public Integer getValorInicial() {
		return valorInicial;
	}

	public void setValorInicial(Integer valorInicial) {
		this.valorInicial = valorInicial;
	}

	public void setMesesRestantes(int mesesRestantes) {
		this.mesesRestantes = mesesRestantes;
	}

	public void setTotal(double total) {
		this.total = total;
	}

	public void setValorAGanhar(double valorAGanhar) {
		this.valorAGanhar = valorAGanhar;
	}

	public SimpleDateFormat getSdf() {
		return sdf;
	}

	public void setPorcento(double porcento) {
		this.porcento = porcento;
	}

	public void setTempoContrato(int tempoContrato) {
		this.tempoContrato = tempoContrato;
	}

	public void setMesAtual(int mesAtual) {
		this.mesAtual = mesAtual;
	}

	public void setValorInicial(int valorInicial) {
		this.valorInicial = valorInicial;
	}

	@Override
	public double getValorAGanhar() {
		return valorAGanhar;
	}

	@Override
	public double getTotal() {
		return total;
	}

	@Override
	public double getMesesRestantes() {
		return mesesRestantes;
	}

}
