import React, { Component } from 'react'
import './App.css'
import LoginForm from './LoginForm'
import Favorites from './Favorites'
import Home from './Home'
import Error404 from './Error404'
import { BrowserRouter, Route, Switch } from 'react-router-dom'
import Menu from './Menu';

class App extends Component {

  constructor() {
    super()

    this.state = {
      isLoggedIn: false,
      loginCookie: ""
    }

    this.login_handler = this.login_handler.bind(this)
  }

  render() {
    return (
      <BrowserRouter>
        <div className="App">
          <Menu isLoggedIn={this.state.isLoggedIn} />
          <hr />
          <div id="content">
            <Switch>
              <Route exact path="/" component={Home} />
              <Route path="/favorites" component={Favorites} />
              <Route path="/login" component={(props) => <LoginForm {...props} login_handler={this.login_handler}/>} />
              <Route component={Error404} />
            </Switch>
          </div>
        </div>
      </BrowserRouter>
    )
  }

  login_handler = (result) => {
    if (result) {
      this.props.loginCookie = result
      this.props.isLoggedIn = true
    }
  }
}

export default App;
