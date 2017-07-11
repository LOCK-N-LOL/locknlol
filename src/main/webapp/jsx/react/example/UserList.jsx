import React from 'react';

export default class extends React.Component {
    constructor(props) {
        super(props);

        // binding
        /*
           bind란?
           fun.bind(thisArg, ...args)
           fun의 this 키워드를 thisArg로 설정
           args는 fun의 arguments
           es6에서는 autobinding이 안됨으로 필수(https://facebook.github.io/react/docs/react-without-es6.html#autobinding)
         */
        this.bindFun = this.bindFun.bind(this);

        // 초기 state 설정
        this.state = {}
    }

    componentDidMount() {
        // Ajax 초기 호출은 여기서
    }

    componentWillReceiveProps(newProps) {
        // 부모 컴포넌트의 state 변화로 인해 자식 컴포넌트의 props가 바뀔 때 호출됨
        console.log(newProps.users);
    }

    bindFun() {
        // 예제
    }

    searchUserDetails(user) {
        alert(user);
    }

    render() {
        return (
            <ul>
                {this.props.users.map((user, index) =>
                    <li key={index} onClick={() => this.searchUserDetails(user)}>{user}</li> // Arrow function으로 바인딩
                )}
            </ul>
        );
    }
}