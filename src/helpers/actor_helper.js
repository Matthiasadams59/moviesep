import Axios from 'axios'

const getActor = async (actorId, callback) => {
    let result

    try {
        result = await Axios.get("http://localhost:8080/actor/"+actorId)
        console.log(result.data)
    } catch (error) {
        console.log(error)
        result = null
    }

    callback(result.data)
}

export { getActor }