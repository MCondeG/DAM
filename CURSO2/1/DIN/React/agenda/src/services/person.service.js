import firebase from "../firebase";

const db = firebase.ref("/personas");

class PersonDataService {

    getAll() {
        return db;
    }

    create(person) {
        return db.push(person);
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

export default new PersonDataService();