import React from 'react';
import './TopMenu.css';
import { Link, Redirect } from 'react-router-dom';
import { FaEllipsisV , FaBell } from 'react-icons/lib/fa'; 

class TopMenu extends React.Component {
  constructor(props) {
    super(props);

    this.state = {
      redirect_login: false,
      username: ''
    }
  }

  handleLogOutClick = (event) => {
    event.preventDefault();
    localStorage.clear();

    this.setState({
      redirect_login: true
    })
  }

  renderRedirect = () => {
    if (this.state.redirect_login) {
      return <Redirect to="/login" />
    }
  }

  componentDidMount() {
    this.setState({
      username: localStorage.getItem("username")
    })
  }
  render() {

    return (
      <div className="header">
        <div className="header__left">
          <div className="header__left__content">
            <Link to="/"> Home </Link>

            <Link to="/my-houses"> My houses </Link>
          </div>
        </div>

        <div className="header__right">
          <div className="header__right__content">

            <div className="header__right__content__icon">
              <Link to="/user">
                <FaBell />
              </Link>
            </div>

            <div className="header__right__content__username">
              <span>{this.state.username}</span>
            </div>

            <div className="header__right__content__icon">
              <Link to="/user">
                <FaEllipsisV />
              </Link>
            </div>

            <div className="header__right__content__avatar">
              <div className="img"></div>
            </div>

            <div className="header__right__content__logout">
              <button onClick={this.handleLogOutClick}> Log out </button>
            </div>
            {this.state.redirect_login && this.renderRedirect()}
          </div>
        </div>
      </div>
    );
  }
}

export default TopMenu;