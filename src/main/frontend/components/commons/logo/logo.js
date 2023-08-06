'use client'

import Image from "next/image";
import Link from "next/link";

export default function logo(args) {

  const linkHref = args.href || '/';

  return (
      <h1 className="flex h-16 items-center justify-center m-auto">
        <Link href={linkHref}>
          <p className='text-blue-600 font-bold text-5xl'>C<span className='text-4xl'>HAT</span>!</p>
        </Link>
      </h1>
  )
}
