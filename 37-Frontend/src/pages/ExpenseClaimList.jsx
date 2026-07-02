import React, { useEffect, useState } from "react";
import { motion, AnimatePresence } from "framer-motion";
import { getAllClaims1 } from "../services/claimService";
import { toast } from "react-toastify";

const ExpenseClaimList = () => {
  const [claims, setClaims] = useState([]);
  const [filteredClaims, setFilteredClaims] = useState([]);
  const [statusFilter, setStatusFilter] = useState("");

  const loadClaims = async () => {
    try {
      const response = await getAllClaims1();
      setClaims(response.data);
      setFilteredClaims(response.data);
    } catch {
      toast.error("Claim not found");
    }
  };

  useEffect(() => {
    loadClaims();
  }, []);

  useEffect(() => {
    if (!statusFilter) {
      setFilteredClaims(claims);
    } else {
      setFilteredClaims(
        claims.filter((c) => c.status === statusFilter)
      );
    }
  }, [statusFilter, claims]);

  const getStatusColor = (status) => {
    switch (status) {
      case "APPROVED":
        return "bg-green-500/20 text-green-400 border-green-500/30";
      case "REJECTED":
        return "bg-red-500/20 text-red-400 border-red-500/30";
      default:
        return "bg-yellow-500/20 text-yellow-300 border-yellow-500/30";
    }
  };

  return (
    <div className="min-h-screen bg-linear-to-br from-slate-950 via-slate-900 to-indigo-950 text-white p-6">

      <div className="max-w-7xl mx-auto space-y-6">

        {/* HEADER */}
        <div className="bg-white/5 border border-white/10 backdrop-blur-xl rounded-3xl p-6 flex flex-col md:flex-row md:items-center md:justify-between gap-4">

          <h1 className="text-3xl font-bold bg-linear-to-r from-cyan-400 via-blue-400 to-purple-400 bg-clip-text text-transparent">
            Expense Claims Dashboard
          </h1>

          {/* FILTER */}
          <select
            value={statusFilter}
            onChange={(e) => setStatusFilter(e.target.value)}
            className="p-3 rounded-xl bg-black/30 border border-white/10 focus:border-cyan-400 outline-none"
          >
            <option value="">All Status</option>
            <option value="PENDING">PENDING</option>
            <option value="APPROVED">APPROVED</option>
            <option value="REJECTED">REJECTED</option>
          </select>

        </div>

        {/* LIST (CARD STYLE instead of ugly table) */}
        <div className="space-y-4">

          <AnimatePresence>
            {filteredClaims.map((claim) => (
              <motion.div
                key={claim.id}
                initial={{ opacity: 0, y: 10 }}
                animate={{ opacity: 1, y: 0 }}
                exit={{ opacity: 0 }}
                whileHover={{ scale: 1.01 }}
                className="bg-white/5 border border-white/10 backdrop-blur-xl rounded-2xl p-5 flex flex-col md:flex-row md:items-center justify-between gap-4"
              >

                {/* LEFT */}
                <div className="grid md:grid-cols-4 gap-4 w-full">

                  <div>
                    <p className="text-gray-400 text-sm">Employee</p>
                    <p className="font-semibold">{claim.employeeName}</p>
                  </div>

                  <div>
                    <p className="text-gray-400 text-sm">Department</p>
                    <p>{claim.department}</p>
                  </div>

                  <div>
                    <p className="text-gray-400 text-sm">Category</p>
                    <p>{claim.expenseCategory}</p>
                  </div>

                  <div>
                    <p className="text-gray-400 text-sm">Amount</p>
                    <p className="text-cyan-300 font-bold">
                      ₹ {claim.amount}
                    </p>
                  </div>
                  <div>
                    <p className="text-gray-400 text-sm">Description</p>
                    <p className="text-cyan-300 font-bold">
                      ₹ {claim.description}
                    </p>
                  </div><div>
                    <p className="text-gray-400 text-sm">Date</p>
                    <p className="text-cyan-300 font-bold">
                      ₹ {claim.expenseDate}
                    </p>
                  </div>
                </div>

                {/* STATUS BADGE */}
                <div className="flex items-center gap-3">

                  <span
                    className={`px-3 py-1 rounded-full border text-sm font-semibold ${getStatusColor(
                      claim.status
                    )}`}
                  >
                    {claim.status}
                  </span>

                </div>

              </motion.div>
            ))}
          </AnimatePresence>

        </div>

      </div>
    </div>
  );
};

export default ExpenseClaimList;