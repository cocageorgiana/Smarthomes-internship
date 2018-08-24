import React from 'react';
import './UserAction.css';

class UserAction extends React.Component {

  render() {
    const { icon , action , id} = this.props;

    return (
      <div className={`UserAction UserAction--${id}`} >
        <div className="UserAction__icon">
          {icon}
        </div>
        <div className="UserAction__action">
          {action}
        </div>
      </div>
    )
  }

}

export default UserAction;