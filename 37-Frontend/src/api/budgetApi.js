import axios from "axios"

const budgetApi = axios.create({
    baseURL: "http://localhost:8080/api/budgets"
})

export default budgetApi