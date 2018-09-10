package com.app.charts;

import java.io.File;
import java.util.List;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartUtilities;
import org.jfree.chart.JFreeChart;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.data.general.DefaultPieDataset;
import org.springframework.stereotype.Component;
@Component
public class CstomerPieChart {

	public void generatePie(String path,List<Object[]> li) {
		DefaultPieDataset dataset=new DefaultPieDataset();
		for(Object[] ob:li) {
			dataset.setValue(ob[0].toString(),new Double(ob[1].toString()));
			JFreeChart jf=ChartFactory.createPieChart3D("Customer", dataset, true, true, false);
			try {
				ChartUtilities.saveChartAsJPEG(new File(path+"/CustomerPieChartA.jpg"), jf,250,250);
			}catch(Exception e) {
				e.printStackTrace();
			}

		}

	}
	public void generateBarChart(String path,List<Object[]> li) {
		DefaultCategoryDataset dataset=new DefaultCategoryDataset();
		for(Object[] ob:li) {
			dataset.setValue(new Double(ob[1].toString()),ob[0].toString(),"");
		}
		JFreeChart jc=ChartFactory.createBarChart3D("CustomerReport","Customer Type", "count", dataset);

		try {
			ChartUtilities.saveChartAsJPEG(new File(path+"/customerBar.jpg"), jc, 250, 250);
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}
}