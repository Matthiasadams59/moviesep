import React from 'react'
import PropTypes from 'prop-types'
import Button from '@material-ui/core/Button';
import Card from '@material-ui/core/Card';
import CardActions from '@material-ui/core/CardActions';
import CardContent from '@material-ui/core/CardContent';
import Typography from '@material-ui/core/Typography';

const Film = (props) =>
    <Card style={{ margin: '3%', width: '30%' }}>
        <CardContent>
            <Typography variant="h3">{props.film.title}</Typography>
            <Typography component="p">{props.film.description}</Typography>
        </CardContent>
        <CardActions>
            <Button href={"/film/" + props.film.filmId} style={{ margin: 'auto' }}>Learn More</Button>
        </CardActions>
    </Card>

Film.propTypes = {
    film: PropTypes.object.isRequired
}

export default Film