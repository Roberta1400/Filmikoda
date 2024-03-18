import { NavLink } from 'react-router-dom';
import './Navigationbar.css';


const Navigationbar = () => {
    return (
        <nav className="navbar">
          <div className="kinonimi">
            <p>Kinokava</p>
          </div>
          <div className="nav-links">
            <NavLink exact to="/" activeClassName="active">Kodu</NavLink>
            <NavLink to="/login" activeClassName="active">Logi sisse</NavLink>
            <NavLink to="/seanssid" activeClassName="active">Seanssid</NavLink>
          </div>
        </nav>
      )
}

export default Navigationbar;