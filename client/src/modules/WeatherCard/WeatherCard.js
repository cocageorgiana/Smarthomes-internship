import React from 'react';
// import Title from '../../common/Title/Title';
import './WeatherCard.css';

class WeatherCard extends React.Component {
  constructor(props) {
    super(props);

    this.state = {
      isCeslsius: false,
    }
  }
  render() {
    const { location, minTemp, maxTemp, date, url } = this.props;

    return (
      <div className="weatherCard">
        <div className="weatherCard__location">
          <h2>{location}</h2>
        </div>
        <div className="weatherCard__info">
          <div className="weatherCard__info__night"></div>

          <div className="weatherCard__info__temperature">
            <div className="weatherCard__info__temperature__min">
              {minTemp}
            </div>
            <hr />
            <div className="weatherCard__info__temperature__max">
              {maxTemp}
            </div>
            <div className="weatherCard__info__temperature__type">
              <div onClick={this.convertToC} className="weatherCard__info__temperature__type__c">C</div>
              <hr />
              <div onClick={this.convertToF} className="weatherCard__info__temperature__type__f">F</div>
            </div>
          </div>
          <div className="weatherCard__info__day"></div>

        </div>
        <div className="weatherCard__footer">
          <div className="weatherCard__footer__date">{date}</div>
          <div className="weatherCard__footer__seeMore"><a href={url} target="_blank">See more</a></div>

        </div>

      </div>
    )
  }
}

export default WeatherCard;