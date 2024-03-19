import { NavLink } from 'react-router-dom';
import './Navigationbar.css';


const Navigationbar = () => {
    return (
        <nav className="navbar">
          <div className="kinonimi">
            <p>Filmikoda</p>
          </div>
          <div className="nav-links">
            <NavLink exact to="/" activeClassName="active">Kodu</NavLink>
            <NavLink to="/seanssid" activeClassName="active">Seanssid</NavLink>
            <NavLink to="/login" activeClassName="active">Logi sisse</NavLink>
          </div>
        </nav>
      )
}

export default Navigationbar;