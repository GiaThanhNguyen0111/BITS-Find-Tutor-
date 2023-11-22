import TutorDisplay from "@/components/student/TutorDisplay";
import TutorFilter from "@/components/student/TutorFilter";
import findTutorCover from "@/public/find_tutor_cover.jpg";
import Image from "next/image";

const StudentMainPage = () => {
  return (
    <div className="min-h-[700px] h-1 flex flex-col">
      <div className="w-full h-48 bg-black flex justify-center items-center">
        <p className="text-white text-center">Find your tutor</p>
      </div>
      <div className="flex flex-col md:flex-row mt-5 px-10">
        <div className="w-full md:w-1/5">
          <TutorFilter />
        </div>
        <div className="w-full md:w-4/5 flex justify-center">
          <TutorDisplay />
        </div>
      </div>
    </div>
  );
};

export default StudentMainPage;
