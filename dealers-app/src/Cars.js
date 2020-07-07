import React, { Component } from 'react';
import { Table, Button, Modal, ModalHeader, FormGroup,Form, ModalBody, ModalFooter,Input } from 'reactstrap';
import {Link} from 'react-router-dom';
import axios from 'axios';

class Cars extends Component {
    style = {
        color: 'white'
    }
  state = {
    cars: [],
    searchType: '',
    searchHp: 0.0,
    searchManu: '',
    newCarModal: false,
    editCarModal: false,
    newCarData:{
        name:'',
        hp: 0,
        manufacturer: '',
        type: ''
    },
    editCarData:{
        id: '',
        name:'',
        hp: 0,
        manufacturer: '',
        type: ''
    }
  }

editCarData(id, name, hp, type, manufacturer){
    this.setState({
        editCarData:{id, name, hp, type, manufacturer},
        editCarModal: ! this.state.editCarModal

    })
}

deleteCar(id){
    axios.delete('http://localhost:9001/deleteCar/' + id, {
    }).then((response)=>{
        this.componentWillMount();
    })
}

updateCarData(){
    let { name, hp, manufacturer, type} = this.state.editCarData;
    axios.put('http://localhost:9001/carUpdate/' + this.state.editCarData.id, {
        name, hp, type, manufacturer
    }).then((response)=>{
        this.componentWillMount();
        this.setState({
            editCarModal: false
        })
    })
}

componentWillMount(){
axios.get('http://localhost:9001/cars').then((response)=>{
    this.setState({
    cars: response.data
    })
})
}

toggleEditCarModal(){
    this.setState({
        editCarModal: ! this.state.editCarModal
    })
}

toggleNewCarModal(){
    this.setState({
        newCarModal: ! this.state.newCarModal
    })
}

addCar(){
    axios.post('http://localhost:9001/addCar', this.state.newCarData).then((response)=> {
        this.componentWillMount();
        // let {cars} = this.state;
        // cars.push(response.data);
        let cars = this.state.cars;
        this.setState({cars, newCarModal: false, newCarData:{
        name:'',
        hp: 0,
        manufacturer: '',
        type: ''
        }
    });
    });
}

    render(){
    let cars = this.state.cars.map((car)=>{
        return (
        <tr key={car.id}>
            <td>{car.id}</td>
            <td>{car.name}</td>
            <td>{car.hp}</td>
            <td>{car.manufacturer}</td>
            <td>{car.type}</td>
            <td>
            <Button color="success" size="sm" className="mr-2"onClick={this.editCarData
                .bind(this, car.id, car.name, car.hp, car.type, car.manufacturer)} >Edit</Button>
            <Button color="danger" size="sm" onClick={this.deleteCar.bind(this, car.id)}>Delete</Button>
            </td>
        </tr>
        )
    })
    return (
        <div className="App container">

        <Button className="my-3" color="primary" onClick={this.toggleNewCarModal.bind(this)}>Add a new car</Button>
        <Button className="my-3 mx-2" color="primary"><Link style={this.style} to="/showOrders">Show orders</Link></Button>
        <Modal isOpen={this.state.newCarModal} toggle={this.toggleNewCarModal.bind(this)}>
            <ModalHeader toggle={this.toggleNewCarModal.bind(this)}>Adding a new car to database</ModalHeader>
            <ModalBody>
                <FormGroup>
                    <Input placeholder="name" value={this.state.newCarData.name} onChange={(e) =>{
                        let {newCarData} = this.state;
                        newCarData.name = e.target.value
                        this.setState({newCarData});
                    }}
                    />
                </FormGroup>
                <br></br>
                <FormGroup>
                    <Input placeholder="hp" value={this.state.newCarData.hp} onChange={(e) =>{
                        let {newCarData} = this.state;
                        newCarData.hp = e.target.value
                        this.setState({newCarData});
                    }} />
                </FormGroup>
                <br></br>
                <FormGroup>
                    <Input placeholder="manufacturer" value={this.state.newCarData.manufacturer} onChange={(e) =>{
                        let {newCarData} = this.state;
                        newCarData.manufacturer = e.target.value
                        this.setState({newCarData});
                    }} />
                </FormGroup>
                <br></br>
                <FormGroup>
                    <Input placeholder="type" value={this.state.newCarData.type} onChange={(e) =>{
                        let {newCarData} = this.state;
                        newCarData.type = e.target.value
                        this.setState({newCarData});
                    }} />
                </FormGroup>
                <br></br>
            </ModalBody>
            <ModalFooter>
            <Button color="primary" onClick={this.addCar.bind(this)}>Add</Button>{' '}
            <Button color="secondary" onClick={this.toggleNewCarModal.bind(this)}>Cancel</Button>
            </ModalFooter>
        </Modal>
        
        {/* Edit modal */}
        <Modal isOpen={this.state.editCarModal} toggle={this.toggleEditCarModal.bind(this)}>
            <ModalHeader toggle={this.toggleEditCarModal.bind(this)}>Edit car info</ModalHeader>
            <ModalBody>
                <FormGroup>
                    <Input placeholder="name" value={this.state.editCarData.name} onChange={(e) =>{
                        let {editCarData} = this.state;
                        editCarData.name = e.target.value
                        this.setState({editCarData});
                    }}
                    />
                </FormGroup>
                <br></br>
                <FormGroup>
                    <Input placeholder="hp" value={this.state.editCarData.hp} onChange={(e) =>{
                        let {editCarData} = this.state;
                        editCarData.hp = e.target.value
                        this.setState({editCarData});
                    }} />
                </FormGroup>
                <br></br>
                <FormGroup>
                    <Input placeholder="manufacturer" value={this.state.editCarData.manufacturer} onChange={(e) =>{
                        let {editCarData} = this.state;
                        editCarData.manufacturer = e.target.value
                        this.setState({editCarData});
                    }} />
                </FormGroup>
                <br></br>
                <FormGroup>
                    <Input placeholder="type" value={this.state.editCarData.type} onChange={(e) =>{
                        let {editCarData} = this.state;
                        editCarData.type = e.target.value
                        this.setState({editCarData});
                    }} />
                </FormGroup>
                <br></br>
            </ModalBody>
            <ModalFooter>
            <Button color="primary" onClick={this.updateCarData.bind(this)}>Update</Button>{' '}
            <Button color="secondary" onClick={this.toggleEditCarModal.bind(this)}>Cancel</Button>
            </ModalFooter>
        </Modal>

        <Table>
            <thead>
            <tr>
                <th>ID</th>
                <th>Name</th>
                <th>Hp</th>
                <th>Manufacturer</th>
                <th>Type</th>
                <th>Actions</th>
            </tr>
            </thead>
            <tbody>
            {cars}
            </tbody>
        </Table>
        
        <Form inline>
        <FormGroup>
            <Input placeholder="Type of car" value={this.state.searchType} onChange={(e) =>{
                        let {searchType} = this.state;
                        searchType = e.target.value
                        this.setState({searchType});
                    }} /> 
            <Button className="mx-2" color="primary"><Link style={this.style} to={"/showByType/" + this.state.searchType}>Search</Link></Button>
        </FormGroup>
        </Form>

        <Form inline className="mt-2">
        <FormGroup>
            <Input placeholder="Number of hp" value={this.state.searchHp} onChange={(e) =>{
                        let {searchHp} = this.state;
                        searchHp = e.target.value
                        this.setState({searchHp});
                    }} /> 
            <Button className="mx-2" color="primary"><Link style={this.style} to={"/showByHp/" + this.state.searchHp}>Search</Link></Button>
        </FormGroup>
        </Form>

        <Form inline>
        <FormGroup className="mt-2">
            <Input placeholder="Name of manufacturer" value={this.state.searchManu} onChange={(e) =>{
                        let {searchManu} = this.state;
                        searchManu = e.target.value
                        this.setState({searchManu});
                    }}/> 
            <Button className="mx-2" color="primary" ><Link style={this.style} to={"/showByManufacturer/" + this.state.searchManu}>Search</Link></Button>
        </FormGroup>
        </Form>
        
        </div>
    );
  }
}

export default Cars;