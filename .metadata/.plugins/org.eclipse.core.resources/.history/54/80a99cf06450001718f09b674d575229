package br.imd.visao;

import java.io.IOException;
import java.io.OutputStream;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartUtilities;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;

public class GeradorHistograma {

	private Object grafico;
	private DefaultCategoryDataset dados;
	private int fim;
	private int comeco;
	private SerieTemporal serie;

	public GeradorHistograma(SerieTemporal serie, int comeco, int fim){
		this.serie = serie;
		this.comeco = comeco;
		this.fim = fim;
		this.dados = new DefaultCategoryDataset();
		this.grafico = ChartFactory.createLineChart("Indicadores", "Dias", "Valores", dados,
				PlotOrientation.VERTICAL, true, true, false);
	}

	public void plotaMediaMovelSimples() {

		MediaMovelSimples ind = new MediaMovelSimples();

		for (int i = comeco; i <= fim; i++) {

			double valor = ind.calcula(i, serie);

			dados.addValue(valor, ind.toString(), Integer.valueOf(i));

		}

	}



	public void salva(OutputStream out) throws IOException {

		ChartUtilities.writeChartAsPNG(out, (JFreeChart) grafico, 500, 350);

	}

}