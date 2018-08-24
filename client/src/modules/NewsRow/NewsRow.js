import React from 'react';
import './NewsRow.css';

class NewsRow extends React.Component {
  render() {
    const { title, description, url } = this.props;

    return (
      <div className="NewsRow">
        <div className="NewsRow__container">
          <div className="NewsRow__container__title">
            <h5>Title: <a href={url} target="_blank">{title}</a></h5>
          </div>

          <div className="NewsRow__container__description">
            <h5>Description: </h5>
            {description}
          </div>


          <div className="NewsRow__container__footer">
            <div className="NewsRow__container__footer__postedBy">
              <h6>Posted by: </h6>
            </div>
            <div className="NewsRow__container__footer__postedAt">
              <h6>Posted at: </h6>
            </div>
          </div>





        </div>
      </div>
    )
  }
}

export default NewsRow;