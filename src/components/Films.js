import React, {Component} from 'react'
import Grid from '@material-ui/core/Grid';
import GridList from '@material-ui/core/GridList';
import List from '@material-ui/core/List';
import ListItem from '@material-ui/core/ListItem';
import Typography from '@material-ui/core/Typography';
import Link from '@material-ui/core/Link';
import Button from '@material-ui/core/Button';
import Card from '@material-ui/core/Card';
import CardActions from '@material-ui/core/CardActions';
import CardContent from '@material-ui/core/CardContent';
import CardMedia from '@material-ui/core/CardMedia';
import axios from 'axios';
import films_helper from './../helpers/films_helper'
import { ListItemText } from '@material-ui/core';

const styles = {
    card: {
      minWidth: 275,
    },
    bullet: {
      display: 'inline-block',
      margin: '0 2px',
      transform: 'scale(0.8)',
    },
    title: {
      fontSize: 14,
    },
    pos: {
      marginBottom: 12,
    },
};

class Films extends Component {
    constructor(props) {
        super(props)

        this.state = {
            films: [],
        }

        
    }

    getFilms2 = async (e) => {
        films_helper( (results) => {
            this.setState({
                films: results
            })
        })
    }

    getFilms = (e) => {
        axios
        .get("http://localhost:8080/film/")
        .then( response => {
            this.setState({
                films: response.data,
            })
        })
        .catch(error => this.setState({ error }))
    }

    componentDidMount= () => {
        this.getFilms();
    }

    render() {

        return(
            <div>
                {console.log(this.state.films)}
                <Typography variant="h2">FILMS LIST</Typography>
                    <div>   
                        <List style={{display: 'flex', flexWrap: 'wrap', justifyContent: 'space-around',overflow: 'hidden'}}>
                            {
                                this.state.films.map((film, index) => (
                                    <Card key={index} style={{margin:'3%', width:'30%'}}>
                                        <CardContent>
                                            <Typography variant="h3">{film.title}</Typography>
                                            <Typography component="p">{film.description}</Typography>
                                        </CardContent>
                                        <CardActions>
                                            <Button href="/film/{index}" style={{margin:'auto'}}>Learn More</Button>
                                            {/* <Link to="/film/{index}">Learn again</Link> */}
                                        </CardActions>
                                    </Card>
                                    
                                )
                            )}   
                        </List>
                    </div>
            </div>
        )
    }
}

export default Films