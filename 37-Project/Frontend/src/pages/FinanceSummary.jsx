import React, { useState } from "react";
import { motion } from "framer-motion";
import { getSummary1 } from "../services/budgetService";
import SummaryCard from "../components/SummaryCard";
import { toast } from "react-toastify";

const FinanceSummary = () => {
   const [department, setDepartment] =
    useState("IT");
  const [month, setMonth] = useState(new Date().getMonth() + 1);
  const [year, setYear] = useState(new Date().getFullYear());
  const [summary, setSummary] = useState(null);
  const [loading, setLoading] = useState(false);

  const fetchSummary = async () => {
    try {
      setLoading(true);
      const response = await getSummary1(department, month, year);
      setSummary(response.data);
    } catch {
      toast.error("Budget Not Found");
    } finally {
      setLoading(false);
    }
  };

  return (
    <div className="min-h-screen bg-linear-to-br from-slate-950 via-slate-900 to-indigo-950 text-white p-6">

      <div className="max-w-7xl mx-auto space-y-6">

        {/* HEADER */}
        <motion.div
          initial={{ opacity: 0, y: -20 }}
          animate={{ opacity: 1, y: 0 }}
          className="bg-white/5 border border-white/10 backdrop-blur-xl rounded-3xl p-6"
        >
          <h1 className="text-3xl font-bold bg-linear-to-r from-cyan-400 via-blue-400 to-purple-400 bg-clip-text text-transparent">
            Finance Summary Dashboard
          </h1>
          <p className="text-gray-400 mt-2">
            Track budgets, expenses & claims in real time
          </p>
        </motion.div>

        {/* FILTER PANEL */}
        <div className="bg-white/5 border border-white/10 backdrop-blur-xl rounded-3xl p-6 grid md:grid-cols-4 gap-4">

          <select
            value={department}
            required={true}
            onChange={(e) => setDepartment(e.target.value)}
            className="p-3 rounded-xl bg-black/30 border border-white/10"
          >
            <option>IT</option>
            <option>HR</option>
            <option>FINANCE</option>
            <option>SALES</option>
          </select>

          <input
            type="number"
            required={true}
            value={month}
            onChange={(e) => setMonth(e.target.value)}
            className="p-3 rounded-xl bg-black/30 border border-white/10"
          />

          <input
            type="number"
            required={true}
            value={year}
            onChange={(e) => setYear(e.target.value)}
            className="p-3 rounded-xl bg-black/30 border border-white/10"
          />

          <button
            onClick={fetchSummary}
            className="rounded-xl bg-linear-to-r from-cyan-500 via-blue-500 to-purple-500 font-bold hover:scale-105 transition"
          >
            {loading ? "Loading..." : "Get Summary"}
          </button>

        </div>

        {/* CARDS */}
        {summary && (
          <motion.div
            initial={{ opacity: 0, y: 20 }}
            animate={{ opacity: 1, y: 0 }}
            className="grid md:grid-cols-3 gap-6"
          >

            <SummaryCard
              title="Monthly Budget"
              value={`₹ ${summary.monthlyBudget}`}
              icon="💰"
            />

            <SummaryCard
              title="Approved Expense"
              value={`₹ ${summary.approvedExpense}`}
              icon="✅"
            />

            <SummaryCard
              title="Pending Expense"
              value={`₹ ${summary.pendingExpense}`}
              icon="⏳"
            />

            <SummaryCard
              title="Remaining Budget"
              value={`₹ ${summary.remainingBudget}`}
              icon="📊"
            />

            <SummaryCard
              title="Approved Claims"
              value={summary.approvedClaims}
              icon="👍"
            />

            <SummaryCard
              title="Pending Claims"
              value={summary.pendingClaims}
              icon="🕒"
            />

            <SummaryCard
              title="Rejected Claims"
              value={summary.rejectedClaims}
              icon="❌"
            />

          </motion.div>
        )}

      </div>
    </div>
  );
};

export default FinanceSummary;