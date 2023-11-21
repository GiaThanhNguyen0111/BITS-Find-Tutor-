"use client";
import Navbar from "@/components/Navbar";
import Footer from "@/components/Footer";
import { useAuth } from "@/hooks/useAuth";
const HomeLayout = ({ children }: { children: React.ReactNode }) => {
  const { role } = useAuth();

  return (
    <div className="h-full">
      <div className="w-full">
        <Navbar />
      </div>
      <main className="min-h-full">{children}</main>
      <Footer />
    </div>
  );
};

export default HomeLayout;
