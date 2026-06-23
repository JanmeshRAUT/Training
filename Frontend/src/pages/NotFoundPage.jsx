import React from 'react';
import { Link } from 'react-router-dom';
import { Home } from 'lucide-react';
import { Button } from '../components/ui/Button';

const NotFoundPage = () => {
    return (
        <div className="min-h-screen flex flex-col items-center justify-center bg-gray-50 dark:bg-gray-900 px-4 transition-colors duration-200">
            <h1 className="text-9xl font-extrabold text-blue-600 dark:text-blue-500 tracking-widest relative">
                404
                <div className="bg-orange-500 px-2 py-1 text-sm font-bold rounded rotate-12 absolute top-1/2 left-1/2 transform -translate-x-1/2 -translate-y-1/2 text-white shadow-lg">
                    Page Not Found
                </div>
            </h1>
            
            <div className="mt-8 text-center max-w-md">
                <h3 className="text-2xl font-bold text-gray-800 dark:text-gray-100 mb-4">
                    Oops! You seem to be lost.
                </h3>
                <p className="text-gray-500 dark:text-gray-400 mb-8">
                    The page you are looking for does not exist, might have been removed, or is temporarily unavailable.
                </p>
                <Link to="/dashboard">
                    <Button className="gap-2 px-8 py-3 text-lg font-semibold">
                        <Home size={20} />
                        Return to Dashboard
                    </Button>
                </Link>
            </div>
        </div>
    );
};

export default NotFoundPage;
