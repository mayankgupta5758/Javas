import axios from "axios";
import budgetApi from "../api/budgetApi";

const API = "http://localhost:8080/api/budgets";

export const createBudget = (data) =>
  axios.post(API, data);

export const getAllBudgets = () =>
  axios.get(API);

export const getSummary = (
  department,
  month,
  year
) =>
  axios.get(
    `${API}/summary?department=${department}&month=${month}&year=${year}`
  );


export const getSummary1 = async (department,month,year) => {
  try {
    const res = await budgetApi.get(`/summary?department=${department}&month=${month}&year=${year}`)

    return res.data
  } catch (error) {
    console.log(error)
    throw error;
  }
}

export const getAllBudgets1 = async () => {
  try {
    const res = await budgetApi.get("")

    return res.data
  } catch (error) {
    console.log(error)
    throw error;
  }
}


export const createBudget1 = async (formData) => {
  try {
    const res = await budgetApi.post("", formData)

    return res.data
  } catch (error) {
    console.log(error)
    throw error;
  }
}