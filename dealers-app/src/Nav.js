import React from 'react';
import './App.css';
import {Link} from 'react-router-dom';

function Nav(){
    const style = {
        color: 'white'
    }
    return(
        <nav>
            <ul className="nav-links">
                <Link style={style} to="/cars">
                <li>Cars microservice</li>
                </Link>
                <Link style={style} to="/boats">
                <li>Botas microservice</li>
                </Link>
            </ul>
        </nav>
    );
}

export default Nav;