import React from 'react';

const Posts = ({id, title, content, createdAt}) => {
    return (
        <div className="card text-center">
            <div className="card-body" key={id}>
                <h5 className="card-title">{title}</h5>
                <p className="card-text">{content}</p>
                <div className="card-footer text-muted">
                    {createdAt}
                </div>
            </div>
        </div>
    );
};

export default Posts;