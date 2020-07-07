import React, { Component } from 'react';
import { Table, Button } from 'reactstrap';
import axios from 'axios';

class Orders extends Component{

    state = {
        orders: []
    }

    componentWillMount(){
        axios.get('http://localhost:9001/showOrders').then((response)=>{
            this.setState({
            orders: response.data,
            })
        })
    }

    putInProgress(id){
        axios.put('http://localhost:9001/putInProgress/' + id).then((response)=>{
            this.componentWillMount();
        })
    }
  
    render(){
    
        let orders = this.state.orders.map((ord)=>{
            if(ord.status != "inProgress"){
            return(
            <tr key={ord.order_id}>
                <td>{ord.manufacturer}</td>
                <td>{ord.name}</td>
                <td>{ord.hp}</td>
                <td>{ord.status}</td>
                <td>
                    <Button color="success" size="sm" className="mr-2" onClick={this.putInProgress.bind(this, ord.order_id)}>Put in progress</Button>
                </td>
            </tr>
            )
            }else{
                return(
                    <tr key={ord.order_id}>
                        <td>{ord.manufacturer}</td>
                        <td>{ord.name}</td>
                        <td>{ord.hp}</td>
                        <td>{ord.status}</td>
                    </tr>
                )
            }
        })
   
    return(
     
    <div className="App container">

    <Table>
        <thead>
            <tr>
                <th>Manufacturer</th>
                <th>Name</th>
                <th>Hp</th>
                <th>Status</th>
            </tr>
        </thead>
        <tbody>
        {orders}
        
        </tbody>
    </Table>

    </div>
    );
  }
}

export default Orders;
  