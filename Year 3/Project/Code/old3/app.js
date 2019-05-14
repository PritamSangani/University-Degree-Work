let ws_scheme;
// Support TLS-specific URLs, when appropriate.
if (window.location.protocol === "https:") {
    ws_scheme = "wss://";
} else {
    ws_scheme = "ws://";
}


const inbox = new ReconnectingWebSocket(ws_scheme + location.host + "/receive");
const outbox = new ReconnectingWebSocket(ws_scheme + location.host + "/submit");

inbox.onmessage = function (message) {
    console.log("Message arrived: "+ data);

    let data = JSON.parse(message.data);
    // $("#chat-area").append("<div class='panel panel-default'><div class='panel-heading'>" + $('<span/>').text(data.handle).html() + "</div><div class='panel-body'>" + $('<span/>').text(data.text).html() + "</div></div>");
    $("#chat-area").append(getElizaMessageHTML(data.message));
    $("#chat-area").stop().animate({
        scrollTop: $('#chat-area')[0].scrollHeight
    }, 800);
};

inbox.onclose = function () {
    console.log('inbox closed');
    this.inbox = new WebSocket(inbox.url);

};

outbox.onclose = function () {
    console.log('outbox closed');
    this.outbox = new WebSocket(outbox.url);
};

// $("#input-form").on("submit", function(event) {
//   event.preventDefault();
//   let text = $("#input-text")[0].value;
//   outbox.send(JSON.stringify({ handle: handle, text: text }));
//   $("#input-text")[0].value = "";
// });

// event listener - when enter key is pressed decide what to do with chat input
$(document).keypress(function (e) {
    e.preventDefault();
    if (e.which === 13) {
        handleUserInput();
    }
});

function handleUserInput() {
    let content = $(".send-textbox").val();

    if (content === null || content !== null && content.length === 0) {
        error("Error: Input cannot be blank");
    } else {
        console.log("Sending message: "+content);
        sendElizaNewMessage(content);
        outbox.send(JSON.stringify({
            message: content
        }));

        clearSendTextbox();
    }
}


