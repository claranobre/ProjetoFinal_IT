package br.imd.visao;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.CategoryDataset;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.ui.ApplicationFrame;
import org.jfree.ui.RefineryUtilities;

import br.imd.controle.Calendario;

/**
 * 
 * @author Ana Clara e Felipe Gilberto
 * Classe GeradorHistograma irá gerar o Histograma dos dados de acesso dos usuários buscados
 *
 */

public class GeradorHistograma extends ApplicationFrame{
/**
 * Método Construtor
 * @param applicationTitle
 * @param chartTitle
 * @param contadorLogon
 * @param contadorLogoff
 * @param contadorConnect
 * @param contadorDisconnect
 * @param contadorHttp
 */
	public GeradorHistograma( String applicationTitle , String chartTitle, int contadorLogon, int contadorLogoff, int contadorConnect, int contadorDisconnect, int contadorHttp ) {
		super( applicationTitle );        
		JFreeChart barChart = ChartFactory.createBarChart(
				chartTitle,           
				"Atividades",            
				"Frequencia",            
				createDataset(contadorLogon, contadorLogoff, contadorConnect, contadorDisconnect, contadorHttp),          
				PlotOrientation.VERTICAL,           
				true, true, false);

		ChartPanel chartPanel = new ChartPanel( barChart );        
		chartPanel.setPreferredSize(new java.awt.Dimension( 560 , 367 ) );        
		setContentPane( chartPanel ); 
	}
/**
 * Método createDataset do tipo CategoryDataset
 * @param contadorLogon
 * @param contadorLogoff
 * @param contadorConnect
 * @param contadorDisconnect
 * @param contadorHttp
 * @return dataset
 */
	public static CategoryDataset createDataset(int contadorLogon, int contadorLogoff, int contadorConnect, int contadorDisconnect, int contadorHttp) {
		
		final String logon_user = "Logon";        
		final String device = "Device";        
		final String acesso = "Sites";   
		final String http = "Acessados";
		final String logon = "Logon";        
		final String logoff = "Logoff";        
		final String connect = "Connect";        
		final String disconnect = "Disconnect";        
		final DefaultCategoryDataset dataset = new DefaultCategoryDataset();
		
		dataset.addValue(contadorLogon, logon_user , logon );                
		dataset.addValue(contadorLogoff, logon_user , logoff );          
       
		dataset.addValue(contadorConnect, device , connect );       
		dataset.addValue(contadorDisconnect, device , disconnect );

		dataset.addValue(contadorHttp, http, acesso);

		return dataset; 
	}
}