"use client";

import { Input } from "@/components/ui/input";
import { Checkbox } from "../ui/checkbox";
import { Label } from "@/components/ui/label";
import { Separator } from "@/components/ui/separator";
import { Button } from "@/components/ui/button";
import { Search } from "lucide-react";
import { useState } from "react";
import { Subject } from "@/types";

interface TutorFilterProps {
  subjects: Subject[];
  validSubjects: Subject[];
  setValidSubjects: (selectedSubjects: Subject[]) => void;
}

const TutorFilter = ({
  subjects,
  validSubjects,
  setValidSubjects,
}: TutorFilterProps) => {
  return (
    <>
      <div className="mb-3 py-1 max-w-full">
        <h2 className="mb-3 sm:text-center md:text-start font-semibold text-xl">
          Search by name
        </h2>
        <div className="flex w-full max-w-sm items-center space-x-2">
          <Input className="block w-full " type="text" placeholder="Search by name" />
          <Button className="w-1/6">
            <Search className="w-full" />
          </Button>
        </div>
      </div>
      <Separator className="w-full mb-3" />
      <div className="flex flex-col gap-2">
        <h3 className="mb-3 font-semibold">Filter by Subject</h3>
        {subjects.map((subject) => (
          <div key={subject.subject_id}>
            <Checkbox
              className="mr-2"
              onCheckedChange={(checked) => {
                let newSubjectArray;
                if (checked) {
                  newSubjectArray = [...validSubjects, subject];
                } else {
                  newSubjectArray = validSubjects.filter(
                    (currentSubject) =>
                      currentSubject.subject_name !== subject.subject_name
                  );
                }
                setValidSubjects(newSubjectArray);
              }}
            />
            <Label>{subject.subject_name}</Label>
          </div>
        ))}
      </div>
    </>
  );
};

export default TutorFilter;
