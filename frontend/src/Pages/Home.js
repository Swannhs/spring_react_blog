import React, {Component} from 'react';
import axios from "axios";
import Posts from "../Components/Posts";
import Layout from "../Components/Layout";

class Home extends Component {
    state = {
        data: []
    }
    onApiCall = () => {
        axios.get('http://localhost:8080/api/v1/post')
            .then(response => {
                this.setState({
                    data: response.data.data
                })
            })
    }

    componentDidMount() {
        this.onApiCall();
    }

    render() {
        return (
            <Layout>
                {
                    this.state.data.map(post => {
                        return <Posts id={post.postId} title={post.title} content={post.content} createdAt={post.createdAt}/>
                    })
                }
            </Layout>
        );
    }
}

export default Home;