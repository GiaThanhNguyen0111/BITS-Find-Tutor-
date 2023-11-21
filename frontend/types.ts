import { JwtPayload } from "jwt-decode";

export interface MyJWT extends JwtPayload {
  role: "student" | "tutor" | "admin" | null;
}
