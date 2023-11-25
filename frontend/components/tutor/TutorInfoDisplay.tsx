import React from "react";
import { Avatar, AvatarFallback, AvatarImage } from "@/components/ui/avatar";

export const TutorInfoDisplay = () => {
  return (
    <>
      <div className="mb-7">
        <div className="">
          <Avatar className="w-full h-full">
            <AvatarImage src="https://github.com/shadcn.png" />
            <AvatarFallback>CN</AvatarFallback>
          </Avatar>
        </div>
        <div className="">
          <h2 className="text-3xl mt-5 font-semibold text-center">Baroibeo</h2>
          <h2 className="text-lg mt-5 text-center">
            <span className="font-semibold">Email: </span> baroibeo@gmail.com
          </h2>
        </div>
      </div>
    </>
  );
};
