window.addEventListener('load', drawLine);

function drawLine()
{
    var canvas = document.getElementById('myCanvas');
    var context = canvas.getContext('2d');
    context.beginPath();
    context.moveTo(0,40);
    context.lineWidth = 4;
    context.lineTo(100,40);
    context.closePath();
    context.strokeStyle = 'blue';
    context.stroke();
    
    context.beginPath();
    context.moveTo(0,80);
    context.lineWidth = 4;
    context.lineTo(100,80);
    context.closePath();
    context.strokeStyle = 'red';
    context.stroke();
}