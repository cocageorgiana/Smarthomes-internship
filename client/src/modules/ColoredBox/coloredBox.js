import React from 'react';
import './coloredBox.css';

class ColoredBox extends React.Component {
    render () {
        const { color } = this.props;

        return (
            <div className="ColoredBox" style={{backgroundColor: color}}>
                {color}
            </div>
        );
    }
}

export default ColoredBox;