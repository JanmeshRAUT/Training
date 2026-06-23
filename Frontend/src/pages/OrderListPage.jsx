import React, { useEffect, useState } from 'react';
import { Plus, Trash2, Search } from 'lucide-react';
import toast from 'react-hot-toast';

import { orderService } from '../services/orderService';
import { Card } from '../components/ui/Card';
import { Table, Tr, Th, Td } from '../components/ui/Table';
import { Button } from '../components/ui/Button';
import { Input } from '../components/ui/Input';
import { Loader } from '../components/ui/Loader';
import { ConfirmDialog } from '../components/ui/ConfirmDialog';
import OrderCreateModal from './OrderCreateModal';

const OrderListPage = () => {
    const [orders, setOrders] = useState([]);
    const [loading, setLoading] = useState(true);
    const [searchTerm, setSearchTerm] = useState('');
    
    const [isFormOpen, setIsFormOpen] = useState(false);
    
    const [isDeleteDialogOpen, setIsDeleteDialogOpen] = useState(false);
    const [orderToDelete, setOrderToDelete] = useState(null);

    const loadOrders = async () => {
        setLoading(true);
        try {
            const data = await orderService.getAllOrders();
            // Sort by latest order ID descending (assuming larger ID is newer)
            data.sort((a, b) => b.orderId - a.orderId);
            setOrders(data);
        } catch (err) {
            console.error(err);
            toast.error("Failed to load orders");
        } finally {
            setLoading(false);
        }
    };

    useEffect(() => {
        loadOrders();
    }, []);

    // Filter Logic
    const filteredOrders = orders.filter(o => {
        const term = searchTerm.toLowerCase();
        return (
            o.customer?.name?.toLowerCase().includes(term) ||
            o.product?.productName?.toLowerCase().includes(term) ||
            o.orderId.toString().includes(term)
        );
    });

    const handleDeleteClick = (order) => {
        setOrderToDelete(order);
        setIsDeleteDialogOpen(true);
    };

    const confirmDelete = async () => {
        if (!orderToDelete) return;
        try {
            await orderService.deleteOrder(orderToDelete.orderId);
            toast.success("Order deleted successfully");
            loadOrders();
        } catch (err) {
            console.error(err);
            toast.error("Failed to delete order");
        } finally {
            setIsDeleteDialogOpen(false);
            setOrderToDelete(null);
        }
    };

    return (
        <div className="space-y-6 animate-in fade-in duration-300">
            <div className="flex flex-col sm:flex-row justify-between items-start sm:items-center gap-4">
                <div>
                    <h1 className="text-2xl font-bold text-gray-900 dark:text-white tracking-tight">Orders</h1>
                    <p className="text-gray-500 dark:text-gray-400 mt-1">Manage and track customer purchases.</p>
                </div>
                <Button onClick={() => setIsFormOpen(true)} className="gap-2 shadow-sm">
                    <Plus size={18} />
                    New Order
                </Button>
            </div>

            <Card className="p-0 overflow-hidden shadow-sm border border-gray-200 dark:border-gray-800">
                <div className="p-4 border-b border-gray-200 dark:border-gray-800 bg-gray-50/50 dark:bg-gray-800/20">
                    <div className="relative max-w-sm">
                        <Search className="absolute left-3 top-1/2 -translate-y-1/2 text-gray-400" size={18} />
                        <Input 
                            placeholder="Search by Order ID, Customer, or Product..." 
                            className="pl-10 bg-white dark:bg-gray-900"
                            value={searchTerm}
                            onChange={(e) => setSearchTerm(e.target.value)}
                        />
                    </div>
                </div>

                <div className="overflow-x-auto">
                    <Table>
                        <thead>
                            <Tr>
                                <Th>Order ID</Th>
                                <Th>Customer</Th>
                                <Th>Product</Th>
                                <Th>Qty</Th>
                                <Th>Total Price</Th>
                                <Th className="text-right">Actions</Th>
                            </Tr>
                        </thead>
                        <tbody>
                            {loading ? (
                                <Tr>
                                    <Td colSpan={6} className="text-center py-12">
                                        <div className="flex flex-col items-center justify-center text-gray-500">
                                            <Loader size="md" className="mb-4" />
                                            <p>Loading orders...</p>
                                        </div>
                                    </Td>
                                </Tr>
                            ) : filteredOrders.length === 0 ? (
                                <Tr>
                                    <Td colSpan={6} className="text-center py-12 text-gray-500 dark:text-gray-400">
                                        No orders found matching your search.
                                    </Td>
                                </Tr>
                            ) : (
                                filteredOrders.map(order => (
                                    <Tr key={order.orderId} className="hover:bg-gray-50 dark:hover:bg-gray-800/50 transition-colors">
                                        <Td className="font-medium text-gray-900 dark:text-gray-100">#{order.orderId}</Td>
                                        <Td>{order.customer?.name}</Td>
                                        <Td>{order.product?.productName}</Td>
                                        <Td>{order.quantity}</Td>
                                        <Td className="font-bold text-blue-600 dark:text-blue-400">
                                            ${order.price?.toFixed(2)}
                                        </Td>
                                        <Td className="text-right space-x-2">
                                            <button 
                                                onClick={() => handleDeleteClick(order)}
                                                className="p-2 text-gray-500 hover:text-red-600 dark:hover:text-red-400 hover:bg-red-50 dark:hover:bg-red-900/30 rounded-md transition-colors"
                                                title="Delete"
                                            >
                                                <Trash2 size={16} />
                                            </button>
                                        </Td>
                                    </Tr>
                                ))
                            )}
                        </tbody>
                    </Table>
                </div>
            </Card>

            <OrderCreateModal 
                isOpen={isFormOpen} 
                onClose={() => setIsFormOpen(false)} 
                onOrderSaved={loadOrders}
            />

            <ConfirmDialog 
                isOpen={isDeleteDialogOpen}
                onClose={() => setIsDeleteDialogOpen(false)}
                onConfirm={confirmDelete}
                title="Delete Order"
                message={`Are you sure you want to delete Order #${orderToDelete?.orderId}? This action cannot be undone.`}
            />
        </div>
    );
};

export default OrderListPage;
