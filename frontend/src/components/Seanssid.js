import React, { useState, useEffect } from 'react';
import './Seansid.css';
import { format } from "date-fns";
import { Link } from 'react-router-dom';

function Seanssid() {
  const [seanssid, setSeanssid] = useState([]);

  
  useEffect(() => {
    fetch('http://localhost:8080/api/v1/seansid')
      .then(response => response.json())
      .then(data => {
        setSeanssid(data);
      })
      .catch(error => {
        console.error('Error fetching seansid:', error);
      });
  }, []);

  return (
    <div className="container">
      <h1>Seanssid</h1>
      <div className="seanssid-list">
        {seanssid.map(seanss => (
          <Link to={`/saal/${seanss.saal.id}`} key={seanss.id} className="seanss-link">
          <div className="seanss">
            <h2>{seanss.film.pealkiri}</h2>
            <p>Kuupäev: {format(new Date(seanss.algusaeg), 'dd/MM')}</p>
            <p>Algusaeg: {format(new Date(seanss.algusaeg), 'HH:hh')}</p>
            <p>Saal: {seanss.saal.nimi}</p>
          </div>
        </Link>
        ))}
      </div>
    </div>
  );
}

export default Seanssid;