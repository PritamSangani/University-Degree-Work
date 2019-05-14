// Display Chat when page has loaded
$(document).ready(function () {
    displayChat();
});

// event listener - when enter key is pressed decide what to do with chat input
$(document).keypress(function (e) {
    if (e.which === 13) {
        handleUserInput();
    }
});

// handles what happens when enter key is pressed
function handleUserInput() {
    let content = $(".send-textbox").val();

    if (content === null || content !== null && content.length === 0) {
		error("Error: Input cannot be blank");
	} else {
        sendElizaNewMessage(content);
    }
}

// handles errors sending them to user as notifications - see notifications.js
function error(message) {
    createNegativeNotification(message, 9);
}

// // function to display chat when logged in
// function displayChat() {
//     // load chat from db
//
//     // insert random greeting
// }
//
// // function that handles what happens when user enters a message
// function sendElizaNewMessage(message) {
//     // add to chat
//
//     // send to db
//
// }

// function to get the html content for a new message from ELIZA
function getElizaMessageHTML(message) {
	return `<div class="chat-message-outter-wrapper"><img src="static/images/guy.png" class="chat-message-icon"><div class="chat-message-wrapper eliza-message"><p class="chat-message-text text-left">${message}</p><p class="chat-user-text">Eliza</p></div></div>`;
}

// function to get html content for a new message from user
function getUserMessageHTML(message) {
	return `<div class="chat-message-outter-wrapper text-right"><div class="chat-message-wrapper you-message"><p class="chat-message-text text-left">${message}</p><p class="chat-user-text">You</p></div><img src="static/images/laptop.png" class="chat-message-icon"></div>`;
}

// function that clears the send text field after a message has been handled
function clearSendTextbox() {
	$(".send-textbox").val('');
}