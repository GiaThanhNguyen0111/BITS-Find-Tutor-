import React from "react";
import { Avatar, AvatarFallback, AvatarImage } from "@/components/ui/avatar";

export const TutorInfoDisplay = () => {
  return (
    <>
      <div className="flex flex-col min-h-screen">
        <div className="">
          <Avatar className="w-full h-full">
            <AvatarImage src="https://github.com/shadcn.png" />
            <AvatarFallback>CN</AvatarFallback>
          </Avatar>
        </div>
        <div className="">
          <h2 className="text-5xl mt-5 font-semibold text-center">Baroibeo</h2>
          <h3 className="text-lg mt-5 text-center">
            <span className="font-semibold">Email: </span> baroibeo@gmail.com
          </h3>
        </div>  
      </div>
    </>
  );
};
