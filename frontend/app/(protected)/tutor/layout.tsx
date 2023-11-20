"use client"
import Navbar from "@/components/Navbar";
import Footer from "@/components/Footer";
import { redirect } from "next/navigation";
import { useAuth } from "@/hooks/useAuth";
const TutorLayout = ({ children }: { children: React.ReactNode }) => {
  const { role } = useAuth();
  if (role !== "tutor") {
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

export default TutorLayout;
