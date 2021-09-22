import React, { Component } from "react";
import PersonDataService from "../services/person.service";

export default class AddPerson extends Component {
  constructor(props) {
    super(props);
    this.onChangeNombre = this.onChangeNombre.bind(this);
    this.onChangeApellido = this.onChangeApellido.bind(this);
    this.onChangeDireccion = this.onChangeDireccion.bind(this);
    this.onChangeCiudad = this.onChangeCiudad.bind(this);
    this.onChangeCodPostal = this.onChangeCodPostal.bind(this);
    this.onChangeFechaNacimiento = this.onChangeFechaNacimiento.bind(this);
    this.savePerson = this.savePerson.bind(this);
    this.newPerson = this.newPerson.bind(this);

    this.state = {
      nombre: "",
      apellido: "",
      direccion: "",
      ciudad: "",
      codPostal: "",
      fechaNacimiento: "",
      submitted: false,
    };
  }

  onChangeNombre(e) {
    this.setState({
      nombre: e.target.value,
    });
  }

  onChangeApellido(e) {
    this.setState({
      apellido: e.target.value,
    });
  }

  onChangeDireccion(e) {
    this.setState({
      direccion: e.target.value,
    });
  }

  onChangeCiudad(e) {
    this.setState({
      ciudad: e.target.value,
    });
  }

  onChangeCodPostal(e) {
    this.setState({
      codPostal: e.target.value,
    });
  }

  onChangeFechaNacimiento(e) {
    this.setState({
      fechaNacimiento: e.target.value,
    });
  }

  savePerson() {
    let data = {
      nombre: this.state.nombre,
      apellido: this.state.apellido,
      direccion: this.state.direccion,
      ciudad: this.state.ciudad,
      codPostal: this.state.codPostal,
      fechaNacimiento: this.state.fechaNacimiento,
    };

    PersonDataService.create(data)
      .then(() => {
        console.log("Created new item successfully!");
        this.setState({
          submitted: true,
        });
      })
      .catch((e) => {
        console.log(e);
      });
  }

  newPerson() {
    this.setState({
      nombre: "",
      apellido: "",
      direccion: "",
      ciudad: "",
      codPostal: "",
      fechaNacimiento: "",
      submitted: false,
    });
  }

  render() {
    return (
      <div className="submit-form">
        {this.state.submitted ? (
          <div>
            <h4>You submitted successfully!</h4>
            <br />
            <button className="btn btn-success" onClick={this.newPerson}>
              OK
            </button>
          </div>
        ) : (
          <div>
            <h4>Nuevo contacto</h4>

            <br />

            <div className="form-group row">
              <label htmlFor="nombre" className="col-2 offset-1">Nombre</label>
              <input
                type="text"
                className="form-control col-8"
                id="nombre"
                required
                value={this.state.nombre}
                onChange={this.onChangeNombre}
                name="nombre"
              />
            </div>

            <div className="form-group row">
              <label htmlFor="apellido" className="col-2 offset-1">Apellido</label>
              <input
                type="text"
                className="form-control col-8"
                id="apellido"
                required
                value={this.state.apellido}
                onChange={this.onChangeApellido}
                name="apellido"
              />
            </div>

            <div className="form-group row">
              <label htmlFor="direccion" className="col-2 offset-1">Dirección</label>
              <input
                type="text"
                className="form-control col-8"
                id="direccion"
                required
                value={this.state.direccion}
                onChange={this.onChangeDireccion}
                name="direccion"
              />
            </div>

            <div className="form-group row">
              <label htmlFor="ciudad" className="col-2 offset-1">Ciudad</label>
              <input
                type="text"
                className="form-control col-8"
                id="ciudad"
                required
                value={this.state.ciudad}
                onChange={this.onChangeCiudad}
                name="ciudad"
              />
            </div>

            <div className="form-group row">
              <label htmlFor="codPostal" className="col-2 offset-1">Código Postal</label>
              <input
                type="text"
                className="form-control col-8"
                id="codPostal"
                value={this.state.codPostal}
                onChange={this.onChangeCodPostal}
                name="codPostal"
              />
            </div>

            <div className="form-group row">
              <label htmlFor="fechaNacimiento" className="col-2 offset-1">Fecha de Nacimiento</label>
              <input
                type="text"
                className="form-control col-8"
                id="fechaNacimiento"
                value={this.state.fechaNacimiento}
                onChange={this.onChangeFechaNacimiento}
                name="fechaNacimiento"
              />
            </div>

            <br /><br />

            <button onClick={this.savePerson} className="btn btn-success">
              Submit
            </button>
          </div>
        )}
      </div>
    );
  }
}