// File containing all functions related to getting and display chat messages

function getElizaMessageHTML(message) {
    return `<div class="chat-message-outer-wrapper"><img src="static/images/guy.png" class="chat-message-icon"><div class="chat-message-wrapper eliza-message"><p class="chat-message-text text-left">${message}</p><p class="chat-user-text">Eliza</p></div></div>`;
}

function getUserMessageHTML(message) {
    return `<div class="chat-message-outer-wrapper text-right"><div class="chat-message-wrapper you-message"><p class="chat-message-text text-left">${message}</p><p class="chat-user-text">You</p></div><img src="static/images/laptop.png" class="chat-message-icon"></div>`;
}

function displayChatMessage(message, isEliza=false) {

    let content = isEliza ? getElizaMessageHTML(message) : getUserMessageHTML(message);

    $("#chat-area").append(content);

    $(".send-textbox").val('');
    window.scrollTo(0, document.body.scrollHeight);
}

// function displayMessageDateTime(messageDate) {
//     console.log("Date: " + Object.keys(messageDate));
//     let html = `<div style="text-align: center">${messageDate}</div>`;
//     $("#chat-area").append(html);
// }

function error(message) {
    createNegativeNotification(message, 9);
}