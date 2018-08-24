import React from 'react';
import { Link, Redirect } from 'react-router-dom';
import './login.css';
import { auth } from '../../services/authService';
import FormControl from '../../common/FormControl/FormControl';

class Login extends React.Component {
  constructor(props) {
    super(props);

    this.state = {
      username: '',
      password: '',
      isLogged: false,
      redirect: false,
      loginErr: false
    }

    this.handleChange = this.handleChange.bind(this);
    this.handleSubmit = this.handleSubmit.bind(this);
  }

  setRedirect = () => {
    this.setState({
      redirect: true
    })
  }
  setLoginErr = (message) => {
    this.setState({
      loginErr: message
    })
  }

  handleChange(event) {
    const target = event.target;
    const value = target.value;
    const name = target.name;

    this.setState({
      [name]: value
    });
  }

  renderRedirect = () => {
    if (this.state.redirect) {
      return <Redirect to='/' />
    }
  }
  handleSubmit(event) {
    event.preventDefault();

    const {username , password} = this.state;

    if (username.length === 0 || password.length === 0) {
      console.log("Please fill all fields");
    } else {
      auth(this.state).then(response => {
        console.log(response);
        if (response.status !== 200) {
          this.setLoginErr(response.message);
        } else {
          localStorage.setItem("isAuth", true);
          localStorage.setItem("username", this.state.username);
          this.setRedirect();
        }
      })
    } 
  }

  componentWillMount() {
    if (localStorage.getItem("isAuth")) {
      this.setState({
        isLogged: true
      })
    }
  }
  render() {
    const { username, password } = this.state;

    return (
      <div className="login">
        {this.state.isLogged && <Redirect to="/" />}
        <div className="login__container">
          <h1>Log in</h1>
          {this.state.loginErr}

          <div className="login__container__form">

            <form onSubmit={this.handleSubmit}>
              <div className="login__container__form__fields">
                <FormControl label="Username" name="username" value={username} type="text" placeholder="Username"
                  onChange={this.handleChange} />

                <FormControl label="Password" name="password" value={password} type="password" placeholder="Password"
                  onChange={this.handleChange} />

              </div>
              <button id="submit-btn" type="submit"> Log in </button>

            </form>

          </div>

          <h6>Register <Link to="/register">here </Link></h6>
        </div>
        {this.state.redirect && this.renderRedirect()}
      </div>
    );
  }
}

export default Login;