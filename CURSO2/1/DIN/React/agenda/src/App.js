import React, { Component } from "react";
import { Switch, Route, Link } from "react-router-dom";
import "bootstrap/dist/css/bootstrap.min.css";
import "./App.css";
import AddPerson from "./components/add-person.component";
import PeopleList from "./components/people-list.component";

class App extends Component {
  render() {
    return (
      <div className="App">
        <div className="container">

          <br />

          <h1>Agenda de direcciones</h1>

          <br />

          <nav className="navbar navbar-expand navbar-dark bg-dark">
            <a href="/people" className="navbar-brand">
              AGENDA
            </a>

            <div className="navbar-nav mr-auto">
              <li className="nav-item">
                <Link to={"/people"} className="nav-link">
                  Contactos
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
                  <Route exact path={["/", "/people"]} component={PeopleList} />
                  <Route exact path="/add" component={AddPerson} />
                </Switch>
              </div>
            </div>
          </div>
        </div>
      </div>
    );
  }
}

export default App;