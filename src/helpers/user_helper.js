import Axios from 'axios'

const getUser = async (userId, callback) => {
    let result

    try {
        result = await Axios.get("http://localhost:8080/user/"+userId)
        console.log(result.data)
    } catch (error) {
        console.log(error)
        result = null
    }

    callback(result.data)
}

export { getUser }