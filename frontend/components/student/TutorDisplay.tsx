"use client";
import { Card, CardContent, CardHeader, CardTitle } from "@/components/ui/card";
import { Avatar, AvatarImage, AvatarFallback } from "@/components/ui/avatar";
import { useState } from "react";
import { Badge } from "@/components/ui/badge";
import { Plus } from "lucide-react";
import { Button } from "@/components/ui/button";
import { Subject } from "@/types";
import { boolean } from "zod";

let originTeacherArray = [
  {
    name: "Alex",
    subjects: ["Mathematics"],
  },
  {
    name: "Bob",
    subjects: ["History"],
  },
  {
    name: "Charlie",
    subjects: ["English", "Psychology", "History"],
  },
  {
    name: "David",
    subjects: ["Science"],
  },
  {
    name: "Eva",
    subjects: ["Geography"],
  },
  {
    name: "Frank",
    subjects: ["Computer Science"],
  },
  {
    name: "Grace",
    subjects: ["Economics", "Sociology"],
  },
  {
    name: "Hank",
    subjects: ["Foreign Languages"],
  },
  {
    name: "Ivy",
    subjects: ["Mathematics", "History"],
  },
  {
    name: "Jack",
    subjects: ["Psychology"],
  },
  {
    name: "Kelly",
    subjects: ["Computer Science", "Economics"],
  },
  {
    name: "Leo",
    subjects: ["Science", "Geography"],
  },
];

interface TutorDisplayProps {
  validSubjects: Subject[];
}

const TutorDisplay = ({ validSubjects }: TutorDisplayProps) => {
  const [loading, setIsLoading] = useState(false);
  const [currentPage, setCurrentPage] = useState<number>(1);
  const itemsPerPage = 9;
  let dummyTeacherArray = originTeacherArray;
  if (validSubjects.length !== 0) {
    dummyTeacherArray = originTeacherArray.filter((teacher) => {
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

  const totalPages = Math.ceil(dummyTeacherArray.length / itemsPerPage);

  const handlePageChange = (newPage: number) => {
    setCurrentPage(newPage);
  };

  return (
    <>
      <div className="min-h-screen">
        <h2 className="text-center text-3xl font-semibold">Available Tutors</h2>
        <div className="grid grid-cols-3 gap-5 mt-5 ml-5 px-16">
          {dummyTeacherArray.slice(startIndex, endIndex).map((teacher) => (
            <Card
              key={teacher.name}
              className="h-56 w-full cursor-pointer hover:scale-105 transition"
            >
              <CardContent className="flex flex-col gap-3 items-center justify-center h-full">
                <Avatar className="w-24 h-24">
                  <AvatarImage src="https://github.com/shadcn.png" />
                  <AvatarFallback>CN</AvatarFallback>
                </Avatar>
                <CardTitle className="text-center text-xl">
                  {teacher.name}
                </CardTitle>
                <div className="flex flex-row gap-3 flex-wrap max-w-full">
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
