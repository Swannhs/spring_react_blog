import React from 'react';
import Navbar from "./Navbar";
import Footer from "./Footer";

const Layout = props => {
    return (
        <>
            <Navbar/>
            <div className='p-4'>
                {props.children}
                <Footer/>
            </div>
        </>
    );
};

export default Layout;