import TutorDisplay from "@/components/student/TutorDisplay";
import TutorFilter from "@/components/student/TutorFilter";
import findTutorCover from "@/public/find_tutor_cover.jpg";
import Image from "next/image";

const StudentMainPage = () => {
  return (
    <div className="flex flex-col max-h-screen h-screen">
      <div className="w-full h-48 bg-black flex justify-center items-center">
        <p className="text-white text-center text-5xl font-bold">
          Find your tutor
        </p>
      </div>
      <div className="h-full flex flex-col md:flex-row mt-10 px-10">
        <div className="h-full w-full md:w-1/5 overflow-y-hidden px-1">
          <TutorFilter />
        </div>
        <div className="w-full md:w-4/5 overflow-y-hidden">
          <h2 className="text-center text-3xl font-semibold">
            Available Tutor
          </h2>
          <TutorDisplay />
        </div>
      </div>
    </div>
  );
};

export default StudentMainPage;
