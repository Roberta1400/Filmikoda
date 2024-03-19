
import './App.css';
import { BrowserRouter as Router, Routes, Route} from "react-router-dom";
import Filmid from './components/Filmid';
import Navigationbar from './components/Navigationbar';
import Seanssid from './components/Seanssid';
import Saal from './components/Saal';

function App() {
  return (
    <div className="App">
    <Router>
    <Navigationbar/>
      <Routes>
        <Route path="" element={<Filmid />} /> 
        <Route path="/seanssid" element={<Seanssid />} />
        <Route path="/saal/:saalId" element={<Saal />} />
      </Routes>
    </Router>
  </div>
  );
}

export default App;
