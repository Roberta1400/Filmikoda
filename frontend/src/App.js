
import './App.css';
import { BrowserRouter as Router, Routes, Route} from "react-router-dom";
import Filmid from './components/Filmid';
import Navigationbar from './components/Navigationbar';

function App() {
  return (
    <div className="App">
    <Router>
    <Navigationbar/>
      <Routes>
        <Route path="" element={<Filmid />} /> 
      </Routes>
    </Router>
  </div>
  );
}

export default App;
