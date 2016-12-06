/**
 * Created by guo on 15-7-2.
 */
var can;
var ctx;
var width;
var height;

var girlPic = new Image();
var starPic = new Image();

var num = 60;
var stars = [];

var lastTime;
var deltaTime;

var switchy = false;
var life = 0;
function init(){

	can = document.getElementById("canvas");
	ctx = can.getContext("2d");
	width = can.width;
	height = can.height;

	//添加鼠标事件
	document.addEventListener("mousemove",mousemove,false);

	girlPic.src = "images/girl.jpg";
	starPic.src = "images/star.png";

	for(var i = 0; i< num; i++){
		var obj = new starObj();
		stars.push(obj);
		stars[i].init();
	}

	lastTime = Date.now();
	gameloop();
}
document.body.onload = init;
function gameloop(){
	window.requestAnimFrame(gameloop);
	var now = Date.now();
	deltaTime = now - lastTime;
	lastTime = now;
	drawBackground();
	drawGirl();
	drawStars();
	aliveUpdate();
}
function drawBackground(){
	ctx.fillStyle = "#393550";
	ctx.fillRect(0,0,width,height);
}
function drawGirl(){
	ctx.drawImage(girlPic,100,150,600,300);
}
function mousemove(e){
	if(e.offsetX || e.layerX){
		var px = e.offsetX == undefined? e.layerX: e.offsetX;
		var py = e.offsetY == undefined? e.layerY: e.offsetY;

		console.log(px+","+py);
		if(px > 100 && px < 700 && py>150&&py<450){
			switchy = true;
		}else{
			switchy = false;
		}
	}
}