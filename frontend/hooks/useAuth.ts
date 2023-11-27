import { create } from "zustand";
import { persist } from "zustand/middleware";

type RoleType = "student" | "tutor" | "admin" | null;

interface AuthState {
  role: RoleType;
  accessToken: string | null;
  login: (role: RoleType, accessToken: string | null) => void;
  logout: () => void;
}

export const useAuth = create<AuthState>()(
  persist(
    (set) => ({
      role: null,
      accessToken: null,
      login: (role, accessToken) => set({ role, accessToken }),
      logout: () => set({ role: null, accessToken: null }),
    }),
    { name: "authStore" }
  )
);
