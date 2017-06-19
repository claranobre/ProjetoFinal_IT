package br.imd.visao;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.CategoryDataset;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.ui.ApplicationFrame;
import org.jfree.ui.RefineryUtilities;

/**
 * 
 * @author Ana Clara e Felipe Gilberto
 * Classe GeradorHistograma irá gerar o Histograma dos dados de acesso dos usuários buscados
 *
 */

public class GeradorHistograma extends ApplicationFrame{

	public GeradorHistograma( String applicationTitle , String chartTitle ) {
		super( applicationTitle );        
		JFreeChart barChart = ChartFactory.createBarChart(
				chartTitle,           
				"Atividades",            
				"Frequencia",            
				createDataset(),          
				PlotOrientation.VERTICAL,           
				true, true, false);

		ChartPanel chartPanel = new ChartPanel( barChart );        
		chartPanel.setPreferredSize(new java.awt.Dimension( 560 , 367 ) );        
		setContentPane( chartPanel ); 
	}

	private CategoryDataset createDataset( ) {
		final String logon_user = "Logon";        
		final String device = "Device";        
		final String acesso = "Sites";        
		final String logon = "Logon";        
		final String logoff = "Logoff";        
		final String connect = "Connect";        
		final String disconnect = "Disconnect";        
		final DefaultCategoryDataset dataset = 
				new DefaultCategoryDataset();  

		dataset.addValue( 1.0 , logon_user , logon );                
		dataset.addValue( 5.0 , logon_user , logoff );          
       
		dataset.addValue( 6.0 , device , connect );       
		dataset.addValue( 4.0 , device , disconnect );

		/*dataset.addValue( 4.0 , acesso , logon );        
		dataset.addValue( 2.0 , acesso , connect );        
		dataset.addValue( 3.0 , acesso , logoff );        
		dataset.addValue( 6.0 , acesso , disconnect );*/     

		return dataset; 
	}

	public static void main(String[ ] args) {
		GeradorHistograma chart = new GeradorHistograma("Histograma", 
				"Atividades do Usuario");
		chart.pack();        
		RefineryUtilities.centerFrameOnScreen(chart);        
		chart.setVisible(true); 
	}
}