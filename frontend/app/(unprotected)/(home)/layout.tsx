import Navbar from "@/components/Navbar";
import Footer from "@/components/Footer";
const HomeLayout = ({ children }: { children: React.ReactNode }) => {
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
