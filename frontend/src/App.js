import { HomePage } from "./pages/Home";
import { BrowserRouter as Router, Route, Routes } from "react-router-dom";
import { ROUTE } from "./constants/route";

function App() {
  return (
    <div className="App">
      <Router>
        <Routes>
          <Route exact path={ROUTE.HOME.PATH} element={<HomePage />}></Route>
        </Routes>
      </Router>
    </div>
  );
}

export default App;
