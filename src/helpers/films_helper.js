import axios from 'axios'

const films_helper = (callback) => {
    axios
        .get("http://localhost:8080/film/")
        .then( response => {
            this.setState({
                films: response.data,
            })
        })
        .catch(error => this.setState({ error }))
}

export default films_helper