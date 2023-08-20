"use client";
import Logo from '@/components/commons/logo/logo'
import 'material-icons/iconfont/material-icons.css'
import {useState} from "react";

export default function Login() {
  const [emailId, setEmailId] = useState('');
  const [password, setPassword] = useState('');

  const handleInputChange = (e) => {
    setEmailId(e.target.value);
  };
  const handleInputChange2 = (e) => {
    setPassword(e.target.value);
  };
  const handleSubmit = async (e) => {
    e.preventDefault();

    try {
      const response = await fetch('http://localhost:8080/api/authenticate', {
        method: 'POST',
        headers: {
          'Content-Type': 'application/json',
        },
        body: JSON.stringify({emailId,password}),
      });

      if (response.ok) {

      } else {
        // 로그인 실패
      }
    } catch (error) {
      console.error('Error:', error);
    }
  };

  return (
      <div className='app login-page'>
        <div className='flex flex-col w-4/5 lg:w-3/5 xl:w-3/5 2xl:w-1/5 h-full m-auto justify-center align-middle'>
          <main className='w-4/5 m-auto'>
            <Logo href='/login'/>
            <form className='mt-16' action='' onSubmit={handleSubmit}>
              <div className='flex flex-col'>
                <label htmlFor='emailId'>이메일 주소</label>
                <input className='h-11 p-2 border-2 focus:outline-none focus:border-blue-600 focus:ring-blue-600 focus:ring-1 rounded border-solid border-inherit' type='text' id='emailId' name='emailId' value={emailId} onChange={handleInputChange}/>
              </div>
              <div className='flex flex-col mt-2'>
                <label htmlFor='password'>비밀번호</label>
                <input className='h-11 p-2 border-2 focus:outline-none focus:border-blue-600 focus:ring-blue-600 focus:ring-1 rounded border-solid border-inherit' type='password' id='password' value={password} name='password' onChange={handleInputChange2}/>
              </div>
              <div className='flex flex-col mt-6'>
                <button type='submit' className="flex h-11 justify-center bg-blue-600 hover:bg-blue-700 text-white font-bold py-2 px-4 items-center">
                  <span className="material-icons-outlined pr-2.5">login</span>
                  <span>로그인</span>
                </button>
              </div>
            </form>
          </main>
        </div>
      </div>
  )
}
