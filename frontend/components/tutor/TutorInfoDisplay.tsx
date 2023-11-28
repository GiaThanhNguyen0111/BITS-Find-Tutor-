"use client";
import React from "react";
import { Avatar, AvatarFallback, AvatarImage } from "@/components/ui/avatar";
import { Badge } from "@/components/ui/badge";
import { academicSubjects } from "@/dummyData";
import { Plus } from "lucide-react";
import { useModal } from "@/hooks/useModal";
import Image from "next/image";


export const TutorInfoDisplay = () => {
  const { onOpen } = useModal();

  return (
    <>
      <div className="flex flex-col min-h-screen">
        <div className="self-center">
          <Avatar className="w-64 h-64">
            <AvatarImage src="https://github.com/shadcn.png" />
            <AvatarFallback>CN</AvatarFallback>
          </Avatar>
        </div>

        <div className="flex flex-col">
          <h2 className="text-5xl mt-5 font-semibold text-center">Baroibeo</h2>
          <h3 className="text-lg mt-5 text-center">
            <span className="font-semibold">Email: </span> baroibeo@gmail.com
          </h3>
        </div>
        <div className="flex justify-center mt-5 gap-1">
          {[...Array(5)].map(() => {
            return (
              <Image src="/star.svg" alt="My Icon" width={24} height={24} />
            );
          })}
        </div>
        <div className="flex flex-col mt-12 border-t-2 border-black">
          <h2 className="text-3xl font-semibold text-center mt-10">Subjects</h2>
          <div className="mt-5 ml-3 flex flex-wrap gap-[.6rem]">
            {academicSubjects
              .slice(0, 4)
              .sort((a, b) => a.subject_name.length - b.subject_name.length) // Sort by subject_name length
              .map((subject) => (
                <div key={subject.subject_id}>
                  <Badge className="cursor-pointer bg-gradient-to-r from-[#D0A2F7] to-[#BE9FE1] border-none h-9 hover:scale-105 transition">
                    {subject.subject_name}
                  </Badge>
                </div>
              ))}
            <div>
              <Badge
                onClick={() => {
                  onOpen("addsubject");
                }}
                className="cursor-pointer bg-gradient-to-r from-[#D0A2F7] to-[#BE9FE1] border-none  h-9 w-[4.2rem] hover:scale-105 transition flex items-center justify-center"
              >
                <Plus className="w-3 h-3" />
              </Badge>
            </div>
          </div>
        </div>
        <div className="flex flex-col mt-12 border-t-2 border-black ">
          <h2 className="text-3xl font-semibold text-center mt-10">Reviews</h2>
          <div></div>
        </div>
      </div>
    </>
  );
};
