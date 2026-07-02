import React, { useEffect, useState } from "react";
import { motion } from "framer-motion";
import { toast } from "react-toastify";
import { BarChart, Bar, XAxis, YAxis, Tooltip, ResponsiveContainer } from "recharts";

import {
  createBudget1,
  getAllBudgets1,
} from "../services/budgetService";

const BudgetManagement = () => {
  const [budgets, setBudgets] = useState([]);

  const [formData, setFormData] = useState({
    department: "",
    budgetMonth: "",
    budgetYear: "",
    budgetAmount: "",
  });

  const loadBudgets = async () => {
    try {
      const res = await getAllBudgets1();
      setBudgets(res.data);
    } catch {
      toast.error("Failed to load budgets");
    }
  };

  useEffect(() => {
    loadBudgets();
  }, []);

  const handleChange = (e) => {
    setFormData({ ...formData, [e.target.name]: e.target.value });
  };

  const handleSubmit = async (e) => {
    e.preventDefault();

    try {
      await createBudget1(formData);
      toast.success("Budget Created Successfully");

      setFormData({
        department: "",
        budgetMonth: "",
        budgetYear: "",
        budgetAmount: "",
      });

      loadBudgets();
    } catch {
      toast.error("Failed to create budget");
    }
  };

  const chartData = budgets.map((b) => ({
    name: b.department,
    budget: Number(b.budgetAmount),
  }));

  const totalBudget = budgets.reduce(
    (acc, b) => acc + Number(b.budgetAmount || 0),
    0
  );

  return (
    <div className="min-h-screen bg-linear-to-br from-slate-950 via-slate-900 to-indigo-950 text-white p-6">

      <div className="max-w-7xl mx-auto space-y-8">

        {/* HEADER */}
        <motion.div
          initial={{ opacity: 0, y: -20 }}
          animate={{ opacity: 1, y: 0 }}
          className="bg-white/5 border border-white/10 p-6 rounded-3xl backdrop-blur-xl"
        >
          <h1 className="text-3xl font-extrabold bg-linear-to-r from-cyan-400 via-blue-400 to-purple-400 bg-clip-text text-transparent">
            Budget Control Dashboard
          </h1>
          <p className="text-gray-400 mt-2">
            Manage department budgets in real time
          </p>
        </motion.div>

        {/* STATS */}
        <div className="grid md:grid-cols-3 gap-5">

          <motion.div whileHover={{ scale: 1.05 }}
            className="bg-white/5 p-6 rounded-3xl border border-white/10 backdrop-blur-xl"
          >
            <h3 className="text-gray-400">Total Budget</h3>
            <h1 className="text-3xl font-bold text-cyan-300">
              ₹ {totalBudget}
            </h1>
          </motion.div>

          <motion.div whileHover={{ scale: 1.05 }}
            className="bg-white/5 p-6 rounded-3xl border border-white/10 backdrop-blur-xl"
          >
            <h3 className="text-gray-400">Departments</h3>
            <h1 className="text-3xl font-bold text-purple-300">
              {budgets.length}
            </h1>
          </motion.div>

          <motion.div whileHover={{ scale: 1.05 }}
            className="bg-white/5 p-6 rounded-3xl border border-white/10 backdrop-blur-xl"
          >
            <h3 className="text-gray-400">Average Budget</h3>
            <h1 className="text-3xl font-bold text-pink-300">
              ₹ {budgets.length ? (totalBudget / budgets.length).toFixed(0) : 0}
            </h1>
          </motion.div>

        </div>

        {/* CHART */}
        <div className="bg-white/5 border border-white/10 p-6 rounded-3xl backdrop-blur-xl">
          <h2 className="text-xl font-bold mb-6 text-cyan-300">
            Budget Overview
          </h2>

          <div className="h-80">
            <ResponsiveContainer width="100%" height="100%">
              <BarChart data={chartData} barGap={12}>

                <XAxis dataKey="name" stroke="#94a3b8" />
                <YAxis stroke="#94a3b8" />

                {/* ✅ FIXED TOOLTIP */}
                <Tooltip
                  cursor={{
                    fill: "rgba(34, 211, 238, 0.08)", // soft glow instead of white
                  }}
                  contentStyle={{
                    backgroundColor: "rgba(15, 23, 42, 0.95)",
                    border: "1px solid rgba(255,255,255,0.1)",
                    borderRadius: "12px",
                    color: "#fff",
                    backdropFilter: "blur(10px)",
                  }}
                  itemStyle={{ color: "#22d3ee" }}
                  labelStyle={{ color: "#94a3b8" }}
                />

                {/* Smooth bars */}
                <Bar
                  dataKey="budget"
                  radius={[10, 10, 0, 0]}
                  fill="url(#grad)"
                  activeBar={{
                    fill: "rgba(34,211,238,0.4)", // no white flash
                    stroke: "#22d3ee",
                    strokeWidth: 1,
                  }}
                />

                <defs>
                  <linearGradient id="grad" x1="0" y1="0" x2="0" y2="1">
                    <stop offset="0%" stopColor="#22d3ee" />
                    <stop offset="50%" stopColor="#3b82f6" />
                    <stop offset="100%" stopColor="#8b5cf6" />
                  </linearGradient>
                </defs>

              </BarChart>
            </ResponsiveContainer>
          </div>
        </div>

        {/* FORM */}
        <div className="bg-white/5 border border-white/10 p-6 rounded-3xl backdrop-blur-xl">
          <form
            onSubmit={handleSubmit}
            className="grid md:grid-cols-4 gap-4"
          >
            <select
              name="department"
              value={formData.department}
              onChange={handleChange}
              className="p-3 rounded-xl bg-black/30 border border-white/10"
            >
              <option value="">Department</option>
              <option>IT</option>
              <option>HR</option>
              <option>FINANCE</option>
              <option>SALES</option>
            </select>

            <input
              name="budgetMonth"
              type="number"
              placeholder="Month"
              value={formData.budgetMonth}
              onChange={handleChange}
              className="p-3 rounded-xl bg-black/30 border border-white/10"
            />

            <input
              name="budgetYear"
              type="number"
              placeholder="Year"
              value={formData.budgetYear}
              onChange={handleChange}
              className="p-3 rounded-xl bg-black/30 border border-white/10"
            />

            <input
              name="budgetAmount"
              type="number"
              placeholder="Amount"
              value={formData.budgetAmount}
              onChange={handleChange}
              className="p-3 rounded-xl bg-black/30 border border-white/10"
            />

            <button className="md:col-span-4 py-3 rounded-xl bg-linear-to-r from-cyan-500 via-blue-500 to-purple-500 font-bold hover:scale-[1.02] transition">
              Create Budget
            </button>
          </form>
        </div>

        {/* TABLE */}
        <div className="bg-white/5 border border-white/10 p-6 rounded-3xl backdrop-blur-xl">
          <h2 className="text-xl font-bold mb-4 text-cyan-300">
            Budget List
          </h2>

          <div className="overflow-x-auto">
            <table className="w-full text-left">
              <thead className="text-gray-400 border-b border-white/10">
                <tr>
                  <th className="p-3">Department</th>
                  <th className="p-3">Month</th>
                  <th className="p-3">Year</th>
                  <th className="p-3">Amount</th>
                </tr>
              </thead>

              <tbody>
                {budgets.map((b, i) => (
                  <tr
                    key={i}
                    className="border-b border-white/5 hover:bg-white/5 transition"
                  >
                    <td className="p-3 font-semibold">{b.department}</td>
                    <td className="p-3">{b.budgetMonth}</td>
                    <td className="p-3">{b.budgetYear}</td>
                    <td className="p-3 text-cyan-300 font-bold">
                      ₹ {b.budgetAmount}
                    </td>
                  </tr>
                ))}
              </tbody>

            </table>
          </div>
        </div>

      </div>
    </div>
  );
};

export default BudgetManagement;