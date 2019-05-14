/*
 * Starts by displaying the chat
 */
$(document).ready(function () {
	displayChat();
});
/*
 * Watches for enter key to be pressed
 */

$(document).keypress(function (e) {
	//When the enter key is pressed
	if (e.which === 13) {
		getUserInput();
	}
});
/*
 * Takes the content out of the textbox,
 * error checks, and checks for demos.
 */
function getUserInput() {
	let inputFromUser = $(".send-textbox").val();

	if (inputFromUser === null || inputFromUser !== null && inputFromUser.length === 0) {
		error("Error: Input cannot be blank");
	} else if (inputFromUser === "run demo1") {
		runDemo1();
		clearSendTextbox();
	} else if (inputFromUser === "run demo2") {
		runDemo2();
		clearSendTextbox();
	} else {
		sendElizaNewMessage(inputFromUser);
	}
}
/*
 * Shows error using notifications
 */
function error(message) {
	//console.log(message);
	createNegativeNotification(message, 9);
}
/*
 * Refreshes the HTML based on the 
 * chat history array which is a list
 * of chat messages sent from the user
 * and eliza.
 */
function displayChat() {
	//console.log("displayChat");

	let html = '';
	if (chatHistory.length === 0) {
		startElizaChat();
	} else {
		for (let i = 0; i < chatHistory.length; i++) {

			let currentMessage = chatHistory[i];
			// console.log("loop");

			if (currentMessage.isEliza) {
				html += getElizaMessageHTML(currentMessage.content);
			} else {
				html += getUserMessageHTML(currentMessage.content);
			}
		}
		let chat_area = $("#chat-area");
		chat_area.html(html);
		chat_area.scrollTop(chat_area)[0].scrollHeight;
	}
	let body = $("#body");
	body.scrollTop(body)[0].scrollHeight;
	//console.log($('#body')[0].scrollHeight);
}
/*
 * HTML for Eliza's message
 */
function getElizaMessageHTML(message) {
	return '<div class="chat-message-outter-wrapper"><img src="static/images/guy.png" class="chat-message-icon"><div class="chat-message-wrapper eliza-message"><p class="chat-message-text text-left">' + message + '</p><p class="chat-user-text">Eliza</p></div></div>';
}
/*
 * HTML for User's message
 */
function getUserMessageHTML(message) {
	return '<div class="chat-message-outter-wrapper text-right"><div class="chat-message-wrapper you-message"><p class="chat-message-text text-left">' + message + '</p><p class="chat-user-text">You</p></div><img src="static/images/laptop.png" class="chat-message-icon"></div>';
}
/*
 * Empty user send textbox
 */
function clearSendTextbox() {
	$(".send-textbox").val('');
}