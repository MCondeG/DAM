import React, { Component } from "react";
import { Switch, Route, Link } from "react-router-dom";
import "bootstrap/dist/css/bootstrap.min.css";
import "./App.css";
import AddMoneda from "./components/add-moneda.component";
import MonedasList from "./components/monedas-list.component";

class App extends Component {

  render() {
    return (
      <div className="App">
        <div className="container">

          <br />

          <h1>Conversor de monedas</h1>

          <br />

          <nav className="navbar navbar-expand navbar-dark bg-dark">
            <a href="/monedas" className="navbar-brand">
              CONVERSOR
            </a>

            <div className="navbar-nav mr-auto">
              <li className="nav-item">
                <Link to={"/monedas"} className="nav-link">
                  Monedas
                </Link>
              </li>
              <li className="nav-item">
                <Link to={"/add"} className="nav-link">
                  Añadir
                </Link>
              </li>
            </div>
          </nav>

          <br /><br />

          <div className="row">
            <div className="col-12">
              <div className="jumbotron">
                <Switch>
                  <Route exact path={["/", "/monedas"]} component={MonedasList} />
                  <Route exact path="/add" component={AddMoneda} />
                </Switch>
              </div>
            </div>
          </div>
        </div>
      </div>
    )
  }
}

export default App;
