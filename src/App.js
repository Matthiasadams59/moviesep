import React, { Component } from 'react';
import logo from './logo.svg';
import './App.css';
import LoginForm from './LoginForm';

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
      <div className="App">
        <LoginForm login_handler={this.login_handler}/>
      </div>
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
