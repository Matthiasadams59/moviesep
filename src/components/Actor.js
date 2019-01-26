import React, {Component} from 'react'
import List from '@material-ui/core/List';
import Typography from '@material-ui/core/Typography';
import Button from '@material-ui/core/Button';
import Card from '@material-ui/core/Card';
import CardActions from '@material-ui/core/CardActions';
import CardContent from '@material-ui/core/CardContent';
import axios from 'axios';

class Actor extends Component {
    constructor(props) {
        super(props)

        this.state = {
            actorId: '',
            actor: []
        }
    }

    getActor = (e) => {
        axios
        .get("http://localhost:8080/actor/8")
        .then( response => {
            this.setState({
                actor: response.data,
            })
        })
        .catch(error => this.setState({ error }))
    }

    componentDidMount= () => {
        this.getActor();
    }

    render() {

        return(
            <div>
                {console.log(this.state.actor)}
                <Typography variant="h2">ACTOR INFO</Typography>
                    <div>  
                        <p>{this.state.actor.firstName}</p>
                        <p>{this.state.actor.lastName}</p>
                        <p>{this.state.actor.gender}</p>
                    </div>
            </div>
        )
    }
}

export default Actor