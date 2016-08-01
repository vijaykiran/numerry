function plot(json) {

    var svg = d3.select("body").append("svg");
    
    svg.selectAll("circle")
	.data(json)
	.enter().append("circle")
	.attr("cx", function(d) {return d["x"];})
	.attr("cy", function(d) {return d["y"];})
	.attr("r", 20)
	.style("fill", "steelblue");
    
};

d3.json(window.location.href + "/data", function(json) {
    plot(json);
});

