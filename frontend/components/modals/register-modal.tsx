"use client";

import * as z from "zod";
import { zodResolver } from "@hookform/resolvers/zod";
import { useForm } from "react-hook-form";
import axios from "axios";
import {
  Dialog,
  DialogContent,
  DialogDescription,
  DialogFooter,
  DialogHeader,
  DialogTitle,
} from "@/components/ui/dialog";
import { useModal } from "@/hooks/useModal";

const formSchema = z.object({
  name: z.string().min(1, { message: "Name is required" }),
  password: z
    .string()
    .min(8, { message: "Password must have the minimum length of 8" }),
});

export const RegisterModal = () => {
  const { isOpen, onClose, type } = useModal();
  const isModalOpen = isOpen && type === "register";

  const form = useForm({
    resolver: zodResolver(formSchema),
  });

  const handleClose = () => {
    form.reset();
    onClose();
  };

  return <Dialog open={isModalOpen} onOpenChange={handleClose}></Dialog>;
};
