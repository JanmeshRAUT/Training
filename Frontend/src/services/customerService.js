import apiClient from '../api/axiosConfig';

export const customerService = {
    getAllCustomers: async () => {
        const response = await apiClient.get('/admin/customers');
        return response.data;
    },
    getCustomerById: async (id) => {
        const response = await apiClient.get(`/admin/customer/id/${id}`);
        return response.data;
    },
    getCustomerByEmail: async (email) => {
        const response = await apiClient.get(`/admin/customer/email/${email}`);
        return response.data;
    },
    getCustomerByCity: async (city) => {
        const response = await apiClient.get(`/admin/customer/city/${city}`);
        return response.data;
    },
    updateCustomer: async (id, data) => {
        const response = await apiClient.put(`/admin/customer/id/${id}`, data);
        return response.data;
    },
    deleteCustomer: async (id) => {
        const response = await apiClient.delete(`/admin/customer/id/${id}`);
        return response.data;
    }
};
