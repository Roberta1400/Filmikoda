import React, { useState, useEffect } from 'react';
import { Link } from 'react-router-dom';
import './Filmid.css';

function Filmid() {
  const [films, setFilms] = useState([]);
  const [selectedFilters, setSelectedFilters] = useState({
    žanr: '',
    vanusepiirang: '',
    keel: ''
  });

  const handleŽanrChange = (event) => {
    setSelectedFilters({ ...selectedFilters, žanr: event.target.value });
  };
  
  const handleVanusepiirangChange = (event) => {
    setSelectedFilters({ ...selectedFilters, vanusepiirang: event.target.value });
  };
  
  const handleKeelChange = (event) => {
    setSelectedFilters({ ...selectedFilters, keel: event.target.value });
  };

  useEffect(() => {
    let apiURL = 'http://localhost:8080/api/v1/filmid';

    const parameters = Object.entries(selectedFilters)
      .map(([key, value]) => value && `${key}=${value}`)
      .filter(Boolean)
      .join('&');

    if (parameters) {
      apiURL += `?${parameters}`;
    }

    fetch(apiURL)
      .then(response => response.json())
      .then(data => {
        setFilms(data);
      })
      .catch(error => {
        console.error('Error fetching films:', error);
      });
  }, [selectedFilters]);

  return (
  <div className="container">
    <div className="filter-container">
      <select value={selectedFilters.žanr} onChange={handleŽanrChange}>
        <option value="">All</option>
        <option value="scifi">SciFi</option>
        <option value="animatsioon">Animatsioon</option>
        <option value="drama">Draama</option>
      </select>
      <select value={selectedFilters.vanusepiirang} onChange={handleVanusepiirangChange}>
        <option value="">All</option>
        <option value="14">14</option>
        <option value="16">Inglise keel</option>
        <option value="0">Puudub</option>
      </select>
      <select value={selectedFilters.keel} onChange={handleKeelChange}>
        <option value="">All</option>
        <option value="eesti">Eesti keel</option>
        <option value="inglise">Inglise keel</option>
        <option value="vene">Vene keel</option>
      </select>
    </div>
    <div className="film-list">
      {films.map(film => (
        <div key={film.id} className="film">
          <Link to={`/movies/${film.id}`}>
            <img src={film.pilt} alt="Filmipilt" />
          </Link>
          <h2>{film.pealkiri}</h2>
        </div>
      ))}
    </div>
  </div>
  );
}

export default Filmid;