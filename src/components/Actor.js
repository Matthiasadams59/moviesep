import React, {Component} from 'react'
import List from '@material-ui/core/List';
import ListItemText from '@material-ui/core/ListItemText';
import Typography from '@material-ui/core/Typography';
import Button from '@material-ui/core/Button';
import { getActor } from './../helpers/actor_helper';


class Actor extends Component {
    constructor(props) {
        super(props)

        this.state = {
            actorId: 0,
            lastName: '',
            firstName: '',
            gender: '',
            films: [] 
        }
    }


    componentDidMount= () => {
        getActor(this.props.match.params.id, (actor) => {
            this.setState({
                actorId: actor.actorId,
                lastName: actor.lastName,
                firstName: actor.firstName,
                gender: actor.gender,
                films: actor.films
            })
        })
    }

    render() {

        return(
            <div>
                <Typography variant="h2">ACTOR INFO</Typography>
                    <div>  
                        <List>
                            <ListItemText>
                                First Name: {this.state.firstName}
                            </ListItemText>
                            <ListItemText>
                                Last Name: {this.state.lastName}
                            </ListItemText>
                            <ListItemText>
                                Gender: {this.state.gender}
                            </ListItemText>
                            <Typography variant="h4">Movies</Typography>
                            <List>
                                {this.state.films.map((film, index) => {
                                    return (
                                        <ListItemText key={index}><Button href={"/film/" + film.filmId}>{film.title}</Button></ListItemText>
                                    )
                                })}
                            </List>
                        </List>
                    </div>
            </div>
        )
    }
}

export default Actor