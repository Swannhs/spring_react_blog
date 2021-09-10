import './App.css';
import React from 'react';
import Layout from "./Components/Layout";
import Post from "./Components/Post";

function App() {
    return (
        <div className="App">
            <Layout>
                <Post/>
                <Post/>
                <Post/>
                <Post/>
            </Layout>
        </div>
    );
}

export default App;
