"use client";
import Lottie from "lottie-react";
import mainAnimation from "../../../animation/main.json";
import main2Animation from "../../../animation/main2.json";
import { Button } from "@/components/ui/button";
import { Card, CardContent, CardHeader, CardTitle } from "@/components/ui/card";
import { motion } from "framer-motion";
import { BookA, GraduationCap, CalendarCheck, Users } from "lucide-react";

const HomePage = () => {
  return (
    <div className="home-container h-3/4 px-20 pb-20">
      {/* Hero Container */}
      <div className="hero-container flex h-[600px] mb-24">
        <motion.div
          className="flex-1 flex flex-col items-center justify-center"
          initial={{ opacity: 0, x: 100 }}
          whileInView={{ opacity: 1, x: 0 }}
          transition={{ duration: 1 }}
          viewport={{ once: true }}
        >
          <p className="font-bold text-4xl">
            Welcome to{" "}
            <span className=" text-emerald-500 uppercase">Tutoria</span>,
          </p>
          <p className="font-bold text-4xl text-center px-20">
            Discover the ultimate platform for online education search and
            exploration.
          </p>
          <p className="mt-2 text-xl">Let&apos;s start your learning today.</p>
          <div className="mt-5 flex gap-5">
            <Button
              variant={"secondary"}
              className="w-48 text-xl hover:bg-[#d8d4d6]"
            >
              Sign up
            </Button>
            <Button className="w-48 text-xl bg-emerald-500 hover:bg-[#019c91]">
              Login
            </Button>
          </div>
        </motion.div>
        <motion.div
          className="flex flex-1 items-center justify-center"
          initial={{ opacity: 0, x: 100 }}
          whileInView={{ opacity: 1, x: 0 }}
          transition={{ duration: 1 }}
          viewport={{ once: true }}
        >
          <Lottie animationData={mainAnimation} />
        </motion.div>
      </div>
      <h2 className="text-center text-black text-2xl font-bold mb-10">
        The best way for online education
      </h2>
      <div className="card-container w-full flex justify-around gap-10  mb-24">
        <motion.div
          className="w-1/4 shadow-md"
          initial={{ opacity: 0, x: -100 }}
          whileInView={{ opacity: 1, x: 0 }}
          transition={{ duration: 1 }}
          viewport={{ once: true }}
        >
          <Card className="h-72  flex flex-col justify-center hover:scale-105 transition">
            <CardHeader>
              <CardTitle className="text-center text-xl">
                1. Choose a subject
              </CardTitle>
            </CardHeader>
            <CardContent>
              <div className="flex justify-center mb-5">
                <BookA className="w-32 h-32" />
              </div>
            </CardContent>
          </Card>
        </motion.div>

        <motion.div
          className="w-1/4  shadow-md"
          initial={{ opacity: 0, x: -100 }}
          whileInView={{ opacity: 1, x: 0 }}
          transition={{ duration: 1, delay: 0.25 }}
          viewport={{ once: true }}
        >
          <Card className="h-72  flex flex-col justify-center hover:scale-105 transition">
            <CardHeader>
              <CardTitle className="text-center text-xl">
                2. Choose a tutor
              </CardTitle>
            </CardHeader>
            <CardContent>
              <div className="flex justify-center mb-5">
                <GraduationCap className="w-32 h-32" />
              </div>
            </CardContent>
          </Card>
        </motion.div>

        <motion.div
          className="w-1/4  shadow-md"
          initial={{ opacity: 0, x: -100 }}
          whileInView={{ opacity: 1, x: 0 }}
          transition={{ duration: 1, delay: 0.5 }}
          viewport={{ once: true }}
        >
          <Card className="h-72  flex flex-col justify-center hover:scale-105 transition">
            <CardHeader>
              <CardTitle className="text-center text-xl">
                3. Scheduling
              </CardTitle>
            </CardHeader>
            <CardContent>
              <div className="flex justify-center mb-5">
                <CalendarCheck className="w-32 h-32" />
              </div>
            </CardContent>
          </Card>
        </motion.div>

        <motion.div
          className="w-1/4  shadow-md"
          initial={{ opacity: 0, x: -100 }}
          whileInView={{ opacity: 1, x: 0 }}
          transition={{ duration: 1, delay: 0.75 }}
          viewport={{ once: true }}
        >
          <Card className="h-72 flex flex-col justify-center hover:scale-105 transition">
            <CardHeader>
              <CardTitle className="text-center text-xl">
                4. Start learning
              </CardTitle>
            </CardHeader>
            <CardContent>
              <div className="flex justify-center mb-5">
                <Users className="w-32 h-32" />
              </div>
            </CardContent>
          </Card>
        </motion.div>
      </div>

      <motion.div
        initial={{ opacity: 0, x: 100 }}
        whileInView={{ opacity: 1, x: 0 }}
        transition={{ duration: 1, delay: 0.75 }}
        viewport={{ once: true }}
        className="why-container w-full flex px-20 mb-8"
      >
        <div className="flex-1 flex items-center justify-center">
          <Lottie animationData={main2Animation} />
        </div>
        <div className="flex-1 flex justify-center  flex-col ">
          <p className="font-bold text-3xl text-center">What sets us apart?</p>
          <p className="text-xl mt-2 text-center">
            At{" "}
            <span className="text-emerald-500 uppercase font-semibold">
              Tutoria
            </span>
            , we are committed to revolutionizing online education. Here&apos;s
            what sets us apart:
          </p>
          <ul className="mt-2 text-xl flex flex-col items-center gap-2">
            <li>Simple, straight foward process.</li>
            <li>Detailed information about tutor.</li>
            <li>Live session on the platform.</li>
          </ul>
        </div>
      </motion.div>
    </div>
  );
};

export default HomePage;
