import axios from "axios";
import {GET_POSTS} from "./Types";

export const getPosts = () => async dispatch => {
    const response = await axios.get('http://localhost:8080/api/v1/post');
    dispatch({
        type: GET_POSTS,
        payload: response.data.data
    })
}