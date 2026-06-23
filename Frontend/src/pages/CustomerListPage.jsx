import React, { useState, useEffect } from 'react';
import { toast } from 'react-hot-toast';
import { Search, Edit2, Trash2 } from 'lucide-react';

import { customerService } from '../services/customerService';
import { Table, TableHeader, TableBody, TableRow, TableCell } from '../components/ui/Table';
import { Button } from '../components/ui/Button';
import { Input } from '../components/ui/Input';
import { Card } from '../components/ui/Card';
import { Loader } from '../components/ui/Loader';
import { ConfirmDialog } from '../components/ui/ConfirmDialog';
import { CustomerEditModal } from './CustomerEditModal';

const CustomerListPage = () => {
    const [customers, setCustomers] = useState([]);
    const [loading, setLoading] = useState(true);
    
    // Search State
    const [searchTerm, setSearchTerm] = useState('');
    const [searchType, setSearchType] = useState('all'); // 'all', 'email', 'city'
    
    // Modal States
    const [editingCustomer, setEditingCustomer] = useState(null);
    const [deletingCustomer, setDeletingCustomer] = useState(null);
    const [isActionLoading, setIsActionLoading] = useState(false);

    const loadCustomers = async () => {
        setLoading(true);
        try {
            const data = await customerService.getAllCustomers();
            setCustomers(data);
        } catch (error) {
            toast.error("Failed to load customers from server.");
        } finally {
            setLoading(false);
        }
    };

    useEffect(() => {
        loadCustomers();
    }, []);

    // Handlers
    const handleSearch = async (e) => {
        e.preventDefault();
        if (!searchTerm) {
            return loadCustomers();
        }
        
        setLoading(true);
        try {
            let data = [];
            if (searchType === 'email') {
                const res = await customerService.getCustomerByEmail(searchTerm);
                if (res) data = [res]; // Ensure array format
            } else if (searchType === 'city') {
                data = await customerService.getCustomerByCity(searchTerm);
            } else {
                // Client side filter fallback for "all"
                const all = await customerService.getAllCustomers();
                const term = searchTerm.toLowerCase();
                data = all.filter(c => 
                    c.name?.toLowerCase().includes(term) || 
                    c.email?.toLowerCase().includes(term) ||
                    c.city?.toLowerCase().includes(term)
                );
            }
            setCustomers(data);
            if(data.length === 0) toast("No customers found", { icon: 'ℹ️' });
        } catch (error) {
            toast.error("Search failed");
            setCustomers([]);
        } finally {
            setLoading(false);
        }
    };

    const handleUpdate = async (id, data) => {
        try {
            await customerService.updateCustomer(id, data);
            toast.success("Customer updated successfully");
            setEditingCustomer(null);
            loadCustomers();
        } catch (error) {
            toast.error("Failed to update customer");
        }
    };

    const handleDelete = async () => {
        if (!deletingCustomer) return;
        setIsActionLoading(true);
        try {
            await customerService.deleteCustomer(deletingCustomer.id);
            toast.success("Customer deleted successfully");
            setDeletingCustomer(null);
            loadCustomers();
        } catch (error) {
            toast.error("Failed to delete customer");
        } finally {
            setIsActionLoading(false);
        }
    };

    return (
        <div className="space-y-6 animate-in fade-in duration-300">
            <div className="flex flex-col md:flex-row justify-between items-start md:items-center gap-4">
                <div>
                    <h1 className="text-2xl font-bold text-gray-900 dark:text-white">Customers</h1>
                    <p className="text-gray-500 dark:text-gray-400">Manage your platform's customers</p>
                </div>
                
                <form onSubmit={handleSearch} className="flex w-full md:w-auto gap-2">
                    <select 
                        value={searchType}
                        onChange={(e) => setSearchType(e.target.value)}
                        className="px-3 py-2 bg-white border border-gray-300 rounded-lg outline-none focus:ring-2 focus:ring-blue-500 dark:bg-gray-800 dark:border-gray-700 dark:text-white transition-colors"
                    >
                        <option value="all">All</option>
                        <option value="email">Email</option>
                        <option value="city">City</option>
                    </select>
                    <Input 
                        placeholder="Search..."
                        value={searchTerm}
                        onChange={(e) => setSearchTerm(e.target.value)}
                        className="w-full md:w-64"
                    />
                    <Button type="submit" variant="primary">
                        <Search size={18} />
                    </Button>
                </form>
            </div>

            <Card className="overflow-hidden">
                {loading ? (
                    <div className="p-20"><Loader size="lg" className="mx-auto" /></div>
                ) : customers.length === 0 ? (
                    <div className="p-20 flex flex-col items-center justify-center text-gray-500 dark:text-gray-400">
                        <Search size={48} className="mb-4 text-gray-300 dark:text-gray-600" />
                        <p className="text-lg font-medium">No customers found</p>
                        <p className="text-sm">Try adjusting your search filters.</p>
                    </div>
                ) : (
                    <Table>
                        <TableHeader>
                            <TableCell isHeader>ID</TableCell>
                            <TableCell isHeader>Name</TableCell>
                            <TableCell isHeader>Email</TableCell>
                            <TableCell isHeader>City</TableCell>
                            <TableCell isHeader>Age</TableCell>
                            <TableCell isHeader className="text-right">Actions</TableCell>
                        </TableHeader>
                        <TableBody>
                            {customers.map((c) => (
                                <TableRow key={c.id}>
                                    <TableCell className="text-gray-500 dark:text-gray-400">#{c.id}</TableCell>
                                    <TableCell className="font-medium text-gray-900 dark:text-white">{c.name}</TableCell>
                                    <TableCell>{c.email}</TableCell>
                                    <TableCell>{c.city}</TableCell>
                                    <TableCell>{c.age}</TableCell>
                                    <TableCell className="text-right space-x-2">
                                        <button 
                                            onClick={() => setEditingCustomer(c)}
                                            className="p-2 text-blue-600 hover:bg-blue-50 rounded-lg transition-colors dark:text-blue-400 dark:hover:bg-blue-900/30"
                                            title="Edit Customer"
                                        >
                                            <Edit2 size={18} />
                                        </button>
                                        <button 
                                            onClick={() => setDeletingCustomer(c)}
                                            className="p-2 text-red-600 hover:bg-red-50 rounded-lg transition-colors dark:text-red-400 dark:hover:bg-red-900/30"
                                            title="Delete Customer"
                                        >
                                            <Trash2 size={18} />
                                        </button>
                                    </TableCell>
                                </TableRow>
                            ))}
                        </TableBody>
                    </Table>
                )}
            </Card>

            <CustomerEditModal 
                isOpen={!!editingCustomer} 
                onClose={() => setEditingCustomer(null)}
                customer={editingCustomer}
                onSave={handleUpdate}
            />

            <ConfirmDialog 
                isOpen={!!deletingCustomer}
                title="Delete Customer"
                message={`Are you sure you want to delete ${deletingCustomer?.name}? This action cannot be undone.`}
                confirmText="Delete"
                isLoading={isActionLoading}
                onClose={() => setDeletingCustomer(null)}
                onConfirm={handleDelete}
            />
        </div>
    );
};

export default CustomerListPage;
