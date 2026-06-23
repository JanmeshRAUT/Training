import React, { forwardRef } from 'react';

export const Input = forwardRef(({ label, error, className = '', ...props }, ref) => {
    return (
        <div className={`flex flex-col gap-1 ${className}`}>
            {label && <label className="text-sm font-medium text-gray-700 dark:text-gray-300">{label}</label>}
            <input
                ref={ref}
                className={`px-4 py-2 bg-white border rounded-lg outline-none transition-colors 
                dark:bg-gray-800 dark:border-gray-700 dark:text-white
                focus:ring-2 focus:border-transparent disabled:opacity-50 disabled:bg-gray-100 dark:disabled:bg-gray-900
                ${error ? 'border-red-500 focus:ring-red-500' : 'border-gray-300 focus:ring-blue-500'}`}
                {...props}
            />
            {error && <span className="text-sm text-red-500">{error}</span>}
        </div>
    );
});
Input.displayName = 'Input';
