import React from 'react';
import { Redirect } from 'react-router-dom';
import UserCard from '../../common/userCard/userCard';
import { getUser } from '../../services/users';
import './userSettings.css';
import Button from '../../common/Button/Button';
import FormControl from '../../common/FormControl/FormControl';
import Title from '../../common/Title/Title';

class userSettings extends React.Component {
  constructor(props) {
    super(props);

    this.state = {
      name: '',
      email: '',
      oldPassword: '',
      newPassword: '',
      newPassword2: '',
      user: {},
      isLogged: false
    }
  }

  handleSubmitInfo = (event) => {
    event.preventDefault();
    if (this.state.name.length === 0) {
      console.log("Fill name");
    } else if (this.state.email.length === 0) {
      console.log("Fill email");
    } else {
      console.log(`User: ${this.state.name}, email: ${this.state.email}`);
    }
  }

  handleSubmitPassword = (event) => {
    event.preventDefault();
    if (this.state.oldPassword.length === 0) {
      console.log("Fill old password");
    } else if (this.state.newPassword.length === 0) {
      console.log("Fill new password");
    } else if (this.state.newPassword2.length === 0) {
        console.log("Re-enter new password");
      } else if (this.state.oldPassword === this.state.newPassword) {
        console.log("New password must be different from old password");
      } else if ( this.state.newPassword !== this.state.newPassword2) {
        console.log ("Passwords don't match");
      } else {
      console.log(`Old password: ${this.state.oldPassword}, new passwords: 1) ${this.state.newPassword} 2) ${this.state.newPassword2} `);
    }
  }

  onInputChange = (event) => {
    this.setState({
      [event.target.name]: event.target.value
    });
  }

  componentWillMount() {
    console.log(localStorage.getItem("username"));
    if (!localStorage.getItem("isAuth")) {
      this.setState({
        isLogged: true
      })
    }
  }

  componentDidMount() {
    getUser(localStorage.getItem("username")).then((response) => {
      this.setState({ user:  response.user }, function() {
        console.log(this.state);
      });
      // console.log(`Response :${response}`);
    });
    console.log(`User: ${Object.keys(this.state.user)}`);
  }

  render() {
    const { isLogged, user } = this.state;
    const { firstName, lastName } = user;

    return (

      <div className="UserSettings">
        {isLogged && <Redirect to="/login" />}
        <div className="UserSettings__details">
          {/* {this.state.user.map(function (user, index) {
            return <UserCard key={index} user={user} />
          })} */}
          <UserCard firstName={firstName} lastName={lastName} />
        </div>
        <div className="UserSettings__forms">
          <div className="UserSettings__forms__form">
            <div className="UserSettings__forms__form__title">
              <Title text="Change info" />
            </div>
            <form onSubmit={this.handleSubmitInfo} >
              <div className="grid-container">
                <div className="grid-item">
                  <FormControl onChange={this.onInputChange} label="Name" name="name" type="text" value={this.state.name} placeholder="John Smith" />
                </div>
                <div className="grid-item">
                  <FormControl onChange={this.onInputChange} label="Email" name="email" type="email" value={this.state.email} placeholder="something@example.com" />
                </div>
              </div>

              <div className="btn-container">
                <Button name="Save changes" />
              </div>
            </form>
          </div>
          <hr />
          <div className="UserSettings__forms__form">
            <div className="UserSettings__forms__form__title">
              <Title text="Change password" />
            </div>
            <form onSubmit={this.handleSubmitPassword} >
              <FormControl label="Old password" name="oldPassword" type="password"
                onChange={this.onInputChange}
                value={this.state.oldPassword} placeholder="Old passowrd" />
              <FormControl label="New password" name="newPassword" type="password"
                onChange={this.onInputChange}
                value={this.state.newPassword} placeholder="New password" />
              <FormControl label="Re-enter password" name="newPassword2" type="password"
                onChange={this.onInputChange}
                value={this.state.newPassword2} placeholder="Re-enter new password" />

              <div className="btn-container">
                <Button name="Save password" />
              </div>
            </form>


          </div>
        </div>

      </div>
    );
  }
}

export default userSettings;