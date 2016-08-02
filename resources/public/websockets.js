function plot(json) {
    console.log(json);

    var svg = d3.select("body").append("svg");
    
    svg.selectAll("circle")
	.data(json)
	.enter().append("circle")
	.attr("cx", function(d) {return d["x"];})
	.attr("cy", function(d) {return d["y"];})
	.attr("r", 20)
	.style("fill", "steelblue");
    
};

var socket = new WebSocket("ws://localhost:8140/data/");

socket.onopen = function (event) {
    console.log("Socket opened");
};

socket.onmessage = function (event) {
    console.log(event.data);
    var data = JSON.parse(event.data);
    plot(data);
}


