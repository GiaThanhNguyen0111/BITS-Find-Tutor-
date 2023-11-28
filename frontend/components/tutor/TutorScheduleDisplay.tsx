import React from 'react'
import { Badge, badgeVariants } from '@/components/ui/badge';


export const TutorScheduleDisplay = () => {
    const schedule = {
      Monday: ['7:00 PM - 8:30 PM','9:00 AM - 10:00 AM', '1:00 PM - 3:00 PM', '4:00 PM - 6:00 PM','6:30 PM - 8:00 PM','8:30 PM - 9:30 PM','10:00 PM - 11:30 PM'],
      Tuesday: ['9:00 AM - 10:00 AM', '1:00 PM - 3:00 PM', '4:00 PM - 6:00 PM','6:30 PM - 8:00 PM','8:30 PM - 9:30 PM','10:00 PM - 11:30 PM'],
      Wednesday: ['7:00 PM - 8:30 PM','9:00 AM - 10:00 AM', '1:00 PM - 3:00 PM', '4:00 PM - 6:00 PM','8:30 PM - 9:30 PM','10:00 PM - 11:30 PM'],
      Thursday: ['7:00 PM - 8:30 PM','9:00 AM - 10:00 AM', '1:00 PM - 3:00 PM', '4:00 PM - 6:00 PM','6:30 PM - 8:00 PM','8:30 PM - 9:30 PM','10:00 PM - 11:30 PM'],
      Friday: ['7:00 PM - 8:30 PM','9:00 AM - 10:00 AM', '1:00 PM - 3:00 PM','6:30 PM - 8:00 PM','8:30 PM - 9:30 PM','10:00 PM - 11:30 PM'],
      Saturday: ['7:00 PM - 8:30 PM','9:00 AM - 10:00 AM', '1:00 PM - 3:00 PM', '4:00 PM - 6:00 PM','6:30 PM - 8:00 PM','10:00 PM - 11:30 PM'],
      Sunday: ['7:00 PM - 8:30 PM','9:00 AM - 10:00 AM', '1:00 PM - 3:00 PM', '4:00 PM - 6:00 PM','6:30 PM - 8:00 PM','8:30 PM - 9:30 PM'],
    };
  
    return (
      <table className="table-fixed">
        <thead>
          <tr>
            <th className="text-5xl mt-5 font-semibold text-left">Schedule</th>
          </tr>
        </thead>
        <tbody>
          {Object.entries(schedule).map(([day, timeSlots]) => (
            <tr key={day}>
              <td className="w-1/5 border border-black p-2">{day}</td>
              <td className="w-4/5 border border-black p-2 flex flex-wrap">
                {timeSlots.map((timeSlot, index) => (
                  <Badge
                    key={`${day}-${index}`}
                    variant="default"
                    className={`m-1 cursor-pointer p-2 h-10 ${timeSlot === '+' ? 'w-20' : 'w-15'} hover:scale-105 items-center justify-center`}
                  >
                    {timeSlot}
                  </Badge>
                ))}
                <Badge
                  variant="default"
                  className="m-1 cursor-pointer p-2 h-10 w-15 hover:scale-105 items-center justify-center"
                >
                  +
                </Badge>
              </td>
            </tr>
          ))}
        </tbody>
      </table>
    );
  };