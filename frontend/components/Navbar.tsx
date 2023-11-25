"use client";

import {
  NavigationMenu,
  NavigationMenuContent,
  NavigationMenuIndicator,
  NavigationMenuItem,
  NavigationMenuLink,
  NavigationMenuList,
  NavigationMenuTrigger,
  NavigationMenuViewport,
} from "@/components/ui/navigation-menu";
import { Button } from "@/components/ui/button";
import Link from "next/link";

import { Avatar, AvatarFallback, AvatarImage } from "@/components/ui/avatar";
import { useAuth } from "@/hooks/useAuth";
import { useModal } from "@/hooks/useModal";
import { useEffect, useState } from "react";
import { useRouter } from "next/navigation";

const Navbar = () => {
  const { role } = useAuth();
  const { onOpen } = useModal();
  const router = useRouter();
  const [mounted, setMounted] = useState(false);
  useEffect(() => {
    setMounted(true);
  });

  if (!mounted) {
    return "";
  }

  const studentNavigation = [
    { label: "Find a tutor", url: "/student/findtutor" },
    { label: "Your schedule", url: "/student/schedule" },
  ];

  const tutorNavigation = [
    { label: "Tutor profile", url: "/tutor/tutorprofile" },
    { label: "tutor 2", url: "/path2" },
    { label: "tutor 3", url: "/path3" },
  ];

  return (
    <nav className="flex justify-between items-center max-w-4xl mx-auto py-5 h-[70px]">
      <div className="text-2xl font-bold uppercase">
        <Link href={"/"}>Tutoria</Link>
      </div>
      {!!role && role === "student" && (
        <NavigationMenu>
          <NavigationMenuList className="flex gap-16">
            {studentNavigation.map((navigation) => (
              <NavigationMenuItem
                key={navigation.label}
                className="cursor-pointer"
                onClick={() => {
                  router.push(navigation.url);
                }}
              >
                {navigation.label}
              </NavigationMenuItem>
            ))}
          </NavigationMenuList>
        </NavigationMenu>
      )}

      {!!role && role === "tutor" && (
        <NavigationMenu>
          <NavigationMenuList className="flex gap-16">
            {tutorNavigation.map((navigation) => (
              <NavigationMenuItem className="cursor-pointer"
                key={navigation.label}
                onClick={() => {router.push(navigation.url)}}
              >
                {navigation.label}
              </NavigationMenuItem>
            ))}
          </NavigationMenuList>
        </NavigationMenu>
      )}

      <div>
        {!!role && (
          <Avatar onClick={() => onOpen("profile")} className="cursor-pointer">
            <AvatarImage src="https://github.com/shadcn.png" />
            <AvatarFallback>CN</AvatarFallback>
          </Avatar>
        )}
        {!role && (
          <div className="flex justify-center gap-5 ">
            <Button
              onClick={() => onOpen("login")}
              className="bg-transparent w-24 text-emerald-500 hover:bg-transparent"
            >
              Login
            </Button>
            <Button
              onClick={() => onOpen("register")}
              className="bg-emerald-500 w-24"
            >
              Register
            </Button>
          </div>
        )}
      </div>
    </nav>
  );
};

export default Navbar;
