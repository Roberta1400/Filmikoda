import { NavLink } from 'react-router-dom';
import './Navigationbar.css';




const Navigationbar = () => {
    return (
        <nav className="navbar">
          <div className="kinonimi">
            <p>Filmikoda</p>
          </div>
          <div className="nav-links">
            <NavLink to="/" activeclassname="active">Kodu</NavLink>
            <NavLink to="/seanssid" activeclassname="active">Seanssid</NavLink>
            <NavLink to="/login" activeclassname="active">Logi sisse</NavLink>
          </div>
        </nav>
      )
}

export default Navigationbar;