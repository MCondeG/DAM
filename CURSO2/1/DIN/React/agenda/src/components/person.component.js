import React, { Component } from "react";
import PersonDataService from "../services/person.service";

export default class Person extends Component {
  constructor(props) {
    super(props);
    this.onChangeNombre = this.onChangeNombre.bind(this);
    this.onChangeApellido = this.onChangeApellido.bind(this);
    this.onChangeDireccion = this.onChangeDireccion.bind(this);
    this.onChangeCiudad = this.onChangeCiudad.bind(this);
    this.onChangeCodPostal = this.onChangeCodPostal.bind(this);
    this.onChangeFechaNacimiento = this.onChangeFechaNacimiento.bind(this);
    this.updatePerson = this.updatePerson.bind(this);
    this.deletePerson = this.deletePerson.bind(this);

    this.state = {
      currentPerson: {
        key: null,
        nombre: "",
        apellido: "",
        direccion: "",
        ciudad: "",
        codPostal: "",
        fechaNacimiento: "",
      },
      message: "",
    };
  }

  static getDerivedStateFromProps(nextProps, prevState) {
    const { person } = nextProps;
    if (prevState.currentPerson.key !== person.key) {
      return {
        currentPerson: person,
        message: ""
      };
    }

    return prevState.currentPerson;
  }

  componentDidMount() {
    this.setState({
      currentPerson: this.props.person,
    });
  }

  onChangeNombre(e) {
    const nombre = e.target.value;

    this.setState(function (prevState) {
      return {
        currentPerson: {
          ...prevState.currentPerson,
          nombre: nombre,
        },
      };
    });
  }

  onChangeApellido(e) {
    const apellido = e.target.value;

    this.setState((prevState) => ({
      currentPerson: {
        ...prevState.currentPerson,
        apellido: apellido,
      },
    }));
  }

  onChangeDireccion(e) {
    const direccion = e.target.value;

    this.setState((prevState) => ({
      currentPerson: {
        ...prevState.currentPerson,
        direccion: direccion,
      },
    }));
  }

  onChangeCiudad(e) {
    const ciudad = e.target.value;

    this.setState((prevState) => ({
      currentPerson: {
        ...prevState.currentPerson,
        ciudad: ciudad,
      },
    }));
  }

  onChangeCodPostal(e) {
    const codPostal = e.target.value;

    this.setState((prevState) => ({
      currentPerson: {
        ...prevState.currentPerson,
        codPostal: codPostal,
      },
    }));
  }

  onChangeFechaNacimiento(e) {
    const fechaNacimiento = e.target.value;

    this.setState((prevState) => ({
      currentPerson: {
        ...prevState.currentPerson,
        fechaNacimiento: fechaNacimiento,
      },
    }));
  }


  updatePerson() {
    const data = {
      nombre: this.state.currentPerson.nombre,
      apellido: this.state.currentPerson.apellido,
      direccion: this.state.currentPerson.direccion,
      ciudad: this.state.currentPerson.ciudad,
      codPostal: this.state.currentPerson.codPostal,
      fechaNacimiento: this.state.currentPerson.fechaNacimiento,
    };

    PersonDataService.update(this.state.currentPerson.key, data)
      .then(() => {
        this.setState({
          message: "The person was updated successfully!",
        });
      })
      .catch((e) => {
        console.log(e);
      });
  }

  deletePerson() {
    PersonDataService.delete(this.state.currentPerson.key)
      .then(() => {
        this.props.refreshList();
      })
      .catch((e) => {
        console.log(e);
      });
  }

  render() {
    const { currentPerson } = this.state;

    return (
      <div>
        <h3>Detalles</h3>

        <br />

        {currentPerson ? (
          <div className="edit-form">
            <form>
              <div className="form-group row">
                <label htmlFor="nombre" className="col-3 offset-1">Nombre</label>
                <input
                  type="text"
                  className="form-control col-7"
                  id="nombre"
                  value={currentPerson.nombre}
                  onChange={this.onChangeNombre}
                />
              </div>

              <div className="form-group row">
                <label htmlFor="apellido" className="col-3 offset-1">Apellido</label>
                <input
                  type="text"
                  className="form-control col-7"
                  id="apellido"
                  value={currentPerson.apellido}
                  onChange={this.onChangeApellido}
                />
              </div>

              <div className="form-group row">
                <label htmlFor="direccion" className="col-3 offset-1">Dirección</label>
                <input
                  type="text"
                  className="form-control col-7"
                  id="direccion"
                  value={currentPerson.direccion}
                  onChange={this.onChangeDireccion}
                />
              </div>

              <div className="form-group row">
                <label htmlFor="ciudad" className="col-3 offset-1">Ciudad</label>
                <input
                  type="text"
                  className="form-control col-7"
                  id="ciudad"
                  value={currentPerson.ciudad}
                  onChange={this.onChangeCiudad}
                />
              </div>

              <div className="form-group row">
                <label htmlFor="codPostal" className="col-3 offset-1">Código Postal</label>
                <input
                  type="text"
                  className="form-control col-7"
                  id="codPostal"
                  value={currentPerson.codPostal}
                  onChange={this.onChangeCodPostal}
                />
              </div>

              <div className="form-group row">
                <label htmlFor="fechaNacimiento" className="col-3 offset-1">Fecha de Nacimiento</label>
                <input
                  type="text"
                  className="form-control col-7"
                  id="fechaNacimiento"
                  value={currentPerson.fechaNacimiento}
                  onChange={this.onChangeFechaNacimiento}
                />
              </div>
            </form>

            <br />

            <button
              className="badge badge-danger mr-2"
              onClick={this.deletePerson}
            >
              Delete
            </button>

            <button
              type="submit"
              className="badge badge-success"
              onClick={this.updatePerson}
            >
              Edit
            </button>
            <p>{this.state.message}</p>
          </div>
        ) : (
          <div>
            <br />
            <p>Please click on a Person...</p>
          </div>
        )}
      </div>
    );
  }
}