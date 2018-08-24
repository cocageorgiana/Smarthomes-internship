import React from 'react';
import './FormControl.css';

class FormControl extends React.Component {

  render() {
    const {label , name, value, type, placeholder, onChange} = this.props;

    return (
      <div className="form-container">
        <div className="form-label">
          <label>{label}</label>
        </div>
        <div className="form-input">
          <input name={name} type={type} value={value} placeholder={placeholder} onChange={onChange} />
        </div>
      </div>
    )
  }
}

export default FormControl;