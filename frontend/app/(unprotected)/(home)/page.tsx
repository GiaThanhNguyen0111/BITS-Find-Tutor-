"use client";
import Lottie from "lottie-react";
import mainAnimation from "../../../animation/main.json";
import { Button } from "@/components/ui/button";

const HomePage = () => {
  return (
    <div className="home-container h-3/4 px-20">
      {/* Hero Container */}
      <div className="hero-container flex h-[600px]">
        <div className="flex-1 flex flex-col items-center justify-center">
          <p className="font-semibold text-3xl">Welcome to <span className="text-4xl text-emerald-500 uppercase">Logo</span></p>
          <p className="font-semibold text-3xl text-center">
            Discover the ultimate platform for online education search and
            exploration.
          </p>
          <p className="mt-2">Let's start your learning today.</p>
          <div className="mt-5 flex gap-5">
            <Button variant={"secondary"} className="w-40">
              Sign up
            </Button>
            <Button className="w-40">Login</Button>
          </div>
        </div>
        <div className="flex flex-1 items-center justify-center">
          <Lottie animationData={mainAnimation} />
        </div>
      </div>

      <div className="">
        hello
      </div>
    </div>
  );
};

export default HomePage;
