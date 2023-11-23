"use client";

import * as z from "zod";
import { zodResolver } from "@hookform/resolvers/zod";
import { useForm } from "react-hook-form";
import axios from "axios";
import { useModal } from "@/hooks/useModal";
import {
  Dialog,
  DialogContent,
  DialogTitle,
  DialogHeader,
  DialogFooter,
  DialogDescription,
} from "@/components/ui/dialog";
import {
  Form,
  FormControl,
  FormField,
  FormItem,
  FormLabel,
  FormMessage,
} from "@/components/ui/form";
import { Button } from "@/components/ui/button";
import { Input } from "@/components/ui/input";
import { jwtDecode } from "jwt-decode";
import { useAuth } from "@/hooks/useAuth";
import { MyJWT } from "@/types";
import { redirect } from "next/navigation";

const formSchema = z.object({
  email: z
    .string()
    .refine(
      (value) =>
        /^[a-zA-Z0-9_!#$%&’*+/=?`{|}~^.-]+@[a-zA-Z0-9.-]+$/.test(value),
      {
        message: "Invalid email format. Please provide a valid email address.",
      }
    ),
  password: z
    .string()
    .refine(
      (value) =>
        /^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=])(?=\S+$).{8,}$/.test(
          value
        ),
      {
        message:
          "Password must be at least 8 characters long and include a mix of uppercase, lowercase, numbers, and special characters.",
      }
    ),
});

export const LoginModal = () => {
  const { isOpen, onClose, type, onOpen } = useModal();
  const { login } = useAuth();
  const isModalOpen = isOpen && type === "login";

  const form = useForm<z.infer<typeof formSchema>>({
    resolver: zodResolver(formSchema),
    defaultValues: {
      email: "",
      password: "",
    },
  });

  const onSubmit = async (values: z.infer<typeof formSchema>) => {
    const response = await axios.post(
      `${process.env.NEXT_PUBLIC_SERVER_URL}/api/v1/auth/authenticate`
    );
    if (response.status == 200) {
      const { data } = response;
      const accessToken = data.access_token;
      const decodedToken = jwtDecode<MyJWT>(accessToken);
      if (decodedToken && decodedToken.role) {
        if (decodedToken.role === "student") {
          login("student", accessToken);
          return redirect("/student/findtutor");
        } else if (decodedToken.role === "tutor") {
          login("tutor", accessToken);
          return redirect("/tutor");
        } else if (decodedToken.role === "admin") {
          login("admin", accessToken);
          return redirect("/admin");
        }
      }
    } else {
      alert("There is a problem logging you in, maybe check your credentials");
    }
  };

  const handleClose = () => {
    form.reset();
    onClose();
  };

  const handleChangeToRegister = () => {
    onClose();
    onOpen("register");
  };

  return (
    <Dialog open={isModalOpen} onOpenChange={handleClose}>
      <DialogContent>
        <DialogHeader>
          <DialogTitle className="text-3xl text-center font-bold">
            Login
          </DialogTitle>
        </DialogHeader>
        <Form {...form}>
          <form onSubmit={form.handleSubmit(onSubmit)} className="space-y-8">
            <div className="space-y-8 px-6">
              <FormField
                control={form.control}
                name="email"
                render={({ field }) => (
                  <FormItem>
                    <FormLabel className="uppercase text-sm font-semibold">
                      Email
                    </FormLabel>
                    <FormControl>
                      <Input
                        type="email"
                        className="bg-zinc-300/50 border-0 focus-visible:ring-0 text-black focus-visible:ring-offset-0"
                        placeholder="Enter your email"
                        {...field}
                      />
                    </FormControl>
                    <FormMessage />
                  </FormItem>
                )}
              />

              <FormField
                control={form.control}
                name="password"
                render={({ field }) => (
                  <FormItem>
                    <FormLabel className="uppercase text-sm font-semibold">
                      Password
                    </FormLabel>
                    <FormControl>
                      <Input
                        type="password"
                        className="bg-zinc-300/50 border-0 focus-visible:ring-0 text-black focus-visible:ring-offset-0"
                        placeholder="Enter your password"
                        {...field}
                      />
                    </FormControl>
                    <FormMessage />
                  </FormItem>
                )}
              />
            </div>
            <DialogDescription
              className="underline text-black cursor-pointer px-6"
              onClick={handleChangeToRegister}
            >
              Do not have an account ? Register
            </DialogDescription>
            <DialogFooter>
              <Button type="submit" className="w-24 bg-emerald-500">
                Login
              </Button>
            </DialogFooter>
          </form>
        </Form>
      </DialogContent>
    </Dialog>
  );
};
