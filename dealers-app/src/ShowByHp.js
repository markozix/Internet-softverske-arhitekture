import React, { Component } from 'react';
import { Table, Button, Modal, ModalHeader, FormGroup,Form, ModalBody, ModalFooter,Input } from 'reactstrap';
import axios from 'axios';

class ShowByHp extends Component{

    state = {
        cars: []
    }

    componentWillMount(){
        axios.get('http://localhost:9001/carHp/' + this.props.match.params.hp).then((response)=>{
            this.setState({
            cars: response.data
            })
        })
    }

    render(){
        
        let cars = this.state.cars.map((car)=>{
            return(
            <tr key={car.id}>
                <td>{car.name}</td>
                <td>{car.hp}</td>
                <td>{car.manufacturer}</td>
                <td>{car.type}</td>
            </tr>
            )
        })

    return(
     
    <div className="App container">
    
    <Table>
        <thead>
        <tr>
            <th>Name</th>
            <th>Hp</th>
            <th>Manufacturer</th>
            <th>Type</th>
        </tr>
        </thead>
        <tbody>
        
        {cars}
        </tbody>
    </Table>

    </div>
    );
  }
}

export default ShowByHp;
  