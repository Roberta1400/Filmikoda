import React, { useState, useEffect } from 'react';
import { Link } from 'react-router-dom';
import './Filmid.css';

function Filmid({user}) {
  const [films, setFilms] = useState([]);
  const [selectedFilters, setSelectedFilters] = useState({
    žanr: '',
    vanusepiirang: '',
    keel: ''
  });
  const [vaadatudFilmid, setVaadatudFilmid] = useState([]);
  const [soovitatudFilmid, setSoovitatudFilmid] = useState([]);

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
    fetch(`http://localhost:8080/api/v1/kasutaja/${user.id}/vaadatudfilmid`)
    .then(response => response.json())
    .then(data => {
      setVaadatudFilmid(data);
    })
    .catch(error => {
      console.error('Error fetching watched films:', error);
    });

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
  }, [selectedFilters, user.id]);

  const soovitaFilme = (vaadatudFilmid) => {
    const zanriteKaart = new Map();

    vaadatudFilmid.forEach(film => {
      const zanr = film.žanr;
      console.log(zanr);
      zanriteKaart.set(zanr, (zanriteKaart.get(zanr) || 0) + 1);
    });
    
    let maxEsinemisteArv = 0;
    zanriteKaart.forEach(esinemisteArv => {
      if (esinemisteArv > maxEsinemisteArv) {
        maxEsinemisteArv = esinemisteArv;
      }
    });

    const populaarsedZanrid = [];
    zanriteKaart.forEach((esinemisteArv, zanr) => {
      if (esinemisteArv === maxEsinemisteArv) {
        populaarsedZanrid.push(zanr);
      }
    });

    const vaatamataFilmid = films.filter(film => !vaadatudFilmid.some(vaadatudFilm => vaadatudFilm.id === film.id));

    console.log(vaatamataFilmid);

    const soovitatudFilmid = vaatamataFilmid.filter(film => populaarsedZanrid.includes(film.žanr));

    console.log(soovitatudFilmid);
 
    setSoovitatudFilmid(soovitatudFilmid);
};

  return (
  <div className="container">
    <div className="filter-container">
      <div>
        <label htmlFor="žanr"><b>Žanr:</b></label>
        <select id="žanr" value={selectedFilters.žanr} onChange={handleŽanrChange}>
          <option value="">All</option>
          <option value="scifi">SciFi</option>
          <option value="animatsioon">Animatsioon</option>
          <option value="drama">Draama</option>
          <option value="romcom">Romantiline komöödia</option>
          <option value="horror">Horror</option>
        </select>
      </div>
      <div>
        <label htmlFor="vanusepiirang"><b>Vanusepiirang:</b></label>
        <select id="vanusepiirang" value={selectedFilters.vanusepiirang} onChange={handleVanusepiirangChange}>
          <option value="">All</option>
          <option value="12">12</option>
          <option value="14">14</option>
          <option value="16">16</option>
          <option value="18">18</option>
          <option value="0">Puudub</option>
        </select>
      </div>
      <div>
        <label htmlFor="keel"><b>Keel:</b></label>
        <select id="keel" value={selectedFilters.keel} onChange={handleKeelChange}>
          <option value="">All</option>
          <option value="eesti">Eesti keel</option>
          <option value="inglise">Inglise keel</option>
          <option value="vene">Vene keel</option>
        </select>
      </div>
    </div>
    <h2>Hetkel kinos</h2>
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
    <h2 onClick={() => soovitaFilme(vaadatudFilmid)} className="soovita">Sulle soovitatud</h2>
    <div className="film-list">
      {soovitatudFilmid.map(film => (
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