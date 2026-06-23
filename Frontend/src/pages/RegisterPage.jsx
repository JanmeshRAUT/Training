import React, { useState } from 'react';
import { useNavigate, Link } from 'react-router-dom';
import { useForm } from 'react-hook-form';
import toast from 'react-hot-toast';
import { Eye, EyeOff } from 'lucide-react';

import { useLoader } from '../context/LoaderContext';
import { authService } from '../services/authService';
import { Button } from '../components/ui/Button';
import { Input } from '../components/ui/Input';
import { Card } from '../components/ui/Card';

const RegisterPage = () => {
    const [showPassword, setShowPassword] = useState(false);
    const { showLoader, hideLoader } = useLoader();
    const navigate = useNavigate();

    const { register, handleSubmit, formState: { errors, isSubmitting } } = useForm();

    const onSubmit = async (data) => {
        showLoader();
        try {
            await authService.register(data);
            toast.success('Account created successfully! Please log in.');
            navigate('/login');
        } catch (err) {
            console.error(err);
            const errMsg = err.response?.data?.message || 'Registration failed. Please try again.';
            toast.error(errMsg);
        } finally {
            hideLoader();
        }
    };

    return (
        <Card className="w-full max-w-lg p-8 shadow-xl">
            <div className="text-center mb-8">
                <h2 className="text-3xl font-bold text-gray-900 dark:text-white">Create an Account</h2>
                <p className="text-gray-500 dark:text-gray-400 mt-2">Join JerryJR to manage your data</p>
            </div>

            <form onSubmit={handleSubmit(onSubmit)} className="space-y-4">
                <Input
                    label="Full Name"
                    placeholder="John Doe"
                    error={errors.name?.message}
                    {...register("name", { required: "Name is required" })}
                />
                
                <Input
                    label="Email Address"
                    type="email"
                    placeholder="john@example.com"
                    error={errors.email?.message}
                    {...register("email", { 
                        required: "Email is required",
                        pattern: { value: /^[A-Z0-9._%+-]+@[A-Z0-9.-]+\.[A-Z]{2,}$/i, message: "Invalid email" }
                    })}
                />

                <div className="relative">
                    <Input
                        label="Password"
                        type={showPassword ? 'text' : 'password'}
                        placeholder="••••••••"
                        error={errors.password?.message}
                        {...register("password", { 
                            required: "Password is required",
                            minLength: { value: 6, message: "Must be at least 6 characters" }
                        })}
                    />
                    <button 
                        type="button" 
                        onClick={() => setShowPassword(!showPassword)}
                        className="absolute right-3 top-9 text-gray-400 hover:text-gray-600 dark:hover:text-gray-300"
                    >
                        {showPassword ? <EyeOff size={18} /> : <Eye size={18} />}
                    </button>
                </div>

                <div className="grid grid-cols-2 gap-4">
                    <Input
                        label="City"
                        placeholder="New York"
                        error={errors.city?.message}
                        {...register("city", { required: "City is required" })}
                    />
                    <Input
                        label="Age"
                        type="number"
                        placeholder="25"
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
                    placeholder="john_bank"
                    error={errors.bankUserName?.message}
                    {...register("bankUserName", { required: "Bank Username is required" })}
                />

                <Button type="submit" className="w-full h-11 text-lg mt-6" isLoading={isSubmitting}>
                    Create Account
                </Button>
            </form>

            <div className="mt-6 text-center text-sm text-gray-500 dark:text-gray-400 border-t pt-6 dark:border-gray-700">
                Already have an account?{' '}
                <Link to="/login" className="font-medium text-blue-600 hover:text-blue-500 dark:text-blue-400 transition-colors">
                    Sign in here
                </Link>
            </div>
        </Card>
    );
};

export default RegisterPage;
