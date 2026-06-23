import React, { useEffect, useState } from 'react';
import { Card } from '../components/ui/Card';
import { Users, Package, ShoppingCart, ArrowUpRight } from 'lucide-react';
import { dashboardService } from '../services/dashboardService';
import { Link } from 'react-router-dom';

const StatCard = ({ title, value, icon: Icon, colorClass }) => (
    <Card className="relative overflow-hidden p-6 flex items-center justify-between border border-white/20 dark:border-white/10 shadow-lg backdrop-blur-xl bg-white/70 dark:bg-gray-900/60 hover:shadow-xl hover:-translate-y-1 transition-all duration-300">
        <div className="absolute -right-6 -top-6 w-24 h-24 rounded-full bg-gradient-to-br from-white/10 to-transparent blur-2xl"></div>
        <div className="relative z-10">
            <p className="text-sm font-medium text-gray-500 dark:text-gray-400 mb-1 uppercase tracking-wider">{title}</p>
            <h4 className="text-4xl font-extrabold text-transparent bg-clip-text bg-gradient-to-r from-gray-900 to-gray-600 dark:from-white dark:to-gray-400">{value}</h4>
        </div>
        <div className={`relative z-10 w-16 h-16 rounded-2xl flex items-center justify-center shadow-inner ${colorClass}`}>
            <Icon size={32} />
        </div>
    </Card>
);

const DashboardPage = () => {
    const [stats, setStats] = useState({
        totalCustomers: 0,
        totalProducts: 0,
        totalOrders: 0
    });

    useEffect(() => {
        dashboardService.getStats()
            .then(data => setStats(data))
            .catch(err => console.error("Failed to load dashboard stats", err));
    }, []);

    return (
        <div className="space-y-8 animate-in fade-in duration-500 pb-12">
            {/* Premium Hero Banner */}
            <div className="relative w-full h-64 rounded-3xl overflow-hidden shadow-2xl group">
                <img 
                    src="/assets/images/hero.png" 
                    alt="Dashboard Hero" 
                    className="absolute inset-0 w-full h-full object-cover group-hover:scale-105 transition-transform duration-1000"
                />
                <div className="absolute inset-0 bg-gradient-to-r from-black/80 via-black/50 to-transparent"></div>
                <div className="absolute inset-0 p-8 flex flex-col justify-center">
                    <h1 className="text-4xl md:text-5xl font-extrabold text-white tracking-tight drop-shadow-lg mb-2">
                        Welcome back, Admin
                    </h1>
                    <p className="text-gray-300 text-lg max-w-xl font-medium drop-shadow">
                        Here's what's happening with your store today. Review your metrics and manage your enterprise effectively.
                    </p>
                </div>
            </div>

            <div className="grid grid-cols-1 md:grid-cols-3 gap-8">
                <StatCard 
                    title="Total Customers" 
                    value={stats.totalCustomers} 
                    icon={Users} 
                    colorClass="bg-gradient-to-br from-blue-400 to-indigo-600 text-white shadow-blue-500/30" 
                />
                <StatCard 
                    title="Active Products" 
                    value={stats.totalProducts} 
                    icon={Package} 
                    colorClass="bg-gradient-to-br from-emerald-400 to-teal-600 text-white shadow-emerald-500/30" 
                />
                <StatCard 
                    title="Total Orders" 
                    value={stats.totalOrders} 
                    icon={ShoppingCart} 
                    colorClass="bg-gradient-to-br from-purple-400 to-pink-600 text-white shadow-purple-500/30" 
                />
            </div>

            <div className="grid grid-cols-1 lg:grid-cols-2 gap-6 mt-6">
                <Card className="p-6">
                    <h3 className="text-lg font-bold text-gray-900 dark:text-white mb-4">Quick Actions</h3>
                    <div className="flex gap-4">
                        <Link to="/customers" className="flex items-center gap-2 px-4 py-2.5 bg-blue-50 text-blue-700 rounded-lg hover:bg-blue-100 transition-colors dark:bg-blue-900/30 dark:text-blue-400 dark:hover:bg-blue-900/50 font-medium">
                            <span>Manage Customers</span>
                            <ArrowUpRight size={16} />
                        </Link>
                        <button className="flex items-center gap-2 px-4 py-2.5 bg-gray-50 text-gray-700 rounded-lg hover:bg-gray-100 transition-colors dark:bg-gray-800 dark:text-gray-300 dark:hover:bg-gray-700 font-medium border border-gray-200 dark:border-gray-700">
                            <span>View Recent Orders</span>
                            <ArrowUpRight size={16} />
                        </button>
                    </div>
                </Card>
                
                <Card className="p-6 flex flex-col justify-center items-center text-center">
                     <p className="text-gray-500 dark:text-gray-400 mb-2">Platform Status</p>
                     <div className="flex items-center gap-2">
                         <div className="w-3 h-3 bg-green-500 rounded-full animate-pulse"></div>
                         <span className="font-medium text-gray-900 dark:text-white">All systems operational</span>
                     </div>
                </Card>
            </div>
        </div>
    );
};

export default DashboardPage;
