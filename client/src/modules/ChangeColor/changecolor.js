import React from 'react';
import './changecolor.css'

class ChangeColor extends React.Component{
    state = {
        colors: ["green" , "blue" , "yellow" , "red"]
    }
    
    // handleClick = () => {
    //     this.setState((prevState) => {
    //         return {

    //         };
    //     });
    //     document.getElementById("ColoredBox").style.background = this.state.colors[1];
    // };
    render() {
        return (
            <div className="Container">
                <button onClick={this.props.onClickFunction}>Change color</button>
            </div>
        );
    }
}

export default ChangeColor;