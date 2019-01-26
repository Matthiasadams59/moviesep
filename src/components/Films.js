import React, {Component} from 'react'
import List from '@material-ui/core/List';
import Typography from '@material-ui/core/Typography';
import axios from 'axios'
import Film from './Film'

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

    componentDidMount = () => {
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