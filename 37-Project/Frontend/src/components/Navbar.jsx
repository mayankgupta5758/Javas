import React from "react";
import { NavLink } from "react-router-dom";
import {
  FaFileInvoiceDollar,
  FaClipboardList,
  FaCheckCircle,
  FaWallet,
  FaChartLine,
} from "react-icons/fa";

function Navbar() {
  const links = [
    { path: "/", label: "Claims", icon: <FaFileInvoiceDollar /> },
    { path: "/claims", label: "All Claims", icon: <FaClipboardList /> },
    { path: "/review", label: "Review", icon: <FaCheckCircle /> },
    { path: "/budgets", label: "Budgets", icon: <FaWallet /> },
    { path: "/summary", label: "Analytics", icon: <FaChartLine /> },
  ];

  return (
    <div className="sticky top-4 z-50 px-4">
      <nav className="max-w-7xl mx-auto">
        <div className="bg-black/80 backdrop-blur-2xl border border-white/10 rounded-3xl px-6 py-4 shadow-[0_20px_80px_rgba(0,0,0,0.5)]">
          
          <div className="flex flex-col lg:flex-row items-center justify-between gap-5">
            
            <div>
              <h1 className="text-3xl font-black tracking-wide bg-linear-to-r from-cyan-400 via-blue-500 to-purple-500 bg-clip-text text-transparent">
                ExpenseHub
              </h1>
              <p className="text-gray-400 text-xs">
                Smart Expense Management
              </p>
            </div>

            <div className="flex flex-wrap justify-center gap-3">
              {links.map((item) => (
                <NavLink
                  key={item.path}
                  to={item.path}
                  className={({ isActive }) =>
                    `group flex items-center gap-2 px-5 py-3 rounded-2xl font-semibold transition-all duration-300
                    ${
                      isActive
                        ? "bg-linear-to-r from-cyan-500 to-blue-600 text-white shadow-[0_0_30px_rgba(59,130,246,0.7)] scale-105"
                        : "text-gray-300 bg-white/5 hover:bg-white/10 hover:text-white hover:scale-105"
                    }`
                  }
                >
                  <span className="text-lg">{item.icon}</span>
                  <span>{item.label}</span>
                </NavLink>
              ))}
            </div>

            <div className="hidden lg:flex items-center gap-3">
              <div className="h-3 w-3 rounded-full bg-green-400 animate-pulse"></div>
              <span className="text-gray-300 text-sm">
                System Active
              </span>
            </div>

          </div>
        </div>
      </nav>
    </div>
  );
}

export default Navbar;