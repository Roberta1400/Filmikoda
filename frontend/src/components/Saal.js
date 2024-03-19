import React, { useState, useEffect } from 'react';
import { useParams } from 'react-router-dom';
import './Saal.css';

function Saal() {
    const [saal, setSaal] = useState(null);
    const { saalId } = useParams();

    useEffect(() => {
      fetch(`http://localhost:8080/api/v1/saalid/${saalId}`)
        .then(response => response.json())
        .then(data => {
          setSaal(data);
        })
        .catch(error => {
          console.error('Error fetching saal:', error);
        });
    }, [saalId]); 

    if (!saal) {
        return <div>Loading...</div>;
      }/* Kuna ilma selleta viskas errori, siis chatGPT soovitas lisada koodi selle lõigu, et 
    me ei üritaks null valuega saal.nimi kätte saada */

    return (
        <div className="saal-container">
          <h1>{saal.nimi}</h1>
          <p className="saal-text">Ekraan</p>
          <div className="container">
            <hr className="saal-line" />
          </div>
        </div>
      );
}

export default Saal;
