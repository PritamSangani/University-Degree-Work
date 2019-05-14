window.addEventListener('load', drawTriangle);

function drawTriangle()
{
    var canvas = document.getElementById('myCanvas');
    var context = canvas.getContext('2d');
    
    context.fillStyle = 'red';
    context.beginPath();
    context.moveTo(50,100);
    context.lineTo(100,150);
    context.lineTo(150,100);
    context.lineTo(100,50);
    context.closePath();
    context.fill();
}