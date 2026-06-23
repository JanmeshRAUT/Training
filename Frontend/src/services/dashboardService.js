import apiClient from '../api/axiosConfig';

export const dashboardService = {
    getStats: async () => {
        const response = await apiClient.get('/admin/dashboard');
        return response.data;
    }
};
