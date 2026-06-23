import React, { useEffect, useState } from 'react';
import { Plus, Edit2, Trash2, Search } from 'lucide-react';
import toast from 'react-hot-toast';

import { productService } from '../services/productService';
import { Card } from '../components/ui/Card';
import { Table, Tr, Th, Td } from '../components/ui/Table';
import { Button } from '../components/ui/Button';
import { Input } from '../components/ui/Input';
import { Loader } from '../components/ui/Loader';
import { Badge } from '../components/ui/Badge';
import { ConfirmDialog } from '../components/ui/ConfirmDialog';
import ProductFormModal from './ProductFormModal';

const ProductListPage = () => {
    const [products, setProducts] = useState([]);
    const [loading, setLoading] = useState(true);
    const [searchTerm, setSearchTerm] = useState('');
    
    // Modal States
    const [isFormOpen, setIsFormOpen] = useState(false);
    const [selectedProduct, setSelectedProduct] = useState(null);
    
    const [isDeleteDialogOpen, setIsDeleteDialogOpen] = useState(false);
    const [productToDelete, setProductToDelete] = useState(null);

    const loadProducts = async () => {
        setLoading(true);
        try {
            const data = await productService.getAllProducts();
            setProducts(data);
        } catch (err) {
            console.error(err);
            toast.error("Failed to load products");
        } finally {
            setLoading(false);
        }
    };

    useEffect(() => {
        loadProducts();
    }, []);

    // Filter Logic
    const filteredProducts = products.filter(p => 
        p.productName.toLowerCase().includes(searchTerm.toLowerCase()) ||
        p.category.toLowerCase().includes(searchTerm.toLowerCase())
    );

    // Handlers
    const handleAdd = () => {
        setSelectedProduct(null);
        setIsFormOpen(true);
    };

    const handleEdit = (product) => {
        setSelectedProduct(product);
        setIsFormOpen(true);
    };

    const handleDeleteClick = (product) => {
        setProductToDelete(product);
        setIsDeleteDialogOpen(true);
    };

    const confirmDelete = async () => {
        if (!productToDelete) return;
        try {
            await productService.deleteProduct(productToDelete.productId);
            toast.success("Product deleted successfully");
            loadProducts();
        } catch (err) {
            console.error(err);
            toast.error("Failed to delete product");
        } finally {
            setIsDeleteDialogOpen(false);
            setProductToDelete(null);
        }
    };

    const getProductImage = (category) => {
        const lowerCat = category.toLowerCase();
        if (lowerCat.includes('electronic') || lowerCat.includes('tech')) {
            return '/assets/images/electronics.png';
        }
        if (lowerCat.includes('cloth') || lowerCat.includes('apparel') || lowerCat.includes('fashion')) {
            return '/assets/images/clothing.png';
        }
        return '/assets/images/hero.png'; // Fallback to hero abstract for unknown categories
    };

    return (
        <div className="space-y-6 animate-in fade-in duration-300">
            <div className="flex flex-col sm:flex-row justify-between items-start sm:items-center gap-4">
                <div>
                    <h1 className="text-2xl font-bold text-gray-900 dark:text-white tracking-tight">Products</h1>
                    <p className="text-gray-500 dark:text-gray-400 mt-1">Manage your inventory and catalog.</p>
                </div>
                <Button onClick={handleAdd} className="gap-2 shadow-sm">
                    <Plus size={18} />
                    Add Product
                </Button>
            </div>

            <Card className="p-0 overflow-hidden shadow-sm border border-gray-200 dark:border-gray-800">
                <div className="p-4 border-b border-gray-200 dark:border-gray-800 bg-gray-50/50 dark:bg-gray-800/20">
                    <div className="relative max-w-sm">
                        <Search className="absolute left-3 top-1/2 -translate-y-1/2 text-gray-400" size={18} />
                        <Input 
                            placeholder="Search products or categories..." 
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
                                <Th>Product</Th>
                                <Th>Category</Th>
                                <Th>Price</Th>
                                <Th>Stock</Th>
                                <Th className="text-right">Actions</Th>
                            </Tr>
                        </thead>
                        <tbody>
                            {loading ? (
                                <Tr>
                                    <Td colSpan={5} className="text-center py-12">
                                        <div className="flex flex-col items-center justify-center text-gray-500">
                                            <Loader size="md" className="mb-4" />
                                            <p>Loading products...</p>
                                        </div>
                                    </Td>
                                </Tr>
                            ) : filteredProducts.length === 0 ? (
                                <Tr>
                                    <Td colSpan={5} className="text-center py-12 text-gray-500 dark:text-gray-400">
                                        No products found matching your search.
                                    </Td>
                                </Tr>
                            ) : (
                                filteredProducts.map(product => (
                                    <Tr key={product.productId} className="hover:bg-gray-50 dark:hover:bg-gray-800/50 transition-colors">
                                        <Td>
                                            <div className="flex items-center gap-4">
                                                <div className="w-12 h-12 rounded-lg overflow-hidden border border-gray-200 dark:border-gray-700 shrink-0 shadow-sm">
                                                    <img 
                                                        src={getProductImage(product.category)} 
                                                        alt={product.productName} 
                                                        className="w-full h-full object-cover"
                                                    />
                                                </div>
                                                <div>
                                                    <p className="font-semibold text-gray-900 dark:text-gray-100">{product.productName}</p>
                                                    <p className="text-xs text-gray-500 dark:text-gray-400">ID: #{product.productId}</p>
                                                </div>
                                            </div>
                                        </Td>
                                        <Td>
                                            <Badge variant="secondary">{product.category}</Badge>
                                        </Td>
                                        <Td className="font-medium text-emerald-600 dark:text-emerald-400">
                                            ${product.productPrice.toFixed(2)}
                                        </Td>
                                        <Td>
                                            {product.stock > 10 ? (
                                                <Badge variant="success">{product.stock} in stock</Badge>
                                            ) : product.stock > 0 ? (
                                                <Badge variant="warning">{product.stock} low stock</Badge>
                                            ) : (
                                                <Badge variant="danger">Out of stock</Badge>
                                            )}
                                        </Td>
                                        <Td className="text-right space-x-2">
                                            <button 
                                                onClick={() => handleEdit(product)}
                                                className="p-2 text-gray-500 hover:text-blue-600 dark:hover:text-blue-400 hover:bg-blue-50 dark:hover:bg-blue-900/30 rounded-md transition-colors"
                                                title="Edit"
                                            >
                                                <Edit2 size={16} />
                                            </button>
                                            <button 
                                                onClick={() => handleDeleteClick(product)}
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

            <ProductFormModal 
                isOpen={isFormOpen} 
                onClose={() => setIsFormOpen(false)} 
                product={selectedProduct}
                onProductSaved={loadProducts}
            />

            <ConfirmDialog 
                isOpen={isDeleteDialogOpen}
                onClose={() => setIsDeleteDialogOpen(false)}
                onConfirm={confirmDelete}
                title="Delete Product"
                message={`Are you sure you want to delete "${productToDelete?.productName}"? This action cannot be undone.`}
            />
        </div>
    );
};

export default ProductListPage;
