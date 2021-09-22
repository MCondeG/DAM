import firebase from "firebase/app";
import "firebase/database";

let firebaseConfig = {
    apiKey: "AIzaSyAh0Snjx_Z7r-et9t9F8tU-0A1_W15ZViI",
    authDomain: "agendareact-d6366.firebaseapp.com",
    databaseURL: "https://agendareact-d6366-default-rtdb.firebaseio.com",
    projectId: "agendareact-d6366",
    storageBucket: "agendareact-d6366.appspot.com",
    messagingSenderId: "180251937852",
    appId: "1:180251937852:web:a58a6eb3b896bba8748739"
};

  // Initialize Firebase
firebase.initializeApp(firebaseConfig);
//</script>

export default firebase.database();