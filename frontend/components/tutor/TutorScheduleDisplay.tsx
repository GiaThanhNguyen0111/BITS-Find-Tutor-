import React from "react";
import { Badge, badgeVariants } from "@/components/ui/badge";

export const TutorScheduleDisplay = () => {
  const schedule = {
    Monday: [
      "7:00 PM - 8:30 PM",
    ],
    Tuesday: [
      "9:00 AM - 10:00 AM",
      "8:30 PM - 9:30 PM",
      "10:00 PM - 11:30 PM",
    ],
    Wednesday: [
      "7:00 PM - 8:30 PM",
      "9:00 AM - 10:00 AM",
    ],
    Thursday: [
      "1:00 PM - 3:00 PM",
      "6:30 PM - 8:00 PM",
      "10:00 PM - 11:30 PM",
    ],
    Friday: [
      "6:30 PM - 8:00 PM",
      "8:30 PM - 9:30 PM",
      "10:00 PM - 11:30 PM",
    ],
    Saturday: [
      "9:00 AM - 10:00 AM",
      "1:00 PM - 3:00 PM",
      "4:00 PM - 6:00 PM",
    ],
    Sunday: [
      "7:00 PM - 8:30 PM",
      "1:00 PM - 3:00 PM",
    ],
  };

  return (
    <div className="min-w-full">
      <table className="table-fixed my-5 min-w-full">
        <tbody className="">
          {Object.entries(schedule).map(([day, timeSlots]) => (
            <tr key={day} className="w-full">
              <td className={`w-1/5 p-2 border-r border-black font-semibold text-center ${day === "Sunday" ? "" : "border-b "}`}>{day}</td>
              <td className={` w-full p-2 flex-wrap ${day === "Sunday" ? "" : "border-b border-black"}`}>
                {timeSlots.map((timeSlot, index) => (
                  <Badge
                    key={`${day}-${index}`}
                    variant="default"
                    className={`m-1 cursor-pointer p-2 h-10 ${
                      timeSlot === "+" ? "w-20" : ""
                    } bg-gradient-to-r from-[#D0A2F7] to-[#BE9FE1]  hover:scale-105 transition items-center justify-center`}
                  >
                    {timeSlot}
                  </Badge>
                ))}
                <Badge
                  className="m-1 bg-gradient-to-r from-[#D0A2F7] to-[#BE9FE1]  cursor-pointer p-2 h-10 w-16 hover:scale-105 items-center justify-center"
                >
                  +
                </Badge>
              </td>
            </tr>
          ))}
        </tbody>
      </table>
    </div>
  );
};
