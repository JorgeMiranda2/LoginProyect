import Link from "next/link";
import LoginForm from "../ui/LoginForm";
import { AuthProvider } from "../lib/Utils/AuthContext";

export default function LoginPage() {
  return (
    <div className="h-screen w-screen flex justify-center items-center bg-slate-100">
      <div className="sm:shadow-xl px-8 pb-8 pt-12 sm:bg-white rounded-xl space-y-12">
        <h1 className="font-bold text-2xl text-center text-gray-800">Login</h1>
        <LoginForm />     
        <p className="text-center text-gray-700">
          Need to create an account?{' '}
          <Link className="text-indigo-500 hover:underline" href="/register">
            Create Account
          </Link>{' '}
        </p>
      </div>
    </div>
  );
}
