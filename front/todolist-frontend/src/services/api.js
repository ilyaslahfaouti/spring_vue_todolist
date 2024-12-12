import axios from 'axios';

const api = axios.create({
  baseURL: 'http://localhost:8081/api/tasks',  // Change selon ton backend
  headers: {
    'Content-Type': 'application/json',
  },
});

export default api;