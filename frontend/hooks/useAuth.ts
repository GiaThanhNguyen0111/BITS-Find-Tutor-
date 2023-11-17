import { create } from "zustand";

interface AuthState {
  isAuthenticated: boolean;
  role: "student" | "tutor" | "admin" | null;
  accessToken: string | null;
}

export const useAuth = create<AuthState>((set) => ({
  isAuthenticated: false,
  role: null,
  accessToken: null,
}));
