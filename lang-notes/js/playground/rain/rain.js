const CANVAS = document.getElementById("rain");
const CTX = CANVAS.getContext("2d");

CANVAS.height = window.innerHeight;
CANVAS.width = window.innerWidth;

CTX.lineWidth = 2;
CTX.strokeStyle = "white";
for (let i = 0; i < 150; i++) {
    let initX = Math.random() * window.innerWidth;
    let initY = 20;
    
    CTX.moveTo(initX, initY);
    CTX.lineTo(initX + Math.random() * 5, initY + Math.random() * 10);
    CTX.stroke();
}