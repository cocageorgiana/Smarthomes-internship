import React from 'react';
import { Link } from 'react-router-dom';
import './register.css';
import { register } from '../../services/registerService';
import FormControl from '../../common/FormControl/FormControl';

class Register extends React.Component {
  constructor(props) {
    super(props);

    this.state = {
      user: {
        username: '',
        email: '',
        firstName: '',
        lastName: '',
        password: '',
        password2: '',
      },

      addLink: false,
      registerStatus: '',
      didSubmit: false
    }

    this.handleChange = this.handleChange.bind(this);
    this.handleSubmit = this.handleSubmit.bind(this);
  }

  setAddLink = (value) => {
    this.setState({
      addLink: value,
      didSubmit: true
    })
  }

  setRegisterStatus = (message) => {
    this.setState({
      registerStatus: message
    })
  }

  handleChange(event) {
    const target = event.target;
    const value = target.value;
    const name = target.name;

    // let obj =    Object.assign({}, this.state.user, { username: 'salut' });

    this.setState({
      user: {
        ...this.state.user,
        [name]: value
      }
    })
  }

  handleSubmit(event) {
    event.preventDefault();
    const { username, email, firstName, lastName, password, password2 } = this.state.user;

    if (username.length === 0 || email.length === 0 || firstName.length === 0 || lastName.length === 0
      || password.length === 0 || password2.length === 0) {
      this.setRegisterStatus("Please fill all fields");
      this.setState({
        addLink: false,
        didSubmit: true
      })
      console.log("Please fill all fields");
    } else if (this.state.user.password !== this.state.user.password2) {
      this.setRegisterStatus("Passwords don't match");

      this.setState({
        user: {
          ...this.state.user,
          password: '',
          password2: ''
        },
        addLink: false,
        didSubmit: true
      })

    } else {
      register(this.state.user).then(response => {

        if (response.status === 200) {
          this.setAddLink(true);

        } else {
          this.setAddLink(false);
        }
        this.setRegisterStatus(response.message);
        console.log(response);

      })
    }
  }

  renderAddLink = () => {
    if (this.state.addLink) {
      return <div>Go to <Link to='/login'> login </Link></div>
    }
  }

  renderResponse = () => {
    if (this.state.addLink && this.state.didSubmit) {
      return (
        <div className={`response response--${this.state.addLink}`} style={{ display: 'block' }}>
          {this.state.registerStatus}
          {this.state.addLink && this.renderAddLink()}
        </div>
      )
    } else if (this.state.didSubmit) {
      return (
        <div className={`response response--${this.state.addLink}`} style={{ display: 'block' }}>
          {this.state.registerStatus}
        </div>
      )
    }
  }

  showResponse = () => {
    this.setState({
      responseStyle: {
        ...this.state.responseStyle,
        display: 'block'
      }
    })
  }
  render() {
    const { username, email, password, password2, firstName, lastName } = this.state

    return (
      <div className="register">
        <div className="register__container">
          <h1>Register</h1>
          {this.renderResponse()}
          <form onSubmit={this.handleSubmit}>
            <div className="register__container__form">
              <div className="register__container__form__item">
                <FormControl label="Username" name="username" value={username}
                  placeholder="Username" onChange={this.handleChange} type="text"
                />
              </div>
              <div className="register__container__form__item">
                <FormControl label="Email" name="email" value={email}
                  placeholder="Email" onChange={this.handleChange} type="email"
                />
              </div>
              <div className="register__container__form__item">
                <FormControl label="First Name" name="firstName" value={firstName}
                  placeholder="First name" onChange={this.handleChange} type="text"
                />
              </div>
              <div className="register__container__form__item">
                <FormControl label="Last Name" name="lastName" value={lastName}
                  placeholder="Last name" onChange={this.handleChange} type="text"
                />
              </div>
              <div className="register__container__form__item">
                <FormControl label="Password" name="password" value={password}
                  placeholder="Password" onChange={this.handleChange} type="password"
                />
              </div>
              <div className="register__container__form__item">
                <FormControl label="Re-enter password" name="password2" value={password2}
                  placeholder="Re-enter password" onChange={this.handleChange} type="password"
                />
              </div>
            </div>

            <button id="submit-btn" type="submit" onClick={this.showResponse}>Register</button>
          </form>
          <h6>Go to <Link to="/login">login </Link></h6>
        </div>
      </div>
    );
  }
}

export default Register;