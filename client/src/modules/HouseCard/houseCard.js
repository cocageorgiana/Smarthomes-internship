import React from 'react';
import {Link} from 'react-router-dom';
import './houseCard.css';
import testimg from '../../assets/eroare.png';
import { FaPencil, FaTrash } from 'react-icons/lib/fa';
import { MdDirectionsCar } from 'react-icons/lib/md';

class HouseCard extends React.Component {
  render() {
    const { description, location, url } = this.props;
    return (
      <div className="houseCard">
        <Link to="/house">
        <div className="houseCard__content">
          <div className="houseCard__content__img">
            <img src={testimg} />
          </div>
          <div className="houseCard__content__info">
            <div className="houseCard__content__info__gridContainer">
              <div className="houseCard__content__info__gridContainer__gridItem houseCard__content__info__gridContainer__gridItem--label">
                <label>Description: </label>
              </div>
              <div className="houseCard__content__info__gridContainer__gridItem">
                {description}
              </div>
              <div className="houseCard__content__info__gridContainer__gridItem houseCard__content__info__gridContainer__gridItem--label">
                <label>Location: </label>
              </div>
              
              <div className="houseCard__content__info__gridContainer__gridItem">
                {location}
              </div>
            </div>
          </div>
        </div>
        </Link>


        {/* <div className="houseCard__content">
          <img src={testimg} />
        </div>
        <div className="houseCard__content">
          <div className="houseCard__content__gridContainer">
            <div className="houseCard__content__gridContainer__gridItem 
            houseCard__content__gridContainer__gridItem--label">
              <label> Description: </label>
            </div>
            <div className="houseCard__content__gridContainer__gridItem">
              {description}
            </div>
            <div className="houseCard__content__gridContainer__gridItem 
            houseCard__content__gridContainer__gridItem--label">
              <label>Location:</label>
            </div>
            <div className="houseCard__content__gridContainer__gridItem">
              {location}
            </div>
          </div>
        </div> */}
        <div className="houseCard__menu">
          <button><FaPencil />Modify</button>
          <button><MdDirectionsCar />Navigate</button>
          <button><FaTrash />Delete</button>
        </div>
      </div>
    )
  }
}

export default HouseCard;