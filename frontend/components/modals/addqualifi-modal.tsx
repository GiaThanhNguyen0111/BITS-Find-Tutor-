import React from "react";
import { Input } from "@/components/ui/input";
import { useModal } from "@/hooks/useModal";
import {
  Dialog,
  DialogContent,
  DialogTitle,
  DialogHeader,
  DialogFooter,
  DialogDescription,
} from "@/components/ui/dialog";
import { Button } from "@/components/ui/button";
import {
  Form,
  FormControl,
  FormField,
  FormItem,
  FormLabel,
  FormMessage,
} from "@/components/ui/form";
import * as z from "zod";
import { zodResolver } from "@hookform/resolvers/zod";
import { useForm } from "react-hook-form";

const FormSchema = z.object({
  qualifi_name: z.string({
    required_error: "Please select an subject to add",
  }),
  qualifi_description: z.string(),
  image: z.string({
    required_error: "Must have an image",
  }),
});

export const AddQualificationModal = () => {
  const { isOpen, onClose, type } = useModal();
  const isModalOpen = isOpen && type === "addqualifi";

  const form = useForm<z.infer<typeof FormSchema>>({
    resolver: zodResolver(FormSchema),
  });
  return (
    <Dialog open={isModalOpen} onOpenChange={onClose}>
      <DialogContent>
        <DialogHeader>
          <DialogTitle className="text-center uppercase font-bold pb-2">
            Add qualification
          </DialogTitle>
        </DialogHeader>
        <Form {...form}>
          <form className="space-y-8">
            <div className="space-y-8">
              <FormField
                control={form.control}
                name="qualifi_name"
                render={({ field }) => (
                  <FormItem>
                    <FormLabel className="uppercase text-sm font-semibold">
                      Qualification Name
                    </FormLabel>
                    <FormControl>
                      <Input
                        type="text"
                        className="bg-white border-2 focus:border-zinc-500 focus:ring-1
                        focus-visible:ring-0 text-black focus-visible:ring-offset-0"
                        placeholder="Enter your qualification name"
                        {...field}
                      />
                    </FormControl>
                    <FormMessage />
                  </FormItem>
                )}
              />

              <FormField
                control={form.control}
                name="qualifi_name"
                render={({ field }) => (
                  <FormItem>
                    <FormLabel className="uppercase text-sm font-semibold">
                      Qualification Description
                    </FormLabel>
                    <FormControl>
                      <Input
                        type="text"
                        className="bg-white border-2 focus:border-zinc-500 focus:ring-1
                        focus-visible:ring-0 text-black focus-visible:ring-offset-0"
                        placeholder="Enter your qualification description"
                        {...field}
                      />
                    </FormControl>
                    <FormMessage />
                  </FormItem>
                )}
              />

              <FormField
                control={form.control}
                name="image"
                render={({ field }) => (
                  <FormItem>
                    <FormLabel className="uppercase text-sm font-semibold">
                      Image
                    </FormLabel>
                    <FormControl>
                      <Input
                        type="file"
                        className="bg-white border-2 focus:border-zinc-500 focus:ring-1 focus-visible:ring-0 text-black focus-visible:ring-offset-0 cursor-pointer"
                        {...field}
                      />
                    </FormControl>
                    <FormMessage />
                  </FormItem>
                )}
              />
            </div>

            <DialogFooter>
              <Button
                type="submit"
                className="w-24 bg-gradient-to-r from-[#D0A2F7] to-[#BE9FE1] border-none"
              >
                Save
              </Button>
            </DialogFooter>
          </form>
        </Form>
      </DialogContent>
    </Dialog>
  );
};
