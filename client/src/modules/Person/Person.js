import React from 'react';
import './Person.css';
import { FaComments, FaEllipsisV } from 'react-icons/lib/fa';

class Person extends React.Component {
  constructor(props) {
    super(props);

    this.state = {
      messageColor: "rgba(189, 195, 199, 1)",
      expandColor: "rgba(189, 195, 199, 1)"
    }
  }

  hoverMessage = (event) => {
    event.preventDefault();
    this.setState({
      messageColor: "rgba(127, 140, 141,1.0)"
    })
  }

  hoverExpand = (event) => {
    event.preventDefault();
    this.setState({
      expandColor: "rgba(127, 140, 141,1.0)"
    })
  }

  resetMessage = (event) => {
    event.preventDefault();
    this.setState({
      messageColor: "rgba(189, 195, 199, 1)"
    })
  }
  
  resetExpand = (event) => {
    event.preventDefault();
    this.setState({
      expandColor: "rgba(189, 195, 199, 1)"
    })
  }
  render() {
    const { name } = this.props;

    return (
      <div className="Person">
        <div className="Person__left">
          <div className="Person__left__avatar"></div>
          <div className="Person__left__name">{name}</div>
        </div>
        <div className="Person__actions">
          <div className="Person__actions__message" onMouseOver={this.hoverMessage} onMouseLeave={this.resetMessage}>
            <FaComments size={20} color={this.state.messageColor} />
          </div>
          <div className="Person__actions__expand" onMouseOver={this.hoverExpand} onMouseLeave={this.resetExpand}>
            <FaEllipsisV size={20} color={this.state.expandColor} />
          </div>
        </div>
      </div>
    )
  }
}

export default Person;