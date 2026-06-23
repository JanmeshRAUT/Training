import React from 'react';
import { Outlet, NavLink } from 'react-router-dom';
import { useAuth } from '../context/AuthContext';
import { useTheme } from '../context/ThemeContext';
import { LayoutDashboard, Users, Package, ShoppingCart, LogOut, Sun, Moon } from 'lucide-react';
import toast from 'react-hot-toast';

const DashboardLayout = () => {
    const { logout, user } = useAuth();
    const { theme, toggleTheme } = useTheme();

    const handleLogout = () => {
        logout();
        toast.success("Logged out successfully");
    };

    const navItems = [
        { path: '/dashboard', label: 'Dashboard', icon: LayoutDashboard },
        { path: '/customers', label: 'Customers', icon: Users },
        { path: '/products', label: 'Products', icon: Package },
        { path: '/orders', label: 'Orders', icon: ShoppingCart },
    ];

    return (
        <div className="flex h-screen bg-gray-100 dark:bg-gray-900 transition-colors duration-200">
            {/* Sidebar */}
            <aside 
                className="w-64 backdrop-blur-2xl bg-white/70 dark:bg-gray-900/70 border-r border-white/30 dark:border-white/10 shadow-2xl flex flex-col"
            >
                <div className="h-16 flex items-center justify-center border-b border-gray-200 dark:border-gray-700">
                    <h2 className="text-2xl font-bold text-blue-600 dark:text-blue-400 tracking-tight">JerryJR</h2>
                </div>
                
                <nav className="flex-1 overflow-y-auto py-6 px-4 space-y-2">
                    <p className="px-2 text-xs font-semibold text-gray-400 uppercase tracking-wider mb-2">Navigation</p>
                    {navItems.map((item) => {
                        const Icon = item.icon;
                        return (
                            <NavLink 
                                key={item.path} 
                                to={item.path} 
                                className={({ isActive }) => `
                                    flex items-center gap-3 px-3 py-2.5 rounded-lg transition-colors font-medium
                                    ${isActive 
                                        ? 'bg-blue-50 text-blue-700 dark:bg-blue-900/50 dark:text-blue-300' 
                                        : 'text-gray-600 hover:bg-gray-100 dark:text-gray-400 dark:hover:bg-gray-700/50'}
                                `}
                            >
                                <Icon size={20} />
                                {item.label}
                            </NavLink>
                        );
                    })}
                </nav>

                <div className="p-4 border-t border-gray-200 dark:border-gray-700">
                    <button 
                        onClick={handleLogout}
                        className="flex items-center gap-3 w-full px-3 py-2.5 text-red-600 hover:bg-red-50 rounded-lg transition-colors font-medium dark:text-red-400 dark:hover:bg-red-900/20"
                    >
                        <LogOut size={20} />
                        Logout
                    </button>
                </div>
            </aside>

            {/* Main Content Area */}
            <div className="flex-1 flex flex-col overflow-hidden">
                {/* Topbar */}
                <header className="sticky top-0 z-40 backdrop-blur-2xl bg-white/70 dark:bg-gray-900/70 border-b border-white/30 dark:border-white/10 shadow-sm px-8 h-16 flex items-center justify-end gap-6 transition-colors duration-200">
                    <button 
                        onClick={toggleTheme}
                        className="p-2 rounded-full text-gray-500 hover:bg-gray-100 dark:text-gray-400 dark:hover:bg-gray-700 transition-colors"
                        title="Toggle theme"
                    >
                        {theme === 'dark' ? <Sun size={20} /> : <Moon size={20} />}
                    </button>
                    
                    <div className="flex items-center gap-3 border-l border-gray-200 dark:border-gray-700 pl-6 cursor-pointer group">
                        <div className="flex flex-col items-end hidden md:flex">
                            <span className="text-sm font-medium text-gray-900 dark:text-gray-100">
                                {user?.email}
                            </span>
                            <span className="text-xs text-gray-500 dark:text-gray-400">Admin</span>
                        </div>
                        <div className="w-10 h-10 rounded-full bg-blue-600 flex items-center justify-center text-white font-bold text-lg ring-2 ring-white dark:ring-gray-800 group-hover:ring-blue-100 dark:group-hover:ring-blue-900 transition-all">
                            {user?.email?.[0]?.toUpperCase() || 'U'}
                        </div>
                    </div>
                </header>

                {/* Page Content */}
                <main className="flex-1 overflow-y-auto p-8 bg-gray-50 dark:bg-gray-900">
                    <Outlet />
                </main>
            </div>
        </div>
    );
};

export default DashboardLayout;
