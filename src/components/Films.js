import React, {Component} from 'react'
import List from '@material-ui/core/List';
import Typography from '@material-ui/core/Typography';
import Button from '@material-ui/core/Button';
import Card from '@material-ui/core/Card';
import CardActions from '@material-ui/core/CardActions';
import CardContent from '@material-ui/core/CardContent';
import axios from 'axios';

class Films extends Component {
    constructor(props) {
        super(props)

        this.state = {
            films: [],
        }
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
                                            <Button href={'/film/' + film.filmId} style={{margin:'auto'}}>Learn More</Button>
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