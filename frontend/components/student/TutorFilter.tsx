import { Input } from "@/components/ui/input";
import { Checkbox } from "../ui/checkbox";
import { Label } from "@/components/ui/label";
import { Separator } from "@/components/ui/separator";
import { Button } from "@/components/ui/button";
import { Search } from "lucide-react";

const academicSubjects = [
  "Mathematics",
  "Science (Physics, Chemistry, Biology)",
  "English Language and Literature",
  "History",
  "Geography",
  "Computer Science",
  "Economics",
  "Psychology",
  "Foreign Languages (e.g., Spanish, French, Mandarin)",
  "Sociology",
];

const TutorFilter = () => {
  return (
    <>
      <div className="mb-3 py-1 max-w-full">
        <h3 className="mb-3 font-semibold">Search by name</h3>
        <div className="flex w-full max-w-sm items-center space-x-2">
          <Input className="w-5/6" type="text" placeholder="Search by name" />
          <Button className="w-1/6">
            <Search />
          </Button>
        </div>
      </div>
      <Separator className="w-full mb-3" />
      <div className="flex flex-col gap-2">
        <h3 className="mb-3 font-semibold">Filter by Subject</h3>
        {academicSubjects.map((subject) => (
          <div key={subject}>
            <Checkbox className="mr-2" />
            <Label>{subject}</Label>
          </div>
        ))}
      </div>
    </>
  );
};

export default TutorFilter;
