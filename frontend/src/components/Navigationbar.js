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
            <NavLink to="/seansid" activeclassname="active">Seansid</NavLink>
            <NavLink to="/logout" activeclassname="active">Logout</NavLink>
          </div>
        </nav>
      )
}

export default Navigationbar;