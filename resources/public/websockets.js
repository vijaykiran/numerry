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

var socket = new WebSocket("ws://" + window.location.host + "/data/");

socket.onmessage = function (event) {
    var data = JSON.parse(event.data);
    console.log(data);
    plot(data);
};

socket.onopen = function () {
    console.log("Socket opened");
    socket.send(JSON.stringify({"uri": window.location.pathname}));
};


