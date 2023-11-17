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

import { Avatar, AvatarFallback, AvatarImage } from "@/components/ui/avatar";
import { useAuth } from "@/hooks/useAuth";
import { useModal } from "@/hooks/useModal";

const Navbar = () => {
  const { role } = useAuth();
  const { onOpen } = useModal();
  return (
    <nav className="flex justify-between items-center max-w-4xl mx-auto py-5 h-[70px]">
      <div className="text-2xl font-bold uppercase">Tutoria</div>
      <NavigationMenu>
        <NavigationMenuList className="flex gap-16">
          <NavigationMenuItem>Hello</NavigationMenuItem>
          <NavigationMenuItem>Hello</NavigationMenuItem>
          <NavigationMenuItem>Hello</NavigationMenuItem>
        </NavigationMenuList>
      </NavigationMenu>
      <div>
        {!!role && (
          <Avatar>
            <AvatarImage src="https://github.com/shadcn.png" />
            <AvatarFallback>CN</AvatarFallback>
          </Avatar>
        )}
        {!role && (
          <div className="flex justify-center gap-5 ">
            <Button onClick={() => onOpen("register")}>Register</Button>
          </div>
        )}
      </div>
    </nav>
  );
};

export default Navbar;
