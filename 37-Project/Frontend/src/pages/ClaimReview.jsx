import React, { useEffect, useState } from "react";
import { motion, AnimatePresence } from "framer-motion";
import { toast } from "react-toastify";

import {
  getAllClaims1,
  approveClaim1,
  rejectClaim1,
} from "../services/claimService";

const ClaimReview = () => {
  const [claims, setClaims] = useState([]);

  const loadClaims = async () => {
    try {
      // const response = await getAllClaims();

      // const pendingClaims =
      //   response.data.data.filter(
      //     (claim) =>
      //       claim.status === "PENDING"
      //   );

      const data = await getAllClaims1()
      const pendingClaims = data.data.filter((claim) =>
            claim.status === "PENDING")
      console.log(data)

      setClaims(pendingClaims);
    } catch {
      toast.error("Failed to load claims");
    }
  };

  useEffect(() => {
    loadClaims();
  }, []);

  const handleApprove = async (id) => {
    try {
      // await approveClaim(id, {
      //   reviewRemark: "Approved",
      // });

      const data = await approveClaim1(id)
      console.log(data)

      toast.success(
        "Claim Approved Successfully"
      );

      loadClaims();
    } catch (error) {
      toast.error(
        error.response?.data?.message
      );
    }
  };

  const handleReject = async (id) => {
    try {
      // await rejectClaim(id, {
      //   reviewRemark: "Rejected",
      // });

      const res = await rejectClaim1(id)
      console.log(res)

      toast.success(
        "Claim Rejected Successfully"
      );

      loadClaims();
    } catch (error) {
      toast.error(
        error.response?.data?.message
      );
    }
  };

  return (
    <div className="h-[80vh] overflow-auto bg-linear-to-br from-slate-950 via-slate-900 to-indigo-950 text-white p-6">

      <div className="max-w-6xl mx-auto space-y-6">

        {/* HEADER */}
        <div className="bg-white/5 border border-white/10 backdrop-blur-xl p-6 rounded-3xl">
          <h1 className="text-3xl font-bold bg-linear-to-r from-green-400 via-cyan-400 to-blue-400 bg-clip-text text-transparent">
            Claim Review Panel
          </h1>
          <p className="text-gray-400 mt-2">
            Approve or reject employee claims
          </p>
        </div>

        {/* LIST */}
        <div className="space-y-4">

          <AnimatePresence>
            {claims.map((claim) => (
              <motion.div
                key={claim.id}
                initial={{ opacity: 0, y: 10 }}
                animate={{ opacity: 1, y: 0 }}
                exit={{ opacity: 0 }}
                whileHover={{ scale: 1.01 }}
                className="bg-white/5 border border-white/10 backdrop-blur-xl rounded-2xl p-5 flex flex-col md:flex-row md:items-center justify-between gap-4 transition"
              >

                {/* LEFT INFO */}
                <div className="flex flex-col md:flex-row md:items-center gap-4 md:gap-10">

                  <div>
                    <p className="text-gray-400 text-sm">Employee</p>
                    <p className="font-semibold">{claim.employeeName}</p>
                  </div>

                  <div>
                    <p className="text-gray-400 text-sm">Amount</p>
                    <p className="text-cyan-300 font-bold">
                      ₹ {claim.amount}
                    </p>
                  </div>

                  <div>
                    <p className="text-gray-400 text-sm">Department</p>
                    <span className="px-3 py-1 text-sm rounded-full bg-white/10">
                      {claim.department}
                    </span>
                  </div>

                  <div>
                    <p className="text-gray-400 text-sm">Description</p>
                    <span className="px-3 py-1 text-sm rounded-full bg-white/10">
                      {claim.description}
                    </span>
                  </div>
                  <div>
                    <p className="text-gray-400 text-sm">Category</p>
                    <span className="px-3 py-1 text-sm rounded-full bg-white/10">
                      {claim.expenseCategory}
                    </span>
                  </div>
                  <div>
                    <p className="text-gray-400 text-sm">Date</p>
                    <span className="px-3 py-1 text-sm rounded-full bg-white/10">
                      {claim.expenseDate}
                    </span>
                  </div>
                  <div>
                    <p className="text-gray-400 text-sm">Status</p>
                    <span className="px-3 py-1 text-sm rounded-full bg-white/10">
                      {claim.status}
                    </span>
                  </div>
                </div>

                {/* ACTION BUTTONS */}
                <div className="flex gap-3 shrink-0">

                  <button
                    onClick={() => handleApprove(claim.id)}
                    className="px-5 py-2 rounded-xl bg-linear-to-r from-green-400 to-emerald-500 font-semibold hover:scale-105 transition"
                  >
                    Approve
                  </button>

                  <button
                    onClick={() => handleReject(claim.id)}
                    className="px-5 py-2 rounded-xl bg-linear-to-r from-red-500 to-pink-500 font-semibold hover:scale-105 transition"
                  >
                    Reject
                  </button>

                </div>

              </motion.div>
            ))}
          </AnimatePresence>

        </div>

      </div>
    </div>
  );
};

export default ClaimReview;