import React from 'react';

class Login extends React.Component {
  render() {
    console.log("Login!");
    return (
      <div className="modal fade" id="myModal" role="dialog">
        <div className="modal-dialog modal-sm">
          <div className="modal-content">
            <div className="modal-header">
              <button type="button" className="close" data-dismiss="modal">&times;</button>
              <h4 className="modal-title">Log In</h4>
            </div>
            <div className="modal-body">
              <div>
                <p><label>email</label> <input className="form-control" type="email" name="email"/></p>
                <p><label>password</label> <input className="form-control" type="password" name="password"/></p>
                <br/>
                <button className="btn btn-primary" type="submit">Log-in</button>

                <button className="btn btn-default">Find Password</button>
                <button className="btn btn-default">Sign in</button>
              </div>
            </div>
            <div className="modal-footer">
              <button type="button" className="btn btn-link" data-dismiss="modal">Close</button>
            </div>
          </div>

        </div>
      </div>
    );
  }
}

export default Login;