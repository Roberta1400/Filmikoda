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

    const groupIstekohadByReaNr = () => {
        const groupedIstekohad = {};
        istekohad.forEach(istekoht => {
            const { reaNr } = istekoht;
            if (!groupedIstekohad[reaNr]) {
                groupedIstekohad[reaNr] = [];
            }
            groupedIstekohad[reaNr].push(istekoht);
        });
        return groupedIstekohad;
    };

    const groupedIstekohad = groupIstekohadByReaNr();

    const handleClick = (valitudIstekoht) => {
        const updatedIstekohad = istekohad.map(istekoht => {
            if (istekoht.id === valitudIstekoht.id) {
                return { ...istekoht, selected: !istekoht.selected };
            }
            return istekoht;
        });
        setIstekohad(updatedIstekohad);
    };

    return (
        <div className="istekohad-container">
            {Object.keys(groupedIstekohad).map(reaNr => (
                <div key={reaNr} className="istekohad-rea-container">
                    {groupedIstekohad[reaNr].map(istekoht => (
                        <div
                            key={istekoht.id}
                            className={`istekoht ${istekoht.kasVõetud ? 'võetud' : 'vaba'} ${istekoht.selected ? 'valitud' : ''}`}
                            onClick={() => handleClick(istekoht)}
                        >
                            {istekoht.kohaId}
                        </div>
                    ))}
                </div>
            ))}
        </div>
    );
}

export default Istekohad;