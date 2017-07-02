import React from 'react';

export default class extends React.Component {
    constructor(props) {
        super(props);

        this.handleChange = this.handleChange.bind(this);
        this.handleSubmit = this.handleSubmit.bind(this);

        this.state = {
            value: ''
        };
    }

    handleChange(e) {
        this.setState({
            value: e.target.value
        });
    }

    handleSubmit(e) {
        if(e.key === "Enter") {
            if(this.state.value.length === 0) {
                return;
            }

            this.props.addToUsers(this.state.value);

            this.setState({
                value: ''
            });
        }
    }

    render() {
        return (
            <input value={this.state.value}
                   onChange={this.handleChange}
                   onKeyPress={this.handleSubmit} />
        );
    }
}