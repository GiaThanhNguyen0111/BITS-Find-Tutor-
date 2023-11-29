import React, { useEffect, useState } from "react";
import { format } from "date-fns";
import { motion } from "framer-motion";
import { Badge } from "../ui/badge";

interface Schedule {
  [day: string]: string[];
}

interface FormattedSchedule {
  day: string;
  timeSlots: string[];
}

export const TutorScheduleDisplay: React.FC = () => {
  const schedule: Schedule = {
    Monday: ["7:00 PM - 8:30 PM"],
    Tuesday: ["9:00 AM - 10:00 AM", "8:30 PM - 9:30 PM", "10:00 PM - 11:30 PM", "2:00 PM - 3:30 PM"],
    Wednesday: ["7:00 PM - 8:30 PM", "9:00 AM - 10:00 AM"],
    Thursday: ["1:00 PM - 3:00 PM", "6:30 PM - 8:00 PM", "10:00 PM - 11:30 PM"],
    Friday: ["6:30 PM - 8:00 PM", "8:30 PM - 9:30 PM", "10:00 PM - 11:30 PM"],
    Saturday: ["9:00 AM - 10:00 AM", "1:00 PM - 3:00 PM", "4:00 PM - 6:00 PM"],
    Sunday: ["7:00 PM - 8:30 PM", "1:00 PM - 3:00 PM"],
  };
  const defaultDay = "Monday";
  const [selectedDay, setSelectedDay] = useState<string | null>(defaultDay);
  const [formattedSchedule, setFormattedSchedule] = useState<
    FormattedSchedule[]
  >([]);

  const formatTime = (timeString: string): string => {
    const [time, period] = timeString.split(" ");
    const [hours, minutes] = time.split(":");
    const formattedTime = format(
      new Date(
        1970,
        0,
        1,
        parseInt(hours, 10) + (period === "PM" ? 12 : 0),
        parseInt(minutes, 10)
      ),
      "h:mm a"
    );
    return formattedTime;
  };

  useEffect(() => {
    const newSchedule: FormattedSchedule[] = Object.entries(schedule).map(
      ([day, timeSlots]) => {
        const formattedTimeSlots = timeSlots.map((timeSlot) => {
          const [startTime, endTime] = timeSlot.split(" - ");
          return `${formatTime(startTime)} - ${formatTime(endTime)}`;
        });

        return { day, timeSlots: formattedTimeSlots };
      }
    );

    setFormattedSchedule(newSchedule);
  }, [schedule]);

  return (
    <div className="mt-8 flex flex-col">
      <div className="flex flex-row justify-between mb-5 w-full">
        {Object.keys(schedule).map((day) => (
          <h2
            key={day}
            className={`text-lg font-bold cursor-pointer ${
              selectedDay === day
                ? "border-b-2 border-black"
                : "border-b-2 border-transparent"
            }`}
            onClick={() => setSelectedDay(day)}
          >
            {day}
          </h2>
        ))}
      </div>

      {selectedDay && (
        <motion.div key={selectedDay} className="grid grid-cols-3 gap-5">
          {formattedSchedule
            .find((item) => item.day === selectedDay)
            ?.timeSlots.map((timeSlot, index) => (
              <Badge
                className=" bg-gradient-to-r from-[#D0A2F7] to-[#BE9FE1] text-sm p-2 w-full cursor-autp hover:scale-105 duration-400 transition"
                key={index}
              >
                {timeSlot}
              </Badge>
            ))}
        </motion.div>
      )}
    </div>
  );
};
