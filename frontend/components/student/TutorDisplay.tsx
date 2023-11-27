"use client";
import { Card, CardContent, CardHeader, CardTitle } from "@/components/ui/card";
import { Avatar, AvatarImage, AvatarFallback } from "@/components/ui/avatar";
import { useState } from "react";
import { Badge } from "@/components/ui/badge";
import { Plus } from "lucide-react";
import { Button } from "@/components/ui/button";
import { Subject } from "@/types";
import { originTeacherArray } from "@/dummyData";

interface TutorDisplayProps {
  validSubjects: Subject[];
}

const TutorDisplay = ({ validSubjects }: TutorDisplayProps) => {
  const [loading, setIsLoading] = useState(false);
  const [currentPage, setCurrentPage] = useState<number>(1);
  const itemsPerPage = 9;
  let filteredArray = originTeacherArray;
  if (validSubjects.length !== 0) {
    filteredArray = originTeacherArray.filter((teacher) => {
      const teacherSubjects = teacher.subjects;
      return teacherSubjects.some((subject) =>
        validSubjects.some(
          (validSubject) => subject === validSubject.subject_name
        )
      );
    });
  }
  const startIndex = (currentPage - 1) * itemsPerPage;
  const endIndex = startIndex + itemsPerPage;

  if (loading) {
    return <p className="text-center">Loading...</p>;
  }

  const totalPages = Math.ceil(filteredArray.length / itemsPerPage);

  const handlePageChange = (newPage: number) => {
    setCurrentPage(newPage);
  };

  return (
    <>
      <div className="min-h-[800px]">
        <h2 className="text-center text-3xl font-semibold">Available Tutors</h2>
        <div className="grid grid-cols-1 md:grid-cols-2 lg:grid-cols-3 gap-5 mt-5 ml-5 px-16">
          {filteredArray.slice(startIndex, endIndex).map((teacher) => (
            <Card
              key={teacher.name}
              className="h-80 md:h-72 lg:h-56 w-full cursor-pointer hover:scale-105 transition"
            >
              <CardContent className="flex flex-col gap-3 items-center justify-center h-full">
                <Avatar className="w-24 h-24">
                  <AvatarImage src="https://github.com/shadcn.png" />
                  <AvatarFallback>CN</AvatarFallback>
                </Avatar>
                <CardTitle className="text-center text-xl">
                  {teacher.name}
                </CardTitle>
                <div className="flex flex-col md:flex-row gap-3 justify-center items-center flex-wrap max-w-full">
                  {teacher.subjects
                    .slice(0, itemsPerPage - 1)
                    .map((subject) => (
                      <Badge key={subject} className="max-w-fit">
                        {subject}
                      </Badge>
                    ))}
                  {teacher.subjects.length > itemsPerPage - 1 && (
                    <Badge key="more" className="max-w-fit">
                      More <Plus className="w-3 h-3" />
                    </Badge>
                  )}
                </div>
              </CardContent>
            </Card>
          ))}
        </div>
      </div>
      <div className="flex justify-center gap-5 mt-4">
        <Button
          onClick={() => handlePageChange(currentPage - 1)}
          disabled={currentPage === 1}
          className="w-24 cursor-pointer"
        >
          Previous
        </Button>
        <Button
          onClick={() => handlePageChange(currentPage + 1)}
          disabled={currentPage === totalPages}
          className="w-24 cursor-pointer"
        >
          Next
        </Button>
      </div>
    </>
  );
};

export default TutorDisplay;
