import {
  Dialog,
  DialogContent,
  DialogTitle,
  DialogHeader,
  DialogFooter,
  DialogDescription,
} from "@/components/ui/dialog";
import { useModal } from "@/hooks/useModal";
import { Avatar, AvatarImage, AvatarFallback } from "@/components/ui/avatar";
import { Button } from "@/components/ui/button";
import { useAuth } from "@/hooks/useAuth";
import { useRouter } from "next/navigation";

const ProfileModal = () => {
  const { isOpen, onClose, type } = useModal();
  const { logout } = useAuth();
  const router = useRouter();
  const isModalOpen = isOpen && type === "profile";
  const handleLogOut = () => {
    logout();
    router.push("/");
    onClose();
  };
  return (
    <Dialog open={isModalOpen} onOpenChange={onClose}>
      <DialogContent>
        <DialogHeader>
          <DialogTitle className="text-3xl text-center font-bold">
            Profile
          </DialogTitle>
        </DialogHeader>
        <div className="flex flex-col items-center gap-5 ">
          <Avatar className="h-24 w-24">
            <AvatarImage src="https://github.com/shadcn.png" />
            <AvatarFallback>CN</AvatarFallback>
          </Avatar>
          <Button onClick={handleLogOut}>Logout</Button>
        </div>
      </DialogContent>
    </Dialog>
  );
};

export default ProfileModal;
