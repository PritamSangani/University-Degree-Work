const config = {
    apiKey: "AIzaSyA--VWo9k-SpbsySsNV6RstsiMYX4c_IT0",
    authDomain: "eliza-plus.firebaseapp.com",
    databaseURL: "https://eliza-plus.firebaseio.com",
    projectId: "eliza-plus",
    storageBucket: "eliza-plus.appspot.com",
    messagingSenderId: "403065326239"
};
firebase.initializeApp(config);

let ui = new firebaseui.auth.AuthUI(firebase.auth());
ui.disableAutoSignIn();

firebase.firestore().enablePersistence()
  .catch(function(err) {
      if (err.code === 'failed-precondition') {
          // Multiple tabs open, persistence can only be enabled
          // in one tab at a a time.
          // ...
      } else if (err.code === 'unimplemented') {
          // The current browser does not support all of the
          // features required to enable persistence
          // ...
      }
  });

firebase.auth().setPersistence(firebase.auth.Auth.Persistence.SESSION);

firebase.auth().onAuthStateChanged(user => {
    user ? signedInUser(user) :
           handleSignedOutUser();
});

// Initialize Cloud Firestore through Firebase
let db = firebase.firestore();
// Google OAuth Client ID, needed to support One-tap sign-up.
// Set to null if One-tap sign-up is not supported.
const CLIENT_ID = '403065326239-t5lj0q9copugum13l6e9eipppo5vdqte.apps.googleusercontent.com';