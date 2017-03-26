package com.zhouchatian.admin.robotdailly;

import android.app.Activity;
import android.os.Bundle;
import android.renderscript.Sampler;
import android.support.annotation.Nullable;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import lecho.lib.hellocharts.model.ChartData;
import lecho.lib.hellocharts.model.Line;
import lecho.lib.hellocharts.model.LineChartData;
import lecho.lib.hellocharts.model.PointValue;
import lecho.lib.hellocharts.model.ValueShape;
import lecho.lib.hellocharts.util.ChartUtils;
import lecho.lib.hellocharts.view.Chart;
import lecho.lib.hellocharts.view.LineChartView;

/**
 * Created by  Mr.Robot on 2017/3/26.
 * zhouchatain@gmail.com
 * GitHub:TheSadFrog
 */

public class ChartsActivity extends Activity {

    private LineChartView mChart;
    private Map<String,Integer> table = new TreeMap<>();
    private LineChartData mData;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.chart_view);
        mChart = (LineChartView) findViewById(R.id.chart);
        mData = new LineChartData();
        List<CostBean> allDate = (List<CostBean>) getIntent().getSerializableExtra("cost_list");
        generateValues(allDate);
        generateData();
    }

    private void generateData() {
        List<Line> lines = new ArrayList<>();
        List<PointValue> values = new ArrayList<>();
        int indexX = 0;
        for(Integer value : table.values()){
            values.add(new PointValue(indexX, value));
            indexX++;
        }
        Line line = new Line(values);
        line.setColor(ChartUtils.COLORS[0]);
        line.setShape(ValueShape.CIRCLE);
        line.setPointColor(ChartUtils.COLORS[1]);
        lines.add(line);
        mData.setLines(lines);
        mChart.setLineChartData(mData);
    }

    private void generateValues(List<CostBean> allDate) {
        if(allDate != null){
            for (int i = 0; i < allDate.size(); i++) {
                CostBean costBean = allDate.get(i);
                String costDate = costBean.costDate;
                int costMoney = Integer.parseInt(costBean.costMoney);
                if(!table.containsKey(costDate)){
                    table.put(costDate,costMoney);
                }else {
                    int originMoney = table.get(costDate);
                    table.put(costDate,originMoney + costMoney);
                }
            }
        }
    }
}
