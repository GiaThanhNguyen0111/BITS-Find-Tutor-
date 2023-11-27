"use client";
import Navbar from "@/components/Navbar";
import Footer from "@/components/Footer";
import { useAuth } from "@/hooks/useAuth";
import { redirect } from "next/navigation";
const StudentLayout = ({ children }: { children: React.ReactNode }) => {
  const { role } = useAuth();

  if (role !== "student") {
    return redirect("/");
  }
  return (
    <div>
      <div className="h-full">
        <div className="w-full">
          <Navbar />
        </div>
        <main className="min-h-full">{children}</main>
        <Footer />
      </div>
    </div>
  );
};

export default StudentLayout;
