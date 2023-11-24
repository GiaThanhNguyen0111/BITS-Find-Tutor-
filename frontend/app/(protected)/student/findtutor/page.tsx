"use client";
import TutorDisplay from "@/components/student/TutorDisplay";
import TutorFilter from "@/components/student/TutorFilter";
import { academicSubjects } from "@/dummyData";
import { Subject } from "@/types";
import { useState } from "react";
import loadingAnimation from "@/animation/loading.json";
import Lottie from "lottie-react";

const StudentMainPage = () => {
  const [validSubjects, setValidSubjects] = useState<Subject[]>([]);
  const [loading, setLoading] = useState(false);
  if (loading) {
    return (
      <div className="flex flex-col justify-center items-center min-h-screen">
        <Lottie animationData={loadingAnimation} />
        <p>Loading...</p>
      </div>
    );
  }
  return (
    <div className="flex flex-col min-h-screen">
      <div className="w-full h-48 bg-gradient-to-r from-[#10b981] to-[#98EECC] flex justify-center items-center">
        <p className="text-white text-center text-5xl font-bold">
          Find your tutor
        </p>
      </div>
      <div className="h-full flex flex-col md:flex-row mt-10 px-10">
        <div className="h-full w-full md:w-1/5 px-1">
          <TutorFilter
            subjects={academicSubjects}
            validSubjects={validSubjects}
            setValidSubjects={setValidSubjects}
          />
        </div>
        <div className="w-full md:w-4/5 ">
          <TutorDisplay validSubjects={validSubjects} />
        </div>
      </div>
    </div>
  );
};

export default StudentMainPage;
