import React, { useState } from 'react';
import './Login.css';

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
                const requestOptions = {
                    method: 'POST',
                    headers: { 'Content-Type': 'application/json' },
                    body: JSON.stringify({ kasutajanimi: email.split('@')[0], email: email, parool: parool })
                };
                const response = await fetch('http://localhost:8080/api/v1/kasutaja', requestOptions);
                if (response.ok) {
                    setError('Kasutaja loodud, palun logige sisse.');
                    setIsLoginMode(true);
                } else {
                    setError('Kasutaja loomisel ilmnes viga.');
                }
            }
        } catch (error) {
            console.error('Viga sisselogimisel/registeerimisel:', error);
            setError('Viga sisselogimisel/registeerimisel');
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
            {isLoginMode ? "Pole veel kasutaja?" : "On juba kasutaja?"}{' '}
            <div className="button-container">
                <button onClick={() => setIsLoginMode(!isLoginMode)}>
                    {isLoginMode ? 'Registreeri' : 'Logi sisse'}
                </button>
            </div>
        </div>
    );
};

export default Login;