import GlobalStyle from "./globalStyle";
import { HomePage } from "./pages/Home";
import { BrowserRouter as Router, Switch } from "react-router-dom";
const LoginPage = () =>
  import(
    /* webpackChunkName: "Login" */ /* webpackPrefetch: true */ "./pages/Login"
  );

function App() {
  return (
    <div className="App">
      <HomePage />
    </div>
  );
}

export default App;
