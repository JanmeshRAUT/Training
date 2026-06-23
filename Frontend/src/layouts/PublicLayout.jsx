import React from 'react';
import { Outlet, Navigate } from 'react-router-dom';
import { useAuth } from '../context/AuthContext';
import { useTheme } from '../context/ThemeContext';
import { Moon, Sun } from 'lucide-react';

const PublicLayout = () => {
    const { user } = useAuth();
    const { theme, toggleTheme } = useTheme();

    if (user) {
        return <Navigate to="/dashboard" replace />;
    }

    return (
        <div className="min-h-screen bg-gray-50 dark:bg-gray-900 flex flex-col justify-center items-center p-4 transition-colors duration-200">
            {/* Theme Toggle Button */}
            <div className="absolute top-4 right-4">
                <button 
                    onClick={toggleTheme}
                    className="p-3 rounded-full bg-white dark:bg-gray-800 text-gray-600 dark:text-gray-300 shadow-sm hover:shadow-md transition-shadow border border-gray-200 dark:border-gray-700"
                >
                    {theme === 'dark' ? <Sun size={20} /> : <Moon size={20} />}
                </button>
            </div>
            
            <Outlet />
        </div>
    );
};

export default PublicLayout;
