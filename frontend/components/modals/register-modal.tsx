"use client";

import * as z from "zod";
import { zodResolver } from "@hookform/resolvers/zod";
import { useForm } from "react-hook-form";
import axios from "axios";
import {
  Dialog,
  DialogContent,
  DialogHeader,
  DialogTitle,
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
import { Input } from "@/components/ui/input";
import { Button } from "@/components/ui/button";
import { RadioGroup, RadioGroupItem } from "@/components/ui/radio-group";
import { useModal } from "@/hooks/useModal";

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
  role: z.enum(["student", "tutor"], {
    required_error: "You need to select your role",
  }),
});

export const RegisterModal = () => {
  const { isOpen, onClose, type, onOpen } = useModal();
  const isModalOpen = isOpen && type === "register";

  const form = useForm<z.infer<typeof formSchema>>({
    resolver: zodResolver(formSchema),
    defaultValues: {
      email: "",
      password: "",
      role: "student",
    },
  });

  const onSubmit = async (values: z.infer<typeof formSchema>) => {
    const response = await axios.post(
      `${process.env.NEXT_PUBLIC_SERVER_URL}/api/v1/auth/register`,
      { ...values }
    );
    if (response.status === 200) {
      handleChangeToLogin();
      alert("Register successful");
    } else {
      alert("There is a problem registering");
    }
  };

  const handleClose = () => {
    form.reset();
    onClose();
  };
  const handleChangeToLogin = () => {
    onClose();
    onOpen("login");
  };

  return (
    <Dialog open={isModalOpen} onOpenChange={handleClose}>
      <DialogContent>
        <DialogHeader>
          <DialogTitle className="text-3xl text-center font-bold">
            Register
          </DialogTitle>
        </DialogHeader>
        <Form {...form}>
          <form onSubmit={form.handleSubmit(onSubmit)}>
            <div className="space-y-5 px-6 mb-5">
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

              <FormField
                control={form.control}
                name="role"
                render={({ field }) => (
                  <FormItem>
                    <FormLabel className="uppercase text-sm font-semibold">
                      Role
                    </FormLabel>
                    <FormControl>
                      <RadioGroup
                        defaultValue={field.value}
                        onValueChange={field.onChange}
                        className="flex space-x-1"
                      >
                        <FormItem className="flex items-center space-x-3 space-y-0">
                          <FormControl>
                            <RadioGroupItem value="student" />
                          </FormControl>
                          <FormLabel className="font-normal">Student</FormLabel>
                        </FormItem>
                        <FormItem className="flex items-center space-x-3 space-y-0">
                          <FormControl>
                            <RadioGroupItem value="tutor" />
                          </FormControl>
                          <FormLabel className="font-normal">Tutor</FormLabel>
                        </FormItem>
                      </RadioGroup>
                    </FormControl>
                    <FormMessage />
                  </FormItem>
                )}
              />
            </div>
            <DialogDescription
              className="underline text-black cursor-pointer px-6"
              onClick={handleChangeToLogin}
            >
              Already have an account ? Login
            </DialogDescription>
            <DialogFooter>
              <Button className="w-24 bg-emerald-500">Register</Button>
            </DialogFooter>
          </form>
        </Form>
      </DialogContent>
    </Dialog>
  );
};
