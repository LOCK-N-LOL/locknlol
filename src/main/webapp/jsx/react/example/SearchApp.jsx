import React from 'react';
import ReactDOM from 'react-dom';
import SearchUser from './SearchUser';
import UserList from './UserList';

class SearchApp extends React.Component {
    constructor(props) {
        super(props);

        this.addToUsers = this.addToUsers.bind(this);

        this.state = {
            users: []
        }
    }

    addToUsers(user) {
        let users = this.state.users;

        users.push(user);

        this.setState({
            users: users
        })
    }

    addToUsersBadExample(user) {
        // 배열의 state를 다음과 같이 바꾸지 말자
        this.state.users.push(user);
    }

    render() {
        return (
            <div>
                <SearchUser addToUsers={this.addToUsers}/>
                <UserList users={this.state.users}/>
            </div>
        );
    }
}

const reactExample = document.getElementById('reactExample');
ReactDOM.render(<SearchApp/>, reactExample);