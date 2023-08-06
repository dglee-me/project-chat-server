'use client'

import { useEffect } from 'react'
import { redirect } from "next/navigation";

import Header from '@/components/commons/header/header'

export default function Home() {

  // 로그인 되어있지 않을 경우 로그인 페이지로 이동
  useEffect(() => {
    const access_token = window.localStorage.getItem('access_token');
    const refresh_token = window.localStorage.getItem('refresh_token');

    if (!access_token || !refresh_token) {
      return (
          redirect('/login', 'replace')
      )
    }
  }, []);

  return (
      <div>
        <Header/>
      </div>
  )
}
