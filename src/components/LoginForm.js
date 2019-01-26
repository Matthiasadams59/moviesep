import React, { Component } from 'react'
import PropTypes from 'prop-types'
import TextField from '@material-ui/core/TextField'
import Button from '@material-ui/core/Button'
import login_helper from './../helpers/login_helper'

class LoginForm extends Component {
  constructor() {
    super()

    this.state = {
      username: "",
      password: ""
    }
  }

  render() {
    return (
      <form>
        <TextField
          id="username"
          label="User Name"
          value={this.state.name}
          onChange={this.handleChange('username')}
          margin="normal" />
        <br />
        <TextField
          id="password"
          label="Password"
          type="password"
          value={this.state.name}
          onChange={this.handleChange('password')}
          margin="normal" />
        <br />
        <Button variant="contained" color="primary" onClick={this.login()}>
          Log in
        </Button>
      </form>
    )
  }

  handleChange = name => event => {
    this.setState({
      [name]: event.target.value,
    })
  }

  login = () => {
    login_helper(this.state.username, this.state.password, this.props.login_handler)
  }
}

LoginForm.propTypes = {
  login_handler: PropTypes.func.isRequired
}

export default LoginForm