import React, { useState } from "react";
import { motion } from "framer-motion";
import { createClaim1 } from "../services/claimService";
import { toast } from "react-toastify";

const ExpenseClaimForm = () => {
  const [formData, setFormData] = useState({
    employeeName: "",
    department: "",
    expenseCategory: "",
    amount: "",
    expenseDate: "",
    description: "",
  });

  const handleChange = (e) => {
    setFormData({ ...formData, [e.target.name]: e.target.value });
  };

  const handleSubmit = async (e) => {
    e.preventDefault();

    try {
      await createClaim1(formData);
      toast.success("Claim Submitted Successfully 🎉");

      setFormData({
        employeeName: "",
        department: "",
        expenseCategory: "",
        amount: "",
        expenseDate: "",
        description: "",
      });
    } catch (error) {
      toast.error(
        error?.response?.data?.message || "Failed to submit claim"
      );
    }
  };

  return (
    <div className="h-[85vh] flex items-center justify-center bg-linear-to-br from-slate-950 via-slate-900 to-indigo-950 p-6">

      {/* glowing background */}
      <div className="absolute w-72 h-72 bg-cyan-500 blur-3xl opacity-20 rounded-full top-10 left-10 animate-pulse"></div>
      <div className="absolute w-72 h-72 bg-purple-500 blur-3xl opacity-20 rounded-full bottom-10 right-10 animate-bounce"></div>

      <motion.div
        initial={{ opacity: 0, scale: 0.95 }}
        animate={{ opacity: 1, scale: 1 }}
        className="relative w-full max-w-3xl bg-white/5 border border-white/10 backdrop-blur-xl rounded-3xl shadow-2xl p-8 text-white"
      >

        {/* TITLE */}
        <h1 className="text-3xl font-extrabold text-center bg-linear-to-r from-cyan-400 via-blue-400 to-purple-400 bg-clip-text text-transparent">
          Expense Claim Submission
        </h1>

        <p className="text-gray-400 text-center mt-2 mb-6">
          Submit your expense request in seconds
        </p>

        {/* FORM */}
        <form onSubmit={handleSubmit} className="grid md:grid-cols-2 gap-5">

          {/* Employee Name */}
          <input
            type="text"
            name="employeeName"
            required={true}
            placeholder="Employee Name"
            value={formData.employeeName}
            onChange={handleChange}
            className="input"
          />

          {/* Department */}
          <select
            name="department"
            required={true}
            value={formData.department}
            onChange={handleChange}
            className="input bg-slate-900 text-white"
          >
            <option value="" className="bg-slate-800 text-gray-400">
              Select Department
            </option>

            <option value="IT" className="bg-slate-900 text-white hover:bg-slate-800">
              IT
            </option>
            <option value="HR" className="bg-slate-900 text-white">
              HR
            </option>
            <option value="FINANCE" className="bg-slate-900 text-white">
              FINANCE
            </option>
            <option value="SALES" className="bg-slate-900 text-white">
              SALES
            </option>
            <option value="MARKETING" className="bg-slate-900 text-white">
              MARKETING
            </option>
          </select>

          {/* Category */}
          <select
            name="expenseCategory"
            required={true}
            value={formData.expenseCategory}
            onChange={handleChange}
            className="input bg-slate-900 text-white"
          >
            <option value="" className="bg-slate-800 text-gray-400">
              Select Category
            </option>

            <option className="bg-slate-900 text-white">TRAVEL</option>
            <option className="bg-slate-900 text-white">FOOD</option>
            <option className="bg-slate-900 text-white">SOFTWARE</option>
            <option className="bg-slate-900 text-white">HARDWARE</option>
            <option className="bg-slate-900 text-white">TRAINING</option>
            <option className="bg-slate-900 text-white">OTHER</option>
          </select>

          {/* Amount */}
          <input
            type="number"
            name="amount"
            required={true}
            placeholder="Amount"
            value={formData.amount}
            onChange={handleChange}
            className="input"
          />

          {/* Date */}
          <input
            type="date"
            required={true}
            name="expenseDate"
            value={formData.expenseDate}
            onChange={handleChange}
            className="input"
          />

          {/* Description */}
          <textarea
            rows="4"
            required={true}
            name="description"
            placeholder="Description"
            value={formData.description}
            onChange={handleChange}
            className="md:col-span-2 input resize-none"
          />

          {/* BUTTON */}
          <motion.button
            whileHover={{ scale: 1.03 }}
            whileTap={{ scale: 0.97 }}
            className="md:col-span-2 py-3 rounded-xl font-bold bg-linear-to-r from-cyan-500 via-blue-500 to-purple-500 shadow-lg"
          >
            Submit Claim
          </motion.button>

        </form>

        {/* INPUT STYLE */}
        <style>{`
          .input {
            width: 100%;
            padding: 12px;
            border-radius: 14px;
            background: rgba(255,255,255,0.05);
            border: 1px solid rgba(255,255,255,0.1);
            outline: none;
            transition: all 0.3s ease;
            color: white;
          }

          .input:focus {
            border-color: #22d3ee;
            box-shadow: 0 0 10px rgba(34,211,238,0.4);
          }

          .input::placeholder {
            color: rgba(255,255,255,0.4);
          }
        `}</style>

      </motion.div>
    </div>
  );
};

export default ExpenseClaimForm;