//Javascript for Three Rectangles Task
window.addEventListener('load', drawCanvas);

function drawCanvas()
{
    var canvas = document.getElementById('myCanvas');
    var context = canvas.getContext('2d');
    context.fillStyle = '#0000FF';
    context.fillRect(16,16,160,120);
    context.fillStyle = "rgba(255,0,0,0.5)";
    context.fillRect(68,58,160,120);
    context.fillStyle = '#0A5E2F';
    context.fillRect(120,100,160,120);
}