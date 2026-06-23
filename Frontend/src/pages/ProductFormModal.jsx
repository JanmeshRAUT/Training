import React, { useEffect, useState } from 'react';
import { useForm } from 'react-hook-form';
import toast from 'react-hot-toast';
import { Modal } from '../components/ui/Modal';
import { Button } from '../components/ui/Button';
import { Input } from '../components/ui/Input';
import { productService } from '../services/productService';

const ProductFormModal = ({ isOpen, onClose, product, onProductSaved }) => {
    const isEditMode = !!product;
    
    const { register, handleSubmit, reset, formState: { errors, isSubmitting } } = useForm({
        defaultValues: {
            productName: '',
            productPrice: '',
            stock: '',
            category: ''
        }
    });

    useEffect(() => {
        if (product) {
            reset(product);
        } else {
            reset({ productName: '', productPrice: '', stock: '', category: '' });
        }
    }, [product, reset]);

    const onSubmit = async (data) => {
        try {
            if (isEditMode) {
                await productService.updateProduct(product.productId, data);
                toast.success('Product updated successfully!');
            } else {
                await productService.addProduct(data);
                toast.success('Product created successfully!');
            }
            onProductSaved();
            onClose();
        } catch (err) {
            console.error(err);
            toast.error(isEditMode ? 'Failed to update product' : 'Failed to create product');
        }
    };

    return (
        <Modal 
            isOpen={isOpen} 
            onClose={onClose} 
            title={isEditMode ? "Edit Product" : "Add New Product"}
        >
            <form onSubmit={handleSubmit(onSubmit)} className="space-y-4">
                <Input
                    label="Product Name"
                    placeholder="e.g. Wireless Mouse"
                    error={errors.productName?.message}
                    {...register("productName", { required: "Product Name is required" })}
                />
                
                <div className="grid grid-cols-2 gap-4">
                    <Input
                        label="Price ($)"
                        type="number"
                        step="0.01"
                        placeholder="29.99"
                        error={errors.productPrice?.message}
                        {...register("productPrice", { 
                            required: "Price is required",
                            min: { value: 0, message: "Price cannot be negative" },
                            valueAsNumber: true
                        })}
                    />
                    
                    <Input
                        label="Stock Quantity"
                        type="number"
                        placeholder="100"
                        error={errors.stock?.message}
                        {...register("stock", { 
                            required: "Stock is required",
                            min: { value: 0, message: "Stock cannot be negative" },
                            valueAsNumber: true
                        })}
                    />
                </div>

                <Input
                    label="Category"
                    placeholder="e.g. Electronics"
                    error={errors.category?.message}
                    {...register("category", { required: "Category is required" })}
                />

                <div className="pt-4 flex justify-end gap-3 border-t border-gray-100 dark:border-gray-800 mt-6">
                    <Button type="button" variant="outline" onClick={onClose}>
                        Cancel
                    </Button>
                    <Button type="submit" isLoading={isSubmitting}>
                        {isEditMode ? 'Save Changes' : 'Create Product'}
                    </Button>
                </div>
            </form>
        </Modal>
    );
};

export default ProductFormModal;
