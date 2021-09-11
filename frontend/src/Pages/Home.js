import React, {Component} from 'react';
import Layout from "../Components/Layout";
import {connect} from "react-redux";
import {getPosts} from "../Actions/PostAction";
import PropTypes from 'prop-types';
import Posts from "../Components/Posts";

class Home extends Component {
    componentDidMount() {
        this.props.getPosts();
    }

    render() {
        const posts = this.props.posts.posts;
        return (
            <Layout>
                {
                    posts.map(post => {
                        return <Posts id={post.postId} title={post.title} content={post.content}
                                      createdAt={post.createdAt}/>
                    })
                }
            </Layout>
        );
    }
}

Home.propsTypes = {
    posts: PropTypes.object.isRequired,
    getPosts: PropTypes.func.isRequired
}

const mapStateToProps = state => ({
    posts: state.posts
})

export default connect(
    mapStateToProps,
    {getPosts}
)(Home);