import React, { Suspense, lazy } from 'react';
import { BrowserRouter, Routes, Route, Navigate } from 'react-router-dom';

// Layouts and Guards (Keep synchronous since they wrap all content)
import PublicLayout from '../layouts/PublicLayout';
import DashboardLayout from '../layouts/DashboardLayout';
import ProtectedRoute from './ProtectedRoute';
import { Loader } from '../components/ui/Loader';

// Code Splitting: Lazy load Pages to optimize initial bundle size
const LoginPage = lazy(() => import('../pages/LoginPage'));
const RegisterPage = lazy(() => import('../pages/RegisterPage'));
const DashboardPage = lazy(() => import('../pages/DashboardPage'));
const CustomerListPage = lazy(() => import('../pages/CustomerListPage'));
const NotFoundPage = lazy(() => import('../pages/NotFoundPage'));

const ProductListPage = lazy(() => import('../pages/ProductListPage'));
const OrderListPage = lazy(() => import('../pages/OrderListPage'));

// Global Suspense Fallback
const PageLoader = () => (
    <div className="flex-1 flex items-center justify-center min-h-[50vh]">
        <Loader size="lg" />
    </div>
);

const AppRoutes = () => {
    return (
        <BrowserRouter>
            {/* Suspense catches lazy loaded components while they download */}
            <Suspense fallback={<PageLoader />}>
                <Routes>
                    {/* Public Routes */}
                    <Route element={<PublicLayout />}>
                        <Route path="/login" element={<LoginPage />} />
                        <Route path="/register" element={<RegisterPage />} />
                    </Route>

                    {/* Protected Routes */}
                    <Route element={<ProtectedRoute />}>
                        <Route element={<DashboardLayout />}>
                            <Route path="/" element={<Navigate to="/dashboard" replace />} />
                            
                            <Route path="/dashboard" element={<DashboardPage />} />
                            <Route path="/customers" element={<CustomerListPage />} />
                            <Route path="/products" element={<ProductListPage />} />
                            <Route path="/orders" element={<OrderListPage />} />
                        </Route>
                    </Route>

                    {/* 404 Catch All Route */}
                    <Route path="*" element={<NotFoundPage />} />
                </Routes>
            </Suspense>
        </BrowserRouter>
    );
};

export default AppRoutes;
