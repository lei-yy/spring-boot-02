import plotly;




def draw_line_graph():
    #准备图轨数据
    trace_1=plotly.graph_objs.Scatter(
        x=[1,2,3,4],
        y=[32,44,11,66],
        name="散点图",
        mode="markers"
    )
    trace_2 = plotly.graph_objs.Scatter(
        x=[1, 2, 3, 4],
        y=[55, 35, 22, 44],
        name="折线图",

    )
    line_data=[trace_1,trace_2]
    #设置画布布局
    layout = plotly.graph_objs.Layout(title="折线图测试",xaxis={"title":"x"},yaxis={"title":"y"})
    #融合图轨数据布局
    figure = plotly.graph_objs.Figure(data=line_data,layout=layout)
    #输出
    plotly.offline.plot(figure,filename="D:/1/upload/line-graph.html")



def draw_bar_graph():
    # 准备图轨数据
    trace_1 = plotly.graph_objs.Bar(
        x=[1, 2, 3, 4],
        y=[32, 44, 11, 66],
        name="A类"
    )
    trace_2 = plotly.graph_objs.Bar(
        x=[1, 2, 3, 4],
        y=[13, 42, 7, 35],
        name="B类"
    )
    trace_3 = plotly.graph_objs.Bar(
        x=[1, 2, 3, 4],
        y=[24, 26, 13, 66],
        name="C类"
    )
    trace_4 = plotly.graph_objs.Bar(
        x=[1, 2, 3, 4],
        y=[46, 4, 76, 88],
        name="D类"
    )
    bar_data=[trace_1,trace_2,trace_3,trace_4]
    # 设置画布布局
    layout = plotly.graph_objs.Layout(title="柱状图测试", xaxis={"title": "季度"}, yaxis={"title": "产值"})
    # 融合图轨数据布局
    figure = plotly.graph_objs.Figure(data=bar_data, layout=layout)
    # 输出
    plotly.offline.plot(figure, filename="D:/1/upload/bar-graph.html")


def draw_pie_graph():
    #准备图轨数据
    trace_1=plotly.graph_objs.Pie(
        labels=["A","B","C","D"],
        values=[24,52,36,45]
    )

    pie_data=[trace_1]
    #设置画布布局
    layout = plotly.graph_objs.Layout(title="饼状图测试",xaxis={"title":"x"},yaxis={"title":"y"})
    #融合图轨数据布局
    figure = plotly.graph_objs.Figure(data=pie_data,layout=layout)
    #输出
    plotly.offline.plot(figure,filename="D:/1/upload/pie-graph.html")





if __name__ == "__main__":
    draw_line_graph();
    draw_bar_graph();
    draw_pie_graph()