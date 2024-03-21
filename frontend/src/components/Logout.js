import React from 'react';

const Logout = ({ setUser }) => {
  const handleLogout = () => {
    setUser(null);
  };

  return (
    <div>
      <h2>Logi välja</h2>
      <button onClick={handleLogout}>Logi välja</button>
    </div>
  );
};

export default Logout;