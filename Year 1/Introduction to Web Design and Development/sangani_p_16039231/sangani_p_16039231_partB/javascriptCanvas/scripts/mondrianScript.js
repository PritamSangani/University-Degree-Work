window.addEventListener('load', drawMondrian);

function drawMondrian()
{
    var canvas = document.getElementById('myCanvas');
    var context = canvas.getContext('2d');
    
    var canWidth = canvas.width; /*---set width of canvas equal to a variable called width---*/
    var canHeight = canvas.height; /*---set height of canvas equal to a variable called height---*/
    
    context.strokeStyle = 'black'; /*---set the outline of all rectangles to a black colour---*/
    for(i = 0; i<100; i++) /*---do code in loop 100 times(draw 100 rectangles)---*/
    {
        var rectWidth = (Math.random() *(canWidth)); /*---set a random value for the width of all rectangles(multiply by width of canvas so whole width of canvas can be drawn on)---*/
        var rectHeight = (Math.random() * (canHeight)); /*---set a random value for the height of all rectangles(multiply by height of canvas so whole height of canvas can be drawn on)---*/
        
        var x = Math.random(); /*---set a random x coordinate for rectangle---*/
        var y = Math.random(); /*---set a random y coordinate for rectangle---*/
        
        context.strokeRect(x,y,rectWidth,rectHeight); /*---draw rectangle using created variables---*/
    }
}