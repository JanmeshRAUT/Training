import apiClient from '../api/axiosConfig';

export const orderService = {
    getAllOrders: async () => {
        const response = await apiClient.get('/admin/orders');
        return response.data;
    },
    createOrder: async (customerId, productId, quantity) => {
        // This targets the generic OrderController on the backend
        const response = await apiClient.post(`/order/${customerId}/${productId}/${quantity}`);
        return response.data;
    },
    deleteOrder: async (id) => {
        // This targets the AdminController on the backend
        const response = await apiClient.delete(`/admin/order/${id}`);
        return response.data;
    }
};
