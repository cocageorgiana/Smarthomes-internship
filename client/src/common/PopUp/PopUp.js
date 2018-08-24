import React from 'react';
import './PopUp.css';

class PopUp extends React.Component {
  render() {
    return (
      <div className="PopUp">
        <div className="PopUp__content">
          <div className="PopUp__content__close" onClick={this.props.onCloseClick}>
            X
          </div>
          {this.props.children}

        </div>
      </div>
    )
  }
}

export default PopUp;