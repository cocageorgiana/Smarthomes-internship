import React from 'react';
import './Button.css';

class Button extends React.Component {

  render() {
  const { onClickFunction, name , type } = this.props;

    return (
      <div className="button">
        <button className={type} onClick={onClickFunction}>{name}</button>
      </div>
    )
  }
}

export default Button;