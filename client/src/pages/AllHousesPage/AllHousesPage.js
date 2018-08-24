import React from 'react';
import { Redirect } from 'react-router-dom';
import './AllHousesPage.css';
import HouseCard from '../../modules/HouseCard/houseCard';
import { FaPlusSquareO } from 'react-icons/lib/fa';
import AddGroupForm from '../../modules/AddGroupForm/AddGroupForm';
import PopUp from '../../common/PopUp/PopUp';


class AHP extends React.Component {
  constructor(props) {
    super(props);

    this.state = {
      displayAdd: false,
      isLogged: false
    }
  }

  onCloseClick = (event) => {
    event.preventDefault();

    this.setState({
      displayAdd: false,
      isLogged: false
    })
  }

  handleAddClick = (event) => {
    event.preventDefault();

    this.setState({
      displayAdd: true
    })

  }
  
  componentWillMount() {
    if(!localStorage.getItem("isAuth")) {
      this.setState({
        isLogged: true
      })
    }
  }

  // componentDidMount() {

  //   window.setTimeout(() => {
  //     console.log(this.props.children);
  //   }, 2000);
  // }

  render() {
    return (
      <div className="housesPage">
        {this.state.isLogged && <Redirect to="/login" />}
        {this.state.displayAdd && <PopUp onCloseClick={this.onCloseClick}>
          <AddGroupForm />
        </PopUp>}
        <div className="housesPage__content">

          <div className="add-house">
            <button onClick={this.handleAddClick}>
              <FaPlusSquareO size={50} color={"rgba(127, 140, 141, .6)"} />
            </button>
          </div>
          <HouseCard description="Big garage" location="port"/>
          <HouseCard description="Main house" location="Str. nr."/>
          <HouseCard description="Holiday house" location="Some location"/>
          <HouseCard description="Deposit" location="port"/>

        </div>
      </div>
    )
  }
}

export default AHP;