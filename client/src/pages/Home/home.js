import React from 'react';
import ColoredBox from '../../modules/ColoredBox/coloredBox';
import ChangeColor from '../../modules/ChangeColor/changecolor';
import { Redirect } from 'react-router-dom';


class Home extends React.Component {
  constructor(props) {
    super(props);

    this.state = {
      boxColor: "green",
      colors: ["green", "blue", "yellow", "red"],
      isLogged: false
    }
  }

  changeColor = () => {
    const { colors } = this.state;
    this.setState((prevState) => {
      let index = colors.indexOf(prevState.boxColor);
      if (index === colors.length - 1) {
        return {
          boxColor: colors[0]
        }
      }

      return {
        boxColor: colors[index + 1]
      }
    });
  };

  componentWillMount() {
    if (!localStorage.getItem("isAuth")) {
      this.setState({
        isLogged: true
      })
    }
  }

  render() {
    return (
      <div className="Home">
        {this.state.isLogged && <Redirect to="/login" />}
        <ColoredBox color={this.state.boxColor} />
        <ChangeColor onClickFunction={this.changeColor} />
      </div>
    );

  }
}

export default Home;