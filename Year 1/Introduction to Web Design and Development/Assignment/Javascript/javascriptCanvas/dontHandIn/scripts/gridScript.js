window.addEventListener('load', drawGrid);

function drawGrid()
{
    var canvas = document.getElementById('myCanvas');
    var context = canvas.getContext('2d');
    
    for(var y = 5; y<100; y+=10)
        {
            context.beginPath();
            context.moveTo(0,y);
            context.lineWidth = 1;
            context.lineTo(100,y);
            context.closePath();
            context.strokeStyle = 'black';
            context.stroke();
        }
    for(var x =10; x<100; x+=10)
    {
            context.beginPath();
            context.moveTo(x,5);
            context.lineWidth = 1;
            context.lineTo(x,100);
            context.closePath();
            context.strokeStyle = 'black';
            context.stroke();
    }
}