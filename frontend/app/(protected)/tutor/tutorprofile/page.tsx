"use client";

import { TutorInfoDisplay } from "@/components/tutor/TutorInfoDisplay";
import { TutorQualifiDisplay } from "@/components/tutor/TutorQualifiDisplay";
import { TutorScheduleDisplay } from "@/components/tutor/TutorScheduleDisplay";
import { Button } from "@/components/ui/button";
import { useModal } from "@/hooks/useModal";

const TutorMainPage = () => {
  const { onOpen } = useModal();
  return (
    <div className="min-h-screen flex flex-row mx-5">
      <div className="h-full w-1/4 md:w-1/4 px-1 flex flex-col mt-10 ">
        <TutorInfoDisplay />
      </div>

      <div className="w-full ml-4 md:w-3/4 flex flex-col mt-10">
        <div className="flex justify-between">
          <h2 className="text-4xl font-semibold">Qualifications</h2>
          <Button
            onClick={() => {
              onOpen("addqualifi");
            }}
          >
            Add new qualification
          </Button>
        </div>
        <TutorQualifiDisplay />
        <div className="flex mt-10">
          <h2 className="text-4xl font-semibold">Available Time</h2>
        </div>
        <TutorScheduleDisplay />
      </div>
    </div>
  );
};

export default TutorMainPage;
