//Javascript for Flags Task
window.addEventListener('load', drawCanvas);

function drawCanvas()
{
    var canvas = document.getElementById('myCanvas');
    var context = canvas.getContext('2d');
    //Germany Flag
    context.fillStyle = '#000000';
    context.fillRect(20,20,200,40);
    context.fillStyle = '#FF0000';
    context.fillRect(20,60,200,40);
    context.fillStyle = '#FFCC00';
    context.fillRect(20,100,200,40);
}