function SummaryCard({ title, value, icon, trend }) {
  return (
    <div className="relative group">

      {/* Background glow orb */}
      <div className="absolute -inset-1 bg-linear-to-r from-indigo-500 via-purple-500 to-pink-500 rounded-2xl blur opacity-30 group-hover:opacity-60 transition duration-500"></div>

      {/* Card */}
      <div className="relative bg-white/80 backdrop-blur-xl border border-white/40 rounded-2xl p-5 shadow-xl overflow-hidden transition-all duration-300 group-hover:-translate-y-1 group-hover:shadow-2xl">

        {/* Floating shine */}
        <div className="absolute inset-0 opacity-0 group-hover:opacity-100 transition duration-700">
          <div className="absolute -top-10 -left-10 w-40 h-40 bg-linear-to-r from-indigo-200 to-transparent rounded-full blur-2xl"></div>
        </div>

        <div className="relative flex items-start justify-between">

          {/* Left side */}
          <div>
            <h3 className="text-gray-500 text-sm font-medium tracking-wide">
              {title}
            </h3>

            <h1 className="text-3xl font-black text-gray-900 mt-2 transition-all duration-300 group-hover:scale-105">
              {value}
            </h1>

            {/* Trend */}
            {trend && (
              <p className="text-xs mt-2 text-green-500 font-semibold flex items-center gap-1 animate-pulse">
                {trend}
              </p>
            )}
          </div>

          {/* Icon */}
          {icon && (
            <div className="text-4xl transition-transform duration-300 group-hover:rotate-12 group-hover:scale-110">
              {icon}
            </div>
          )}
        </div>

        {/* Bottom animated line */}
        <div className="absolute bottom-0 left-0 h-0.75 w-0 group-hover:w-full bg-linear-to-r from-indigo-500 via-purple-500 to-pink-500 transition-all duration-500"></div>
      </div>
    </div>
  );
}

export default SummaryCard;