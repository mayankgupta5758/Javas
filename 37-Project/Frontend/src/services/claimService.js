import axios from "axios";
import claimApis from "../api/claimApi";

const API = "http://localhost:8080/api/claims";

export const createClaim = (data) =>
  axios.post(API, data);

export const getAllClaims = () =>
  axios.get(API);

export const getClaimById = (id) =>
  axios.get(`${API}/${id}`);

export const approveClaim = (id, data) =>
  axios.put(`${API}/${id}/approve`, data);

export const rejectClaim = (id, data) =>
  axios.put(`${API}/${id}/reject`, data);


export const rejectClaim1 = async (id) => {
  try {
    const res = await claimApis.put(`${id}/reject`, {
      reviewRemark: "Rejected",
    })

    return res.data
  } catch (error) {
    console.log(error);
    throw error;
  }
}

export const approveClaim1 = async (id) => {
  try {
    const res = await claimApis.put(`${id}/approve`, {
      reviewRemark: "Approved",
    })

    return res.data
  } catch (error) {
    console.log(error);
    throw error;
  }
}

export const getClaimById1 = async (id) => {
  try {
    const res = await claimApis.get(`${id}`)

    return res.data
  } catch (error) {
    console.log(error);
    throw error;
  }
}

export const getAllClaims1 = async () => {
  try {
    const res = await claimApis.get("")

    return res.data
  } catch (error) {
    console.log(error);
    throw error;
  }
}

export const createClaim1 = async (formData) => {
  try {
    const res = await claimApis.post("", formData);

    return res.data;
  } catch (error) {
    console.log(error);
    throw error;
  }
};
