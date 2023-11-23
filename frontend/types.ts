import { JwtPayload } from "jwt-decode";

export interface MyJWT extends JwtPayload {
  role: "student" | "tutor" | "admin" | null;
}

export type Subject = {
  subject_id: string;
  subject_name: string;
  subject_description: string;
};