import React, { Component } from 'react';
import { Table, Button } from 'reactstrap';
import axios from 'axios';

class Boats extends Component{

    state = {
        boats: [],
        captains: [],
        finalArray: [],
        headers: [],
        dockedBoats: [],
        fullDocks: [],
        availableDocks: [],
        btnPressed: 0
    }

    componentWillMount(){
        axios.get('http://localhost:9000/boats').then((response)=>{
            this.setState({
            boats: response.data,
            btnPressed: 1
            })
        })
    }

    getCaptains(){
        axios.get('http://localhost:9000/captains').then((response)=>{
            this.setState({
                captains: response.data
            })
        })
    }

    showCaptains(){
        this.getCaptains();
        this.state.btnPressed = 2
    }

    getDockedBoats(){
        axios.get('http://localhost:9000/dockedBoats').then((response)=>{
            this.setState({
                dockedBoats: response.data
            })
        })
        this.state.btnPressed = 3
    }

    getFullDocks(){
        axios.get('http://localhost:9000/fullDocks').then((response)=>{
            this.setState({
                fullDocks: response.data
            })
        })
        this.state.btnPressed = 4
    }

    getFreeDocks(){
        axios.get('http://localhost:9000/availableDocks').then((response)=>{
            this.setState({
                availableDocks: response.data
            })
        })
        this.state.btnPressed = 5
    }

    renderHeaders(){
        if(this.state.btnPressed == 1){
            return(
            <tr>
                <th>Boat name</th>
                <th>Captain</th>
                <th>Captains experience</th>
            </tr>
            )
        }else if(this.state.btnPressed == 2){
            return(
                <tr>
                    <th>Captain name</th>
                    <th>Captains experience</th>
                </tr>
            )
        }else if(this.state.btnPressed == 3){
            return(
                <tr>
                    <th>Boat name</th>
                    <th>Dock name</th>
                    <th>Dock's capacity</th>
                    <th>Is full</th>
                    <th>Captain's name</th>
                </tr>
            )
        }else if(this.state.btnPressed == 4){
            return (
                <tr>
                    <th>Dock name</th>
                    <th>Dock's capacity</th>
                    <th>Is full</th>
                </tr>
            )
        }else if(this.state.btnPressed == 5){
            return(
                <tr>
                    <th>Dock name</th>
                    <th>Dock's capacity</th>
                    <th>Is full</th>
                </tr>
            )
        }
    }
  
    render(){
        if(this.state.btnPressed == 1){
            // console.log("Usao u prvi")
            let boats = this.state.boats.map((boat)=>{
                return(
                <tr key={boat.id}>
                    <td>{boat.name}</td>
                    <td>{boat.captain_name}</td>
                    <td>{boat.cap_experience}</td>
                </tr>
                )
            })
            this.state.finalArray = boats
        }else if(this.state.btnPressed == 2){
            // console.log("Usao u drugi")
            let captains = this.state.captains.map((cap)=>{
                return (
                    <tr key={cap.captain_id}>
                        <td>{cap.name}</td>
                        <td>{cap.experience}</td>
                    </tr>
                )
            })
            this.state.finalArray = captains
        }
        else if(this.state.btnPressed == 3){
            var cnt = 0;
            let dockedBoats = this.state.dockedBoats.map((db)=>{
                return(
                    <tr key={cnt++}>
                        <td>{db.boatName}</td>
                        <td>{db.dockName}</td>
                        <td>{db.capacity}</td>
                        <td>{db.full.toString()}</td>
                        <td>{db.capName}</td>
                    </tr>
                )
            })
            this.state.finalArray = dockedBoats
        }else if(this.state.btnPressed == 4){
            let fullDocks = this.state.fullDocks.map((fd)=>{
                return(
                    <tr key={fd.dock_id}>
                        <td>{fd.name}</td>
                        <td>{fd.capacity}</td>
                        <td>{fd.full.toString()}</td>
                    </tr>
                )
            })
            this.state.finalArray = fullDocks
        }else if(this.state.btnPressed == 5){
            let availableDocks = this.state.availableDocks.map((ad)=>{
                return(
                    <tr key={ad.dock_id}>
                        <td>{ad.name}</td>
                        <td>{ad.capacity}</td>
                        <td>{ad.full.toString()}</td>
                    </tr>
                )
            })
            this.state.finalArray = availableDocks
        }

    return(
     
    <div className="App container">
    Show: 
    <Button className="my-3 mx-2" color="primary" onClick={this.componentWillMount.bind(this)}>All boats</Button>
    <Button className="my-3 mx-2" color="primary" onClick={this.getDockedBoats.bind(this)}>Docked boats</Button>
    <Button className="my-3 mx-2" color="primary" onClick={this.getFullDocks.bind(this)}>Full docs</Button>
    <Button className="my-3 mx-2" color="primary" onClick={this.getFreeDocks.bind(this)}>Available docs</Button>
    <Button className="my-3 mx-2" color="primary" onClick={this.showCaptains.bind(this)}>Captains</Button>
    {/* Ubaciti pretrage jos neke da se dobije 15 ruta ukupno */}
    <Table>
        <thead>
        {this.renderHeaders()}
        </thead>
        <tbody>
        {this.state.finalArray}
        
        </tbody>
    </Table>

    </div>
    );
  }
}

export default Boats;
  