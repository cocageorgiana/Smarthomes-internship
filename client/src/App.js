import React, { Component } from 'react';
// import logo from './logo.svg';
import Main from './routes';
import TopMenu from './common/TopMenu/TopMenu';

class App extends Component {
  render() {
    

    return (
      <div className="App">
        {localStorage.getItem("isAuth") && <TopMenu />}
        <div className="container">
          <Main />
        </div>
      </div>
    );
  }
}

export default App;
