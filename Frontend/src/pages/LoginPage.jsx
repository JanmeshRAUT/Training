import React, { useState } from 'react';
import { useNavigate, Link } from 'react-router-dom';
import { useForm } from 'react-hook-form';
import toast from 'react-hot-toast';
import { Eye, EyeOff } from 'lucide-react';

import { useAuth } from '../context/AuthContext';
import { useLoader } from '../context/LoaderContext';
import { authService } from '../services/authService';
import { Button } from '../components/ui/Button';
import { Input } from '../components/ui/Input';
import { Card } from '../components/ui/Card';

const LoginPage = () => {
    const [showPassword, setShowPassword] = useState(false);
    const { login } = useAuth();
    const { showLoader, hideLoader } = useLoader();
    const navigate = useNavigate();

    const { register, handleSubmit, formState: { errors, isSubmitting } } = useForm();

    const onSubmit = async (data) => {
        showLoader();
        try {
            const response = await authService.login(data.email, data.password);
            
            // Mocking token since backend returns just a string
            const mockToken = btoa(data.email); 
            login(data.email, mockToken);
            
            toast.success('Successfully logged in!');
            navigate('/dashboard', { replace: true });
        } catch (err) {
            console.error(err);
            const errMsg = err.response?.data?.message || 'Invalid Email or Password';
            toast.error(errMsg);
        } finally {
            hideLoader();
        }
    };

    return (
        <Card className="w-full max-w-md p-8 shadow-xl">
            <div className="text-center mb-8">
                <h2 className="text-3xl font-bold text-gray-900 dark:text-white">Welcome Back</h2>
                <p className="text-gray-500 dark:text-gray-400 mt-2">Sign in to JerryJR Dashboard</p>
            </div>

            <form onSubmit={handleSubmit(onSubmit)} className="space-y-5">
                <Input
                    label="Email Address"
                    type="email"
                    placeholder="admin@example.com"
                    error={errors.email?.message}
                    {...register("email", { 
                        required: "Email is required",
                        pattern: {
                            value: /^[A-Z0-9._%+-]+@[A-Z0-9.-]+\.[A-Z]{2,}$/i,
                            message: "Invalid email address"
                        }
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
                            minLength: { value: 6, message: "Minimum 6 characters" }
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

                <Button type="submit" className="w-full h-11 text-lg mt-2" isLoading={isSubmitting}>
                    Sign In
                </Button>
            </form>

            <div className="mt-8 text-center text-sm text-gray-500 dark:text-gray-400 border-t pt-6 dark:border-gray-700">
                Don't have an account?{' '}
                <Link to="/register" className="font-medium text-blue-600 hover:text-blue-500 dark:text-blue-400 transition-colors">
                    Create one now
                </Link>
            </div>
        </Card>
    );
};

export default LoginPage;
