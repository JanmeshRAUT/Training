import React, { useEffect } from 'react';
import { useForm } from 'react-hook-form';
import { Modal } from '../components/ui/Modal';
import { Input } from '../components/ui/Input';
import { Button } from '../components/ui/Button';

export const CustomerEditModal = ({ isOpen, onClose, customer, onSave }) => {
    const { register, handleSubmit, reset, formState: { errors, isSubmitting } } = useForm();

    useEffect(() => {
        if (customer) {
            reset({
                name: customer.name || '',
                email: customer.email || '',
                city: customer.city || '',
                age: customer.age || '',
                bankUserName: customer.bankUserName || ''
            });
        }
    }, [customer, reset]);

    const onSubmit = async (data) => {
        await onSave(customer.id, data);
    };

    return (
        <Modal isOpen={isOpen} onClose={onClose} title="Edit Customer">
            <form onSubmit={handleSubmit(onSubmit)} className="space-y-4">
                <Input
                    label="Full Name"
                    error={errors.name?.message}
                    {...register("name", { required: "Name is required" })}
                />
                <Input
                    label="Email Address"
                    type="email"
                    error={errors.email?.message}
                    {...register("email", { 
                        required: "Email is required",
                        pattern: { value: /^[A-Z0-9._%+-]+@[A-Z0-9.-]+\.[A-Z]{2,}$/i, message: "Invalid email" }
                    })}
                />
                <div className="grid grid-cols-2 gap-4">
                    <Input
                        label="City"
                        error={errors.city?.message}
                        {...register("city", { required: "City is required" })}
                    />
                    <Input
                        label="Age"
                        type="number"
                        error={errors.age?.message}
                        {...register("age", { 
                            required: "Age is required",
                            min: { value: 18, message: "Must be 18+" },
                            valueAsNumber: true
                        })}
                    />
                </div>
                <Input
                    label="Bank Username"
                    error={errors.bankUserName?.message}
                    {...register("bankUserName", { required: "Bank Username is required" })}
                />
                
                <div className="flex justify-end gap-3 mt-6 pt-4 border-t dark:border-gray-700">
                    <Button type="button" variant="outline" onClick={onClose} disabled={isSubmitting}>
                        Cancel
                    </Button>
                    <Button type="submit" isLoading={isSubmitting}>
                        Save Changes
                    </Button>
                </div>
            </form>
        </Modal>
    );
};
