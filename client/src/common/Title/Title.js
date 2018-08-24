import React from 'react';
import './Title.css';

class Title extends React.Component {

  render() {
    const {text} = this.props;

    return (
      <div className="title">
        <h1>{text}</h1>
      </div>
    )
  }

}

export default Title;