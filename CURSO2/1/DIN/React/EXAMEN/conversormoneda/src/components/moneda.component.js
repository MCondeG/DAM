import React, { Component } from "react";
import MonedaDataService from "../services/moneda.service";

export default class Moneda extends Component {
  constructor(props) {
    super(props);
    this.onChangeNombre = this.onChangeNombre.bind(this);
    this.onChangeMultiplicador = this.onChangeMultiplicador.bind(this);
    this.onChangeEuro = this.onChangeEuro.bind(this);
    this.onChangeCantidad = this.onChangeCantidad.bind(this);
    this.updateMoneda = this.updateMoneda.bind(this);
    this.deleteMoneda = this.deleteMoneda.bind(this);

    this.state = {
      currentMoneda: {
        key: null,
        nombre: "",
        multiplicador: "",
        euro: "",
        cantidad: "",
      },
      message: "",
    };
  }

  static getDerivedStateFromProps(nextProps, prevState) {
    const { moneda } = nextProps;
    if (prevState.currentMoneda.key !== moneda.key) {
      return {
        currentMoneda: moneda,
        message: ""
      };
    }

    return prevState.currentMoneda;
  }

  componentDidMount() {
    this.setState({
      currentMoneda: this.props.moneda,
    });
  }

  onChangeNombre(e) {
    const nombre = e.target.value;

    this.setState(function (prevState) {
      return {
        currentPerson: {
          ...prevState.currentMoneda,
          nombre: nombre,
        },
      };
    });
  }

  onChangeMultiplicador(e) {
    const multiplicador = e.target.value;

    this.setState((prevState) => ({
      currentMoneda: {
        ...prevState.currentMoneda,
        multiplicador: multiplicador,
      },
    }));
  }


  onChangeEuro(e) {
    const euro = e.target.value;

    this.setState((prevState) => ({
      currentMoneda: {
        ...prevState.currentMoneda,
        euro: euro,
      },
    }));
  }

  onChangeCantidad(e) {
    const cantidad = e.target.value;

    this.setState((prevState) => ({
      currentMoneda: {
        ...prevState.currentMoneda,
        cantidad: cantidad,
      },
    }));
  }

  updateMoneda() {
    const data = {
      nombre: this.state.currentMoneda.nombre,
      multiplicador: this.state.currentMoneda.multiplicador,
      euro: this.state.currentMoneda.euro,
      cantidad: this.state.currentMoneda.cantidad,
    };

    MonedaDataService.update(this.state.currentMoneda.key, data)
      .then(() => {
        this.setState({
          message: "The coin was updated successfully!",
        });
      })
      .catch((e) => {
        console.log(e);
      });
  }

  deleteMoneda() {
    MonedaDataService.delete(this.state.currentMoneda.key)
      .then(() => {
        this.props.refreshList();
      })
      .catch((e) => {
        console.log(e);
      });
  }

  convierteMoneda() {

    this.updateMoneda();

    let euro = this.state.currentMoneda.euro;
    let cantidad = this.state.currentMoneda.cantidad;
    let multiplicador = this.state.currentMoneda.multiplicador;

    if (euro !== "") {
      cantidad = parseFloat(euro) * parseFloat(multiplicador);
    }
    if (cantidad !== "") {
      euro = parseFloat(cantidad) / parseFloat(multiplicador);
    }
  }

  render() {
    const { currentMoneda } = this.state;

    return (
      <div>
        <h3>Detalles</h3>

        <br />

        {currentMoneda ? (
          <div className="edit-form">
            <form>
              <div className="form-group row">
                <label htmlFor="nombre" className="col-3 offset-1">Nombre</label>
                <input
                  type="text"
                  className="form-control col-7"
                  id="nombre"
                  value={currentMoneda.nombre}
                  onChange={this.onChangeNombre}
                />
              </div>

              <div className="form-group row">
                <label htmlFor="multiplicador" className="col-3 offset-1">Multiplicador</label>
                <input
                  type="text"
                  className="form-control col-7"
                  id="multiplicador"
                  value={currentMoneda.multiplicador}
                  onChange={this.onChangeMultiplicador}
                />
              </div>

              <br />

              <div className="form-group row">
                <input
                  type="text"
                  className="form-control col-7 offset-1"
                  id="euro"
                  value={currentMoneda.euro}
                  onChange={this.onChangeEuro}
                />
                <label htmlFor="euro" className="col-2 offset-1">Euros</label>
              </div>

              <div className="form-group row">
                <input
                  type="text"
                  className="form-control col-7 offset-1"
                  id="cantidad"
                  value={currentMoneda.cantidad}
                  onChange={this.onChangeCantidad}
                />
                <label htmlFor="cantidad" className="col-2 offset-1">{this.state.nombre}</label>
              </div>
            </form>

            <br /><br />

            <button
              className="badge badge-danger mr-2"
              onClick={this.deleteMoneda}
            >
              Delete
            </button>

            <button
              type="submit"
              className="badge mr-2"
              onClick={this.updateMoneda}
            >
              Edit
            </button>

            <button
              type="submit"
              className="badge badge-success"
              onClick={this.convierteMoneda}
            >
              Convierte
            </button>

            <p>{this.state.message}</p>
          </div>
        ) : (
          <div>
            <br />
            <p>Please click on a coin...</p>
          </div>
        )}
      </div>
    );
  }
}