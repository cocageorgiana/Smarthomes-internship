import React from 'react';
import FormControl from '../../common/FormControl/FormControl';
import { FaImage } from 'react-icons/lib/fa';
import './AddGroupForm.css';
import Button from '../../common/Button/Button';

class AddGroupForm extends React.Component {
  constructor(props) {
    super(props);

    this.state = {
      groupName: '',
      location: '',
    }
  }

  handleChange = (event) => {
    this.setState({
      [event.target.name]: event.target.value
    })
  }

  handleSubmit = (event) => {
    event.preventDefault();
    console.log(`Group: ${this.state.groupName}, location: ${this.state.location}`);
  }

  render() {
    return (
      <div className="AddGroupForm">
        <div className="AddGroupForm__container">
          <div className="AddGroupForm__container__content">
            <div className="AddGroupForm__container__content__imgContainer">
              <div className="AddGroupForm__container__content__imgContainer__img">
                <FaImage size={50} color="rgba(44, 62, 80, 0.7)" />
              </div>
              <button>Browse</button>
            </div>
            <div className="AddGroupForm__container__content__form">
              <FormControl label="Group Name" name="groupName" 
                type="text" placeholder="House name" onChange={this.handleChange} />
              <FormControl label="Location" name="location" 
                type="text" placeholder="Location" onChange={this.handleChange} />
              <FormControl label="Location" name="location" 
                type="text" placeholder="Location" onChange={this.handleChange} />
            </div>
            
            <div className="AddGroupForm__container__content__form">
              <FormControl label="sadas" name="groupName" 
                type="text" placeholder="House name" onChange={this.handleChange} />
              <FormControl label="rgereg" name="location" 
                type="text" placeholder="Location" onChange={this.handleChange} />
              <FormControl label="wefrbd" name="location" 
                type="text" placeholder="Location" onChange={this.handleChange} />
            </div>
          </div>
          {/* <div className="AddGroupForm__container__secondRow">
            More form
          </div> */}
          {/* <div className="AddGroupForm__container__content">
            <div className="AddGroupForm__container__content__img">
              <div className="AddGroupForm__container__content__img__container">
                <FaImage size={50} color={"rgba(44, 62, 80, .7)"} />
              </div>
              <button>Browse</button>
            </div>
            <div className="AddGroupForm__container__content__form">
              <form onSubmit={this.handleSubmit}>
                <FormControl label="Group Name" name="groupName" type="text" placeholder="House name" onChange={this.handleChange} />
                <FormControl label="Location" name="location" type="text" placeholder="Location" onChange={this.handleChange} />
                <Button name="Save" />
              </form>
            </div>
          </div>

 */}

        </div>
      </div>
    )
  }
}

export default AddGroupForm;