import './globals.css'
import {Inter} from 'next/font/google'

const inter = Inter({subsets: ['latin']})

export const metadata = {
  title: '메신저', description: '메신저 프로젝트',
}

export default function RootLayout({children}) {
  return (
      <html lang="ko">
      <body className={inter.className}>
        {children}
      </body>
      </html>
  )
}
