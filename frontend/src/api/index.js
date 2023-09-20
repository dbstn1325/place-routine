import axios from "axios";

const placeRoutineApi = axios.create({
  //   baseURL: process.env.API_URL,
  baseURL: "http://localhost:8080",
});

export default placeRoutineApi;
