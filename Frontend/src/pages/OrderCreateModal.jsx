import React, { useEffect, useState } from 'react';
import { useForm } from 'react-hook-form';
import toast from 'react-hot-toast';
import { Modal } from '../components/ui/Modal';
import { Button } from '../components/ui/Button';
import { Input } from '../components/ui/Input';
import { customerService } from '../services/customerService';
import { productService } from '../services/productService';
import { orderService } from '../services/orderService';
import { Loader } from '../components/ui/Loader';

const OrderCreateModal = ({ isOpen, onClose, onOrderSaved }) => {
    const [customers, setCustomers] = useState([]);
    const [products, setProducts] = useState([]);
    const [loadingData, setLoadingData] = useState(false);

    const { register, handleSubmit, reset, formState: { errors, isSubmitting } } = useForm();

    const fetchDropdownData = async () => {
        setLoadingData(true);
        try {
            const [custData, prodData] = await Promise.all([
                customerService.getAllCustomers(),
                productService.getAllProducts()
            ]);
            setCustomers(custData);
            setProducts(prodData.filter(p => p.stock > 0)); // Only show products in stock
        } catch (err) {
            console.error(err);
            toast.error("Failed to load customers and products");
        } finally {
            setLoadingData(false);
        }
    };

    useEffect(() => {
        if (isOpen) {
            reset({ customerId: '', productId: '', quantity: 1 });
            fetchDropdownData();
        }
    }, [isOpen, reset]);

    const onSubmit = async (data) => {
        try {
            await orderService.createOrder(data.customerId, data.productId, data.quantity);
            toast.success('Order created successfully!');
            onOrderSaved();
            onClose();
        } catch (err) {
            console.error(err);
            toast.error('Failed to create order');
        }
    };

    return (
        <Modal 
            isOpen={isOpen} 
            onClose={onClose} 
            title="Create New Order"
        >
            {loadingData ? (
                <div className="flex justify-center py-8"><Loader /></div>
            ) : (
                <form onSubmit={handleSubmit(onSubmit)} className="space-y-4">
                    <div>
                        <label className="block text-sm font-medium text-gray-700 dark:text-gray-300 mb-1">
                            Select Customer
                        </label>
                        <select
                            className={`w-full px-4 py-2.5 rounded-lg border bg-white dark:bg-gray-900 text-gray-900 dark:text-white transition-colors focus:ring-2 focus:ring-blue-500/20 focus:border-blue-500 outline-none ${errors.customerId ? 'border-red-500' : 'border-gray-300 dark:border-gray-700'}`}
                            {...register("customerId", { required: "Customer is required" })}
                        >
                            <option value="">-- Choose a Customer --</option>
                            {customers.map(c => (
                                <option key={c.id} value={c.id}>{c.name} ({c.email})</option>
                            ))}
                        </select>
                        {errors.customerId && <p className="mt-1.5 text-sm text-red-500">{errors.customerId.message}</p>}
                    </div>

                    <div>
                        <label className="block text-sm font-medium text-gray-700 dark:text-gray-300 mb-1">
                            Select Product
                        </label>
                        <select
                            className={`w-full px-4 py-2.5 rounded-lg border bg-white dark:bg-gray-900 text-gray-900 dark:text-white transition-colors focus:ring-2 focus:ring-blue-500/20 focus:border-blue-500 outline-none ${errors.productId ? 'border-red-500' : 'border-gray-300 dark:border-gray-700'}`}
                            {...register("productId", { required: "Product is required" })}
                        >
                            <option value="">-- Choose a Product --</option>
                            {products.map(p => (
                                <option key={p.productId} value={p.productId}>
                                    {p.productName} - ${p.productPrice} ({p.stock} in stock)
                                </option>
                            ))}
                        </select>
                        {errors.productId && <p className="mt-1.5 text-sm text-red-500">{errors.productId.message}</p>}
                    </div>
                    
                    <Input
                        label="Quantity"
                        type="number"
                        placeholder="1"
                        error={errors.quantity?.message}
                        {...register("quantity", { 
                            required: "Quantity is required",
                            min: { value: 1, message: "Must be at least 1" },
                            valueAsNumber: true
                        })}
                    />

                    <div className="pt-4 flex justify-end gap-3 border-t border-gray-100 dark:border-gray-800 mt-6">
                        <Button type="button" variant="outline" onClick={onClose}>
                            Cancel
                        </Button>
                        <Button type="submit" isLoading={isSubmitting}>
                            Submit Order
                        </Button>
                    </div>
                </form>
            )}
        </Modal>
    );
};

export default OrderCreateModal;
