import React from 'react';
import { Link } from 'react-router-dom';
import './userCard.css';
import UserAction from '../../modules/UserAction/UserAction';
import { IoSettings } from 'react-icons/lib/io';
import { FaHome } from 'react-icons/lib/fa';

class UserCard extends React.Component {
  render() {
    const { firstName, lastName } = this.props;

    return (
      <div className="UserCard">
        <div className="UserCard__container">
          <div className="UserCard__container__img">
            asdsa
          </div>
        </div>
        <div className="UserCard__container UserCard__container--name">
          <div className="UserCard__container__name">
            {firstName} {lastName}
          </div>
        </div>
        <div className="UserCard__container UserCard__container--menu">
          <div className="UserCard__container--menu__content">
            
            <Link to="/my-houses"><UserAction icon={<FaHome />} action="Houses" /></Link>
            <Link id="active" to="/user"><UserAction id="active" icon={<IoSettings />} action="Settings" /></Link>

          </div>
        </div>
      </div>
    );
  }
}

export default UserCard;