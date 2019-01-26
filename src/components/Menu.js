import React, { Component } from 'react'
import { AppBar, Toolbar, IconButton, Typography, Drawer, List, ListItem } from '@material-ui/core'
import MenuIcon from '@material-ui/icons/Menu'
import PropTypes from 'prop-types'


import { NavLink } from 'react-router-dom'

class Menu extends Component {
    constructor() {
        super()

        this.state = {
            open: false
        }
    }

    toggleOpen = () => {
        this.setState({
            open: !this.state.open
        })
    }

    render() {
        return (
            <div>
                <AppBar>
                    <Toolbar>
                        <IconButton color="inherit" onClick={this.toggleOpen}>
                            <MenuIcon />
                        </IconButton>
                        <Typography variant="h6" color="inherit">
                            Moviesep
                        </Typography>
                    </Toolbar>
                </AppBar>
                <Drawer open={this.state.open} onClose={this.toggleOpen}>
                    <List>
                        {this.props.isLoggedIn ? null :
                            <ListItem><NavLink onClick={this.toggleOpen} to="/login">Login</NavLink></ListItem>
                        }
                        <ListItem><NavLink onClick={this.toggleOpen} exact to="/">Home</NavLink></ListItem>
                        <ListItem><NavLink onClick={this.toggleOpen} exact to="/films">Films List</NavLink></ListItem>
                    </List>
                </Drawer>
            </div>
        )
    }
}

Menu.propTypes = {
    isLoggedIn: PropTypes.bool.isRequired
}

export default Menu