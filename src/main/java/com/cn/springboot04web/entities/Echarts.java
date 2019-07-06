package com.cn.springboot04web.entities;

import java.util.ArrayList;
import java.util.List;

public class Echarts {
    List <String> legend;
    List <String> axis;
    List <Series> series;
    public Echarts(List<String> legend, List<String> axis, List<Series> series) {
        this.legend=legend;
        this.axis=axis;
        this.series=series;
    }

    public Echarts() {

    }

    public List<String> getLegend() {
        return legend;
    }

    public List<String> getAxis() {
        return axis;
    }

    public List<Series> getSeries() {
        return series;
    }

    public void setLegend(List<String> legend) {
        this.legend = legend;
    }

    public void setAxis(List<String> axis) {
        this.axis = axis;
    }

    public void setSeries(List<Series> series) {
        this.series = series;
    }
}
