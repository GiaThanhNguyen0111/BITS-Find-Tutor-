"use client";
import { Card, CardContent, CardHeader, CardTitle } from "@/components/ui/card";
import { Avatar, AvatarImage, AvatarFallback } from "@/components/ui/avatar";
import { useState } from "react";
import { Badge } from "@/components/ui/badge";
import { Plus } from "lucide-react";

const dummyTeacherArray = [
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

const TutorDisplay = () => {
  const [loading, setIsLoading] = useState(false);
  const MAX_SUBJECTS_TO_DISPLAY = 3;
  if (loading) {
    return <p className="text-center">Loading...</p>;
  }
  return (
    <>
      <h2 className="text-center text-3xl font-semibold">Available Tutor</h2>
      <div className="grid grid-cols-3 gap-5 mt-5 ml-5 px-16">
        {dummyTeacherArray.map((teacher) => (
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
                  .slice(0, MAX_SUBJECTS_TO_DISPLAY - 1)
                  .map((subject) => (
                    <Badge key={subject} className="max-w-fit">
                      {subject}
                    </Badge>
                  ))}
                {teacher.subjects.length > MAX_SUBJECTS_TO_DISPLAY - 1 && (
                  <Badge key="more" className="max-w-fit">
                    More <Plus className="w-3 h-3" />
                  </Badge>
                )}
              </div>
            </CardContent>
          </Card>
        ))}
      </div>
    </>
  );
};

export default TutorDisplay;
