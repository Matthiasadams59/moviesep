import React from 'react'
import PropTypes from 'prop-types'
import ListItem from '@material-ui/core/ListItem';
import ListItemText from '@material-ui/core/ListItemText';

const Film = (props) =>
    <ListItem button>
        <ListItemText primary={props.film} />
    </ListItem>

Film.propTypes = {
    film: PropTypes.string.isRequired
}

export default Film