import axios from 'axios';

// The Spring Boot server is running on port 8081, but we use a Vite proxy to bypass CORS
const BASE_URL = '/api';

const apiClient = axios.create({
    baseURL: BASE_URL,
    headers: {
        'Content-Type': 'application/json',
    },
});

// Interceptor to inject tokens into the headers for protected routes
apiClient.interceptors.request.use(
    (config) => {
        const token = localStorage.getItem('token');
        if (token) {
            config.headers['Authorization'] = `Bearer ${token}`;
        }
        return config;
    },
    (error) => {
        return Promise.reject(error);
    }
);

// Interceptor to handle global API errors (like 401 Unauthorized)
apiClient.interceptors.response.use(
    (response) => {
        return response;
    },
    (error) => {
        if (error.response && error.response.status === 401) {
            // Handle unauthorized access (e.g., clear token, redirect to login)
            console.error('Unauthorized access. Please log in again.');
            localStorage.removeItem('token');
            // We can dispatch an event or redirect to login here
        }
        return Promise.reject(error);
    }
);

export default apiClient;
