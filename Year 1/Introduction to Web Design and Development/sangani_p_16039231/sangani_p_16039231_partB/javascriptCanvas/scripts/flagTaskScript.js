window.addEventListener('load', drawBrazilFlag); 

function drawBrazilFlag()
{
    var canvas = document.getElementById('myCanvas');
    var context = canvas.getContext('2d');
    
    context.fillStyle = '#00A859'; /*---fill outer rectangle of flag in a green shade---*/
    context.fillRect(40,40,800,560); /*---draw rectangle---*/
    
    context.fillStyle = '#FFCC29'; /*---choose a gold colour for rhombus---*/
    context.beginPath();
    context.moveTo(108,320); /*---start point of rhombus---*/
    context.lineTo(440,108); 
    context.lineTo(772,320);
    context.lineTo(440,532);
    context.closePath();
    context.fill(); /*---fill rhombus---*/
    
    context.beginPath();
    context.arc(440,320,140,0,Math.PI*2,true); /*---draw a 360 degree arc(circle)---*/
    context.closePath();
    context.fillStyle = '#3E4095'; /*---choose a blue colour for circle---*/
    context.fill();  
}