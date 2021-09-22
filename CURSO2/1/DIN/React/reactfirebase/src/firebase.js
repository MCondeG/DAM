import firebase from "firebase/app";
import "firebase/database";


/** COLOCAR AQUÍ EL CÓDIGO OBTENIDO AL CREAR LA BASE DE DATOS */

let firebaseConfig = {
    apiKey: "AIzaSyDndlm9DrODH673gLoFLPdoz6122YiwAWI",
    authDomain: "react-firebase-69e8a.firebaseapp.com",
    databaseURL: "https://react-firebase-69e8a-default-rtdb.firebaseio.com",
    projectId: "react-firebase-69e8a",
    storageBucket: "react-firebase-69e8a.appspot.com",
    messagingSenderId: "758997660413",
    appId: "1:758997660413:web:3978072e6732dcd48ac494"
};

  // Initialize Firebase
firebase.initializeApp(firebaseConfig);
//</script>

export default firebase.database();