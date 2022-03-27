const { initializeApp, applicationDefault, cert } = require('firebase-admin/app');
const { getFirestore, Timestamp, FieldValue } = require('firebase-admin/firestore');
//cambiar el fichero de credenciales por el de cada alumno
const serviceAccount = require('./practica1firebase-335fe-firebase-adminsdk-nl675-7f1455234d.json');

initializeApp({
  credential: cert(serviceAccount)
});

//crea un timer que ejecuta código cada 10 segundos
const timerId = setInterval(() => {
  let now = new Date().getTime();
  let segundosDiff;
  let minutosJugados;
  const db = getFirestore();
  const partidosRef = db.collection('partidos');
  const snapshot = partidosRef.get()
    .then((data) => {
      data.forEach(element => {

        //para cada partido actualizo sus minutos de juego en firebase
        let jsonObject = element.data();

        if (jsonObject['horaInicioPartido'] != null && jsonObject['horaFinPrimeraParte'] == null) {
          //en juego primera parte
          segundosDiff = (now - jsonObject['horaInicioPartido']) / 1000;
          minutosJugados = Math.floor(segundosDiff / 60) + "'";
          jsonObject['minutosJugados'] = minutosJugados;
          partidosRef.doc(jsonObject['id']).update(jsonObject);
        }//end_if en juego primera parte

        if (jsonObject['horaInicioPartido'] != null && jsonObject['horaFinPrimeraParte'] != null
          && jsonObject['horaInicioSegundaParte'] == null) {
          //en el descando
          jsonObject['minutosJugados'] = "Descanso";
          partidosRef.doc(jsonObject['id']).update(jsonObject);
        }//end_if en descanso

        if (jsonObject['horaInicioPartido'] != null && jsonObject['horaFinPrimeraParte'] != null
          && jsonObject['horaInicioSegundaParte'] != null && jsonObject['horaFinPartido'] == null) {
          //en juego la segunda parte
          segundosDiff = (now - jsonObject['horaInicioPartido']) / 1000;
          minutosJugados = (Math.floor(segundosDiff / 60) + 45) + "'";
          jsonObject['minutosJugados'] = minutosJugados;
          partidosRef.doc(jsonObject['id']).update(jsonObject);
        }//end_if en juego segunda parte

        if (jsonObject['horaFinPartido'] != null) {
          //finalizado
          jsonObject['minutosJugados'] = "Finalizado";
          partidosRef.doc(jsonObject['id']).update(jsonObject);
        }//end_if finalizado

      });
    })
    .catch((error) => {
      console.log(error.message);
    });
}, 10000);
