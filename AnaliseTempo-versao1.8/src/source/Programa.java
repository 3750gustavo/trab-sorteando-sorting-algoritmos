package source;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.GraphicsConfiguration;
import java.awt.HeadlessException;

import javax.swing.BorderFactory;
import javax.swing.JFrame;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.block.BlockBorder;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.plot.XYPlot;
import org.jfree.chart.renderer.xy.XYLineAndShapeRenderer;
import org.jfree.chart.title.TextTitle;
import org.jfree.data.xy.XYDataset;
import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;

public class Programa extends JFrame {
	long t[];

	public Programa() {
		initUI();
	}
	
	public void initUI() {
		XYDataset dataset = createDataset();
        JFreeChart chart = createChart(dataset);
        ChartPanel chartPanel = new ChartPanel(chart);
        chartPanel.setBorder(BorderFactory.createEmptyBorder(15, 15, 15, 15));
        chartPanel.setBackground(Color.white);
        add(chartPanel);

        pack();
        setTitle("Line chart");
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	 private XYDataset createDataset() {
		 XYSeries series = new XYSeries("bubblesort");
		 XYSeries series2 = new XYSeries("Quick sort");
		 XYSeries series3 = new XYSeries("Cube sort");
		 XYSeries series4 = new XYSeries("Shell sort");
		 Principal p = new Principal();
		 long t[] = p.execute();
		 for(int x=0;x<t.length;x++) {
			 series.add(x,t[x]);
		 }
		 Principal p2 = new Principal();
		 long t2[] = p2.executeA();
		 for(int x=0;x<t2.length;x++) {
			 series2.add(x,t2[x]);
		 }
		 Principal p3 = new Principal();
		 long t3[] = p3.executeB();
		 for(int x=0;x<t3.length;x++) {
			 series3.add(x,t3[x]);
		 }

		 Principal p4 = new Principal();
		 long t4[] = p4.executeB();
		 for(int x=0;x<t4.length;x++) {
			 series4.add(x,t4[x]);
		 }

	        XYSeriesCollection dataset = new XYSeriesCollection();
	        dataset.addSeries(series);
			dataset.addSeries(series2);
			dataset.addSeries(series3);
			dataset.addSeries(series4);
	        return dataset;
	    }
	 private JFreeChart createChart(XYDataset dataset) {
	        JFreeChart chart = ChartFactory.createXYLineChart(
	                "Tempo de execucao de algoritmo",
	                "Tamanho dados",
	                "Tempo execucao",
	                dataset,
	                PlotOrientation.VERTICAL,
	                true,
	                true,
	                false
	        );
	        XYPlot plot = chart.getXYPlot();
	        XYLineAndShapeRenderer renderer = new XYLineAndShapeRenderer();
	        renderer.setSeriesPaint(0, Color.RED);
			renderer.setSeriesPaint(1, Color.YELLOW);
			renderer.setSeriesPaint(2, Color.BLUE);
			renderer.setSeriesPaint(3, Color.GRAY);
	        renderer.setSeriesStroke(0, new BasicStroke(2.0f));
			renderer.setSeriesStroke(1, new BasicStroke(2.0f));
			renderer.setSeriesStroke(2, new BasicStroke(2.0f));
			renderer.setSeriesStroke(3, new BasicStroke(2.0f));

	        plot.setRenderer(renderer);
	        plot.setBackgroundPaint(Color.white);

	        plot.setRangeGridlinesVisible(true);
	        plot.setRangeGridlinePaint(Color.BLACK);

	        plot.setDomainGridlinesVisible(true);
	        plot.setDomainGridlinePaint(Color.BLACK);

	        chart.getLegend().setFrame(BlockBorder.NONE);

	        chart.setTitle(new TextTitle("Tempo de execucao de algoritmos",
	                        new Font("Serif", java.awt.Font.BOLD, 18)
	                )
	        );
	        return chart;
	    }

	private static final long serialVersionUID = 1L;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		
		EventQueue.invokeLater(() -> {

			Programa ex = new Programa();
            ex.setVisible(true);
        });
	}

}
