import React from 'react';
import './DisplayMenu.css';
import { FaPlusSquareO, FaBars, FaSearch } from 'react-icons/lib/fa';
import { IoGrid } from 'react-icons/lib/io';
// import FormControl from '../../common/FormControl/FormControl';

class DisplayMenu extends React.Component {

  render() {
    const {handleAddClick, handleGridClick, handleBarsClick} = this.props;
    
    return (
      <div className="DisplayMenu">
        <div className="DisplayMenu__add">
          <button onClick={handleAddClick}><FaPlusSquareO size={30} /></button>
        </div>
        <div className="DisplayMenu__right">
          <div className="DisplayMenu__right__search">
            <label><FaSearch size={20} color="rgba(149, 165, 166,1.0)"/></label>
            <input placeholder="Search item" />
          </div>
          <div className="DisplayMenu__right__type">
            <button onClick={handleGridClick}><IoGrid size={30} /></button>
            <button onClick={handleBarsClick}><FaBars size={30} /></button>
          </div>
        </div>

      </div>
    )
  }
}

export default DisplayMenu;