"use client";
import Lottie from "lottie-react";
import mainAnimation from "../../../animation/main.json";
import { Button } from "@/components/ui/button";
import {
  Card,
  CardContent,
  CardDescription,
  CardFooter,
  CardHeader,
  CardTitle,
} from "@/components/ui/card";
import { motion, Variants } from "framer-motion";

const HomePage = () => {
  return (
    <div className="home-container h-3/4 px-20 pb-20">
      {/* Hero Container */}
      <div className="hero-container flex h-[800px] mb-20">
        <motion.div
          className="flex-1 flex flex-col items-center justify-center"
          initial={{ opacity: 0, x: 100 }}
          whileInView={{ opacity: 1, x: 0 }}
          transition={{ duration: 1.5 }}
          viewport={{ once: true }}
        >
          <p className="font-bold text-5xl">
            Welcome to <span className=" text-emerald-500 uppercase">Logo</span>
            ,
          </p>
          <p className="font-bold text-5xl text-center px-20">
            Discover the ultimate platform for online education search and
            exploration.
          </p>
          <p className="mt-2 text-2xl">Let's start your learning today.</p>
          <div className="mt-5 flex gap-5">
            <Button variant={"secondary"} className="w-48 text-xl">
              Sign up
            </Button>
            <Button className="w-48 text-xl bg-emerald-500">Login</Button>
          </div>
        </motion.div>
        <div className="flex flex-1 items-center justify-center">
          <Lottie animationData={mainAnimation} />
        </div>
      </div>

      <div className="card-container w-full flex justify-around gap-10 px-20">
        <motion.div
          className="w-1/3"
          initial={{ opacity: 0, x: -100 }}
          whileInView={{ opacity: 1, x: 0 }}
          transition={{ duration: 1 }}
          viewport={{ once: true }}
        >
          <Card>
            <CardHeader>
              <CardTitle className="text-center">Card Title 1</CardTitle>
              <CardDescription>Card Description</CardDescription>
            </CardHeader>
            <CardContent>
              <p>Card Content</p>
            </CardContent>
            <CardFooter>
              <p>Card Footer</p>
            </CardFooter>
          </Card>
        </motion.div>

        <motion.div
          className="w-1/3"
          initial={{ opacity: 0, x: -100 }}
          whileInView={{ opacity: 1, x: 0 }}
          transition={{ duration: 1, delay: 0.25 }}
          viewport={{ once: true }}
        >
          <Card>
            <CardHeader>
              <CardTitle className="text-center">Card Title 2</CardTitle>
              <CardDescription>Card Description</CardDescription>
            </CardHeader>
            <CardContent>
              <p>Card Content</p>
            </CardContent>
            <CardFooter>
              <p>Card Footer</p>
            </CardFooter>
          </Card>
        </motion.div>

        <motion.div
          className="w-1/3"
          initial={{ opacity: 0, x: -100 }}
          whileInView={{ opacity: 1, x: 0 }}
          transition={{ duration: 1, delay: 0.5 }}
          viewport={{ once: true }}
        >
          <Card>
            <CardHeader>
              <CardTitle className="text-center">Card Title 3</CardTitle>
              <CardDescription>Card Description</CardDescription>
            </CardHeader>
            <CardContent>
              <p>Card Content</p>
            </CardContent>
            <CardFooter>
              <p>Card Footer</p>
            </CardFooter>
          </Card>
        </motion.div>
      </div>
    </div>
  );
};

export default HomePage;
