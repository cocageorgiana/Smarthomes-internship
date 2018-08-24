import React from 'react';
import { Switch, Route } from 'react-router-dom';
import Home from './pages/Home/home';
import Login from './pages/Login/login';
import Register from './pages/Register/register';
import UserSettings from './pages/UserSettings/userSettings';
import AHP from './pages/AllHousesPage/AllHousesPage';
import SingleHouse from './pages/SingleHouse/SingleHouse';

const Main = (props) => (
  <Switch>
    <Route exact path="/" component={Home} />
    <Route exact path="/login" component={Login} />
    <Route exact path="/register" component={Register} />
    <Route exact path="/user" component={UserSettings} />
    <Route exact path="/my-houses" component={AHP} />
    <Route exact path="/house" component={SingleHouse} />
  </Switch>
)
export default Main;