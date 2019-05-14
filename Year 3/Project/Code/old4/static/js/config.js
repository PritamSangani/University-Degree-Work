var config = {
    apiKey: "AIzaSyA--VWo9k-SpbsySsNV6RstsiMYX4c_IT0",
    authDomain: "eliza-plus.firebaseapp.com",
    databaseURL: "https://eliza-plus.firebaseio.com",
    projectId: "eliza-plus",
    storageBucket: "eliza-plus.appspot.com",
    messagingSenderId: "403065326239"
  };
  firebase.initializeApp(config);
  
  // Google OAuth Client ID, needed to support One-tap sign-up.
  // Set to null if One-tap sign-up is not supported.
  var CLIENT_ID = '403065326239-t5lj0q9copugum13l6e9eipppo5vdqte.apps.googleusercontent.com';