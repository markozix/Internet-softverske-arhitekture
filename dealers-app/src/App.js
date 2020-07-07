import React, { Component } from 'react';
import './App.css';
import Nav from './Nav';
import Cars from './Cars';
import Home from './Home';
import ShowByType from './ShowByType';
import {BrowserRouter as Router, Switch, Route} from 'react-router-dom';
import ShowByHp from './ShowByHp';
import Manufacturer from './Manufacturer';
import {Spinner} from 'reactstrap';
import Boats from './Boats';
import Orders from './Orders';

function App(){

  return(
    <Router>
    <div className="App">
      <Nav />
      <Route path="/" exact component={Home}></Route>
      <Route path="/cars" component={Cars}></Route>
      <Route path="/showByType/:type" component={ShowByType}></Route>
      <Route path="/showByHp/:hp" component={ShowByHp}></Route>
      <Route path="/showByManufacturer/:manu" component={Manufacturer}></Route>
      <Route path="/boats" component={Boats}></Route>
      <Route path="/showOrders" component={Orders}></Route>
    </div>
    </Router>
  );

}


export default App;
