import React, {Component} from 'react'
import List from '@material-ui/core/List';
import Typography from '@material-ui/core/Typography';
import axios from 'axios';
import films_helper from './../helpers/films_helper'
import Film from './Film';

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
                                    <Film key={index} film={film}/>                                    
                                )
                            )}   
                        </List>
                    </div>
            </div>
        )
    }
}

export default Films