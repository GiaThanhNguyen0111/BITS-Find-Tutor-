import { create } from "zustand";

export type RoleType = "student" | "tutor" | "admin" | null;

interface AuthState {
  role: RoleType;
  accessToken: string | null;
  login: (role: RoleType, accessToken: string) => void;
  lougout: () => void;
}

export const useAuth = create<AuthState>((set) => ({
  role: "student",
  accessToken: null,
  login: (role, accessToken) => set({ role, accessToken }),
  lougout: () => set({ role: null, accessToken: null }),
}));
