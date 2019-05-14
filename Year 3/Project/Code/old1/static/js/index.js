/**
 * @returns {!Object} //FirebaseUI config object
 */

function getUiConfig() {
    return {
        'callbacks': {
            'signInSuccessWithAuthResult': function (authResult, redirectUrl) {
                if (authResult.user) {
                    handleSignedInUser(authResult.user);
                }
                if (authResult.additionalUserInfo) {
                    // TODO: handle any additonal user info
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
        // 'credentialHelper': CLIENT_ID && CLIENT_ID != 'YOUR_OAUTH_CLIENT_ID' ?
        //     firebaseui.auth.CredentialHelper.GOOGLE_YOLO : 
        //     firebaseui.auth.CredentialHelper.ACCOUNT_CHOOSER_COM
    };
}

var ui = new firebaseui.auth.AuthUI(firebase.auth());
ui.disableAutoSignIn();

var handleSignedInUser = function(user) {
    //TODO: retrieve chat history from database and display
    console.log("USER Signed In: "+user.displayName);
    document.getElementById('signout').style.display = 'block';
    document.getElementById('chat-app').style.display = 'block';
}

var handleSignedOutUser = function() {
    ui.start('#firebaseui-container', getUiConfig());
    document.getElementById('signout').style.display = 'none';
    document.getElementById('chat-app').style.display = 'none';
};

firebase.auth().onAuthStateChanged(user => {
    user ? handleSignedInUser(user) :
           handleSignedOutUser();
});

var initApp = function() {
    document.getElementById('signout').addEventListener('click', function() {
        firebase.auth().signOut();
    });
}

window.addEventListener('load', initApp);