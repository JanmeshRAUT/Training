import React from 'react';

export const Table = ({ children }) => {
    return (
        <div className="w-full overflow-x-auto rounded-lg border border-gray-200 dark:border-gray-700">
            <table className="w-full text-sm text-left text-gray-500 dark:text-gray-400">
                {children}
            </table>
        </div>
    );
};

export const TableHeader = ({ children }) => (
    <thead className="text-xs text-gray-700 uppercase bg-gray-50 dark:bg-gray-700 dark:text-gray-300">
        <tr>{children}</tr>
    </thead>
);

export const TableBody = ({ children }) => (
    <tbody>{children}</tbody>
);

export const TableRow = ({ children, className = '' }) => (
    <tr className={`bg-white border-b dark:bg-gray-800 dark:border-gray-700 hover:bg-gray-50 dark:hover:bg-gray-600 transition-colors ${className}`}>
        {children}
    </tr>
);

export const TableCell = ({ children, isHeader = false, className = '' }) => {
    const Component = isHeader ? 'th' : 'td';
    const baseStyle = isHeader ? 'px-6 py-3 font-medium' : 'px-6 py-4';
    return (
        <Component className={`${baseStyle} ${className}`}>
            {children}
        </Component>
    );
};

export const Tr = TableRow;
export const Th = (props) => <TableCell isHeader={true} {...props} />;
export const Td = TableCell;
