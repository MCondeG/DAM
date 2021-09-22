import React, { Component } from "react";
import MonedaDataService from "../services/moneda.service";
import "../App.css";

import Moneda from "./moneda.component";

export default class MonedasList extends Component {

  constructor(props) {
    super(props);
    this.refreshList = this.refreshList.bind(this);
    this.setActiveMoneda = this.setActiveMoneda.bind(this);
    this.removeAllMonedas = this.removeAllMonedas.bind(this);
    this.onDataChange = this.onDataChange.bind(this);

    this.state = {
      monedas: [],
      currentMoneda: null,
      currentIndex: -1,
    };
  }

  componentDidMount() {
    MonedaDataService.getAll().on("value", this.onDataChange);
  }

  componentWillUnmount() {
    MonedaDataService.getAll().off("value", this.onDataChange);
  }

  onDataChange(items) {
    let monedas = [];

    items.forEach((item) => {
      let key = item.key;
      let data = item.val();
      monedas.push({
        key: key,
        nombre: data.nombre,
        multiplicador: data.multiplicador,
        euros: data.euros,
        cantidad: data.cantidad,
      });
    });

    this.setState({
      monedas: monedas,
    });
  }

  refreshList() {
    this.setState({
      currentMoneda: null,
      currentIndex: -1,
    });
  }

  setActiveMoneda(moneda, index) {
    this.setState({
      currentMoneda: moneda,
      currentIndex: index,
    });
  }

  removeAllMonedas() {
    MonedaDataService.deleteAll()
      .then(() => {
        this.refreshList();
      })
      .catch((e) => {
        console.log(e);
      });
  }

  render() {
    const { monedas, currentMoneda, currentIndex } = this.state;

    return (
      <div className="row">
        <div className="list col-4">
          <div className="row">
            <div className="col-6">
              <h3>Nombre</h3>
              <br />
              <ul className="list-group">
                {monedas &&
                  monedas.map((moneda, index) => (
                    <li
                      className={
                        "list-group-item " +
                        (index === currentIndex ? "active" : "")
                      }
                      onClick={() => this.setActiveMoneda(moneda, index)}
                      key={index}
                    >
                      {moneda.nombre}
                    </li>
                  ))}
              </ul>
            </div>

            <div className="col-6">
              <h3>Multiplicador</h3>
              <br />
              <ul className="list-group">
                {monedas &&
                  monedas.map((moneda, index) => (
                    <li
                      className={
                        "list-group-item " +
                        (index === currentIndex ? "active" : "")
                      }
                      onClick={() => this.setActiveMoneda(moneda, index)}
                      key={index}
                    >
                      {moneda.multiplicador}
                    </li>
                  ))}
              </ul>
            </div>
          </div>

          <br /><br />

          <button
            className="m-3 btn btn-sm btn-danger"
            onClick={this.removeAllMonedas}
          >
            Remove All
          </button>
        </div>

        <div className="offset-1 bg-dark" id="separador"></div>

        <div className="col-6">
          {currentMoneda ? (
            <Moneda
              moneda={currentMoneda}
              refreshList={this.refreshList}
            />
          ) : (
            <div>
              <br />
              <p>Please click on a coin...</p>
            </div>
          )}
        </div>
      </div>
    );
  }
}

