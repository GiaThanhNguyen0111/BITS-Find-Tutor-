"use client";
import TutorDisplay from "@/components/student/TutorDisplay";
import TutorFilter from "@/components/student/TutorFilter";
import { academicSubjects } from "@/dummyData";

const StudentMainPage = () => {
  return (
    <div className="flex flex-col min-h-screen">
      <div className="w-full h-48 bg-black flex justify-center items-center">
        <p className="text-white text-center text-5xl font-bold">
          Find your tutor
        </p>
      </div>
      <div className="h-full flex flex-col md:flex-row mt-10 px-10">
        <div className="h-full w-full md:w-1/5 px-1">
          <TutorFilter subjects={academicSubjects} />
        </div>
        <div className="w-full md:w-4/5 ">
          <TutorDisplay />
        </div>
      </div>
    </div>
  );
};

export default StudentMainPage;
