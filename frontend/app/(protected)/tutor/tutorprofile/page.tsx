import { TutorInfoDisplay } from "@/components/tutor/TutorInfoDisplay";
import { TutorQualifiDisplay } from "@/components/tutor/TutorQualifiDisplay";
import { TutorScheduleDisplay } from "@/components/tutor/TutorScheduleDisplay";

const TutorMainPage = () => {
  return (
    <div className="min-h-screen flex flex-row">
      <div className="h-full w-1/4 md:w-1/4 px-1 flex flex-col mt-10 ">
        <TutorInfoDisplay />
        
      </div>
    
      <div className="w-full ml-4 md:w-3/4 flex flex-wrap mt-10">
          <TutorQualifiDisplay/>
          <TutorScheduleDisplay/>
      </div>

      
    
    </div>
  );
};

export default TutorMainPage;
