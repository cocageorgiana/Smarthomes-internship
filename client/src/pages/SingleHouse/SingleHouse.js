import React from 'react';
import './SingleHouse.css';
import NewsRow from '../../modules/NewsRow/NewsRow';
// import FormControl from '../../common/FormControl/FormControl';
import Title from '../../common/Title/Title';
import Item from '../../modules/Item/Item';
import PopUp from '../../common/PopUp/PopUp';
import Person from '../../modules/Person/Person';
import DisplayMenu from '../../modules/DisplayMenu/DisplayMenu';
import WeatherCard from '../../modules/WeatherCard/WeatherCard';

import { FaChevronLeft, FaChevronRight, FaCaretLeft, FaCaretRight } from 'react-icons/lib/fa';

class SingleHouse extends React.Component {
  constructor(props) {
    super(props);

    this.state = {
      left: true,
      right: false,
      temperature: 10,
      displayPopUp: false,
      stylePeople: {
        right: -300
      },
      styleDrag: {
        right: -20
      },
      scrollsCount: 0,
      maxScrolls: 10,
      group: {
        name: 'Cei 7 pitici',
        admin: 'Tyler 1',
        members: [
          {
            name: 'ASOFIJ'
          },
          {
            name: 'SERJ'
          }
        ]
      }
    }
  }


  handleAddClick = (event) => {
    event.preventDefault();
    this.setState({
      displayPopUp: true
    })
  }

  expandPeople = (event) => {
    event.preventDefault();

    this.setState((prevState) => {
      if (prevState.stylePeople.right === 0 && prevState.styleDrag.right === 280) {
        return {

          right: false,
          left: true,
          stylePeople: {
            right: -300
          },
          styleDrag: {
            right: -20
          }
        }
      } else {
        return {
          right: true,
          left: false,

          stylePeople: {
            right: 0
          },
          styleDrag: {
            right: 280
          }
        }
      }

    })

  }
  onCloseClick = (event) => {
    event.preventDefault();

    this.setState({
      displayPopUp: false
    })
  }

  scrollLeft = () => {
    this.setState((prevState) => {
      if (prevState.scrollsCount === 0) {
        return { scrollsCount: 0 }
      } else {
        let prevScrolls = prevState.scrollsCount + 1;
        return { scrollsCount: prevScrolls }
      }
    })
    console.log(this.state.scrollsCount);
  }

  scrollRight = () => {
    this.setState((prevState) => {
      if (prevState.scrollsCount === -((this.state.maxScrolls) / 2)) {
        return { scrollsCount: -((this.state.maxScrolls) / 2) }
      } else {
        let prevScrolls = prevState.scrollsCount - 1;
        return { scrollsCount: prevScrolls }
      }

    })
    console.log(this.state.scrollsCount);
  }

  render() {
    const { displayPopUp, left, right } = this.state;

    return (
      <div className="singleHouse">
        {displayPopUp && <PopUp onCloseClick={this.onCloseClick}>
          SADASD
        </PopUp>}

        <div onClick={this.expandPeople} style={this.state.styleDrag} className="singleHouse__dragPeopleContainer">
          {left && <FaCaretLeft size={30} />}
          {right && <FaCaretRight size={30} />}
        </div>
        <div className="singleHouse__people" style={this.state.stylePeople}>
          <div className="singleHouse__people__administrator">
            <h3>Administrator</h3>
            <Person name="Tyler 1" />
          </div>
          <hr />
          <div className="singleHouse__people__title">
            <h4>Members</h4>
          </div>
          <div className="singleHouse__people__members">
            <Person name="Gicu" />
            <Person name="Ion" />
            <Person name="Dan" />
            <Person name="Lulu" />
            <Person name="Gicu" />
            <Person name="Ion" />
            <Person name="Dan" />
            <Person name="Lulu" />
          </div>

        </div>

        <div className="singleHouse__headerRow">
          <div className="singleHouse__headerRow__img">

          </div>
          <div className="singleHouse__headerRow__description">

            <div className="singleHouse__headerRow__description__title">
              <Title text={this.state.group.name} />
              <h3>Administrator: {this.state.group.admin}</h3>
            </div>
          </div>
          <div className="singleHouse__headerRow__weather">
            <WeatherCard location="Location" minTemp={10} maxTemp={20} date="12.12.1221" />
          </div>
        </div>

        <hr />

        <div className="singleHouse__itemsRow">
          <DisplayMenu handleAddClick={this.handleAddClick} 
            handleGridClick={this.handleGridClick} 
            handleBarsClick={this.handleBarsClick}/>
          <div className="singleHouse__itemsRow__items">
            <div className="singleHouse__itemsRow__items__container">

              <Item />
              <Item />
              <Item />
              <Item />
              <Item />
              <Item />
              <Item />
              <Item />
              <Item />
              <Item />
              <Item />
              <Item />
              <Item />
              <Item />
              <Item />
              <Item />
              <Item />
              <Item />
              <Item />
              <Item />
              <Item />
              <Item />
              <Item />
              <Item />
              <Item />
              <Item />
              <Item />
              <Item />
              <Item />
              <Item />
              <Item />
              <Item />
              <Item />
              <Item />
              <Item />
              <Item />
              <Item />
              <Item />
              <Item />
              <Item />
              <Item />
              <Item />
              <Item />
              <Item />
              <Item />
              <Item />
              <Item />
              <Item />
              <Item />
              <Item />

            </div>
          </div>
        </div>

        <hr />

        <div className="singleHouse__statisticsRow">
          <div className="singleHouse__statisticsRow__statistics">
            <h2>Statistics</h2>
          </div>
        </div>

        <hr />

        <div className="singleHouse__newsRow">
          <div className="singleHouse__newsRow__scrollLeft" onClick={this.scrollLeft}>
            <FaChevronLeft size={40} />
          </div>
          <div className="singleHouse__newsRow__news">
            <div className="singleHouse__newsRow__news__content" style={{ left: 151 * this.state.scrollsCount }}>
              <NewsRow title="1" description="jksfhdagsdihgaiguhsdilghfdslkgh" />
              <NewsRow title="2" />
              <NewsRow title="3" />
              <NewsRow title="4" />
              <NewsRow title="5" />
              <NewsRow title="6" />
              <NewsRow title="7" />
              <NewsRow title="8" />
              <NewsRow title="9" />
              <NewsRow title="10" />
            </div>
            {/* <h2>News</h2> */}

          </div>
          <div className="singleHouse__newsRow__scrollRight" onClick={this.scrollRight}>
            <FaChevronRight size={40} />
          </div>

        </div>
      </div>
    )
  }

}

export default SingleHouse;