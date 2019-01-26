import React, { Component } from 'react'

import { getFilm, updateFilm } from './../helpers/film_details_helper';
import TextField from '@material-ui/core/TextField';
import List from '@material-ui/core/List';
import ListItemText from '@material-ui/core/ListItemText';

import Button from '@material-ui/core/Button';
import Axios from 'axios'


class FilmDetails extends Component {
    constructor() {
        super()

        this.state = {
            filmId: 0,
            filmTitle: '',
            filmDescription: '',
            filmReleaseYear: 0,
            filmLanguage: '',
            filmCategory: '',
            filmLength: 0,
            filmRating: 0,
            actors: []
        }
    }

    async componentDidMount() {
        getFilm(this.props.match.params.id, (film) => {
            this.setState({
                filmId: film.filmId,
                filmTitle: film.title,
                filmDescription: film.description,
                filmReleaseYear: film.releaseYear,
                filmLanguage: film.language,
                filmCategory: film.category,
                filmLength: film.length,
                filmRating: film.rating,
                actors: film.actors
            })
        })
    }

    render() {
        console.log(this.state.actors)

        return (
            <form>
                <TextField
                    id="title"
                    label="Title"
                    value={this.state.filmTitle}
                    onChange={this.handleChange('filmTitle')}
                    margin="normal" />
                <br />
                <TextField
                    id="releaseYear"
                    label="Release Year"
                    value={this.state.filmReleaseYear}
                    onChange={this.handleChange('filmReleaseYear')}
                    margin="normal" />
                <br />
                <TextField
                    id="description"
                    label="Description"
                    multiline
                    rowsMax="10"
                    value={this.state.filmDescription}
                    onChange={this.handleChange('filmDescription')}
                    margin="normal" />
                <br />
                <TextField
                    id="language"
                    label="Language"
                    value={this.state.filmLanguage}
                    onChange={this.handleChange('filmLanguage')}
                    margin="normal" />
                <br />
                <TextField
                    id="category"
                    label="Category"
                    value={this.state.filmCategory}
                    onChange={this.handleChange('filmCategory')}
                    margin="normal" />
                <br />
                <TextField
                    id="length"
                    label="Duration"
                    value={this.state.filmLength}
                    onChange={this.handleChange('filmLength')}
                    margin="normal" />
                <br />
                <TextField
                    id="rating"
                    label="Rating"
                    value={this.state.filmRating}
                    onChange={this.handleChange('filmRating')}
                    margin="normal" />
                <br />
                <List>
                    {this.state.actors.map((actor, index) => {
                        return (
                            <ListItemText key={index}><Button href={"/actor/" + actor.actorId}>{actor.firstName + " " + actor.lastName}</Button></ListItemText>
                        )
                    })}
                </List>
                <br />
                <Button variant="contained" color="primary" onClick={() => this.makeFilmUpdate()}>
                    Save changes
                </Button>
            </form>
        )
    }

    makeFilmUpdate = async () => {
        updateFilm({
            filmId: this.state.filmId,
            title: this.state.filmTitle,
            category: this.state.filmCategory,
            description: this.state.filmDescription,
            length: this.state.filmLength,
            language: this.state.filmLanguage,
            releaseYear: this.state.filmReleaseYear,
            rating: this.state.filmRating
        })
    }

    handleChange = name => event => {
        this.setState({
            [name]: event.target.value,
        })
    }
}

export default FilmDetails