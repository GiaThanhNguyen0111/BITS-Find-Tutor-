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

}

export type AvailableTime = {

}

export type Tutor =  {
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
}