import apiClient from '../api/axiosConfig';

export const productService = {
    getAllProducts: async () => {
        const response = await apiClient.get('/admin/products');
        return response.data;
    },
    getProductById: async (id) => {
        const response = await apiClient.get(`/admin/product/${id}`);
        return response.data;
    },
    addProduct: async (data) => {
        const response = await apiClient.post('/admin/product', data);
        return response.data;
    },
    updateProduct: async (id, data) => {
        const response = await apiClient.put(`/admin/product/${id}`, data);
        return response.data;
    },
    deleteProduct: async (id) => {
        const response = await apiClient.delete(`/admin/product/${id}`);
        return response.data;
    }
};
