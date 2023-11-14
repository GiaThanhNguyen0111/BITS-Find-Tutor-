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

import { Avatar, AvatarFallback, AvatarImage } from "@/components/ui/avatar";

const Navbar = () => {
  return (
    <nav className="flex justify-between items-center max-w-3xl mx-auto py-5 h-[70px]">
      <div className="text-2xl font-bold uppercase">Logo</div>
      <NavigationMenu>
        <NavigationMenuList className="flex gap-16">
          <NavigationMenuItem>Hello</NavigationMenuItem>
          <NavigationMenuItem>Hello</NavigationMenuItem>
          <NavigationMenuItem>Hello</NavigationMenuItem>
        </NavigationMenuList>
      </NavigationMenu>
      <div>
        <Avatar>
          <AvatarImage src="https://github.com/shadcn.png" />
          <AvatarFallback>CN</AvatarFallback>
        </Avatar>
      </div>
    </nav>
  );
};

export default Navbar;
