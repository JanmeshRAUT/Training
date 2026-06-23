import apiClient from '../api/axiosConfig';

export const authService = {
    login: async (email, password) => {
        try {
            // Sends LoginRequest DTO: { email, password }
            const response = await apiClient.post('/auth/login', { email, password });
            
            // Note: Currently backend returns "Login Successful".
            // In a production app with JWT, you would extract the token from response.data here.
            return response.data;
        } catch (error) {
            throw error;
        }
    },

    register: async (userData) => {
        try {
            // Sends RegisterRequest DTO: { name, email, password, city, age, bankUserName }
            const response = await apiClient.post('/auth/register', userData);
            return response.data;
        } catch (error) {
            throw error;
        }
    }
};
