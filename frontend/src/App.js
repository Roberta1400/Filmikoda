
import './App.css';
import { BrowserRouter as Router, Routes, Route } from "react-router-dom";
import Filmid from './components/Filmid';

function App() {
  return (
    <div className="App">
    <Router>
      <h1>Kinokava</h1>
      <Routes>
        <Route path="" element={<Filmid />} /> 
      </Routes>
    </Router>
  </div>
  );
}

export default App;
