"use client";

import * as z from "zod";
import { zodResolver } from "@hookform/resolvers/zod";
import { useForm } from "react-hook-form";
import axios from "axios";
import { useModal } from "@/hooks/useModal";
import { useAuth } from "@/hooks/useAuth";

export const LoginModal = async () => {
  const { isOpen, onClose, type } = useModal();
  const isModalOpen = isOpen && type === "register";
};
