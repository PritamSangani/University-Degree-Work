document.addEventListener("DOMContentLoaded", initialise);
function initialise()
{
	var video = document.getElementById("video");	
    video.volume = 0.5; /*---default volume = 50% when video first plays---*/
 /*---declare variables for each of the different controls for the video and link them with declaration in HTML---*/   
	var playButton = document.getElementById("playPause");
	var muteButton = document.getElementById("mute");
	var scrubSlider = document.getElementById("seekBar");
    var volumeSlider = document.getElementById("volume");
    var playbackRate = document.getElementById("playbackSpeed");
    var rewindButton = document.getElementById("rewind");
    var fastForwardButton = document.getElementById("fastForward");
/*---EVENT LISTENERS---*/      
	playButton.addEventListener("click", playPauseVideo); //listen for a button click event
	muteButton.addEventListener("click", muteUnmuteVideo); //listen for a button click event
	
	scrubSlider.addEventListener("change", scrubVideo);    //listen for a change in value event
	scrubSlider.addEventListener("mousedown", pauseSlider); //listen for mouse pressed down event
	scrubSlider.addEventListener("mouseup", resumeSlider);  //listen for a mouse released event
	video.addEventListener("timeupdate", movePlaySlider);  //listen for a change in time event
    
    volumeSlider.addEventListener("change", changeVolume); //listen for a change in value event
    
    video.addEventListener("durationchange", getDuration);  //listen for a change in the duration of the video event
    video.addEventListener("timeupdate", getPlaybackTime);  //listen for a change in time event
    video.addEventListener("durationchange", getPlaybackTime);  //listen for a change in the 
    playbackRate.addEventListener("change", videoSpeed);
    
    rewindButton.addEventListener("click", rewindVideo); //listen for a button click event
    fastForwardButton.addEventListener("mousedown", tripleSpeed); //listen for a mouse pressed down event
    fastForwardButton.addEventListener("mouseup", doubleSpeed); //listen for a mouse released event
    fastForwardButton.addEventListener("dblclick", normalSpeed); //listen for a mouse double clicked event
    
/*---FUNCTIONS---*/	
	function playPauseVideo()
	{
		if(video.paused === true) /*---if video is paused...---*/
		{
			video.play(); /*---resume video when play/pause button clicked---*/
			playButton.innerHTML = "Pause"; /*---change label of button to "Pause"---*/
		}
		else  /*---if video is playing...---*/
		{
			video.pause(); /*---pause video when play/pause button clicked---*/
			playButton.innerHTML = "Play"; /*---change label of button to "Play"---*/
		}
	}
    
	function muteUnmuteVideo()
	{
		if(video.muted === true)  /*---if video is muted...---*/
		{
			video.muted=false; /*---unmute video when mute button pressed---*/
			muteButton.innerHTML = "Mute"; /*---change label of button to "Mute"---*/
		}
		else  /*---if video is unmuted...---*/
		{
			video.muted=true; /*---mute video when mute button pressed---*/
			muteButton.innerHTML = "Unmute"; /*---change label of button to "Unmute"---*/	
		}
	}
    
	function scrubVideo()
	{
		var scrubTime = video.duration * (scrubSlider.value / 100); /*---declare a variable and make it equal to the (duration of the video multiplied by the current value of the slider/100)---*/
		video.currentTime = scrubTime;	/*---make the current playback time of the video equal to scrubTime---*/
	}
	function movePlaySlider()
	{
		var playbackPoint = (100 / video.duration) * video.currentTime; /*---work out current playbackPoint---*/
		scrubSlider.value = playbackPoint;	
	}
	function pauseSlider()
	{
		
		video.pause();	/*---if scrubSlider is being moved pause video---*/
	}
	function resumeSlider()
	{
		video.play();	/*---when mouse is released from scrubSlider resume video---*/
	}
    
    function changeVolume()
    {
        var setVolume = (volumeSlider.value /100); /*---divide value of volumeSlider by 100 to get value of volume between 0 and 1---*/
        video.volume = setVolume;
    }
    
    function getDuration()
    {
        var durationDisplay = document.getElementById("durationField"); 
        var videoDuration = video.duration;
        
        var minutes = Math.floor(videoDuration / 60); /*---divide videoDuration value by 60 to get the number of minutes---*/
        var seconds = Math.floor(videoDuration % 60); /*---get the remainder of videoDuration value from 60 to get the number of seconds---*/
        
        if(minutes<10){
            minutes = "0" + minutes;  /*---add 0 to the front of the minutes value if video duration is less than 10 minutes---*/
        }
        if(seconds<10){
            seconds = "0" + seconds;  /*---add 0 to the front of the seconds value if video duration is less than 10 seconds---*/
        }
        durationDisplay.value = minutes + ":" + seconds;
    }	
    function getPlaybackTime()
    {
        var playbackDisplay = document.getElementById("playbackField");
        var currentPlayback = video.currentTime;
        
        var minutes = Math.floor(currentPlayback / 60); 
        var seconds = Math.floor(currentPlayback % 60);
        
        if(minutes<10){
            minutes = "0" + minutes; 
        }
        if(seconds<10){
            seconds = "0" + seconds; 
        }
        playbackDisplay.value = minutes + ":" + seconds;  
    }
    
    function videoSpeed()
    {
        video.playbackRate = playbackRate.value; /*---make value selected(using drop list) = to playbackRate---*/
    }
    
    function rewindVideo()
    {
        video.currentTime = 0; /*---when rewind button pressed video goes to start---*/
    }
    
    function normalSpeed()
    {
        playbackRate.value = 1;
        video.playbackRate = playbackRate.value;
    }
    
    function doubleSpeed()
    {
        playbackRate.value = 2;
        video.playbackRate = playbackRate.value;
    }
    
    function tripleSpeed()
    {
        video.playbackRate = 3;
    }
}