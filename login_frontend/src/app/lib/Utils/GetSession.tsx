import { cookies } from "next/headers";
export default function GetSession(){

    const cookieStorage = cookies();
    const token = cookieStorage.get("token")?.value || undefined;
    const username = cookieStorage.get("username")?.value || undefined;
    let isAuth = false;
    if(token && username){
    isAuth = true;
    }

    const auth = {
        isAuth: isAuth,
        token: token,
        username: username  
    }

    return auth;


}

