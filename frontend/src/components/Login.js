import React, { useState } from 'react';
import './Login.css'; // Impordi oma CSS-fail

const Login = ({ setUser }) => {
    const [email, setEmail] = useState('');
    const [parool, setParool] = useState('');
    const [isLoginMode, setIsLoginMode] = useState(true);
    const [error, setError] = useState('');

    const handleSubmit = async (event) => {
        event.preventDefault();
        try {
            if (isLoginMode) {
                const response = await fetch('http://localhost:8080/api/v1/kasutaja');
                const users = await response.json();
                const user = users.find(user => user.email === email && user.parool === parool);
                if (user) {
                    setError("Sisselogimine edukas")
                    setUser(user);
                } else {
                    setError('Sellist kontot ei eksisteeri');
                }
            } else {
                console.log('Registreerimine');
            }
        } catch (error) {
            console.error('Viga sisselogimisel:', error);
            setError('Viga sisselogimisel');
        }
    };

    return (
        <div className="form-container">
            <h2>{isLoginMode ? 'Logi sisse' : 'Registreeri'}</h2>
            {error && <p className="error-message">{error}</p>}
            <form onSubmit={handleSubmit}>
                <div>
                    <label>Email:</label>
                    <input
                        type="email"
                        value={email}
                        onChange={(e) => setEmail(e.target.value)}
                        required
                    />
                </div>
                <div>
                    <label>Parool:</label>
                    <input
                        type="password"
                        value={parool}
                        onChange={(e) => setParool(e.target.value)}
                        required
                    />
                </div>
                <div className="button-container">
                    <button type="submit">{isLoginMode ? 'Logi sisse' : 'Registreeri'}</button>
                </div>
            </form>
            <p>
                {isLoginMode ? "Pole veel kasutaja?" : "On juba kasutaja?"}{' '}
                <div className="button-container">
                <button onClick={() => setIsLoginMode(!isLoginMode)}>
                    {isLoginMode ? 'Registreeri' : 'Logi sisse'}
                </button>
                </div>
            </p>
        </div>
    );
};

export default Login;