import React from 'react';
import ReactDOM from 'react-dom';
import EntityList from './EntityList';
import Login from './member/Login';

const contentElement = document.getElementById('content');
ReactDOM.render(<EntityList />, contentElement);
const loginElement = document.getElementById('login_app');
ReactDOM.render(<Login />, loginElement);