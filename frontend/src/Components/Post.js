import React from 'react';
import {Link} from "react-router-dom";

const Post = ({id, title, content, createdAt}) => {
    return (
        <div className="card text-center">
            <div className="card-body" key={id}>
                <h5 className="card-title">{title}</h5>
                <p className="card-text">{content}</p>
                <Link to={`/${id}`} className="btn btn-primary">Read</Link>
                <div className="card-footer text-muted">
                    {createdAt}
                </div>
            </div>
        </div>
    );
};

export default Post;