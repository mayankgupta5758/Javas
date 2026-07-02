import { Routes, Route } from "react-router-dom";
import Navbar from "./components/Navbar";

import ExpenseClaimForm from "./pages/ExpenseClaimForm";
import ExpenseClaimList from "./pages/ExpenseClaimList";
import ClaimReview from "./pages/ClaimReview";
import BudgetManagement from "./pages/BudgetManagement";
import FinanceSummary from "./pages/FinanceSummary";

function App() {
  return (
   <div className="min-h-screen bg-linear-to-br from-slate-950 via-slate-900 to-indigo-950">
      <Navbar />

      <Routes>
        <Route path="/" element={<ExpenseClaimForm />} />
        <Route path="/claims" element={<ExpenseClaimList />} />
        <Route path="/review" element={<ClaimReview />} />
        <Route path="/budgets" element={<BudgetManagement />} />
        <Route path="/summary" element={<FinanceSummary />} />
      </Routes>
    </div>
  );
}

export default App;