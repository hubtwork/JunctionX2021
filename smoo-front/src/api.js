import axios from 'axios';

const api = axios.create({
  baseURL: 'http://52.231.11.134/api/',
});

export const userApi = {
  login: body =>
    api.post('manager/authenticate', {
      ...body,
    }),
};

export default api;
