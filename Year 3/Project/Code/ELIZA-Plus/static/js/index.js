/**
 * @returns {!Object} //FirebaseUI config object
 */

/*
    GLOBAL VARIABLES
*/

let chatId = "";
let email = "";
let global_entities;

function getUiConfig() {
    return {
        'callbacks': {
            'signInSuccessWithAuthResult': function (authResult) {
                if (authResult.user && authResult.additionalUserInfo) {
                    handleSignedInUser(authResult.user, authResult.additionalUserInfo);
                }
                // do not redirect. (for SPA)
                return false;
            }
        },
        'signInFlow': 'popup',
        'signInOptions': [{
                provider: firebase.auth.GoogleAuthProvider.PROVIDER_ID,
                authMethod: 'https://accounts.google.com',
                clientId: CLIENT_ID
            },
            {
                provider: firebase.auth.EmailAuthProvider.PROVIDER_ID,
                requireDisplayName: true,
                signInMethod: 'password'
            }
        ],
        'tosUrl': 'https://www.google.com',
        'privacyPolicyUrl': 'https://www.google.com',
    };
}

let handleSignedInUser = function(user, additionalUserInfo) {
    //TODO: retrieve chat history from database and display
    if (additionalUserInfo.isNewUser) {
        createUserInDB(user);
    }
};

let handleSignedOutUser = function() {
    ui.start('#firebaseui-container', getUiConfig());
    document.getElementById('signout').style.display = 'none';
    document.getElementById('chat-app').style.display = 'none';
};

async function signedInUser(user) {
    email = user.email;
    document.getElementById('signout').style.display = 'block';
    document.getElementById('chat-app').style.display = 'block';
    chatId =  await getChatId(email);
    await retrieveChatMessagesFromDB();
    connectToSocket();
}

function formatEntities(entities) {
         Object.keys(entities).forEach(function(key) {
             if (entities[key].hasOwnProperty('timestamp')) {
                 entities[key].timestamp = entities[key].timestamp.toDate();
             }
        });


    return entities;
}

function getChatId(email) {
    return new Promise(resolve => {
        let docRef = db.collection("users").doc(email);

        docRef.get().then(function(doc) {
            if (doc.exists) {
                chatId = doc.data().chatId;
                global_entities = formatEntities(doc.data().entities);
                resolve(chatId);
            } else {
                // doc.data() will be undefined in this case
                console.log("No such document!");
            }
        }).catch(function(error) {
            console.log("Error getting document:", error);
        });
    })

}

function sendChatMessageToDB(message, entities={}, isEliza=false) {
    db.collection("chats").doc(chatId).collection("messages").add({
        message: message,
        isEliza: isEliza,
        entities: entities,
        timestamp: new Date()
    });
}

function sendEntitiesToUserDocument(entities) {
    let batch = db.batch();
    let docRef = db.collection("users").doc(email);

    Object.keys(entities).forEach(function(key) {
        let entityKey = `entities.${key}`;
        entities[key].timestamp = new Date();
        let json = {};
        json[entityKey] = entities[key];
        global_entities[key] = json[entityKey];
        batch.update(docRef, json);
    });

    batch.commit().then(function () {
        // console.log("Batched write completed successfully");
    });
}

function retrieveChatMessagesFromDB() {
    // get chat uid and then retrieve all messages from
    return new Promise(resolve => {
        db.collection("chats").doc(chatId).collection("messages").orderBy("timestamp").get()
        .then(function(querySnapshot) {
            let timestamp = 0;
            querySnapshot.forEach(function(doc) {
                // doc.data() is never undefined for query doc snapshots
                // console.log(doc.id, " => ", doc.data().timestamp);
                // if (doc.data().timestamp.seconds - timestamp > 3600) {
                //     displayMessageDateTime(doc.data().timestamp.toDate());
                // }
                if (doc.data().isEliza) {
                    displayChatMessage(doc.data().message, true);
                } else {
                    displayChatMessage(doc.data().message);
                }
                timestamp = doc.data().timestamp.toDate();
                resolve(true);
            });
            resolve(true);
        })
            .catch(function (error) {
                console.log(error);
                resolve(false);
            });
    })

}

function createUserInDB(user) {
    db.collection("chats").add({})
    .then(function(docRef) {
        chatId = docRef.id;

        db.collection("users").doc(user.email).set({
            name: user.displayName,
            chatId: docRef.id
        })
        .then(function() {
            // console.log("Document successfully written!");
            // console.log(docRef);
        })
        .catch(function(error) {
            console.error("Error writing document: ", error);
        });
    })
    .catch(function(error) {
        console.error("Error adding document: ", error);
    });
}

let initApp = function() {
    document.getElementById('signout').addEventListener('click', function() {
        firebase.auth().signOut();
        handleSignedOutUser();
    });
};

window.addEventListener('load', initApp);

