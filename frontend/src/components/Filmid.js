
import './Filmid.css';
import React, { useState, useEffect } from 'react';
import { Link } from 'react-router-dom';

function Filmid() {
  const [films, setFilms] = useState([]);

  useEffect(() => {
    fetch('http://localhost:8080/api/v1/filmid')
      .then(response => response.json())
      .then(data => {
        setFilms(data);
      })
      .catch(error => {
        console.error('Error fetching films:', error);
      });
  }, []);

  return (
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
  );
}

export default Filmid;