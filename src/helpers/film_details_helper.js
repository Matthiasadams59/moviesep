import Axios from 'axios'

const getFilm = async (filmId, callback) => {
    let result

    try {
        result = await Axios.get("http://localhost:8080/film/"+filmId)
        console.log(result.data)
    } catch (error) {
        console.log(error)
        result = null
    }

    callback(result.data)
}

const updateFilm = async (film) => {
    let result
    console.log(film)

    try {
        result = await Axios.post("http://localhost:8080/filmUpdate/", film)
    } catch (error) {
        console.log(error)
        result = null
    }
}

export { getFilm, updateFilm }