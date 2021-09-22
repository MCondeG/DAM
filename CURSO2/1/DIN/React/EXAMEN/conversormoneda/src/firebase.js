import firebase from "firebase/app";
import "firebase/database";

let firebaseConfig = {
    apiKey: "AIzaSyDS1cknPcpOEKb6-PaF0imhnRt5rEp5GXc",
    authDomain: "examenreact-30320.firebaseapp.com",
    databaseURL: "https://examenreact-30320-default-rtdb.firebaseio.com",
    projectId: "examenreact-30320",
    storageBucket: "examenreact-30320.appspot.com",
    messagingSenderId: "376774178594",
    appId: "1:376774178594:web:8a96cc8aa5ece39894d77b"
};

// Initialize Firebase
firebase.initializeApp(firebaseConfig);
//</script>

export default firebase.database();