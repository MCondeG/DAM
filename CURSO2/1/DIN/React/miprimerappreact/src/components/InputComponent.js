import React, { Component } from 'react'

export default class HelloComponent extends Component {

    render() {
        return (
            <div>
                <input value={this.props.nombre} onChange={this.props.cambiarNombre}></input>
            </div>
        )
    }
}