import React, { Component } from "react";
import PersonDataService from "../services/person.service";
import "../App.css";

import Person from "./person.component";

export default class PeopleList extends Component {

  constructor(props) {
    super(props);
    this.refreshList = this.refreshList.bind(this);
    this.setActivePerson = this.setActivePerson.bind(this);
    this.removeAllPeople = this.removeAllPeople.bind(this);
    this.onDataChange = this.onDataChange.bind(this);

    this.state = {
      people: [],
      currentPerson: null,
      currentIndex: -1,
    };
  }

  componentDidMount() {
    PersonDataService.getAll().on("value", this.onDataChange);
  }

  componentWillUnmount() {
    PersonDataService.getAll().off("value", this.onDataChange);
  }

  onDataChange(items) {
    let people = [];

    items.forEach((item) => {
      let key = item.key;
      let data = item.val();
      people.push({
        key: key,
        nombre: data.nombre,
        apellido: data.apellido,
        direccion: data.direccion,
        ciudad: data.ciudad,
        codPostal: data.codPostal,
        fechaNacimiento: data.fechaNacimiento,
      });
    });

    this.setState({
      people: people,
    });
  }

  refreshList() {
    this.setState({
      currentPerson: null,
      currentIndex: -1,
    });
  }

  setActivePerson(person, index) {
    this.setState({
      currentPerson: person,
      currentIndex: index,
    });
  }

  removeAllPeople() {
    PersonDataService.deleteAll()
      .then(() => {
        this.refreshList();
      })
      .catch((e) => {
        console.log(e);
      });
  }

  render() {
    const { people, currentPerson, currentIndex } = this.state;

    return (
      <div className="row">
        <div className="list col-4">
          <div className="row">
            <div className="col-6">
              <h3>Nombre</h3>
              <br />
              <ul className="list-group">
                {people &&
                  people.map((person, index) => (
                    <li
                      className={
                        "list-group-item " +
                        (index === currentIndex ? "active" : "")
                      }
                      onClick={() => this.setActivePerson(person, index)}
                      key={index}
                    >
                      {person.nombre}
                    </li>
                  ))}
              </ul>
            </div>

            <div className="col-6">
              <h3>Apellido</h3>
              <br />
              <ul className="list-group">
                {people &&
                  people.map((person, index) => (
                    <li
                      className={
                        "list-group-item " +
                        (index === currentIndex ? "active" : "")
                      }
                      onClick={() => this.setActivePerson(person, index)}
                      key={index}
                    >
                      {person.apellido}
                    </li>
                  ))}
              </ul>
            </div>
          </div>

          <br /><br />

          <button
            className="m-3 btn btn-sm btn-danger"
            onClick={this.removeAllPeople}
          >
            Remove All
          </button>
        </div>

        <div className="offset-1 bg-dark" id="separador"></div>

        <div className="col-6">
          {currentPerson ? (
            <Person
              person={currentPerson}
              refreshList={this.refreshList}
            />
          ) : (
            <div>
              <br />
              <p>Please click on a Person...</p>
            </div>
          )}
        </div>
      </div>
    );
  }
}

