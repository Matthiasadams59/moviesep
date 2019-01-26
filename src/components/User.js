import React, { Component } from 'react'

import { getFilm, updateFilm } from './../helpers/user_helper';
import TextField from '@material-ui/core/TextField';
import List from '@material-ui/core/List';
import ListItemText from '@material-ui/core/ListItemText';

import Button from '@material-ui/core/Button';
import Axios from 'axios'

class FilmDetails extends Component {
    constructor() {
        super()

        this.state = {
            userId: 0,
            username: '',
            password: '',
            lastName: '',
            firstName: '',
            films: ''
        }
    }

    async componentDidMount() {
        getUser(this.props.match.params.id, (user) => {
            this.setState({
                userId: user.userId,
                username: user.username,
                password: user.password,
                lastName: user.lastName,
                firstName: user.firstName,
                films: user.films,
            })
        })
    }

    render() {

    }

}

export default FilmDetails