import React, { useState, useEffect } from 'react';
import { useParams } from 'react-router-dom';
import { Link } from 'react-router-dom';
import "./FilmiDetailid.css"

function FilmDetailid() {
  const [filmDetailid, setFilmDetailid] = useState([]);
  const { filmiId } = useParams();
  console.log(filmiId);

  useEffect(() => {
    fetch(`http://localhost:8080/api/v1/filmid/${filmiId}`)
      .then(response => response.json())
      .then(data => {
        setFilmDetailid(data);
      })
      .catch(error => {
        console.error('Error fetching film details:', error);
      });
  }, [filmiId]);

  if (!filmDetailid) {
    return <div>Loading...</div>;
  }

  return (
    <div className="film-detailid">
      <h1>{filmDetailid.pealkiri}</h1>
      <img src={filmDetailid.pilt} alt="Filmipilt" />
      <p><b>Žanr: </b>{filmDetailid.žanr}</p>
      <p><b>Sisu: </b> {filmDetailid.sisu}</p>
      <Link to="/seansid"><p className='nupp'>Seanssidele</p></Link>
    </div>
  );
}

export default FilmDetailid;