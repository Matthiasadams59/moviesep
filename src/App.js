import React, { Component } from 'react'
import './App.css'
import Home from './components/Home'
import LoginForm from './components/LoginForm'
import Actor from './components/Actor'
import Films from './components/Films'
import FilmDetails from './components/FilmDetails'
import Error404 from './components/Error404'
import { BrowserRouter, Route, Switch } from 'react-router-dom'
import Menu from './components/Menu';

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
          <div id="navbar">
            <Menu isLoggedIn={this.state.isLoggedIn} />
          </div>
          <hr />
          <div id="content" className="ui">
            <Switch>
              <Route exact path="/" component={Home} />
              <Route path="/login" component={(props) => <LoginForm {...props} login_handler={this.login_handler}/>} />
              <Route path="/actor/:id" component={Actor} />
              <Route path="/film/:id" component={FilmDetails} />
              <Route path="/films" component={Films} />
              <Route path="/user/:id" component={User} />
              <Route component={Error404} />
            </Switch>
          </div>
        </div>
      </BrowserRouter>
    )
  }

  login_handler = (result) => {
    if (result) {
      window.location.replace("/user/"+result.data.userId)
    }
  }
}

export default App;
