/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ui.CarInsuranceManager;

import java.awt.Color;
import java.awt.Font;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.axis.CategoryAxis;
import org.jfree.chart.axis.ValueAxis;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.PiePlot;
import org.jfree.chart.plot.Plot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.renderer.category.CategoryItemRenderer;
import org.jfree.data.category.CategoryDataset;
import org.jfree.data.category.DefaultCategoryDataset;

public class BarChart {
	ChartPanel frame1;
	public  BarChart( CategoryDataset dataset ){
        JFreeChart chart = ChartFactory.createBarChart3D(
       		                 "", // 图表标题
                            "Loss Range", // 文件夹轴的显示标签
                            "distribution", // 数值轴的显示标签
                            dataset, // 数据集
                            PlotOrientation.VERTICAL, // 图表方向：水平、垂直
                            true,           // 是否显示图例(对于简单的柱状图必须是false)
                            false,          // 是否生成工具
                            false           // 是否生成URL链接
                            );
        
        //从这里開始
        CategoryPlot plot=chart.getCategoryPlot();//获取图表区域对象
        CategoryAxis domainAxis=plot.getDomainAxis();        //水平底部列表
         domainAxis.setLabelFont(new Font("黑体",Font.BOLD,14));         //水平底部标题
         domainAxis.setTickLabelFont(new Font("宋体",Font.BOLD,12));  //垂直标题
         ValueAxis rangeAxis=plot.getRangeAxis();//获取柱状
         rangeAxis.setLabelFont(new Font("黑体",Font.BOLD,15));
          chart.getLegend().setItemFont(new Font("黑体", Font.BOLD, 15));
          chart.getTitle().setFont(new Font("宋体",Font.BOLD,20));//设置标题字体
            CategoryItemRenderer renderer = plot.getRenderer();
            renderer.setSeriesPaint(0, new Color(0,153,255));
            
          
          
          //到这里结束，尽管代码有点多，但仅仅为一个目的，解决汉字乱码问题
          
         frame1=new ChartPanel(chart,true);        //这里也能够用chartFrame,能够直接生成一个独立的Frame
         
	}
	   
public ChartPanel getChartPanel(){
	return frame1;
	
}
}