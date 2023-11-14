import Navbar from "@/components/Navbar";

const HomeLayout = ({ children }: { children: React.ReactNode }) => {
  return (
    <div className="h-full">
      <div className="w-full">
        <Navbar />
      </div>
      <main className="min-h-full">{children}</main>
    </div>
  );
};

export default HomeLayout;
