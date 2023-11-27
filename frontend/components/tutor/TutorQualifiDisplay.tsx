import React from 'react'
import Image from 'next/image'
import {
  Card,
  CardContent,
  CardDescription,
  CardFooter,
  CardHeader,

} from "@/components/ui/card"

export const TutorQualifiDisplay = () => {
  return (
    <div className="grid grid-cols-3 w-full py-4 gap-6">

      <Card className='w-full border-2 shadow-md hover:scale-105 duration-500 transition'>

        <CardHeader><div className='h-40 w-full relative'><Image src="/find_tutor_cover.jpg" alt="pic" fill /></div></CardHeader>

        <CardContent><p className="text-center font-bold">Something</p></CardContent>
      </Card>



      <Card className='w-full border-2 shadow-md hover:scale-105 duration-500 transition'>

        <CardHeader><div className='h-40 w-full relative'><Image src="/find_tutor_cover.jpg" alt="pic" fill /></div></CardHeader>

        <CardContent><p className="text-center font-bold">Something</p></CardContent>
      </Card>



      <Card className='w-full border-2 shadow-md'>

        <CardHeader><div className='h-40 w-full relative'><Image src="/find_tutor_cover.jpg" alt="pic" fill /></div></CardHeader>

        <CardContent><p className="text-center font-bold">Something</p></CardContent>
      </Card>



      <Card className='w-full border-2 shadow-md hover:scale-105 transition'>

        <CardHeader><div className='h-40 w-full relative'><Image src="/find_tutor_cover.jpg" alt="pic" fill /></div></CardHeader>

        <CardContent><p className="text-center font-bold">Something</p></CardContent>
      </Card>

      <Card className='w-full border-2 shadow-md'>

        <CardHeader><div className='h-40 w-full relative'><Image src="/find_tutor_cover.jpg" alt="pic" fill /></div></CardHeader>

        <CardContent><p className="text-center font-bold">Something</p></CardContent>
      </Card>

      <Card className='w-full border-2 shadow-md'>

        <CardHeader><div className='h-40 w-full relative'><Image src="/find_tutor_cover.jpg" alt="pic" fill /></div></CardHeader>

        <CardContent><p className="text-center font-bold">Something</p></CardContent>
      </Card>

      <Card className='w-full border-2 shadow-md'>

        <CardHeader><div className='h-40 w-full relative'><Image src="/find_tutor_cover.jpg" alt="pic" fill /></div></CardHeader>

        <CardContent><p className="text-center font-bold">Something</p></CardContent>
      </Card>
    </div>
  )
}
