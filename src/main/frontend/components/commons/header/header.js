import Image from "next/image";

export default function header() {
  return (
      <header className="mx-auto max-w-3xl px-2 sm:px-6 lg:px-8">
        <h1 className="flex h-16 items-center">
          <a href="/">
            <Image
                src="/vercel.svg" // 로고 임시로 사용
                alt={'logo'}
                width={100}
                height={24}
                priority
            />
          </a>
        </h1>
      </header>
  )
}
