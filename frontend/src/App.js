import './App.css';
import { BrowserRouter as Router, Routes, Route} from "react-router-dom";
import Filmid from './components/Filmid';
import Navigationbar from './components/Navigationbar';
import Seansid from './components/Seansid';
import Saal from './components/Saal';
import Login from './components/Login';
import Logout from './components/Logout';
import { useState } from 'react';

function App() {
  const [user, setUser] = useState(null); // Kasutaja oleku idee ja kasutamise näitas ette ChatGPT

  return (
    <div className="App">
      <Router>
        {!user && (
          <div>
            <h1>Tere tulemast Filmikotta!</h1>
            <Login setUser={setUser} />
          </div>
        )}
        {user && (
          <>
            <Navigationbar user={user} />
            <Routes>
              <Route path="/" element={<Filmid />} />
              <Route path="/seansid" element={<Seansid />} />
              <Route path="/saal/:saalId" element={<Saal />} />
              <Route path="/logout" element={<Logout setUser={setUser} />} />
            </Routes>
          </>
        )}
      </Router>
    </div>
  );
}

export default App;
