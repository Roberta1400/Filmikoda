import React, { useState, useEffect } from 'react';
import './Istekohad.css';

function Istekohad({ saalId }) {
    const [istekohad, setIstekohad] = useState([]);

    useEffect(() => {
        fetch(`http://localhost:8080/api/v1/istekohad/${saalId}`)
            .then(response => response.json())
            .then(data => {
                setIstekohad(data);
            })
            .catch(error => {
                console.error('Error fetching istekohad:', error);
            });
    }, [saalId]);

    return (
        <div className="istekohad-container">
            {istekohad.map(istekoht => (
                <div
                    key={istekoht.id}
                    className={`istekoht ${istekoht.kasVõetud ? 'võetud' : 'vaba'}`}
                >
                    {istekoht.kohaId}
                </div>
            ))}
        </div>
    );
}

export default Istekohad;