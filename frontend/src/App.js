import './App.css';
import React from 'react';
import {BrowserRouter as Router, Switch, Route, Link} from "react-router-dom";
import Home from "./Pages/Home";
import Login from "./Pages/Login";
import {Provider} from "react-redux";
import store from "./store";

function App() {
    return (
        <Provider store={store}>
            <div className="App">
                <Router>
                    <Switch>
                        <Route exact path='/' component={Home}/>
                        <Route exact path='/login' component={Login}/>
                    </Switch>
                </Router>
            </div>
        </Provider>
    );
}

export default App;
