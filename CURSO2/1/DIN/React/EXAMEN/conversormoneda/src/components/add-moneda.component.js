import React, { Component } from "react";
import MonedaDataService from "../services/moneda.service";

export default class AddMoneda extends Component {
  constructor(props) {
    super(props);
    this.onChangeNombre = this.onChangeNombre.bind(this);
    this.onChangeMultiplicador = this.onChangeMultiplicador.bind(this);
    this.saveMoneda = this.saveMoneda.bind(this);
    this.newMoneda = this.newMoneda.bind(this);

    this.state = {
      nombre: "",
      multiplicador: "",
      euro: "",
      cantidad: "",
      submitted: false,
    };
  }

  onChangeNombre(e) {
    this.setState({
      nombre: e.target.value,
    });
  }

  onChangeMultiplicador(e) {
    this.setState({
      multiplicador: e.target.value,
    });
  }

  saveMoneda() {
    let data = {
      nombre: this.state.nombre,
      multiplicador: this.state.multiplicador,
      euro: this.state.euro,
      cantidad: this.state.cantidad,
    };

    MonedaDataService.create(data)
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

  newMoneda() {
    this.setState({
      nombre: "",
      multiplicador: "",
      euro: "",
      cantidad: "",
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
            <button className="btn btn-success" onClick={this.newMoneda}>
              OK
            </button>
          </div>
        ) : (
          <div>
            <h4>Nueva moneda</h4>

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
              <label htmlFor="multiplicador" className="col-2 offset-1">Multiplicador</label>
              <input
                type="text"
                className="form-control col-8"
                id="multiplicador"
                required
                value={this.state.multiplicador}
                onChange={this.onChangeMultiplicador}
                name="multiplicador"
              />
            </div>

            <br /><br />

            <button onClick={this.saveMoneda} className="btn btn-success">
              Submit
            </button>
          </div>
        )}
      </div>
    );
  }
}