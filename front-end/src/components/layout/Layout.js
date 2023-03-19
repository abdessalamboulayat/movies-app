import React from "react";
import { Outlet, Route, Routes } from "react-router-dom";
import Home from "../home/Home";

function Layout(){

    return(
        <main>
            <Routes>
                <Route path="/" element={<Home />}/>
            </Routes>
        </main>
    )
}
export default Layout;