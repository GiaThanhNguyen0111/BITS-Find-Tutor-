import { JwtPayload } from "jwt-decode";

export interface MyJWT extends JwtPayload {
  role: "student" | "tutor" | "admin" | null;
}

export type Subject = {
  subject_id: string;
  subject_name: string;
  subject_description: string;
};

export type Qualification = {
  qualifi_id: string;
  qualifi_name: string;
  qualifi_description: string;
  qualifi_image: string;
};

export type AvailableTime = {};

export type Tutor = {
  tutor_id: string;
  full_name: string;
  dob: Date;
  email: string;
  major: string;
  password: string;
  image: string;
  role: string;
  qualification: Qualification[];
  availableTime: AvailableTime[];
};
