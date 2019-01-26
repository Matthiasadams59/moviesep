import React, {Component} from 'react'
import List from '@material-ui/core/List';
import ListItemText from '@material-ui/core/ListItemText';
import Typography from '@material-ui/core/Typography';
import axios from 'axios';


class Actor extends Component {
    constructor(props) {
        super(props)

        this.state = {
            actorId: '',
            actor: []
        }
    }

    getActor = async (e) => {
        await axios
        .get("http://localhost:8080/actor/5")
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
                <Typography variant="h2">ACTOR INFO</Typography>
                    <div>  
                        <List>
                            <ListItemText>
                                First Name: {this.state.actor.firstName}
                            </ListItemText>
                            <ListItemText>
                                Last Name: {this.state.actor.lastName}
                            </ListItemText>
                            <ListItemText>
                                Gender: {this.state.actor.gender}
                            </ListItemText>
                        </List>
                    </div>
            </div>
        )
    }
}

export default Actor