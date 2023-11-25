import { TutorInfoDisplay } from "@/components/tutor/TutorInfoDisplay";
import { TutorSubjectDisplay } from "@/components/tutor/TutorSubjectDisplay";
import { TutorQualifiDisplay } from "@/components/tutor/TutorQualifiDisplay";
import { TutorScheduleDisplay } from "@/components/tutor/TutorScheduleDisplay";

const TutorMainPage = () => {
  return (
    <div className="min-h-screen flex flex-row">
      <div className="h-full w-full md:w-1/4 px-1 flex flex-col mt-10 border-8">
        <TutorInfoDisplay />
        <TutorSubjectDisplay />
      </div>
      <div className="w-full md:w-3/4">
          <TutorQualifiDisplay/>
          <TutorScheduleDisplay/>
      </div>
    </div>
  );
};

export default TutorMainPage;
