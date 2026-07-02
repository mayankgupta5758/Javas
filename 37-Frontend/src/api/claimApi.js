import axios from "axios"

const claimApis = axios.create({
    baseURL: "http://localhost:8080/api/claims"
})

export default claimApis