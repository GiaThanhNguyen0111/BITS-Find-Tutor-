import { create } from "zustand";

type RoleType = "student" | "tutor" | "admin" | null;

interface AuthState {
  role: RoleType;
  accessToken: string | null;
  login: (role: RoleType, accessToken: string | null) => void;
  logout: () => void;
}

const setCookie = (name: string, value: string | null, hours: number) => {
  if (typeof window !== "undefined") {
    const expires = new Date();
    if (value === null) {
      expires.setTime(expires.getTime() - 1);
    } else {
      expires.setTime(expires.getTime() + hours * 60 * 60 * 1000);
    }
    document.cookie = `${name}=${value};expires=${expires.toUTCString()};path=/`;
  }
};

const getCookie = (name: string) => {
  if (typeof window !== "undefined") {
    const cookieName = `${name}=`;
    const cookies = document.cookie.split(";");
    for (let i = 0; i < cookies.length; i++) {
      let cookie = cookies[i].trim();
      if (cookie.startsWith(cookieName)) {
        return cookie.substring(cookieName.length, cookie.length);
      }
    }
  }
  return null;
};

export const useAuth = create<AuthState>((set) => {
  const storedRole = getCookie("authRole");
  const storedAccessToken = getCookie("authAccessToken");

  const initialState: AuthState = {
    role: storedRole ? (storedRole as RoleType) : "student",
    accessToken: storedAccessToken || null,
    login: (role, accessToken) => {
      set({ role, accessToken });
      setCookie("authRole", role, 2);
      setCookie("authAccessToken", accessToken, 2);
    },
    logout: () => {
      set({ role: null, accessToken: null });
      setCookie("authRole", null, 0);
      setCookie("authAccessToken", null, 0);
    },
  };

  set(initialState);

  return initialState;
});
