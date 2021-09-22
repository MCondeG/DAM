import firebase from "../firebase";

const db = firebase.ref("/monedas");

class MonedaDataService {

    getAll() {
        return db;
    }

    create(moneda) {
        return db.push(moneda);
    }

    update(key, value) {
        return db.child(key).update(value);
    }

    delete(key) {
        return db.child(key).remove();
    }

    deleteAll() {
        return db.remove();
    }
}

export default new MonedaDataService();