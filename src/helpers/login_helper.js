import Axios from 'axios'

const login_helper = async (username, password, callback) => {
    let result

    try {
        const loginResult = await Axios.post("http://localhost:8080/login", {
            'username': username,
            'password': password
        })
        result = loginResult
    } catch (error) {
        console.log(error)
        result = null
    }

    callback(result)
}

export default login_helper