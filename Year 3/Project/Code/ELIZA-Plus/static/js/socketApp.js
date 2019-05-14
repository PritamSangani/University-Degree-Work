function connectToSocket() {
    let socket = io.connect(document.domain + ':' + location.port);

    socket.on('connect', function() {
        console.log("socket connected");
        socket.emit('connected', JSON.stringify({
            message: "Connected to socket"
        }));
    });

    socket.on('elizamessage', function(data) {
       // console.log("elizamessage received: "+data);
       data = JSON.parse(data);
       let response = data.response;
       let message = data.message;
       let entities = {};

       if (data.hasOwnProperty('entities')) {
           entities = data.entities;
           // console.log("Entities: ");
           // console.log(entities);
       }

       displayChatMessage(response, true);
       if (data.hasOwnProperty('message')) {
           sendChatMessageToDB(message, entities);
       }

       sendChatMessageToDB(response, entities, true);

       if (Object.keys(entities).length > 0)
           sendEntitiesToUserDocument(entities);
    });

    $(document).keypress(function (e) {
        //When the enter key is pressed
        if (e.which === 13) {
            let content = $(".send-textbox").val();

            if (content === null || (content != null && content.length === 0)) {
                error("Error: Input cannot be blank");
            } else {
                // add chat to chat div
                displayChatMessage(content);
                // send via socket to python script
                console.log("HEllo");
                console.log(global_entities);
                socket.emit('usermessage', JSON.stringify({
                    message: content,
                    entities: global_entities
                }));
            }
        }
    });
}